package com.orangechain.laplace.cameraqrcode;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.client.result.ResultParser;
import com.orangechain.laplace.R;
import com.orangechain.laplace.activity.guideregistration.LeadInIdentityActivity;
import com.orangechain.laplace.base.BaseActivity;
import com.orangechain.laplace.camera.CameraManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;


public class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback {

    private static final String TAG = CaptureActivity.class.getSimpleName();

    private static final long DEFAULT_INTENT_RESULT_DURATION_MS = 1500L;
    private static final long BULK_MODE_SCAN_DELAY_MS = 1000L;
    public static String KEY_DATA = "key_data"; //作为最后返回数据的标志位

    private static final Collection<ResultMetadataType> DISPLAYABLE_METADATA_TYPES =
            EnumSet.of(ResultMetadataType.ISSUE_NUMBER,
                    ResultMetadataType.SUGGESTED_PRICE,
                    ResultMetadataType.ERROR_CORRECTION_LEVEL,
                    ResultMetadataType.POSSIBLE_COUNTRY);

    private CameraManager cameraManager;
    private CaptureActivityHandler handler;
    private Result savedResultToShow;
    private ViewfinderView viewfinderView;
    private TextView statusView;
    //  private View resultView;
    private Result lastResult;
    private boolean hasSurface; //判断是否含有SurfaceView
    private IntentSource source;
    private Collection<BarcodeFormat> decodeFormats;
    private Map<DecodeHintType, ?> decodeHints;
    private String characterSet;
    //  private HistoryManager historyManager;
    private InactivityTimer inactivityTimer;
    private BeepManager beepManager;
    private AmbientLightManager ambientLightManager;

    String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.VIBRATE
    };

    // 声明一个集合，在后面的代码中用来存储用户拒绝授权的权
    List<String> mPermissionList = new ArrayList<>();

    @Override
    public void initWithView() {

        setToolBarText("二维码扫描");

        //检查权限
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                //有权限尚未打开
                mPermissionList.add(permissions[i]);
                if (!mPermissionList.isEmpty()) {
                    String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
                    ActivityCompat.requestPermissions(this, permissions, 10000);
                }
            }
        }

        /******************/

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
//        {
//
//            //已经关闭了权限不再询问
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
//
//                //告知用户 其本身已经关闭了权限
//                Toast.makeText(this, "请开启权限", Toast.LENGTH_SHORT).show();
//
//            } else {
//
//                //申请权限
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1000);
//
//            }
//
//        }

        Window window = getWindow();
        //保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        inactivityTimer = new InactivityTimer(this);//计时器
        beepManager = new BeepManager(this);//震动
        ambientLightManager = new AmbientLightManager(this);//闪光

        hasSurface = false;

    }


    /**
     * 检查权限是否开启
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 10000:

                int Mark = 0;//标记权限是否全部开启

                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        //判断是否勾选禁止后不再询问  如果返回false 则不再询问
                        boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i]);
                        if (showRequestPermission) {
                            Toast.makeText(this, "请开启权限", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "权限尚未开启", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Mark++;
                    }
                }

                if (Mark != 0 & Mark == grantResults.length) {

                    //重现打开预览

                }

                /******************/

//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//
//                    inactivityTimer = new InactivityTimer(this);
//                    beepManager = new BeepManager(this);
//                    ambientLightManager = new AmbientLightManager(this);
//
//
//                } else {
//
//                    //告知用户 其本身已经关闭了权限
//                    Toast.makeText(this, "请开启权限,否则无法使用此功能", Toast.LENGTH_SHORT).show();
//
//                }
                return;
            default:
                return;

        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_capture;
    }

    @Override
    public void pushActivity(Context context) {
        Intent intent = getLaunchIntent(context, CaptureActivity.class);
        startWithNewAnimation(context, intent);
    }

    //获取自定义界面
    ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public Handler getHandler() {
        return handler;
    }

    CameraManager getCameraManager() {
        return cameraManager;
    }

//    @Override
//    public void onCreate(Bundle icicle)
//    {
//        super.onCreate(icicle);
//
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        setContentView(R.layout.capture);
//
//        hasSurface = false;
//        inactivityTimer = new InactivityTimer(this);
//        beepManager = new BeepManager(this);
//        ambientLightManager = new AmbientLightManager(this);
//
//        //    PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
//    }


    @Override
    protected void onResume() {
        super.onResume();
        cameraManager = new CameraManager(getApplication());
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        viewfinderView.setCameraManager(cameraManager);

        //    resultView = findViewById(R.id.result_view);
        statusView = (TextView) findViewById(R.id.status_view); //提示语

        handler = null;
        lastResult = null;

        resetStatusView();

        beepManager.updatePrefs();
        ambientLightManager.start(cameraManager);

        inactivityTimer.onResume();

        source = IntentSource.NONE;
        decodeFormats = null;
        characterSet = null;

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            // The activity was paused but not stopped, so the surface still exists. Therefore
            // surfaceCreated() won't be called, so init the camera here.
            initCamera(surfaceHolder);
        } else {
            // Install the callback and wait for surfaceCreated() to init the camera.
            surfaceHolder.addCallback(this);
        }
    }

    @Override
    protected void onPause() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        ambientLightManager.stop();
        beepManager.close();
        cameraManager.closeDriver();
        //historyManager = null; // Keep for onActivityResult
        if (!hasSurface) {
            SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
            SurfaceHolder surfaceHolder = surfaceView.getHolder();
            surfaceHolder.removeCallback(this);
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (source == IntentSource.NATIVE_APP_INTENT) {
                    setResult(RESULT_CANCELED);
                    finish();
                    return true;
                }
                if ((source == IntentSource.NONE || source == IntentSource.ZXING_LINK) && lastResult != null) {
                    restartPreviewAfterDelay(0L);
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_FOCUS:
            case KeyEvent.KEYCODE_CAMERA:
                // Handle these events so they don't launch the Camera app
                return true;
            // Use volume up/down to turn on light
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                cameraManager.setTorch(false);
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                cameraManager.setTorch(true);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //处理图片数据
    private void decodeOrStoreSavedBitmap(Bitmap bitmap, Result result) {
        // Bitmap isn't used yet -- will be used soon
        if (handler == null) {
            savedResultToShow = result;
        } else {
            if (result != null) {
                savedResultToShow = result;
            }
            if (savedResultToShow != null) {
                Message message = Message.obtain(handler, R.id.decode_succeeded, savedResultToShow);
                handler.sendMessage(message);
            }
            savedResultToShow = null;
        }
    }

    /**
     * surface 对应的三个回调
     * @param holder
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // do nothing
        hasSurface = false;
    }

    /**
     * A valid barcode has been found, so give an indication of success and show the results.
     *
     * @param rawResult   The contents of the barcode.
     * @param scaleFactor amount by which thumbnail was scaled
     * @param barcode     A greyscale bitmap of the camera data which was decoded.
     */
    public void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        inactivityTimer.onActivity();
        lastResult = rawResult;
        //    ResultHandler resultHandler = ResultHandlerFactory.makeResultHandler(this, rawResult);

//        boolean fromLiveScan = barcode != null;
//        if (fromLiveScan)
//        {
        //      historyManager.addHistoryItem(rawResult, resultHandler);
        // Then not from history, so beep/vibrate and we have an image to draw on
        beepManager.playBeepSoundAndVibrate();
        viewfinderView.drawResultBitmap(barcode);
//            drawResultPoints(barcode, scaleFactor, rawResult);
//        }
        handleDecodeInternally(rawResult, barcode);

    }

    // Put up our own UI for how to handle the decoded contents.
    private void handleDecodeInternally(Result rawResult, Bitmap barcode) {

        String result = ResultParser.parseResult(rawResult).getDisplayResult().toString().trim();
        handleResult(result);

    }

    /**
     * 处理最终的结果 返回到调用界面
     * @param result
     */
    private void handleResult(String result) {

        Toast.makeText(this,"读取内容:" + result,Toast.LENGTH_LONG).show();

        //这边回调方式修改一下
        Intent intent = new Intent();
        intent.putExtra(KEY_DATA, result);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {

        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }

        if (cameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }

        try {
            cameraManager.openDriver(surfaceHolder);
            // Creating the handler starts the preview, which can also throw a RuntimeException.
            if (handler == null) {
                handler = new CaptureActivityHandler(this, decodeFormats, decodeHints, characterSet, cameraManager);
            }
            decodeOrStoreSavedBitmap(null, null);

        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e) {
            // Barcode Scanner has seen crashes in the wild of this variety:
            // java.?lang.?RuntimeException: Fail to connect to camera service
            Log.w(TAG, "Unexpected error initializing camera", e);
            displayFrameworkBugMessageAndExit();
        }
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("很遗憾，Android 相机出现问题。你可能需要开启权限");
        builder.setPositiveButton("确定", new FinishListener(this));
//        builder.setOnCancelListener(new FinishListener(this));
        builder.create().show();
    }

    public void restartPreviewAfterDelay(long delayMS) {
        if (handler != null) {
            handler.sendEmptyMessageDelayed(R.id.restart_preview, delayMS);
        }
        resetStatusView();
    }

    /**
     * 重置界面各个view的状态
     */
    private void resetStatusView() {
        //    resultView.setVisibility(View.GONE);
        statusView.setText("请将条码置于取景框内扫描");
        statusView.setVisibility(View.VISIBLE);
        viewfinderView.setVisibility(View.VISIBLE);
        lastResult = null;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();
    }

}

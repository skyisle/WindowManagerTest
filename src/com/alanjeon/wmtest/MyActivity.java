package com.alanjeon.wmtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MyActivity extends Activity {

    private WindowManager mWindowManager;
    private ImageView mDragView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        /*
        WindowManager.LayoutParams btnWmParam = new WindowManager.LayoutParams();
        btnWmParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
        btnWmParam.width = WindowManager.LayoutParams.WRAP_CONTENT;
        btnWmParam.flags =  WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        btnWmParam.format = PixelFormat.TRANSLUCENT;
        btnWmParam.windowAnimations = 0;

        Button btn = new Button(this);
        btn.setText("ClickClick");

        mWindowManager.addView(btn, btnWmParam);
        */

        WindowManager.LayoutParams wmParam = new WindowManager.LayoutParams();
        wmParam.height = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParam.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParam.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        wmParam.format = PixelFormat.TRANSLUCENT;
        wmParam.windowAnimations = 0;

        ImageView v = new ImageView(this);
        v.setPadding(0, 0, 0, 0);
        v.setImageResource(R.drawable.bg_image);

        mWindowManager.addView(v, wmParam);
        mDragView = v;

        mDragView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWindowManager.removeView(mDragView);
                mDragView = null;
            }
        }, 3000);
    }
}

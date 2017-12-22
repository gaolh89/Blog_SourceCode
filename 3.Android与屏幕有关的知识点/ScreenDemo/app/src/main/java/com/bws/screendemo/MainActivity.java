package com.bws.screendemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTest = (TextView) findViewById(R.id.tv_test);

        int screenWidth = DisplayUtils.getScreenWidth(this);
        int screenHeight = DisplayUtils.getScreenHeight(this);
        int statusHeight = DisplayUtils.getStatusHeight(this);
        int navitionBarHeight = DisplayUtils.getNavitionBarHeight(this);

        Log.e("屏幕数据", screenWidth + "......" + screenHeight + "..........." + statusHeight +
                "......." + navitionBarHeight);

        //  720......1184...........50.......96


        int width1 = mTvTest.getWidth();
        int height1 = mTvTest.getHeight();
        Log.e("控件数据....为空", width1+"......"+height1);

        mTvTest.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {

                        int mTvTestHeight = mTvTest.getHeight();
                        int mTvTestWidth = mTvTest.getWidth();
                        Log.e("控件数据", mTvTestHeight + "......" + mTvTestWidth);

                      //  40......120

                        int height = DisplayUtils.px2dip(MainActivity.this, mTvTestHeight);
                        Log.e("控件数据....转换后", height+"");

                    }
                });

    }
}

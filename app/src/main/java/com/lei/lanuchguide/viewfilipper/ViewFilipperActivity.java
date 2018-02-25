package com.lei.lanuchguide.viewfilipper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.lei.lanuchguide.MainActivity;
import com.lei.lanuchguide.R;

/**
 * Created by yanle on 2018/2/25.
 */

public class ViewFilipperActivity extends Activity implements GestureDetector.OnGestureListener{
    private ViewFlipper viewFlipper;
    private Button btn;
    private LinearLayout llindicator;

    private GestureDetector gestureDetector;//手势监测
    private int index = 0;//当前时第几屏

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfilipper);

        viewFlipper = findViewById(R.id.viewFilipper);
        btn = findViewById(R.id.btn);
        llindicator = findViewById(R.id.ll_indicator);

        initlndicator();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewFilipperActivity.this, MainActivity.class));
            }
        });
    }

    /*
   初始化指示器
    */
    private void initlndicator() {
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, width);
        lp.rightMargin = 2 * width;
        for(int i = 0; i < viewFlipper.getChildCount(); i++) {
            View view = new View(this);
            view.setId(i);
            view.setBackgroundResource(i == 0 ? R.drawable.dot_focus : R.drawable.dot_normal);
            view.setLayoutParams(lp);
            llindicator.addView(view, i);
        }

        gestureDetector = new GestureDetector(this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if(e1.getX() > e2.getX()) {
            //显示下一组图片
            viewFlipper.showNext();
            index = index < 2 ? index + 1: 0;
        } else if(e1.getX() < e2.getX()) {
            viewFlipper.showPrevious();
            index = index > 0 ? index - 1: 2;
        } else {
            return false;
        }

        changelndicator();
         return true;
    }

    private void changelndicator() {
        for(int i = 0; i < viewFlipper.getChildCount(); i++) {
            llindicator.getChildAt(i).setBackgroundResource(i == index ?
                    R.drawable.dot_focus: R.drawable.dot_normal);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}

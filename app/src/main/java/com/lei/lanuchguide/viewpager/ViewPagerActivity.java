package com.lei.lanuchguide.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.lei.lanuchguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanle on 2018/2/25.
 */

public class ViewPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    private LinearLayout ll_indicator;

    private PagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = findViewById(R.id.viewPager);
        ll_indicator = findViewById(R.id.ll_indicator);

        Log.i("tag","ViewPagerActivity");

        //创建Fragment
        for(int i = 0; i < 3; i++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
            Log.i("tag","ViewPagerActivity" + i);
        }

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for(int i = 0; i < fragments.size(); i++) {
                    ll_indicator.getChildAt(i).setBackgroundResource(i == position ?
                    R.drawable.dot_focus: R.drawable.dot_normal);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initlndicator();
    }

    /*
    初始化指示器
     */
    private void initlndicator() {
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f,getResources().getDisplayMetrics());

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, width);
        lp.rightMargin = 2 * width;
        for(int i = 0; i < fragments.size(); i++) {
            View view = new View(this);
            view.setId(i);
            view.setBackgroundResource(i == 0 ? R.drawable.dot_focus : R.drawable.dot_normal);
            view.setLayoutParams(lp);
            ll_indicator.addView(view, i);
        }
    }
}

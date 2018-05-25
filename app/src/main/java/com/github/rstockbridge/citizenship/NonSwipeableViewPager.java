package com.github.rstockbridge.citizenship;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeableViewPager extends ViewPager {

    public NonSwipeableViewPager(final Context context) {
        super(context);
    }

    public NonSwipeableViewPager(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent event) {
        return false;
    }


}

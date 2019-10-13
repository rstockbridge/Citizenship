package com.github.rstockbridge.citizenship;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public final class NonSwipeableViewPager extends ViewPager {

    public NonSwipeableViewPager(@NonNull final Context context) {
        super(context);
    }

    public NonSwipeableViewPager(@NonNull final Context context, @NonNull final AttributeSet attrs) {
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

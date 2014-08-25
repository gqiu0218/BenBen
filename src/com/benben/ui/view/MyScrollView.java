package com.benben.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ScrollView;

/**
 * 自定义ScrollView
 * 
 * @author hlwang
 * 
 */
public class MyScrollView extends ScrollView
{
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 100; // 反弹最大距离基数

    private Context mContext;
    private int mMaxYOverscrollDistance; // 反弹最大距离

    public MyScrollView(Context context)
    {
        super(context);
        this.mContext = context;
        initBounceScrollView();
    }

    public MyScrollView(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        this.mContext = context;
        initBounceScrollView();
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context,attrs,defStyle);
        this.mContext = context;
        initBounceScrollView();
    }

    private void initBounceScrollView()
    {
        if(isInEditMode())
            return;
        
        final DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        final float density = metrics.density;

        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
    }

    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
        int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent)
    {
        return super.overScrollBy(deltaX,
            deltaY,
            scrollX,
            scrollY,
            scrollRangeX,
            scrollRangeY,
            maxOverScrollX,
            mMaxYOverscrollDistance,
            isTouchEvent);
    }
}

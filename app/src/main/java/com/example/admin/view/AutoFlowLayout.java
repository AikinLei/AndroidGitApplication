package com.example.admin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author leixinqiao
 * @version 1.0
 * @since: on 2018/06/19  19:03
 * @Description
 */
public class AutoFlowLayout extends ViewGroup {
    public AutoFlowLayout(Context context) {
        super(context);
    }

    public AutoFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}

package com.example.admin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leixinqiao
 * @version 1.0
 * @since: on 2018/06/19  15:18
 * @Description
 */
public class FlowLayout extends ViewGroup {

    private List<Integer> mLineHeight = new ArrayList<>();
    private List<List<View>> mLineViews = new ArrayList<>();

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //由于onMeasure会执行多次,避免重复的计算控件个数和高度,这里需要进行清空操作
        mLineViews.clear();
        mLineHeight.clear();

        //获取测量模式和尺寸大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec) + getPaddingTop() + getPaddingBottom();
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //viewGroup的真实宽高
        int viewGroupWidth = 0 - getPaddingLeft() - getPaddingRight();
        int viewGroupHeight = getPaddingBottom() + getPaddingBottom();


        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            viewGroupWidth = widthSize;
            viewGroupHeight = heightSize;
        } else {
            int currentLineWidth = 0;
            int currentLineHeight = 0;


            List<View> lineView = new ArrayList<>();
            int childCount = getChildCount();


            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);

                measureChild(childView, widthMeasureSpec, heightMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();

                int childWidth = childView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                int childHeight = childView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;

                if (currentLineWidth + childWidth > widthSize ) {//换行
                    viewGroupWidth = Math.max(currentLineWidth, widthSize);
                    viewGroupHeight += currentLineHeight;

                    mLineHeight.add(currentLineHeight);
                    mLineViews.add(lineView);

                    lineView = new ArrayList<>();
                    lineView.add(childView);
                    currentLineWidth = childWidth;

                } else {
                    currentLineWidth += childWidth;
                    currentLineHeight = Math.max(currentLineHeight, childHeight);
                    lineView.add(childView);
                }


                if (i == childCount - 1) {
                    mLineViews.add(lineView);
                    viewGroupWidth = Math.max(childWidth, viewGroupWidth);
                    viewGroupHeight += childHeight;
                    //添加行高
                    mLineHeight.add(currentLineHeight);
                }
            }


        }
        setMeasuredDimension(viewGroupWidth, viewGroupHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = getPaddingLeft();
        int top = getPaddingTop();

        for (int i = 0; i < mLineViews.size(); i++) {
            //行高
            int lineHeight = mLineHeight.get(i);

            //单行的views
            List<View> views = mLineViews.get(i);

            for (int j = 0; j < views.size(); j++) {
                View view = views.get(j);
                MarginLayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();

                int vl = left + layoutParams.leftMargin;
                int vt = top + layoutParams.topMargin;
                int vr = vl + view.getMeasuredWidth();
                int vb = vt + view.getMeasuredHeight();

                view.layout(vl, vt, vr, vb);

                left += view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            top += lineHeight;
            left = getPaddingLeft();
        }

    }

    /**
     * 指定ViewGroup的LayoutParams
     *
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}

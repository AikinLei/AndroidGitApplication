package com.example.admin.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.custmerviewapplication.R;

/**
 * @author leixinqiao
 * @version 1.0
 * @since: on 2018/06/27  11:05
 * @Description
 */
public class CustomerTextView extends AppCompatTextView {
    private int mLastX;
    private int mLastY;

    private Paint mPaint = new Paint();
    private int mColor;

    public CustomerTextView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(1.5f);
    }

    public CustomerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomerTextView);
        mColor = typedArray.getColor(R.styleable.CustomerTextView_usColor, Color.BLUE);
        typedArray.recycle();
        initPaint();
    }

    public CustomerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float rawX = event.getRawX();
        float rawY = event.getRawY();

        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.i("lei", "onTouchEvent: ---rawX-->" + rawX);
        Log.i("lei", "onTouchEvent: ---rawY-->" + rawY);

        Log.i("lei", "onTouchEvent: ---x-->" + x);
        Log.i("lei", "onTouchEvent: ---y-->" + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
                //方式一：采用layout();

                layout(getLeft() + offsetX, getTop() + offsetY,
                        getRight() + offsetX, getBottom() + offsetY);

                //方式二：采用offsetLeftAndRight(),offsetTopAndBottom();

                /*offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);*/

                //方式三：体验不是很好
                // 采用layoutParams  根据此控件的父布局决定使用 LinearLayout.LayoutParams 还是RelativeLayout.LayoutParams
                //                                                 或者直接使用 ViewGroup.MarginLayoutParams

                /*LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                linearLayoutParams.leftMargin = getLeft() + offsetX;
                linearLayoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(linearLayoutParams);*/

                /*ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = offsetX;
                layoutParams.topMargin = offsetY;
                setLayoutParams(layoutParams);*/

                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();

        int height = getHeight();

        canvas.drawLine(0, height / 2, width, height / 2, mPaint);
    }
}

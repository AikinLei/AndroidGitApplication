package com.example.admin.custmerviewapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewLocationActivity extends AppCompatActivity {

//    @BindView(R.id.text_location)
//    TextView mTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ListView lv_one=(ListView)this.findViewById(R.id.lv_one);
        ListView lv_two=(ListView)this.findViewById(R.id.lv_two);
        String[] strs1 = {"1","2","3","4","5","6","7","8","9","10","11"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs1);
        lv_one.setAdapter(adapter1);

        String[] strs2 = {"A","B","C","D","E","F","G","H"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs2);
        lv_two.setAdapter(adapter2);

    }

//    @OnClick(R.id.text_location)
//    public void onViewClicked() {
//
//        mTextLocation.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(ViewLocationActivity.this, "I'm touched!", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
//
//        float x = mTextLocation.getX();
//        float y = mTextLocation.getY();
//
//        Log.i("Lei", "onViewClicked: ---X--->" + x);
//        Log.i("Lei", "onViewClicked: ---y--->" + y);
//
//        int top = mTextLocation.getTop();
//        int left = mTextLocation.getLeft();
//        int right = mTextLocation.getRight();
//        int bottom = mTextLocation.getBottom();
//
//
//        Log.i("Lei", "onViewClicked: ---top--->" + top);
//        Log.i("Lei", "onViewClicked: ---left--->" + left);
//        Log.i("Lei", "onViewClicked: ---right--->" + right);
//        Log.i("Lei", "onViewClicked: ---bottom--->" + bottom);
//
//    }


}

package com.example.admin.custmerviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Lei";
    private int a = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.main_layout);
//        ViewParent parent = viewById.getParent();
//        Log.i(TAG, "onCreate: -->" + parent);

//        View buttonView = LayoutInflater.from(this).inflate(R.layout.layout_button, null);
//        mainLayout.addView(buttonView);
    }


    private int changeValue(int a) {
        a = 100;
        return a;
    }
}

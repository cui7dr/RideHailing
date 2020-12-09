package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cui.ridehailing.R;

public class IndexActivity extends AppCompatActivity {

    TextView tv_owner_manage;
    TextView tv_car_manage;
    TextView tv_owner_info;
    TextView tv_car_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
    }

    private void initView() {
        tv_owner_manage = (TextView) findViewById(R.id.tv_owner_manage);
        tv_car_manage = (TextView) findViewById(R.id.tv_car_manage);
        tv_owner_info = (TextView) findViewById(R.id.tv_owner_info);
        tv_car_info = (TextView) findViewById(R.id.tv_car_info);
    }
}
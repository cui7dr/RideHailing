package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cui.ridehailing.R;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

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
        tv_owner_manage.setOnClickListener(this);
        tv_car_manage.setOnClickListener(this);
        tv_owner_info.setOnClickListener(this);
        tv_car_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_owner_manage:
                Intent intent_owner_manage = new Intent(IndexActivity.this,
                        OwnerManageActivity.class);
                startActivity(intent_owner_manage);
                finish();
                break;
            case R.id.tv_car_manage:
                Intent intent_car_manage = new Intent(IndexActivity.this, CarManageActivity.class);
                startActivity(intent_car_manage);
                finish();
                break;
            case R.id.tv_owner_info:
                Intent intent_owner_info = new Intent(IndexActivity.this, OwnerInfoActivity.class);
                startActivity(intent_owner_info);
                finish();
                break;
            case R.id.tv_car_info:
                Intent intent_car_info = new Intent(IndexActivity.this, CarInfoActivity.class);
                startActivity(intent_car_info);
                finish();
                break;
        }
    }
}
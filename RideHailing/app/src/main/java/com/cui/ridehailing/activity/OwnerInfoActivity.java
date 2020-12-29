package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.cui.ridehailing.R;

public class OwnerInfoActivity extends AppCompatActivity {

    TextView tv_ownerInfo_name;
    TextView tv_ownerInfo_sex;
    TextView tv_ownerInfo_birth;
    TextView tv_ownerInfo_country;
    TextView tv_ownerInfo_address;
    TextView tv_ownerInfo_licenseNum;
    TextView tv_ownerInfo_drivingModels;
    TextView tv_ownerInfo_plate;
    TextView tv_ownerInfo_initialDate;
    TextView tv_ownerInfo_effectiveDate;

    private String name;
    private String sex;
    private String birth;
    private String country;
    private String address;
    private String licenseNum;
    private String drivingModels;
    private String plate;
    private String initialDate;
    private String effectiveDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);
    }

    private void initView() {
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        birth = getIntent().getStringExtra("birth");
        country = getIntent().getStringExtra("country");
        address = getIntent().getStringExtra("address");
        licenseNum = getIntent().getStringExtra("licenseNum");
        drivingModels = getIntent().getStringExtra("model");
        plate = getIntent().getStringExtra("plate");
        initialDate = getIntent().getStringExtra("start");
        effectiveDate = getIntent().getStringExtra("end");

        tv_ownerInfo_name = (TextView) findViewById(R.id.tv_ownerInfo_name);
        tv_ownerInfo_sex = (TextView) findViewById(R.id.tv_ownerInfo_sex);
        tv_ownerInfo_birth = (TextView) findViewById(R.id.tv_ownerInfo_birth);
        tv_ownerInfo_country = (TextView) findViewById(R.id.tv_ownerInfo_country);
        tv_ownerInfo_address = (TextView) findViewById(R.id.tv_ownerInfo_address);
        tv_ownerInfo_licenseNum = (TextView) findViewById(R.id.tv_ownerInfo_licenseNum);
        tv_ownerInfo_drivingModels = (TextView) findViewById(R.id.tv_ownerInfo_drivingModels);
        tv_ownerInfo_plate = (TextView) findViewById(R.id.tv_ownerInfo_plate);
        tv_ownerInfo_initialDate = (TextView) findViewById(R.id.tv_ownerInfo_initialDate);
        tv_ownerInfo_effectiveDate = (TextView) findViewById(R.id.tv_ownerInfo_effectiveDate);

        tv_ownerInfo_name.setText(name);
        tv_ownerInfo_sex.setText(sex);
        tv_ownerInfo_birth.setText(birth);
        tv_ownerInfo_country.setText(country);
        tv_ownerInfo_address.setText(address);
        tv_ownerInfo_licenseNum.setText(licenseNum);
        tv_ownerInfo_drivingModels.setText(drivingModels);
        tv_ownerInfo_plate.setText(plate);
        tv_ownerInfo_initialDate.setText(initialDate);
        tv_ownerInfo_effectiveDate.setText(effectiveDate);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, SearchOwnerActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
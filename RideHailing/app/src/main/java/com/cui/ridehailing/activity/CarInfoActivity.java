package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;

import com.cui.ridehailing.R;

public class CarInfoActivity extends AppCompatActivity {

    Toolbar tb_carInfo_menu;
    TextView tv_carInfo_transport;
    TextView tv_carInfo_plate;
    TextView tv_carInfo_vehicleModel;
    TextView tv_carInfo_seat;
    TextView tv_carInfo_color;
    TextView tv_carInfo_size;
    TextView tv_carInfo_businessScope;
    TextView tv_carInfo_operationStatus;
    TextView tv_carInfo_issuingAuthority;

    private String transport;
    private String plate;
    private String vehicleModel;
    private String seat;
    private String color;
    private String size;
    private String businessScope;
    private String operationStatus;
    private String issuingAuthority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        initView();
    }

    private void initView() {
        tb_carInfo_menu = (Toolbar) findViewById(R.id.tb_carInfo_menu);
        tb_carInfo_menu.inflateMenu(R.menu.menus);
        tb_carInfo_menu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        transport = getIntent().getStringExtra("transport");
        plate = getIntent().getStringExtra("plate");
        vehicleModel = getIntent().getStringExtra("brand");
        seat = getIntent().getStringExtra("seat");
        color = getIntent().getStringExtra("color");
        size = getIntent().getStringExtra("size");
        businessScope = getIntent().getStringExtra("run");
        operationStatus = getIntent().getStringExtra("status");
        issuingAuthority = getIntent().getStringExtra("organ");

        tv_carInfo_transport = (TextView) findViewById(R.id.tv_carInfo_transport);
        tv_carInfo_plate = (TextView) findViewById(R.id.tv_carInfo_plate);
        tv_carInfo_vehicleModel = (TextView) findViewById(R.id.tv_carInfo_vehicleModel);
        tv_carInfo_seat = (TextView) findViewById(R.id.tv_carInfo_seat);
        tv_carInfo_color = (TextView) findViewById(R.id.tv_carInfo_color);
        tv_carInfo_size = (TextView) findViewById(R.id.tv_carInfo_size);
        tv_carInfo_businessScope = (TextView) findViewById(R.id.tv_carInfo_businessScope);
        tv_carInfo_operationStatus = (TextView) findViewById(R.id.tv_carInfo_operationStatus);
        tv_carInfo_issuingAuthority = (TextView) findViewById(R.id.tv_carInfo_issuingAuthority);

        tv_carInfo_transport.setText(transport);
        tv_carInfo_plate.setText(plate);
        tv_carInfo_vehicleModel.setText(vehicleModel);
        tv_carInfo_seat.setText(seat);
        tv_carInfo_color.setText(color);
        tv_carInfo_size.setText(size);
        tv_carInfo_businessScope.setText(businessScope);
        tv_carInfo_operationStatus.setText(operationStatus);
        tv_carInfo_issuingAuthority.setText(issuingAuthority);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, SearchCarActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
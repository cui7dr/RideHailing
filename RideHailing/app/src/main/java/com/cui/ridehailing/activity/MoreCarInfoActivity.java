package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.cui.ridehailing.R;

public class MoreCarInfoActivity extends AppCompatActivity {

    TextView tv_more_plate;
    TextView tv_more_violationRecords;
    TextView tv_more_currentItinerary;
    TextView tv_more_illegalSubmit;

    private String account;
    private String plate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_car_info);
    }

    private void initView() {
        tv_more_plate = (TextView) findViewById(R.id.tv_more_plate);
        tv_more_violationRecords = (TextView) findViewById(R.id.tv_more_violationRecords);
        tv_more_currentItinerary = (TextView) findViewById(R.id.tv_more_currentItinerary);
        tv_more_illegalSubmit = (TextView) findViewById(R.id.tv_more_illegalSubmit);

        plate = getIntent().getStringExtra("plate");
        account = getIntent().getStringExtra("account");
        tv_more_plate.setText(plate);
        tv_more_violationRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreCarInfoActivity.this, RecordsActivity.class);
                intent.putExtra("account", account);
                intent.putExtra("plate", plate);
                startActivity(intent);
                finish();
            }
        });
        tv_more_currentItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreCarInfoActivity.this, StrokeActivity.class);
                intent.putExtra("account", account);
                intent.putExtra("plate", plate);
                startActivity(intent);
                finish();
            }
        });
        tv_more_illegalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreCarInfoActivity.this, SubmitActivity.class);
                intent.putExtra("account", account);
                intent.putExtra("plate", plate);
                startActivity(intent);
                finish();
            }
        });

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
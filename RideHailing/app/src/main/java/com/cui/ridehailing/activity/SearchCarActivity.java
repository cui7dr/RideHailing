package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cui.ridehailing.R;
import com.cui.ridehailing.util.DataBaseUtil;
import com.cui.ridehailing.util.SharedPreferencesUtil;

public class SearchCarActivity extends AppCompatActivity {

    EditText edtTxt_searchCar_transport;
    EditText edtTxt_searchCar_plate;
    Button btn_searchCar1;
    Button btn_searchCar2;
    String transport;
    String plate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_car);
        initView();
    }

    private void initView() {
        edtTxt_searchCar_transport = (EditText) findViewById(R.id.edtTxt_searchCar_transport);
        edtTxt_searchCar_plate = (EditText) findViewById(R.id.edtTxt_searchCar_plate);
        btn_searchCar1 = (Button) findViewById(R.id.btn_searchCar1);
        btn_searchCar2 = (Button) findViewById(R.id.btn_searchCar2);
        btn_searchCar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transport = edtTxt_searchCar_transport.getText().toString();
                if (transport.equals("")) {
                    Toast.makeText(SearchCarActivity.this, "请重新输入道路运输证号", Toast.LENGTH_SHORT).show();
                    return;
                }
                DataBaseUtil dbu = new DataBaseUtil(SearchCarActivity.this);
                SQLiteDatabase sql = dbu.getWritableDatabase();
                Cursor cursor = sql.query("car", new String[]{"plate", "brand", "seat", "color",
                                "size", "run", "status", "organ"}, "transport = ?",
                        new String[]{transport}, null, null, null);
                if (cursor.moveToNext() == true) {
                    String plate1 = cursor.getString(cursor.getColumnIndex("plate"));
                    String brand = cursor.getString(cursor.getColumnIndex("brand"));
                    String seat = cursor.getString(cursor.getColumnIndex("seat"));
                    String color = cursor.getString(cursor.getColumnIndex("color"));
                    String size = cursor.getString(cursor.getColumnIndex("size"));
                    String run = cursor.getString(cursor.getColumnIndex("run"));
                    String status = cursor.getString(cursor.getColumnIndex("status"));
                    String organ = cursor.getString(cursor.getColumnIndex("organ"));
                    Intent intent = new Intent(SearchCarActivity.this, CarInfoActivity.class);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "plate", plate1);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "brand", brand);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "seat", seat);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "color", color);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "size", size);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "run", run);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "status", status);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "organ", organ);
                    SharedPreferencesUtil.saveData(SearchCarActivity.this, "transport", transport);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SearchCarActivity.this, "没有该车辆信息", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btn_searchCar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plate = edtTxt_searchCar_plate.getText().toString();
                if (plate.equals("")) {
                    Toast.makeText(SearchCarActivity.this, "请重新输入道路运输证号", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(SearchCarActivity.this, CarInfoActivity.class);
                SharedPreferencesUtil.saveData(SearchCarActivity.this, "plate", plate);
                startActivity(intent);
                finish();
            }
        });
    }
}
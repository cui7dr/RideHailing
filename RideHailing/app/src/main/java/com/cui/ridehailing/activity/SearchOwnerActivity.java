package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cui.ridehailing.R;
import com.cui.ridehailing.util.DataBaseUtil;
import com.cui.ridehailing.util.SharedPreferencesUtil;

public class SearchOwnerActivity extends AppCompatActivity {

    EditText edtTxt_searchOwner_licenseNum;
    EditText edtTxt_searchOwner_plate;
    Button btn_searchOwner1;
    Button btn_searchOwner2;
    private String licenseNum;
    private String plate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_owner);
        initView();
    }

    private void initView() {
        edtTxt_searchOwner_licenseNum = (EditText) findViewById(R.id.edtTxt_searchOwner_licenseNum);
        edtTxt_searchOwner_plate = (EditText) findViewById(R.id.edtTxt_searchOwner_plate);
        btn_searchOwner1 = (Button) findViewById(R.id.btn_searchOwner1);
        btn_searchOwner2 = (Button) findViewById(R.id.btn_searchOwner2);
        btn_searchOwner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licenseNum = edtTxt_searchOwner_licenseNum.getText().toString();
                if (licenseNum.equals("")) {
                    Toast.makeText(SearchOwnerActivity.this, "请输入驾驶证号", Toast.LENGTH_SHORT).show();
                    return;
                }
                DataBaseUtil dbu = new DataBaseUtil(SearchOwnerActivity.this);
                SQLiteDatabase sql = dbu.getWritableDatabase();
                Cursor cursor = sql.query("owner", new String[]{"name", "sex", "birth", "country"
                                , "plate", "address", "model", "start", "end"}, "license = ?",
                        new String[]{licenseNum}, null, null, null);
                if (cursor.moveToNext() == true) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String sex = cursor.getString(cursor.getColumnIndex("sex"));
                    String birth = cursor.getString(cursor.getColumnIndex("birth"));
                    String country = cursor.getString(cursor.getColumnIndex("country"));
                    String plate1 = cursor.getString(cursor.getColumnIndex("plate"));
                    String address = cursor.getString(cursor.getColumnIndex("address"));
                    String model = cursor.getString(cursor.getColumnIndex("model"));
                    String start = cursor.getString(cursor.getColumnIndex("start"));
                    String end = cursor.getString(cursor.getColumnIndex("end"));
                    Intent intent = new Intent(SearchOwnerActivity.this, OwnerInfoActivity.class);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "name", name);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "sex", sex);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "birth", birth);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "country", country);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "plate", plate1);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "address", address);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "model", model);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "start", start);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "end", end);
                    SharedPreferencesUtil.saveData(SearchOwnerActivity.this,"licensNum",licenseNum);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SearchOwnerActivity.this, "没有该车主信息", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        btn_searchOwner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plate = edtTxt_searchOwner_plate.getText().toString();
                if (plate.equals("")) {
                    Toast.makeText(SearchOwnerActivity.this, "请输入车牌号", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(SearchOwnerActivity.this, OwnerInfoActivity.class);
                SharedPreferencesUtil.saveData(SearchOwnerActivity.this, "plate", plate);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, IndexActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
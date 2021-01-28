package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cui.ridehailing.R;
import com.cui.ridehailing.util.DataBaseUtil;

public class RecordsActivity extends AppCompatActivity {

    Toolbar tb_records_title;
    TextView tv_record_number;
    TextView tv_record_fine;
    TextView tv_record_dealWith;
    LinearLayout ll_record_result;

    private String plate;
    private String account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        initView();
    }

    private void initView(){
        tb_records_title=(Toolbar)findViewById(R.id.tb_record_title);
        tv_record_number=(TextView)findViewById(R.id.tv_record_number);
        tv_record_fine=(TextView)findViewById(R.id.tv_record_fine);
        tv_record_dealWith=(TextView)findViewById(R.id.tv_record_dealWith);
        ll_record_result=(LinearLayout)findViewById(R.id.ll_record_result);
        plate=getIntent().getStringExtra("plate");
        account=getIntent().getStringExtra("account");
        tb_records_title.setTitle(plate);
        DataBaseUtil dbu=new DataBaseUtil(RecordsActivity.this);
        SQLiteDatabase sql=dbu.getWritableDatabase();
        Cursor cursor=sql.query("car",new String[]{"illegal","fine","isDeal"},"plate = ?",new String[]{plate},null,null,null);
        if(cursor.moveToNext()==true){
            ll_record_result.setVisibility(View.GONE);
            String number=cursor.getString(cursor.getColumnIndex("illegal"));
            String fine=cursor.getString(cursor.getColumnIndex("fine"));
            String dealWith=cursor.getString(cursor.getColumnIndex("isDeal"));
            tv_record_number.setText(number==null?"0":number);
            tv_record_fine.setText(fine==null?"0":fine);
            if(dealWith==null||dealWith.equals("0")){
                tv_record_dealWith.setText("无");
            }else if(dealWith.equals("1")){
                tv_record_dealWith.setText("已处理");
            }else {
                tv_record_dealWith.setText("未处理");
            }
        }else {
            ll_record_result.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(RecordsActivity.this, MoreCarInfoActivity.class);
            intent.putExtra("account", account);
            intent.putExtra("plate", plate);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
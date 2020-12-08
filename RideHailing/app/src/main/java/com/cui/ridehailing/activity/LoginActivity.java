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

public class LoginActivity extends AppCompatActivity {

    EditText edtTxt_account;
    EditText edtTxt_password;
    Button btn_login;
    private String account;
    private String password;
    private double exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edtTxt_account = (EditText) findViewById(R.id.edtTxt_account);
        edtTxt_password = (EditText) findViewById(R.id.edtTxt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = edtTxt_account.getText().toString();
                password = edtTxt_password.getText().toString();
                if (account.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    DataBaseUtil dbu = new DataBaseUtil(LoginActivity.this);
                    SQLiteDatabase sqldb = dbu.getWritableDatabase();
                    /**
                     * 参数 1    表名
                     * 参数 2    需要查询的列
                     * 参数 3    条件
                     * 参数 4    条件值
                     * 参数 5    分组方式
                     * 参数 6    having 条件
                     * 参数 7    排序方式
                     */
                    Cursor cursor = sqldb.query("user", new String[]{"account", "password"},
                            "account = ?", new String[]{account}, null, null, null);
                    if (cursor.moveToNext() == true) {
                        Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
                        //intent 传递参数
                        intent.putExtra("account", account);
                        intent.putExtra("password", password);
                        //SharePreferences 存储数据
                        SharedPreferencesUtil.saveData(LoginActivity.this, "account", account);
                        SharedPreferencesUtil.saveData(LoginActivity.this, "password", password);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //System.currentTimeMillis() 无论何时调用必然大于2000
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(LoginActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
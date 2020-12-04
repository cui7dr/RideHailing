package com.cui.ridehailing.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.cui.ridehailing.R;

public class LoginActivity extends AppCompatActivity {

    EditText edtTxt_account;
    EditText edtTxt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
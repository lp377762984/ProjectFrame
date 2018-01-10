package com.nettech.projectframe.view;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nettech.projectframe.R;
import com.nettech.projectframe.presenter.ImpLoginPrter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private TextInputEditText etPhone;
    private TextInputEditText etPsd;
    private Button btnLogin;
    private ImpLoginPrter loginPrter;
    private TextView tvSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPhone = findViewById(R.id.et_phone);
        etPsd = findViewById(R.id.et_psd);
        btnLogin = findViewById(R.id.btn_login);
        tvSend = findViewById(R.id.tv_send);
        btnLogin.setOnClickListener(this);
        tvSend.setOnClickListener(this);
        loginPrter = new ImpLoginPrter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_send:
                loginPrter.sendCode();
                break;
            case R.id.btn_login:
                loginPrter.login(etPhone.getText().toString(),etPhone.getText().toString());
                break;
        }
    }

    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFaile(String msg) {

    }
}

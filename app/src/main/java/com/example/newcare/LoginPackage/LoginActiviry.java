package com.example.newcare.LoginPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.newcare.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActiviry extends AppCompatActivity {



    @BindView(R.id.userName)
    EditText edtuUserName;

    @BindView(R.id.password)
    EditText edtPass;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiry);
        ButterKnife.bind(this);

        loginPresenter= new LoginPresenter(this);
    }

    @OnClick(R.id.btnLogin)
    void Cliked(View view)
    {
        switch (view.getId()) {
            case R.id.btnLogin:
                loginPresenter.validData(edtuUserName, edtPass);
                break;
        }
    }

    @OnClick(R.id.txtRegister)
    public void onClick() {
        startActivity(new Intent(LoginActivity.this , SignUpActivity.class));

    }

}

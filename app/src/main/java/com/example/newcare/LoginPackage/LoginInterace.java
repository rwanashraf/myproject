package com.example.newcare.LoginPackage;

import android.widget.EditText;

import com.example.newcare.Model.Data;

public interface LoginInterace {
    void  validData(EditText editText, EditText password);
    void callLogin(String userName, String password);
    void openHome(Data userObject);
}

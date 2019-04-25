package com.example.newcare.LoginPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newcare.Constants;
import com.example.newcare.MainActivity;
import com.example.newcare.Model.Data;
import com.example.newcare.Model.LoginResponse;
import com.example.newcare.R;
import com.example.newcare.Remote.ApiUtlis;
import com.example.newcare.Remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter implements LoginInterace {

    private Context context;
    private UserService userService;

    public LoginPresenter(Context context) {
        this.context = context;
        userService = ApiUtlis.getUserService();
    }

    public void validData(EditText editText, EditText password) {
        if (TextUtils.isEmpty(editText.getText().toString().trim())) {
            editText.setError(context.getString(R.string.required));
            editText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty((password.getText().toString().trim()))) {
            password.setError(context.getString(R.string.required));
            password.requestFocus();
            return;
        }
        callLogin(editText.getText().toString().trim(),password.getText().toString().trim());

    }

    @Override
    public void callLogin(String username, String pass) {
        Call<LoginResponse> call = userService.login(username, pass, "rhrui");
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().getValue()) {
                        openHome(response.body().getData());
                    } else {
                        Toast.makeText(context, "sucess", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        ;
    }


    @Override
    public void openHome(Data userObject) {

        if (userObject.getVerified()==1){
            Intent intent=new Intent(context, MainActivity.class);
            intent.putExtra(Constants.userFlag, (Parcelable) userObject);
            context.startActivity(intent);
        }else {
            Intent intent=new Intent(context, MainActivity.class);
            intent.putExtra(Constants.userFlag, (Parcelable) userObject);
            context.startActivity(intent);
        }
    }

}

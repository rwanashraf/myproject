package com.example.newcare.Remote;


import com.example.newcare.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("auth/login")
    Call<LoginResponse> login(
      @Query("email") String email,
      @Query("password") String password,
      @Query("fcm_token_android") String fcm_token_android
    );

}
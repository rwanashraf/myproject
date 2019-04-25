package com.example.newcare.Remote;

public class ApiUtlis {

    public static final String Base_Url="http://car-care.panorama-q.com/api/";


    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }

}
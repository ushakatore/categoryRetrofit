package com.example.categoryretrofit;

import com.example.categoryretrofit.Model.CategoriesModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceAPI {
    String BASE_URL="https://stark-spire-93433.herokuapp.com/";
//    String val="Michael+jackson";
    @GET("/json")
    Call<CategoriesModel> getsearch();
//    @GET("search/{term}")
//    Call<List<Result>> getsearch(@Path("term") String termName);
}

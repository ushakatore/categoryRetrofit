package com.example.categoryretrofit;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.categoryretrofit.Model.CategoriesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView result_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        result_list_view=(RecyclerView)findViewById(R.id.result_list_view);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        result_list_view.setLayoutManager(layoutManager);
        InitRetroCall();
    }

    private void InitRetroCall()
    {


        //        String BASE_URL="https://itunes.apple.com/search?term=Michael+jackson";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit=new Retrofit.Builder().baseUrl(InterfaceAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        InterfaceAPI inetrapi=retrofit.create(InterfaceAPI.class);
        final Call<CategoriesModel> call=inetrapi.getsearch();

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        Call<List<Result>> call=inetrapi.getsearch(InterfaceAPI.val);


        call.enqueue(new Callback<CategoriesModel>() {
            @Override
            public void onResponse(Call<CategoriesModel> call, Response<CategoriesModel> response) {
                CategoriesModel responselist=response.body();
//                resAdpter=new ResultAdapter(getBaseContext(),responselist);
//                result_list_view.setAdapter(resAdpter);
            }

            @Override
            public void onFailure(Call<CategoriesModel> call, Throwable t) {

            }
        });






    }
}

package com.example.gauranggoel.webservicesusingretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Log.d(TAG,"onCreate");
        Api api = retrofit.create(Api.class);
        Log.d(TAG,"got call refrence");

        Callback<Hero> call = new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                Hero hero = response.body();

                Log.d(TAG,"inside onResponse" + response.body());

                if(hero.getEvent().equals("true"))
                {
                    Toast.makeText(MainActivity.this, hero.getEvent()+" "+hero.getNum(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, hero.getEvent()+" "+hero.getNum(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                Log.d(TAG,"onFailure");
                Toast.makeText(MainActivity.this, "Data processing is failed, please check your internet connection", Toast.LENGTH_SHORT).show();

            }
        };
*/


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Log.d(TAG,"onCreate");
        Api api = retrofit.create(Api.class);

        Call<Hero> call = api.getHeroes();

        Log.d(TAG,"got call refrence");
        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                Hero hero = response.body();

                Log.d(TAG,"inside onResponse" + response.isSuccessful());
/*
                if(hero.getTrigger_event().equals("true"))
                {
                    Toast.makeText(MainActivity.this, hero.getTrigger_event()+" "+hero.getNumber(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, hero.getTrigger_event()+" "+hero.getNumber(), Toast.LENGTH_SHORT).show();
                }*/
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {

                Log.d(TAG,"onFailure"+t.getMessage());
                Toast.makeText(MainActivity.this, "Data processing is failed, please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });



/*
 Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
*/

 }
}

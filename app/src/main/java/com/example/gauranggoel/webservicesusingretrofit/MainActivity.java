package com.example.gauranggoel.webservicesusingretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdaptor adapter;
    ProgressDialog pd;
    public static final String TAG="Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pd= new ProgressDialog(this);
        pd.setCanceledOnTouchOutside(true);
        pd.setTitle("Downloading");
        pd.setMessage("Processing...");

        pd.show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Log.d(TAG,"onCreate");
        Api api = retrofit.create(Api.class);

        Call<Hero> call = api.getHeroes();

        Log.d(TAG,"got call refrence");
        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                Hero hero = response.body();

                Log.d(TAG,"inside onResponse " + response.isSuccessful()+"  "+hero + " " + hero.getHero());

                Hero1 hero1=hero.getHero();


                ArrayList<Image> img1=hero1.getImg();


               //Toast.makeText(MainActivity.this, ""+img1.get(0).getIsfriend()+" ", Toast.LENGTH_SHORT).show();

                adapter = new CustomAdaptor(getApplicationContext(), img1);
                recyclerView.setAdapter(adapter);

                if(pd!=null)
                    pd.dismiss();
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {

                Log.d(TAG,"onFailure"+t.getMessage());
                Toast.makeText(MainActivity.this, "Data processing is failed, please check your internet connection", Toast.LENGTH_SHORT).show();

                if(pd!=null)
                    pd.dismiss();
            }
        });



        Button btn = (Button) findViewById(R.id.fetch);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

 }
}

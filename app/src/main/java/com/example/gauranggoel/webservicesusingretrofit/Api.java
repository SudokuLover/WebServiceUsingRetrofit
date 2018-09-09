package com.example.gauranggoel.webservicesusingretrofit;

/**
 * Created by gaurang goel on 09-09-2018.
 */
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Belal on 10/2/2017.
 */

public interface Api {

    String BASE_URL = "https://fellafeeds-assignment.herokuapp.com/";

    @GET("")
    Call<Hero> getHeroes();
}



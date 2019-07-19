package com.studio.suku.tmdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("3/trending/movie/week")
    Call<MoviesResults> getMovies(
            @Query("api_key") String Key
    );

}

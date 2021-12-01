package com.example.timetablemuiv;

import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.HTTP;

public interface JSONPlaceHolderApi {

    @GET("/api/commands/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);

}

package com.sph.interviewdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRetrofitClient {

    @GET("users/{user}/repos")
    Call<List<GithubRepo>> reposForUser(@Path("user")String user);

}

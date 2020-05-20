package com.example.news;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("latest-news?language=en&apiKey=k5lAD1LwgM3IFZTxqgndTDp5jhg63T2KD4r4qrI19lbdUx2r")
    Call<News> getAllNews();

}

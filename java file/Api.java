package com.example.com;


import com.example.com.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface Api {
    @POST("ws/")
    Call<ApiResponse> postFeedBack(@Query("tag") String tag, @Query("name") String name,
                                   @Query("mobile") String mobile, @Query("email") String email, @Query("taste") String taste,
                                   @Query("service") String service, @Query("variety") String variety, @Query("clean") String clean,
                                   @Query("price") String price,@Query("ins") String ins, @Query("ratings") String ratings, @Query("sug") String sug);
}
//http://www.relltech.com/ws/?tag=insert&name=raj&mobile=8122984112&email=raj@testmail.com&
// taste=good&service=good&variety=good&clean=average&price=poor&ratings=3.5&sug=need%20more%20dishes%20with%20quick%20service

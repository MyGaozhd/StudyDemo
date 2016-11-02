package com.gaozhd.studydemo.androidbase.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: MovieService
 * @Description: ${todo}
 * @date 2016/11/2 10:06
 */
public interface MovieService {

    @GET("top250")
    public Call<Movie> getMove(@Query("start") int start, @Query("count") int count);
}

package com.gaozhd.studydemo.androidbase.retrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;
import com.gaozhd.studydemo.utils.LogUtil;
import com.gaozhd.studydemo.utils.ThreedUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
 * @ClassName: RetrofitActivity
 * @Description: ${todo}
 * @date 2016/11/2 9:58
 */
public class RetrofitActivity extends BaseActivity {


    @BindView(R.id.data)
    TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_retrofit1);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.getModel, R.id.getResponse})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getModel:
                getMovieReModel();
                break;
            case R.id.getResponse:
                getMovieReResponse();
                break;
            case R.id.postModel:
                break;
            case R.id.postResponse:
                break;
        }
    }

    /**
     * @Title: getMovieReModel
     * @Description: Retrofit 异步方法获取数据
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/11/2 14:04
     */
    private void getMovieReModel() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        //创建一个Retrofit 对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Call<Movie> call = movieService.getMove(0, 10);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                tv_data.setText(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }

    /**
     * @Title: getMovieReResponse
     * @Description: Rxjava 异步线程中执行Retrofit的的同步方法获取数据
     * @author Gao Zhidong <gaozhidong@tiantanhehe.com>
     * @date 2016/11/2 14:04
     */
    private void getMovieReResponse() {
        Observable<Movie> ob = Observable.create(new Observable.OnSubscribe<Movie>() {
            @Override
            public void call(Subscriber<? super Movie> subscriber) {

                String baseUrl = "https://api.douban.com/v2/movie/";

                //创建一个Retrofit 对象
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MovieService movieService = retrofit.create(MovieService.class);
                Call<Movie> call = movieService.getMove(0, 10);
                try {
                    Movie m = call.execute().body();
                    subscriber.onNext(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ob.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Movie>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Movie movie) {
                tv_data.setText(movie.getTitle());
            }
        });
    }
}

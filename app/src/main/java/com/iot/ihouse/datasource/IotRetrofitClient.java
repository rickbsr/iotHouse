package com.iot.ihouse.datasource;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IotRetrofitClient {
    private static final String BASE_URL = "https://iot.cht.com.tw/iot/v1/";
    private static IotRetrofitClient instance;
    private Retrofit retrofit;
    public static synchronized IotRetrofitClient getInstance() {
        if (instance == null) {
            instance = new IotRetrofitClient();
        }
        return instance;
    }
    private IotRetrofitClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        Interceptor headerAuthorizationInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                // header
                Headers headers = request.headers().newBuilder()
                        .add("CK", "PKXF07HTCEBP2GFYBU")
                        .build();
                request = request.newBuilder().headers(headers).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(headerAuthorizationInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public RawDataApi getRawDataApi(){
        return retrofit.create(RawDataApi.class);
    }
    public NodeDataApi getNodeDataApi(){
        return  retrofit.create(NodeDataApi.class);
    }
}

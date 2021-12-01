package com.example.timetablemuiv;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "http://18.185.249.19";
    private Retrofit mRetrofit;

    private NetworkService() {

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()

                .addInterceptor(interceptor).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

}

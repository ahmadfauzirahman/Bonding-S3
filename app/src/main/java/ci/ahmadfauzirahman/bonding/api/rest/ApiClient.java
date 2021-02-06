package ci.ahmadfauzirahman.bonding.api.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import ci.ahmadfauzirahman.bonding.api.server.ServerConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = ServerConfig.API_ENDPOINT;

    private static Retrofit retrofit = null;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
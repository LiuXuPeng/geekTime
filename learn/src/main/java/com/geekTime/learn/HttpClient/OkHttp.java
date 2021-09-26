package com.geekTime.learn.HttpClient;

import okhttp3.*;
import java.io.IOException;

public class OkHttp {

    public void getRequest() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8801")
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }

    }

    public static void main(String[] args) {
        OkHttp okHttp = new OkHttp();
        try {
            okHttp.getRequest();
        }catch (Exception e){

        }
    }
}

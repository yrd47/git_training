package util;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by yrd on 2017/7/5.
 *
 */
public class OkHttpRequest {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static Response get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("authorization", "eyJhbGciOiJIUzI1NiIsImV4cCI6MjgxNzM5ODA4Njc2LCJpYXQiOjE0NDc4NDA2NzZ9.eyJ1c2VybmFtZSI6ImFkbWluIn0.sRxFS5OivgNh80IiH-bBB7n6-ITMt6QeP1sIRAiV2wc")
                .build();
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw  new IOException("Unexpected code" + response);

//        Headers responseHeaders = response.headers();
//        for (int i=0 ; i<responseHeaders.size() ; i++){
//            System.out.println(responseHeaders.name(i) + ":" + responseHeaders.value(i));
//        }
        return response;
    }
}

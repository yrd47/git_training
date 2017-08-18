package testnglistener;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by yrd on 2017/5/24.
 *
 */
public class PostResult {

    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public Boolean post(String url,String result) throws IOException{
        RequestBody requestBody = RequestBody.create(JSON,result);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.isSuccessful();
    }
}

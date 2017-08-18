package okhttp3;

import java.io.IOException;

/**
 * Created by yrd on 2017/5/24.
 *
 */

public class PostExample {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    private Integer post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code" + response);
        return response.code();
    }

    private void get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if(!response.isSuccessful()) throw  new IOException("Unexpected code" + response);

        Headers responseHeaders = response.headers();
        for (int i=0 ; i<responseHeaders.size() ; i++){
            System.out.println(responseHeaders.name(i) + ":" + responseHeaders.value(i));
        }
        System.out.println(response.body().string());
    }

    private void asyGet(String url) throws Exception{
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()) throw  new IOException("Unexpected code" + response);

                Headers responseHeaders = response.headers();
                for (int i=0 ; i<responseHeaders.size() ; i++){
                    System.out.println(responseHeaders.name(i) + ":" + responseHeaders.value(i));
                }
                System.out.println(response.body().string());
            }
        });
    }

    public static void main(String[] args) throws Exception {
        PostExample example = new PostExample();
        String json = example.bowlingJson("Jesse", "Jake");
        int response = example.post("http://www.roundsapp.com/post", json);
        System.out.println(response);
        String getUrl = "http://publicobject.com/helloworld.txt";
        example.get(getUrl);
//        example.asyGet(getUrl);
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }
}

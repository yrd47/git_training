package okhttp3;

import org.json.JSONArray;
import org.json.JSONObject;
import util.HttpRequest;

/**
 * Created by yrd on 2017/7/3.
 *
 */

public class ETraceTest {

    public static final String etraceUlr = "http://trace-gw.elenet.me";

    public static void main(String[] args) throws Exception {
        ETraceTest eTraceTest = new ETraceTest();
        String result = eTraceTest.getAppId();
        System.out.println(result);
    }

    public String getAppId() throws Exception {
        String url = etraceUlr + "/proxy/meta/app";
        String param = "appId=zeus.eos";
//        String ur = baseUrl + "?" + param;
//        Response response = OkHttpRequest.get(url);
//        String result = response.body().string();
//        System.out.println(result);
        String result = HttpRequest.sendGet(url, param);
//        JsonNode jsonNode = JSONUtil.fromJson(result);
//        JsonArrayFormatVisitor machine = jsonNode.get("Machine,RUN_ON");
//        System.out.println(machine);
        JSONObject jsonObject =new JSONObject(result);
        JSONArray jsonArray = jsonObject.optJSONArray("Machine,RUN_ON");
        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.getJSONObject(i).getString("hostIp"));
        }
        return result;
    }

    public String getAppDependency() {
        String url = "http://trace-gw.elenet.me/proxy/meta/app-dependency";
        String param = "appId=zeus.eos";
        String result = HttpRequest.sendGet(url, param);
        System.out.println(result);
        return result;
    }
}

package okhttp3;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Huskar.*;
import util.OkHttpRequest;

/**
 * Created by yrd on 2017/7/5.
 *
 */

public class HuskarTest {

    public static final String BASE_URL = "http://soa-api.alpha.elenet.me/api";

    private Application getApplicationList() throws Exception {
        String url = BASE_URL + "/" + "application";
        Response response = OkHttpRequest.get(url);
        ObjectMapper mapper = new ObjectMapper();
        Application application = mapper.readValue(response.body().string(), Application.class);
        return application;
    }

    private Cluster getCluserService(String name) throws Exception {
        String baseUrl = BASE_URL + "/" + "service";
        String url = baseUrl + "/" + name;
        Response response = OkHttpRequest.get(url);
        ObjectMapper mapper = new ObjectMapper();
        Cluster cluster = mapper.readValue(response.body().string(), Cluster.class);
        return cluster;
    }

    private Instance getInstance(String applicationName, String clusterName) throws Exception {
        String baseUrl = BASE_URL + "/" + "service";
        String url = baseUrl + "/" + applicationName + "/" + clusterName;
        Response response = OkHttpRequest.get(url);
        ObjectMapper mapper = new ObjectMapper();
        Instance instance = mapper.readValue(response.body().string(), Instance.class);
        return instance;
    }

    public static void main(String[] args) throws Exception {
        HuskarTest example = new HuskarTest();
        Application application = example.getApplicationList();
        System.out.println(application.getData().get(0).getName());
        Cluster cluster = example.getCluserService(application.getData().get(0).getName());
        for (ClusterInfo clusterInfo:
             cluster.getData()) {
            System.out.println(clusterInfo.getName());
            Instance instance = example.getInstance(application.getData().get(0).getName(), clusterInfo.getName());
            System.out.println(instance.getData().get(0).getKey());
            ObjectMapper mapper = new ObjectMapper();
            Value value = mapper.readValue(instance.getData().get(0).getValue(), Value.class);
            System.out.println(value.getIp());
        }
    }
}

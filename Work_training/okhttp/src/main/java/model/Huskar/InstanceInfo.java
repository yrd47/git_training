package model.Huskar;

import lombok.Data;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class InstanceInfo {

    private String application;
    private String cluster;
    private String key;
    private String runtime;
    private String value;

    public InstanceInfo() {

    }

    public InstanceInfo(String application, String cluster, String key, String runtime, String value) {
        this.application = application;
        this.cluster = cluster;
        this.key = key;
        this.runtime = runtime;
        this.value = value;
    }
}

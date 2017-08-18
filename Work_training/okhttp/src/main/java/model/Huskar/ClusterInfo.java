package model.Huskar;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class ClusterInfo {

    private String name;
    private String physical_name;
    private HashMap<String, String> route;

    public ClusterInfo() {

    }

    public ClusterInfo(String name, String physical_name, HashMap<String, String> route) {
        this.name = name;
        this.physical_name = physical_name;
        this.route = route;
    }
}

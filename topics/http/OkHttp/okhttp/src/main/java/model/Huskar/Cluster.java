package model.Huskar;

import lombok.Data;

import java.util.List;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class Cluster extends Base {

    private List<ClusterInfo> data;

    public Cluster() {
        super();
    }

    public Cluster(String message, String name, List<ClusterInfo> data) {
        super(message, name);
        this.data = data;
    }
}

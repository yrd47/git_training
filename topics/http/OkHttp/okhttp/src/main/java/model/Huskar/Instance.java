package model.Huskar;

import lombok.Data;

import java.util.List;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class Instance extends Base {

    private List<InstanceInfo> data;

    public Instance() {
        super();
    }

    public Instance(String message, String status, List<InstanceInfo> data) {
        super(message, status);
        this.data = data;
    }

}

package model.Huskar;

import lombok.Data;

import java.util.List;

/**
 * Created by yrd on 2017/7/5.
 */

@Data
public class Application extends Base {

    private List<ApplicationInfo> data;

    public Application() {
        super();
    }

    public Application(List<ApplicationInfo> data, String message, String status) {
        super(message, status);
        this.data = data;
    }
}

package model.Huskar;

import lombok.Data;

/**
 * Created by yrd on 2017/7/5.
 */

@Data
public class ApplicationInfo {

    private String name;
    private String team;

    public ApplicationInfo() {

    }

    public ApplicationInfo(String name, String team) {
        this.name = name;
        this.team = team;
    }
}

package model.Huskar;

import lombok.Data;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class Base {

    private String message;
    private String status;

    public Base() {

    }

    public Base(String message, String status) {
        this.message = message;
        this.status = status;
    }

}

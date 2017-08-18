package model.Huskar;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by yrd on 2017/7/5.
 *
 */

@Data
public class Value {

    private String ip;
    private HashMap<String, String > meta;
    private String name;
    private HashMap<String, Integer> port;
    private String state;

    public Value() {

    }

    public Value(String ip, HashMap<String, String > meta, String name, HashMap<String, Integer> port, String state) {
        this.ip = ip;
        this.meta = meta;
        this.name = name;
        this.port = port;
        this.state = state;
    }

}

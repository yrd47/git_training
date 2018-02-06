package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by yrd on 2017/7/3.
 */
public class JSONUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static JsonNode fromJson(String json) throws IOException {
        return objectMapper.readValue(json, JsonNode.class);
    }

    public void use() {
//        JsonNode body = JSONUtil.fromJson(response.body().string());
//        String status = body.get("status").asText();
//        System.out.println(status);
    }
}

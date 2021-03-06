package com.peihua8858;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * 字符串类型适配
 *
 * @author dingpeihua
 * @version 1.0
 * @date 2020/6/30 16:14
 */
public class StringTypeAdapter implements JsonSerializer<String>, JsonDeserializer<String> {


    @Override
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json == null) {
            return null;
        } else {
            try {//直接解析
                if (json.isJsonArray()) {
                    return json.getAsJsonArray().toString();
                }
                if (json.isJsonObject()) {
                    return json.getAsJsonObject().toString();
                }
               /* String result = json.getAsString();
                if ("null".equalsIgnoreCase(result)){
                    return  null;
                }*/
                return json.getAsString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

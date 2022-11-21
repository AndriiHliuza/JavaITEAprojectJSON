package org.example;

import org.json.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        System.out.println(jo);

        jo.put("name", "joe doe");
        jo.put("age", "22");
        jo.put("city", "chicago");

        System.out.println(jo);

        Map<String, String> map = new HashMap<>();
        map.put("name", "joe doe");
        map.put("age", "22");
        map.put("city", "chicago");

        JSONObject jsonObject = new JSONObject(map);

        System.out.println(jsonObject);

        JSONObject jsonObject1 = new JSONObject("{\"city\":\"chicago\",\"name\":\"joe don\",\"age\":\"22\"}");
        System.out.println(jsonObject1);

        DemoBean demoBean = new DemoBean();
        demoBean.setId(1);
        demoBean.setName("lorem ipsum");
        demoBean.setActive(true);

        JSONObject jsonObject2 = new JSONObject(demoBean);

        System.out.println("Json object 2: " + jsonObject2);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(Boolean.TRUE);
        jsonArray.put("lorem ipsum");

        jsonArray.put(jo);

        System.out.println(jsonArray);

        JSONArray ja = new JSONArray("[true, \"lorem ipsum\", 215]");

        Boolean b = (Boolean) ja.get(0);
        System.out.println(b);

        JSONTokener jsonTokener = new JSONTokener("lorem");

        while (jsonTokener.more()) {
            System.out.println(jsonTokener.next());
        }

        JSONArray jsonArray1 = CDL.rowToJSONArray(new JSONTokener("England, USA, Canada"));
        System.out.println(jsonArray1);


        JSONArray jsonArray2 = new JSONArray("[\"England\",\"USA\",\"Canada\"]");
        String cdt = CDL.rowToString(jsonArray2);
        System.out.println(cdt);

        String cookie = "hello=bob; data=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
        JSONObject cookieJO = Cookie.toJSONObject(cookie);
        System.out.println(cookieJO);

        String str = Cookie.toString(cookieJO);
        System.out.println("Str -> " + str);


        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("Method", "POST");
        jsonObject3.put("Request-URI", "http://www.example.com/");
        jsonObject3.put("HTTP-Version", "HTTP/1.1");
        String httpStr = HTTP.toString(jsonObject3);
        System.out.println(httpStr);

    }
}
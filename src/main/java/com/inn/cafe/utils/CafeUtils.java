package com.inn.cafe.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.description.method.MethodDescription;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CafeUtils {

    private CafeUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }

    public static String getUUID(){
        Date date = new Date();
        long time = date.getTime();
        return "BILL-" + time;
    }

    public static JSONArray getJsonArrayFromString(String data) throws JSONException{
        return new JSONArray(data);
    }

    public static Map<String, Object> getMapFromJson(String data){
        if(data != null){
            return new Gson().fromJson(data, new TypeToken<Map<String,Object>>(){
            }.getType());
        }
        return new HashMap<>();
    }

    public static boolean isFileExist(String path){
        log.info("Inside isFileExist {}", path);
        try{
            File file = new File(path);
            return (file != null && file.exists()) ? Boolean.TRUE : Boolean.FALSE;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}

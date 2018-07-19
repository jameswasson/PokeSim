package Utils;

import com.google.gson.Gson;

public class myGson {

    public static String toJson(Object o){
        return new Gson().toJson(o);
    }
    public static <K> K fromJson(String s,Class <K> klass){
        return new Gson().fromJson(s,klass);
    }
}

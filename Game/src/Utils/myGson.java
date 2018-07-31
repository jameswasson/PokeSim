package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class myGson {

    public static String toJson(Object o){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(o);
    }
    public static <K> K fromJson(String s,Class <K> klass){
        return new Gson().fromJson(s,klass);
    }
}

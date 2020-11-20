package cs.vsu.utils;

import java.util.HashMap;
import java.util.Map;

public class RequestUtils {
    public static <T> Map<String,T> fromStrToMap(String str){
        Map <String, T> res = new HashMap <>();
        String[] pairs = str.split(",");
        String[] tmp;
        for (String pair : pairs) {
            tmp = pair.split(":");
            if (tmp.length<2)
                tmp = pair.split("=");
            res.put(tmp[0], (T) tmp[1]);
        }
        return res;
    }
}

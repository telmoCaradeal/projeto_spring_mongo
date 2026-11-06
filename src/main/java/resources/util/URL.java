package resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decodeParm(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}

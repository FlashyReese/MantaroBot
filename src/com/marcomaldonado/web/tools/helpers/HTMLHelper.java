package com.marcomaldonado.web.tools.helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Mxrck on 19/11/2015.
 */
public class HTMLHelper {

    private static HTMLHelper instance;

    protected HTMLHelper() {
    }

    public static HTMLHelper getInstance() {
        if (instance == null) {
            instance = new HTMLHelper();
        }
        return instance;
    }

    public String get(String url) {
        return null;
    }

    public String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
    public String urlEncodeUTF8(Map<?,?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?,?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }

}

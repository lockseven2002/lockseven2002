package com.example.lockseven2002.readphptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lockseven2002 on 2016/6/6.
 */
public class Http_Connect {
    private String strUrl = "";
    protected Http_Connect(String httpUrl) {
        this.strUrl = httpUrl;
    }
    public String http_Conn() {
        HttpURLConnection httpconn = null;
        StringBuffer strBuff = new StringBuffer();
        BufferedReader bufReader = null;
        String strLine="";
        String strEndSplit = "";
        try {
            URL url = new URL(strUrl);
            httpconn = (HttpURLConnection) url.openConnection();
            httpconn.connect();
            InputStream stream = httpconn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(stream));
            while ((strLine = bufReader.readLine()) != null) {
                strBuff.append(strLine);
            }
            Json_Split splitStr = new Json_Split(strBuff.toString());
            strEndSplit = splitStr.endSplit();
            return strEndSplit;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

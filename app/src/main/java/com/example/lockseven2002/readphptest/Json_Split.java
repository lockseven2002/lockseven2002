package com.example.lockseven2002.readphptest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lockseven2002 on 2016/6/6.
 */
public class Json_Split {
    private String strStartSplit = "";
    private JSONObject parentJsonObj;
    private JSONArray parentJsonArray = new JSONArray();
    private JSONObject childJsonObj = new JSONObject();
    private String strEndSplit = "";
    //=====================================================================
    private String strPID = "";
    private String strName = "";
    private String strPrice = "";
    private String strCreated_at = "";
    private String strUpdated_at = "";
    private String strEmpty = "";
//=======================================================================
    public  Json_Split(String externalStr){
        this.strStartSplit = externalStr;
    }
    public Json_Split(){}
    public String endSplit(){
        try {
            parentJsonObj = new JSONObject(strStartSplit);
            //取得大括弧內name/value的數量
            //return String.valueOf(parentJsonObj.length());
            parentJsonArray = parentJsonObj.getJSONArray("products");
//=====================================================================================
            //以Key為準取JSONOBJ的Value
            for(int i=0;i<parentJsonArray.length();i++){
                childJsonObj = parentJsonArray.getJSONObject(i);
                for(int j=0;j<childJsonObj.length();j++){
                    strPID = childJsonObj.getString("pid");
                    strName = childJsonObj.getString("name");
                    strPrice = childJsonObj.getString("price");
                    strCreated_at = childJsonObj.getString("created_at");
                    strUpdated_at = childJsonObj.getString("updated_at");
                }
                strEmpty = strEmpty+strPID+"***"+strName+"***"+strPrice+"***"+strCreated_at+"***"
                         +strUpdated_at+"#";
            }
//=======================================================================================
            return  strEmpty;
            //取得"success"內的name
            //return parentJsonObj.getString("success");
        } catch (JSONException e) {
            e.printStackTrace();
            return "No data!!";
        }
    }

}

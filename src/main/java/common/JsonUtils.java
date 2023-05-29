package common;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {
	
	public static String  getValueByJsonKey(String json, String key) {
		JSONObject jObject =new JSONObject(json);
		String result = jObject.getString(key);
		return result;
	}
	public static Object getValurByJsonKey(Object jsonObject, String  key) {
		JSONObject resultObj = (JSONObject)jsonObject;
		 Object result = resultObj.get(key);
		 return result;
	}

}

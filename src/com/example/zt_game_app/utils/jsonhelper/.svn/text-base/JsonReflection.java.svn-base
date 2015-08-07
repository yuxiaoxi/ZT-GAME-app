package com.example.zt_game_app.utils.jsonhelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReflection {

	/**
	 * jsonArray converted into list object
	 * 
	 * @param jsonArray
	 * @param packageName
	 * @return
	 */
	// 屏蔽代码警告
	@SuppressWarnings("unchecked")
	public static <T> List<T> getListObject(JSONArray jsonArray,
			String packageName) {
		List<T> list = new ArrayList<T>();

		List<String> listKey = new ArrayList<String>();
		List<String> listValues = new ArrayList<String>();
		List<String> listType = new ArrayList<String>();
		List<String> listName = new ArrayList<String>();

		Class<?> cls = null;
		try {
			cls = Class.forName(packageName);
			Field[] fieldlist = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				listType.add(fld.getType().toString());
				listName.add(fld.getName());
				String newStr = fld.getName().substring(0, 1).toUpperCase()
						+ fld.getName().replaceFirst("\\w", "");
				listKey.add(newStr);
			}
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject item;
				item = jsonArray.getJSONObject(i);
				for (int j = 0; j < listName.size(); j++) {
                    try{
                        if (item.getString(listName.get(j))==null) {
                            listValues.add("");
                        }else {
                            listValues.add(item.getString(listName.get(j)));
                        }
                    }catch(Exception e){
                        listValues.add("");
                        continue;
                    }

				}
				list.add((T) Reflection.get(packageName, listKey, listValues,
						listType));
				listValues.clear();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(JSONObject jsonObject, String packageName) {
		
		List<String> listKey = new ArrayList<String>();
		List<String> listValues = new ArrayList<String>();
		List<String> listType = new ArrayList<String>();
		List<String> listName = new ArrayList<String>();
		Class<?> cls = null;
		try {
			cls = Class.forName(packageName);
			Field[] fieldlist = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				listType.add(fld.getType().toString());
				listName.add(fld.getName());
				String newStr = fld.getName().substring(0, 1).toUpperCase()
						+ fld.getName().replaceFirst("\\w", "");
				listKey.add(newStr);
			}
			for (int j = 0; j < listName.size(); j++) {
                try{
                    if (jsonObject.getString(listName.get(j))==null) {
                        listValues.add("");
                    } else {
                        listValues.add(jsonObject.getString(listName.get(j)));
                    }
                }catch(Exception e){
                    listValues.add("");
                    continue;
                }
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) Reflection.get(packageName, listKey, listValues,
				listType);
	}
}

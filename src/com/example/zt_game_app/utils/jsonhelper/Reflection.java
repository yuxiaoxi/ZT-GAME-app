package com.example.zt_game_app.utils.jsonhelper;

 import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class Reflection {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object get(String packageName,List<String> params,List<String> value,List<String> type){
		Object obj=null;
		try {
			Class cls = Class.forName(packageName);
			Constructor ct = cls.getConstructor();
			obj = ct.newInstance();
			for(int i=0;i<params.size();i++){
				Class paramTypes[] = getParamTypes(cls, "set"+params.get(i));
				Method meth = cls.getMethod("set"+params.get(i), paramTypes);
				meth.setAccessible(true);
				if(type.get(i).equals("int")){
                    meth.invoke(obj, Integer.parseInt(value.get(i)));
				}else if(type.get(i).equals("class java.lang.String")){
					meth.invoke(obj, value.get(i));
				}else if(type.get(i).equals("class java.lang.Double")||type.get(i).equals("double")){
					meth.invoke(obj, Double.parseDouble(value.get(i)));
				}else if(type.get(i).equals("class java.lang.Float")||type.get(i).equals("float")){
                    meth.invoke(obj, Float.parseFloat(value.get(i)));
                }
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return obj;
	}
	
	@SuppressWarnings("rawtypes")
	private static Class[] getParamTypes(Class cls, String mName) {
        Class[] cs = null;
        Method[] mtd = cls.getDeclaredMethods();    
        for (int i = 0; i < mtd.length; i++) {
            if (!mtd[i].getName().equals(mName)) {    
                continue;
            }
            cs = mtd[i].getParameterTypes();
        }
        return cs;
    }
}

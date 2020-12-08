package com.cui.ridehailing.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author cui
 * @version 1.0.0
 * @time 2020/12/8 21:00
 */
public class SharedPreferencesUtil {

    //存储SharedPreferences的文件名
    private static final String fileName = "save_name";

    /**
     * 保存数据/修改数据
     *
     * @param context
     * @param key
     * @param data
     */
    public static String saveData(Context context, String key, Object data) {
        String dataType = data.getClass().getTypeName();
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if ("Integer".equals(dataType)) {
            editor.putInt(key, (Integer) data);
        } else if ("Boolean".equals(dataType)) {
            editor.putBoolean(key, (Boolean) data);
        } else if ("String".equals(dataType)) {
            editor.putString(key, (String) dataType);
        } else if ("Float".equals(dataType)) {
            editor.putFloat(key, (Float) data);
        } else if ("Long".equals(dataType)) {
            editor.putLong(key, (Long) data);
        }
        editor.commit();
        return dataType;
    }

    /**
     * 读取数据
     *
     * @param context
     * @param key
     * @param value
     * @return
     */
    public static Object getData(Context context, String key, Object value) {
        String valueType = value.getClass().getTypeName();
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        //value为默认值，如果当前获取不到数据就返回他
        if ("Integer".equals(valueType)) {
            return sp.getInt(key, (Integer) value);
        } else if ("Boolean".equals(valueType)) {
            return sp.getBoolean(key, (Boolean) value);
        } else if ("String".equals(valueType)) {
            return sp.getString(key, (String) value);
        } else if ("Float".equals(valueType)) {
            return sp.getFloat(key, (Float) value);
        } else if ("Long".equals(valueType)) {
            return sp.getLong(key, (Long) value);
        }
        return null;
    }

    /**
     * 清空数据
     *
     * @param context
     */
    public static void clearData(Context context) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}

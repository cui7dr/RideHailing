package com.cui.ridehailing.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author cui
 * @version 1.0.0
 * @time 2020/11/30 19:57
 */
public class DataBaseUtil extends SQLiteOpenHelper {

    public DataBaseUtil(Context context) {
        //version 数据库版本号只增不减，仅发生改变时，才能执行 onUpgrade()
        super(context, "ride_hailing.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * 创建账户表
         *
         * account----账号
         * password----密码
         * flag----账号等级
         * createTime----创建时间
         * updateTime----更新时间
         * spare----备用
         */
        db.execSQL("CREATE TABLE 'user' ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "'account' TEXT NOT NULL, 'password' TEXT NOT NULL, 'flag' INTEGER NOT NULL, " +
                "'createTime' TEXT NOT NULL, 'updateTime' TEXT NOT NULL, 'spare1' TEXT, 'spare2' " +
                "TEXT, 'spare3' TEXT);");

        /**
         * 创建车主表
         *
         * name----姓名
         * sex----性别
         * birth----出生日期
         * country----国籍
         * plate----车牌
         * address----地址
         * license----驾照
         * model----车型
         * start----开始日期
         * end----结束日期
         */
        db.execSQL("CREATE TABLE 'owner' ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'name'" +
                " TEXT, 'sex' TEXT, 'birth' TEXT, 'country' TEXT, 'plate' TEXT, 'address' TEXT, " +
                "'license' TEXT, 'model' TEXT, 'start' TEXT, 'end' TEXT, 'createTime' TEXT, " +
                "'updateTime' TEXT, 'spare1' TEXT, 'spare2' TEXT, 'spare3' TEXT);");

        /**
         * 创建车辆表
         *
         * transport----运输证编号
         * plate----车牌
         * brand----车辆品牌
         * seat----座位数
         * color----车辆颜色
         * size----车辆尺寸
         * run----经营范围
         * status----经营状态
         * organ----发证机关
         * illegal----违法次数
         * fine----罚款
         * isDeal----是否处理
         * first----起点
         * end----目的地
         * context----违法描述
         */
        db.execSQL("CREATE TABLE 'car' ('id' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "'transport' TEXT, 'plate' TEXT, 'brand' TEXT, 'seat' INTEGER, 'color' TEXT, " +
                "'size' TEXT, 'run' TEXT, 'status' TEXT, 'organ' TEXT, 'illegal' INTEGER, 'fine' " +
                "INTEGER, 'isDeal' INTEGER, 'first' TEXT, 'end' TEXT, 'context' TEXT, " +
                "'createTime' TEXT, 'updateTime' TEXT, 'spare1' TEXT, 'spare2' TEXT, 'spare3' " +
                "TEXT);");
    }

    //修改表结构（添加字段
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}

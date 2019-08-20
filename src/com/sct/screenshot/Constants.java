package com.sct.screenshot;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Environment;

import java.io.File;



/**
 * Created by huanglianzheng on 16/11/30.
 */

public class Constants {
   /* zwx add 20190404*/
	public static int colorposition =0;  //颜色位置
	public static int colorERASER =0;  //擦除颜色
	public static int withERASER =50;  //擦除笔粗�?
	
	public static String WEBIP ="120.79.248.49";  //web服务端IP (上传和下载文件）
	
    public static int displayWidth;  //屏幕�?
    public static int displayHeight; //屏幕�?
    /**
     * 注册码的长度
     */
    public static int REGISTER_NUM_LENGTH = 27;

    /**
     * �?单的数据存储�?
     */
    public static SharedPreferences PUBLIC_SHARED = null;

    /**
     * 注册与试用时访问的链�?
     */
    public static final String MAIN_PATH = "http://www.cec-sct.com:18080/UserManager/isExist_Reg_code";
    public static final String MAIN_PATH_1 = "http://www.cec-sct.com:18080/UserManager/isExist_Trial_code1";
    public static final String MAIN_PATH_2 = "http://www.cec-sct.com:18080/UserManager/isExist_Trial_code2";

    /**
     * 记录多点触控的状�?
     */
    public static boolean MULTI_TOUCH_STATUS = false;
    /**
     * 记录主板信息
     */
    public static int MAINBOARD = 828;
    /**
     * 记录工具状�?��?�比如多屏触控等
     */
    public static SharedPreferences TOOLS_SHARED = null;

    /**
     * 用于记录软件更新�?测时的数�?
     */
    public static String version = null; // 记录版本信息
    public static String description = null; // 记录版本描述信息
    public static String apkURL = null; // 记录新版本下载路�?

    /**
     * 数组颜色�?0黑色�?1白色�?2红色�?3紫色�?4深蓝色，5蓝色�?6青色�?7绿色�?8黄色�?10橘黄色，11橘黄�?
     */
    public static int[] mColor = new int[] { Color.WHITE, Color.BLACK,
            0xffB8DB7C, 0xffFFFB9C, 0xff007CC3, 0xffDA251D, 0xffDD137B,
            0xff00923F, 0xffE77817,0xff00D8FF , 0xff5F3A74, 0xff75C5F0, };
    
/** 设置白板背景颜色   */
    public static int[] mColorBg =  new int[]{ 
            0xff6382A1, 0xff31485E, 0xff44617B, 0xff393F4C, 0xff203744,
            0xff262729, 0xff474A4D,0xff50616D , 0xffffffff, };


    /**
     * 获取文件存储路径的方�?
     */
    public static String getStrokeFilePath(String saveFileName,String saveFileType){
        File sdcarddir = android.os.Environment.getExternalStorageDirectory();// 得到外部sdcard储存目录以便可以保存文件
        String strDir = sdcarddir.getPath() + "/DCIM/pictures/";// 文件目录�?
        String strFileName = saveFileName + saveFileType;// 调用得到方法得到文件�?
        File file = new File(strDir); // 使用文件名生成目�?
        if (!file.exists())// 如果文件不存在就生成文件
        {
            file.mkdirs();// 生成目录
        }
        String strFilePath = strDir + strFileName;
        return strFilePath;// 返回文件路径
    }

    /**
     * 获取文件存储路径的方�?
     */
    public static String getStrokeFile(String saveFileName,int i,String saveFileType){
        File sdcarddir = android.os.Environment.getExternalStorageDirectory();// 得到外部sdcard储存目录以便可以保存文件
        String strDir = sdcarddir.getPath() + "/"+saveFileName+"/";// 文件目录�?
        String strFileName = "page"+ i +saveFileType;// 调用得到方法得到文件�?
        File file = new File(strDir); // 使用文件名生成目�?
        if (!file.exists())// 如果文件不存在就生成文件
        {
            file.mkdirs();// 生成目录
        }
        String strFilePath = strDir + strFileName;
        return strFilePath;// 返回文件路径
    }

    public static int currentindex = 0;//用于记录当前页面
    public static int allPage = 0;//用于记录总页�?

    public static boolean isShot=true;//记录截图按钮只能点击�?次，防止多次点击出现黑屏


    public static final String FOLDER_TEMP_FILE_PATH = Environment.getExternalStorageDirectory().toString() + "/IClass/temp/";

    public static float DEFAULT_SCREEN_HEIGHT = 0.0f;
    public static float DEFAULT_SCREEN_WIDTH = 0.0f;

    static {

        Constants.DEFAULT_SCREEN_WIDTH = 1256.0f;
        Constants.DEFAULT_SCREEN_HEIGHT = 588.0f;
    }
}

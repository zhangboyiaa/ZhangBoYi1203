package com.bawei.zhangboyi.utile;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * date:2019/12/3
 * author:张博一(zhangboyi)
 * function:封装网络判断类
 */
public class Netutile {

    private static Netutile netutile = new Netutile();

    public static Netutile getInstance() {
        return netutile;
    }

    private Netutile(){

    }

    //流转json
    public String io2String(InputStream inputStream){
        byte[] bytes = new byte[1024];

        int len = -1;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String json = "";
        try {
            while ((len = inputStream.read(bytes)) != -1){
                byteArrayOutputStream.write(bytes,0,len);
            }

            json = new String(byteArrayOutputStream.toByteArray());
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return json;
    }

    //流转bitmap
    public Bitmap io2bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }

    //请求json
    @SuppressLint("StaticFieldLeak")
    public void doGet(String httpurl, final MyCallBack myCallBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    myCallBack.onError(new Exception("请求失败"));
                }else {
                    myCallBack.ondoGetSuccsess(s);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                HttpURLConnection httpURLConnection = null;
                InputStream inputStream = null;
                String json = "";
                try {
                    URL url = new URL(strings[0]);
                    httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("GET");

                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);

                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() != 200){
                        Log.i("httpURLConnection","文字请求失败");
                        return json;
                    }
                    json = io2String(httpURLConnection.getInputStream());
                }catch (IOException i){
                    i.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }

                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return json;
            }
        }.execute(httpurl);
    }

    //请求图片
    @SuppressLint("StaticFieldLeak")
    public void doGetPhoto(String httpurl, final MyCallBack myCallBack){
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                myCallBack.ondoGetPhotoSuccsess(bitmap);
            }

            @Override
            protected Bitmap doInBackground(String... strings) {
                HttpURLConnection httpURLConnection = null;
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    URL url = new URL(strings[0]);
                    httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("GET");

                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);

                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() != 200){
                        Log.i("httpURLConnection","文字请求失败");
                        return bitmap;
                    }
                    bitmap = io2bitmap(httpURLConnection.getInputStream());
                }catch (IOException i){
                    i.printStackTrace();
                }finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }

                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return bitmap;
            }
        }.execute(httpurl);
    }

    //接口
    public  interface MyCallBack{
        void ondoGetSuccsess(String json);

        void ondoGetPhotoSuccsess(Bitmap bitmap);

        void onError(Throwable throwable);
    }
}

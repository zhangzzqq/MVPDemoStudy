package com.example.administrator.mvpdemo.utils;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

/**
 * Created by Android on 2017/11/22.
 */

public class NetUtils {

    public static boolean isNetworkAvailable(Context context) {
        Boolean isUseful=false;
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    isUseful = true;
                }
            }
        }
        return isUseful;
    }


    public static final boolean ping() {

        Boolean isPing=false;
        try {
            Process process = Runtime.getRuntime().exec("/system/bin/ping -c 1 -w 1 " + "www.baidu.com");
            int status = process.waitFor();
            if (status == 0) {
                isPing=true;
            } else {
                isPing=false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isPing;
    }

    /**
     * 手机是否开启位置服务，如果没有开启那么所有app将不能使用定位功能
     */
    public static boolean isLocServiceEnable(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }



}

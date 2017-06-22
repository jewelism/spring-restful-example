package com.daydic.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by megap on 2017-05-20.
 */
public class Helper {
    public Helper(){

    }
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}

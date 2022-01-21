package com.example.mysql_test;

import android.util.Log;

public class log_print {

    public log_print() { }
    public static void _dbg_msg(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[0];
        StringBuilder sb = new StringBuilder();

        sb.append("[DEBUG:");
        sb.append((new Throwable()).getStackTrace()[0].getFileName());
        sb.append("> ");
        sb.append((new Throwable()).getStackTrace()[0].getClassName());
        sb.append("> #");
        sb.append((new Throwable()).getStackTrace()[0].getLineNumber());
        sb.append("] ");
        sb.append(message);

        Log.d("STATE", sb.toString());


        if(sb != null) {
            sb = null;
        }

    }

    public static void _dbg_msg(String title, String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[0];
        StringBuilder sb = new StringBuilder();

        sb.append("[" + title + "] - " + "[DEBUG:");
        sb.append((new Throwable()).getStackTrace()[0].getFileName());
        sb.append("> ");
        sb.append((new Throwable()).getStackTrace()[0].getClassName());
        sb.append("> #");
        sb.append((new Throwable()).getStackTrace()[0].getLineNumber());
        sb.append("] ");
        sb.append(message);

        Log.d("STATE", sb.toString());


        if(sb != null) {
            sb = null;
        }

    }
}

package com.example.mysql_test;

import android.util.Log;
public final class DBLog {
    private static boolean DEBUG = true;

    public static final String tag_InqueryOfGradeJudgmentData = "InqueryOfGradeJudgmentData";
    public static final String tag_MainActivity = "MainActivity";

    public static int v(String tag, String msg) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.v(tag, msg, tr);
    }

    public static int e(String tag, String msg) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.e(tag, msg);
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.e(tag, msg, tr);
    }

    public static int w(String tag, String msg) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.w(tag, msg);
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.w(tag, msg, tr);
    }

    public static int i(String tag, String msg) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.i(tag, msg);
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.i(tag, msg, tr);
    }

    public static int d(String tag, String msg) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (DEBUG == false) {
            return 0;
        }
        return Log.d(tag, msg, tr);
    }

}

package com.example.mysql_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private static final String ASSETS_FILE_DB = "databases/" + ConstColumnNames.DB_FILE_NAME;
    private static final String LAONPEOPLE_DB_NAME = ConstColumnNames.DB_FILE_NAME;

    private ArrayList<DBColumnVarables>  m_array_judg = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //int x = 0;
        insert_column h_column = insert_column.insert_column_instance();
        GRDCOW_DB_ColumnName dbm = new GRDCOW_DB_ColumnName(this);

        DBLog.d("STATE", "DB File is copying in Package file");
        //DBLog.d("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        CopyDBFile(this);
/*
        for (int x = 0; x <= 30; x++) {
            Date c = Calendar.getInstance().getTime();
            int attcode = 7777;
            int usecode = 8888;
            int weight = 3333;
            h_column.m_ABATT_CODE = String.format("%s", String.format("%d", attcode + x));
            h_column.m_JUDGE_DATE = String.format("%d", c.getDate() + x);
            h_column.m_USE_CODE = String.format("%s", String.format("%d", usecode + x));;
            h_column.m_SEQ = String.format("%d", 3321 + x);
            h_column.m_ABATT_DATE = String.format("%d", c.getDate() + x);
            h_column.m_JUDGE_BREED = String.format("%c", '1');
            h_column.m_JUDGE_SEX = String.format("%c", '1');
            h_column.m_WEIGHT = String.format("%d", weight + x);
            h_column.m_LAST_GRADE = "A+";
            h_column.m_RATER_CODE = "53672";


            // Test Field
            h_column.m_STD_DATE = String.format("%d", c.getDate() + x);
            h_column.m_ABATT_NO = String.format("%d", 1234 + x);
            h_column.m_JUDGE_GUBN = String.format("%c", '1');

            dbm.CreateQuery_FillupMandatoryColumn(h_column);
        }
*/
        //Date date = new Date(now);
        //long now = System.currentTimeMillis();
        //Date date = new Date(now);
        //Calendar date = Calendar.getInstance();
        //Integer now = date.get(Calendar.DATE);

        //DBLog.d(DBLog.tag_MainActivity, "Time Millis" + String.format("%ld", now));
        //DBLog.d(DBLog.tag_MainActivity, "Time Millis: " + String.format("%d", now));
        //DBLog.d(DBLog.tag_MainActivity, "Date" + String.format("%ld", date.getDate()));
        //DBLog.d(DBLog.tag_MainActivity, "Date no ld: " + String.format("%d", date.getDate()));

        String search_date = "2022-01-19";
        //SimpleDateFormat query_date = new SimpleDateFormat("YYYY-MM-DD");
        //Date in_date = new Date(search_date);

        //DBLog.d("onCreate", "Time :" +  query_date.format(in_date));
        String strTime = dbm.makeWHERE_date(search_date);
        DBLog.d("onCreate", "Convert Time :" + strTime );
        String search_condition = ConstColumnNames.SDT_DATE + " == " + strTime;
        m_array_judg =  dbm.getGradeJudgmentData(search_condition);
        if(m_array_judg == null) {
            DBLog.e("MainActivity", "Oncrete getGradeJudgmentData fail");
        }

        for (DBColumnVarables i : m_array_judg) {
            DBLog.d(DBLog.tag_InqueryOfGradeJudgmentData, "Input Number = " + i.SEQ );
            DBLog.d(DBLog.tag_InqueryOfGradeJudgmentData, "ABATT Number = " + i.ABATT_NO);
            DBLog.d(DBLog.tag_InqueryOfGradeJudgmentData, "Weight = " + i.WEIGHT);
        }


    }

    public void CopyDBFile(Context context) {
        //int sz_dbfile = 0;
        AssetManager am = context.getAssets();
        InputStream is = null;
        try {
            is = am.open(ASSETS_FILE_DB);
            BufferedInputStream bis = new BufferedInputStream(is);
            String strDbPath = context.getDatabasePath("tmp").getParent();
            DBLog.d("CopyDBFile" ,"Copy Path: " + strDbPath);

            File f = new File(strDbPath + "/" + LAONPEOPLE_DB_NAME);
            //DBLog.d(f.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int read = 1;
            int sz_file = (int)is.available();
            DBLog.d("CopyDBFile " , "Size : " + String.format("%d", sz_file));
            byte[] buffer = new byte[sz_file];
            DBLog.d("CopyDBFile" , "Copying Start");
            while((read = bis.read(buffer,0, sz_file)) != -1) {
                bos.write(buffer, 0, read);
            }

            DBLog.d("CopyDBFile" , "Copying Done");
            bos.flush();
            bos.close();
            fos.close();
            bis.close();

            DBLog.d("CopyDBFile" , "Close Done");

        } catch (IOException e) {
            DBLog.d("Exection for CopyDBFile", "Happen the IO Exception");
            e.printStackTrace();
        }

    }
}
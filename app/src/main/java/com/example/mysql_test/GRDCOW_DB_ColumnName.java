package com.example.mysql_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

class insert_column {
    public String m_TABLE_NAME;
    public String m_ABATT_CODE;
    public String m_JUDGE_DATE;
    public String m_USE_CODE;
    public String m_SEQ;
    public String m_STD_DATE;
    public String m_ABATT_DATE;
    public String m_ABATT_NO;
    public String m_JUDGE_GUBN;
    public String m_AUCT_DATE;
    public String m_LIVE_WEIGHT;
    public String m_LEFT_WEIGHT;
    public String m_RIGHT_WEIGHT;
    public String m_COST_AMT;
    public String m_JUDGE_BREED;
    public String m_JUDGE_SEX;
    public String m_BACKFAT;
    public String m_REA;
    public String m_WEIGHT;
    public String m_WINDEX;
    public String m_WGRADE;
    public String m_INSFAT;
    public String m_FIRST_GRADE;
    public String m_YUKSAK;
    public String m_FATSAK;
    public String m_TISSUE;
    public String m_GROWTH;
    public String m_QGRADE;
    public String m_UPDOWN_CODE;
    public String m_OFFGRADE_CODE;
    public String m_OFFGRADE_NO;
    public String m_DEFECT_CODE;
    public String m_DEFECT_DTL_CODE;
    public String m_LAST_GRADE;
    public String m_FARMHOUSE_NO;
    public String m_RATER_CODE;
    public String m_BAR_CODE;
    public String m_SHIP_DATE;
    public String m_REQ_REG_NO;
    public String m_FAR_ADDRESS_NO;
    public String m_REQ_ADDRESS_NO;
    public String m_FAR_REG_NO;
    public String m_NATIONAL_CODE;
    public String m_CUT_GUBN;
    public String m_REGER_ID;
    public String m_REGER_IP;
    public String m_REG_YMD;
    public String m_REG_HMS;
    public String m_MODER_ID;
    public String m_MODER_IP;
    public String m_MOD_YMD;
    public String m_MOD_HMS;
    public String m_CUT_FORLEG_WEIGHT;
    public String m_CUT_HIP_WEIGHT;
    public String m_SAMPLER;
    public String m_PRINT_SEQ;
    public String m_SAMPLE_SEQ;
    public String m_CALB_IMG_PATH;
    public String m_AIDTA_ID;
    public String m_MCHN_BACKFAT;
    public String m_MCHN_BACKFAT_PXL;
    public String m_MCHN_REA;
    public String m_MCHN_REA_STDUNIT;
    public String m_MCHN_REA_PXL;
    public String m_MCHN_REA_UNIT1;
    public String m_MCHN_REA_UNIT2;
    public String m_MCHN_REA_UNIT3;
    public String m_MCHN_REA_UNIT4;
    public String m_MCHN_REA_UNIT5;
    public String m_MCHN_INSFAT_MTHD1;
    public String m_MCHN_INSFAT_MTHD2;
    public String m_MCHN_FRSTGRD;
    public String m_MCHN_YUKSAK;
    public String m_MCHN_YUKSAK_RGB;
    public String m_MCHN_YUKSAK_LAB;
    public String m_MCHN_FATSAK;
    public String m_MCHN_FATSAK_RGB;
    public String m_MCHN_FATSAK_LAB;
    public String m_MCHN_TISSUE;

    private static insert_column h_instance;

    private static void _insert_column_log(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();

        sb.append("[DEBUG:");
        sb.append(ste.getFileName());
        sb.append("> ");
        sb.append(ste.getMethodName());
        sb.append("> #");
        sb.append(ste.getLineNumber());
        sb.append("] ");
        sb.append(message);

        Log.d("STATE", sb.toString());


        if(sb != null) {
            sb = null;
        }
    }


    private insert_column() {

    }

    /**
     * Get the instance for handling the column for DB
     * @return return the insert_column class object.
     */
    public static synchronized insert_column insert_column_instance() {
        if(h_instance == null)
            h_instance = new insert_column();

        // Fill-up the default value at the column that default valued needed
        h_instance.m_SEQ = String.format("%d",0);
        h_instance.m_JUDGE_GUBN = String.format("%c", '0');
        h_instance.m_BACKFAT = String.format("%d", 0);
        h_instance.m_REA = String.format("%d", 0);
        h_instance.m_WEIGHT = String.format("%d", 0);
        h_instance.m_WINDEX = String.format("%d", 0);

        Log.d("STATE", "SEQ " + h_instance.m_SEQ + "JUDGE " + h_instance.m_JUDGE_GUBN +
                "BACKFAT " + h_instance.m_BACKFAT + "READ " + h_instance.m_REA +
                "WEIGHT " + h_instance.m_WEIGHT + "WINDEX " + h_instance.m_WINDEX);

        //_insert_column_log(h_instance.m_SEQ);
        //_insert_column_log(h_instance.m_JUDGE_GUBN);
        //_insert_column_log(h_instance.m_BACKFAT);
        //_insert_column_log(h_instance.m_REA);
        //_insert_column_log(h_instance.m_WEIGHT);
        //_insert_column_log(h_instance.m_WINDEX);


        return h_instance;
    }
}

public class GRDCOW_DB_ColumnName {


    private Map<String, Integer>  m_DBNotNull;
    private MCH_GradeCow_MST h_dbm;
    //private static final String LAONPEOPLE_DB_NAME = "LaonPepople_TEST.sqlite3";
    private DBColumnVarables gradeJudgement = null;
    private ArrayList<DBColumnVarables> m_gradeJudgementDataArray = null;

   public GRDCOW_DB_ColumnName(Context context) {
        // Get the DB MGM Handle
        String db_absolute_name =  ConstColumnNames.DB_FILE_NAME;
        //String db_absolute_name = ConstColumnNames.DB_FILE_NAME;
        h_dbm = MCH_GradeCow_MST.getInstance(context, db_absolute_name);
        m_DBNotNull = new Hashtable<String, Integer>();
        m_gradeJudgementDataArray = new ArrayList<DBColumnVarables>();

        //String _d = "DBM Handle: " + h_dbm;
        //DBLog.d(_d);

        m_DBNotNull.put("ABATT_CODE",1);
        m_DBNotNull.put("JUDGE_DATE",1);
        m_DBNotNull.put("USE_CODE",1);
        m_DBNotNull.put("SEQ",1);
        m_DBNotNull.put("STD_DATE",1);
        m_DBNotNull.put("ABATT_DATE",1);
        m_DBNotNull.put("ABATT_NO",1);
        m_DBNotNull.put("JUDGE_GUBN",1);
        m_DBNotNull.put("AUCT_DATE",0);
        m_DBNotNull.put("LIVE_WEIGHT",0);
        m_DBNotNull.put("LEFT_WEIGHT",0);
        m_DBNotNull.put("RIGHT_WEIGHT",0);
        m_DBNotNull.put("COST_AMT",0);
        m_DBNotNull.put("JUDGE_BREED",1);
        m_DBNotNull.put("JUDGE_SEX",1);
        m_DBNotNull.put("BACKFAT",0);
        m_DBNotNull.put("REA",0);
        m_DBNotNull.put("WEIGHT",1);
        m_DBNotNull.put("WINDEX",0);
        m_DBNotNull.put("WGRADE",0);
        m_DBNotNull.put("INSFAT",0);
        m_DBNotNull.put("FIRST_GRADE",0);
        m_DBNotNull.put("YUKSAK",0);
        m_DBNotNull.put("FATSAK",0);
        m_DBNotNull.put("TISSUE",0);
        m_DBNotNull.put("GROWTH",0);
        m_DBNotNull.put("QGRADE",0);
        m_DBNotNull.put("UPDOWN_CODE",0);
        m_DBNotNull.put("OFFGRADE_CODE",0);
        m_DBNotNull.put("OFFGRADE_NO",0);
        m_DBNotNull.put("DEFECT_CODE",0);
        m_DBNotNull.put("DEFECT_DTL_CODE",0);
        m_DBNotNull.put("LAST_GRADE",1);
        m_DBNotNull.put("FARMHOUSE_NO",0);
        m_DBNotNull.put("RATER_CODE",1);
        m_DBNotNull.put("BAR_CODE",0);
        m_DBNotNull.put("SHIP_DATE",0);
        m_DBNotNull.put("REQ_REG_NO",0);
        m_DBNotNull.put("FAR_ADDRESS_NO",0);
        m_DBNotNull.put("REQ_ADDRESS_NO",0);
        m_DBNotNull.put("FAR_REG_NO",0);
        m_DBNotNull.put("NATIONAL_CODE",0);
        m_DBNotNull.put("CUT_GUBN",0);
        m_DBNotNull.put("REGER_ID",0);
        m_DBNotNull.put("REGER_IP",0);
        m_DBNotNull.put("REG_YMD",0);
        m_DBNotNull.put("REG_HMS",0);
        m_DBNotNull.put("MODER_ID",0);
        m_DBNotNull.put("MODER_IP",0);
        m_DBNotNull.put("MOD_YMD",0);
        m_DBNotNull.put("MOD_HMS",0);
        m_DBNotNull.put("CUT_FORLEG_WEIGHT",0);
        m_DBNotNull.put("CUT_HIP_WEIGHT",0);
        m_DBNotNull.put("SAMPLER",0);
        m_DBNotNull.put("PRINT_SEQ",0);
        m_DBNotNull.put("SAMPLE_SEQ",0);
        m_DBNotNull.put("CALB_IMG_PATH",0);
        m_DBNotNull.put("AIDTA_ID",0);
        m_DBNotNull.put("MCHN_BACKFAT",0);
        m_DBNotNull.put("MCHN_BACKFAT_PXL",0);
        m_DBNotNull.put("MCHN_REA",0);
        m_DBNotNull.put("MCHN_REA_STDUNIT",0);
        m_DBNotNull.put("MCHN_REA_PXL",0);
        m_DBNotNull.put("MCHN_REA_UNIT1",0);
        m_DBNotNull.put("MCHN_REA_UNIT2",0);
        m_DBNotNull.put("MCHN_REA_UNIT3",0);
        m_DBNotNull.put("MCHN_REA_UNIT4",0);
        m_DBNotNull.put("MCHN_REA_UNIT5",0);
        m_DBNotNull.put("MCHN_INSFAT_MTHD1",0);
        m_DBNotNull.put("MCHN_INSFAT_MTHD2",0);
        m_DBNotNull.put("MCHN_FRSTGRD",0);
        m_DBNotNull.put("MCHN_YUKSAK",0);
        m_DBNotNull.put("MCHN_YUKSAK_RGB",0);
        m_DBNotNull.put("MCHN_YUKSAK_LAB",0);
        m_DBNotNull.put("MCHN_FATSAK",0);
        m_DBNotNull.put("MCHN_FATSAK_RGB",0);
        m_DBNotNull.put("MCHN_FATSAK_LAB",0);
        m_DBNotNull.put("MCHN_TISSUE",0);
    }

    /**
     * Query Syntx print on LogCat windows.
     * @param [in] query Query syntax string
     * @note Query syntax related string SHOLUD be see on LogCat windows of AndroidStudio (
     *       In terms of the Searching, KeyWord on LogCatWindows is "Debug" and " PrintQuerySyntax"
     */
    private void PrintQuerySyntax(String query) {
        Log.d("PrintQuerySyntax", "Query:" + "\"" + query + "\"");
    }

    public Integer isNotNullColumn(String k) {
        if(m_DBNotNull.containsKey(k) != true) {
            return -1;
        }

        return m_DBNotNull.get(k);
    }

    /**
     * Inquire the DB Table whether the "Not Null filed" on Table has or has't a value
     * @return On Not Null filed, if value is NULL, return the netagitave value (-1), otherwise,
     *         reutrn the zero
     */
    public Integer CreateQuery_isChecksTheNotNullColumnIsEmpty() {
        String makeQuery = "SELECT" + ConstColumnNames.SDT_DATE + "," + ConstColumnNames.JUDGE_GUBN +
                "FROM" + ConstColumnNames.TABLE_NAME + ";";

        Cursor c = null;
        String is_notnull_stddate = null;
        String is_notnull_judge_gubn = null;

        //assert h_dbm == null : "DB Handler Object can't be NULL";

        PrintQuerySyntax(makeQuery);


        c = (Cursor) h_dbm.executeRawQuery(makeQuery);

        try {
            if(c.moveToFirst()) {
                do {
                    is_notnull_stddate = c.getString(c.getColumnIndex(ConstColumnNames.SDT_DATE));
                    is_notnull_judge_gubn = c.getString(c.getColumnIndex(ConstColumnNames.JUDGE_GUBN));
                }while(c.moveToNext());
            }
        }
        catch(Exception e) {
            Log.d("STATE", "Error while trying to get posts from database");
        }
        finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }

        Log.d("STATE", "STD_DATE and JUDGE_GUBN file check :" + is_notnull_judge_gubn + is_notnull_stddate);

        if(is_notnull_stddate == null || is_notnull_judge_gubn == null) {
            return 0;
        }

        return -1;
    }

    /**
     *
     * @param column
     * @return
     */
    public int CreateQuery_FillupMandatoryColumn(insert_column column) {
        String str_insert_table = "INSERT INTO " + ConstColumnNames.TABLE_NAME;
        String str_insert_column = " (" + ConstColumnNames.ABATT_CODE + "," + ConstColumnNames.JUDGE_DATE + "," + ConstColumnNames.USE_CODE +
                "," + ConstColumnNames.SEQ + "," +  ConstColumnNames.ABATT_DATE + "," + ConstColumnNames.ABATT_NO + "," + ConstColumnNames.JUDGE_BREED +
                "," + ConstColumnNames.JUDGE_SEX + "," + ConstColumnNames.WEIGHT + "," + ConstColumnNames.LAST_GRADE + "," + ConstColumnNames.RATER_CODE +
                "," + ConstColumnNames.SDT_DATE + "," + ConstColumnNames.ABATT_NO +"," + ConstColumnNames.JUDGE_GUBN + ")";

        String str_insert_values =  " VALUES " + "(" + column.m_ABATT_CODE + ","  + column.m_ABATT_DATE +
                "," + column.m_USE_CODE + "," + column.m_SEQ + "," + column.m_ABATT_DATE +
                "," + column.m_ABATT_NO + "," + column.m_JUDGE_BREED + "," + column.m_JUDGE_SEX +
                "," + column.m_WEIGHT + "," + column.m_LAST_GRADE + "," + column.m_RATER_CODE +
                "," + column.m_STD_DATE + "," + column.m_ABATT_NO + "," + column.m_JUDGE_GUBN + ")" +
                ";";

        String makeQuery = str_insert_table + str_insert_column + str_insert_values;
        ContentValues v = new ContentValues();

        String _d = "DBM Handle: " + h_dbm;
        //DBLog.d(_d);
        //assert h_dbm == null : "DB Handler Object can't be NULL";
        PrintQuerySyntax(makeQuery);

        v.put(ConstColumnNames.ABATT_CODE, column.m_ABATT_CODE);
        v.put(ConstColumnNames.JUDGE_DATE, column.m_JUDGE_DATE);
        v.put(ConstColumnNames.USE_CODE, column.m_USE_CODE);
        v.put(ConstColumnNames.SEQ, column.m_SEQ);
        v.put(ConstColumnNames.ABATT_NO, column.m_ABATT_NO);
        v.put(ConstColumnNames.ABATT_DATE, column.m_ABATT_DATE);
        v.put(ConstColumnNames.JUDGE_BREED, column.m_JUDGE_BREED);
        v.put(ConstColumnNames.JUDGE_SEX, column.m_JUDGE_SEX);
        v.put(ConstColumnNames.WEIGHT, column.m_WEIGHT);
        v.put(ConstColumnNames.LAST_GRADE, column.m_LAST_GRADE);
        v.put(ConstColumnNames.RATER_CODE, column.m_RATER_CODE);

        // Test
        v.put(ConstColumnNames.SDT_DATE, column.m_STD_DATE);
        v.put(ConstColumnNames.ABATT_NO, column.m_ABATT_NO);
        v.put(ConstColumnNames.JUDGE_GUBN, column.m_JUDGE_GUBN);

        //SQLiteDatabase db = h_dbm.getWritableDatabase();
        h_dbm.insertRawQuery(v, ConstColumnNames.TABLE_NAME);

        return 0;
    }

    /**
     * Inquery the whole DB column
     * @return On success, return the Cursor object where stored the whole column \n
     *          otherwise, return the NULL
     */
    public Cursor getTableAllColumn() {
        Cursor query_result = null;
        String query = "SELECT * FROM " + ConstColumnNames.TABLE_NAME;
        DBLog.d("GetTableAllColumn" , "Query: " + query);

        query_result = (Cursor)h_dbm.executeRawQuery(query);

        DBLog.d("GetTableAllColumn", "ColumnCount: " +  String.format("%d", query_result.getColumnCount()).toString());
        DBLog.d("GetTableAllColumn", "Rows Count : " +  String.format("%d", query_result.getCount()).toString());

        if(query_result.getColumnCount() <= 0) {
            return null;
        }

        return query_result;

    }

    public int deleteDataBetweenDateAndDate(String start, String end) {

    }

    /**
     * Create the Date string to used on DB WHERE syntax
     * @param [in] date Date object
     * @return On success, the Date string ( YYYY-MM-DD format included the single quation marks ) \n
     *         Otherwise, return the NULL
     * @note In Date object, An entry for the Year, Month, Day MUST be set. ( Ignore the TIME related item)
     */
    public String makeWHERE_date (Date date) {
        SimpleDateFormat d = new SimpleDateFormat("YYYY-MM-DD");
        String ret = null;
        DBLog.d("makeWHERE_date", "Date Override");
        ret = "\'" + d.format(date) + "\'";

        return ret;
    }

    /**
     * Date string converts to format to be used on DB WHERE syntax
     * @param [in] date Date related string
     * @return On success, the Date string ( YYYY-MM-DD format included the single quation marks ) \n
     *          Otherwise, return the NULL
     * @note Date String MUST consist of the following format: (YYYY-MM-DD)
     */
    public String makeWHERE_date (String date) {
        String ret_date = null;
        int len = 0;
        char[] syntax_array; // Buffer to check whether the date format can be used on DB "WHERE" syntax.
        int syntax_flag = 0;

        DBLog.d("makeWHERE_date", "String Override");
        if ((len = date.length()) == 0 ) {
            DBLog.e("makeWHERE_date", "Date string empty");
            return null;
        }

        DBLog.d("makeWHERE_date", "Date string length: " + String.format("%d", len));

        syntax_array = date.toCharArray();
        for (int x = 0; x < len; x++) {
            DBLog.d("makeWHERE_date", "Value: " +  String.format("%c", syntax_array[x]));
            if(syntax_array[x] == 0x2D) { //0x2D menans the '-' symbol
                syntax_flag += 1;
            }
        }

        DBLog.d("makeWHERE_date", "Syntax Check done");

        if(syntax_flag != 2) {
            DBLog.e("makeWHERE_date", "Invalied the Date Format");
            return null;
        }

        ret_date = "\'" + date + "\'";
        DBLog.d("makeWHERE_date", "Return Date : " + ret_date);
        return ret_date;

    }

    /**
     * System current milliseconds converts to 'YYYY-MM-DD' format
     * @param [in] milliseconds System current time
     * @return Return the Date string ( YYYY-MM-DD format included the single quation marks )
     * @note In terms of the milliseconds for System, It can be used the System.currentTimeMillis()
     *       to get regards to System Epoch Time.
     */
    public String makeWHERE_date (long milliseconds) {
        String ret_date = null;
        SimpleDateFormat time_format = new SimpleDateFormat("YYYY-MM-DD");
        Date result = new Date(milliseconds);

        DBLog.d("makeWHERE_date", "Long  Override");

        ret_date = "\'" + time_format.format(result) + "\'";

        return ret_date;

    }

    /**
     * Get the Judgement data that Grade related
     * @param [in] search_base It is date string that inquery the Judgement Data for Grade
     * @return On success, return the ArrayList of inqueried data, otherwise return the NULL
     * @note In terms of the Data inquire base Date String format, It MUST has the "YYYY-MM-DD format".
     */
    public ArrayList<DBColumnVarables> getGradeJudgmentData(String search_base) {
        //InqueryOfGradeJudgmentData  d = new InqueryOfGradeJudgmentData();
        Cursor query_result = null;
        StringBuilder query = new StringBuilder();

        DBLog.d("getGradeJudgmentData", "--- Start ---");

        query.append("SELECT * FROM ");
        if(search_base != null) {
            query.append(ConstColumnNames.TABLE_NAME + " WHERE " + search_base);
        }
        else {
            query.append(ConstColumnNames.TABLE_NAME);
        }

        DBLog.d("getGradeJudgmentData",  "V Query : " + query.toString());
        query_result = (Cursor)h_dbm.executeRawQuery(query.toString());

        query_result.moveToFirst();
        if(query_result.getCount() <= 0) {
            DBLog.e("getGradeJudgmentData", "Error: Data is empty forGradeJudgment");
            return null;
        }

        DBLog.d("getGradeJudgmentData", "Row Count: " + String.format("%d", query_result.getCount()));
        do {
            gradeJudgement = new DBColumnVarables();

            gradeJudgement.SEQ = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.SEQ));
            gradeJudgement.ABATT_NO = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.ABATT_NO));
            gradeJudgement.MCHN_BACKFAT_PXL = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_BACKFAT_PXL));
            gradeJudgement.MCHN_REA = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_REA));
            gradeJudgement.MCHN_REA_STDUNIT = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_REA_STDUNIT));
            gradeJudgement.MCHN_REA_UNIT1 = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_REA_UNIT1));
            gradeJudgement.MCHN_REA_UNIT2 = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_REA_UNIT2));
            gradeJudgement.MCHN_REA_UNIT3 = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_REA_UNIT3));
            gradeJudgement.MCHN_INSFAT_MTHD1 = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD1));
            gradeJudgement.MCHN_INSFAT_MTHD1_DTL = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD1_DTL));
            gradeJudgement.MCHN_INSFAT_MTHD1_RT = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD1_RT));
            gradeJudgement.MCHN_INSFAT_MTHD2 = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD2));
            gradeJudgement.MCHN_INSFAT_MTHD2_DTL = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD2_DTL));
            gradeJudgement.MCHN_INSFAT_MTHD2_RT = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_INSFAT_MTHD2_RT));
            gradeJudgement.MCHN_YUKSAK = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK));
            gradeJudgement.MCHN_YUKSAK_RGB_R = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_RGB_R));
            gradeJudgement.MCHN_YUKSAK_RGB_G = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_RGB_G));
            gradeJudgement.MCHN_YUKSAK_RGB_B = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_RGB_B));
            gradeJudgement.MCHN_YUKSAK_LAB_L = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_LAB_L));
            gradeJudgement.MCHN_YUKSAK_LAB_A = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_LAB_A));
            gradeJudgement.MCHN_YUKSAK_LAB_B = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_YUKSAK_LAB_B));
            gradeJudgement.MCHN_FATSAK = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK));
            gradeJudgement.MCHN_FATSAK_RGB_R = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_RGB_R));
            gradeJudgement.MCHN_FATSAK_RGB_G = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_RGB_G));
            gradeJudgement.MCHN_FATSAK_RGB_B = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_RGB_B));
            gradeJudgement.MCHN_FATSAK_LAB_L = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_LAB_L));
            gradeJudgement.MCHN_FATSAK_LAB_A = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_LAB_A));
            gradeJudgement.MCHN_FATSAK_LAB_B = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_FATSAK_LAB_B));
            gradeJudgement.MCHN_TISSUE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_TISSUE));
            gradeJudgement.MCHN_TISSUE_ROUGH = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_TISSUE_ROUGH));
            gradeJudgement.JUDGE_BREED = query_result.getString(query_result.getColumnIndex(ConstColumnNames.JUDGE_BREED));
            gradeJudgement.JUDGE_SEX = query_result.getString(query_result.getColumnIndex(ConstColumnNames.JUDGE_SEX));
            gradeJudgement.BACKFAT = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.BACKFAT));
            gradeJudgement.MCHN_BACKFAT = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.MCHN_BACKFAT));
            gradeJudgement.REA = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.REA));
            gradeJudgement.WEIGHT = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.WEIGHT));
            gradeJudgement.WINDEX = query_result.getLong(query_result.getColumnIndex(ConstColumnNames.WINDEX));
            gradeJudgement.WGRADE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.WGRADE));
            gradeJudgement.QGRADE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.QGRADE));
            gradeJudgement.UPDOWN_CODE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.UPDOWN_CODE));
            gradeJudgement.LAST_GRADE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.LAST_GRADE));
            gradeJudgement.MCHN_LAST_GRADE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.MCHN_LAST_GRADE));
            gradeJudgement.DEFECT_CODE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.DEFECT_CODE));
            gradeJudgement.DEFECT_DTL_CODE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.DEFECT_DTL_CODE));
            gradeJudgement.YUKSAK = query_result.getString(query_result.getColumnIndex(ConstColumnNames.YUKSAK));
            gradeJudgement.INSFAT = query_result.getString(query_result.getColumnIndex(ConstColumnNames.INSFAT));
            gradeJudgement.INSFAT_DTL = query_result.getString(query_result.getColumnIndex(ConstColumnNames.INSFAT_DTL));
            gradeJudgement.FATSAK = query_result.getString(query_result.getColumnIndex(ConstColumnNames.FATSAK));
            gradeJudgement.TISSUE = query_result.getString(query_result.getColumnIndex(ConstColumnNames.TISSUE));
            gradeJudgement.GROWTH = query_result.getString(query_result.getColumnIndex(ConstColumnNames.GROWTH));
            gradeJudgement.REG_HMS = query_result.getString(query_result.getColumnIndex(ConstColumnNames.REG_HMS));


            m_gradeJudgementDataArray.add(gradeJudgement);
           // DBLog.d("getGradeJudgmentData", "V " + "Add the Inquery Data");
        }while (query_result.moveToNext());

        query_result.close();
        DBLog.d("getGradeJudgmentData", "--- Done ---");


        return m_gradeJudgementDataArray;
    }




}

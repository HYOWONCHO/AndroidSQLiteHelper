package com.example.mysql_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MCH_GradeCow_MST extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "asserts/databases/LaonPepople.sqlite3";
    //String strDbPath = context.getDatabasePath("tmp").getParent();
    private static final int DATABASE_VERSION = 1;
    private static MCH_GradeCow_MST m_db_instance;

    private void _class_log(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[0];
        StringBuilder sb = new StringBuilder();

        sb.append("[MCH_GradeCow_MST DEBUG:");
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

    public static synchronized MCH_GradeCow_MST getInstance(Context context, String name) {
        Log.d("STATE", "Get the DB MGM Application Context" +  "DB FILE" + name);
        if(m_db_instance == null) {
            m_db_instance = new MCH_GradeCow_MST(context.getApplicationContext(), name);
        }
        //assert m_db_instance == null : "xxx DB Handler Object can't be NULL";

        //Log.d("STATE", String.format("Class %s @ %d",
        //                    m_db_instance.getClass().getName(),
        //                    Integer.toHexString(System.identityHashCode(m_db_instance))));

        if (m_db_instance == null) {
            Log.d("STATE", "MCH DB Class Object Instance is NULL");
        }
        return m_db_instance;
    }

    public MCH_GradeCow_MST(Context context, String name) {
        super(context, name, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
        Log.d("STATE", "The database connection is being configured");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.d("STATE", "The database has been opened");
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("STATE", " onCreate() is only run when the database file did not exist and was just created. " + db.getPath());
        /*
        String create_table = "CREATE TABLE MCH_GRDCOW_MST (
                ABATT_CODE             CHAR (4)       NOT NULL,
                JUDGE_DATE             DATE           DEFAULT (DATE() ) 
                                                      NOT NULL,
                USE_CODE               CHAR (2)       NOT NULL,
                SEQ                    NUMERIC (4)    DEFAULT (0) 
                                                      NOT NULL,
                SDT_DATE               DATE           DEFAULT (DATE() ) 
                                                      NOT NULL,
                ABATT_DATE             DATE           DEFAULT (DATE() ) 
                                                      NOT NULL,
                ABATT_NO               NUMERIC (4)    NOT NULL,
                JUDGE_GUBN             CHAR (1)       DEFAULT (0) 
                                                      NOT NULL,
                AUCT_DATE              DATE           DEFAULT (DATE() ),
                LIVE_WEIGHT            NUMERIC (4),
                LEFT_WEIGHT            NUMERIC (8, 2),
                RIGHT_WEIGHT           NUMERIC (8, 2),
                COST_AMT               NUMERIC (8),
                JUDGE_BREED            CHAR (1)       NOT NULL,
                JUDGE_SEX              CHAR (1)       NOT NULL,
                BACKFAT                NUMERIC (3, 1) DEFAULT (0),
                REA                    NUMERIC (3)    DEFAULT (0),
                WEIGHT                 NUMERIC (5, 1) DEFAULT (0) 
                                                      NOT NULL,
                WINDEX                 NUMERIC (5, 2) DEFAULT (0),
                WGRADE                 CHAR (1),
                INSFAT                 VARCHAR (2),
                FIRST_GRADE            CHAR (1),
                YUKSAK                 CHAR (1),
                FATSAK                 CHAR (1),
                TISSUE                 VARCHAR (2),
                GRWOWTH                CHAR (2),
                OGRADE                 CHAR (1),
                UPDOWN_CODE            CHAR (1),
                OFFGRADE_CODE          CHAR (1),
                OFFGRADE_NO            VARCHAR (3),
                DEFECT_CODE            CHAR (2),
                DEFECT_DTL_CODE        CHAR (2),
                LAST_GRADE             CHAR (2)       NOT NULL,
                FARMHOUSE_NO           VARCHAR (20),
                RATER_CODE             CHAR (5)       NOT NULL,
                BAR_CODE               VARCHAR (12),
                SHIP_DATE              DATE           DEFAULT (DATE() ),
                REQ_REG_NO             CHAR (13),
                FAR_ADDRESS_NO         CHAR (13),
                REQ_ADDRESS_NO         CHAR (8),
                FAR_REG_NO             CHAR (41),
                NATIONAL_CODE          CHAR (2),
                CUT_GUBN               CHAR (1),
                REGER_ID               VARCHAR (50),
                REGER_IP               VARCHAR (30),
                REG_YMD                CHAR (8)       DEFAULT (19700101),
                REG_HMS                CHAR (6)       DEFAULT (0),
                MODER_ID               VARCHAR (50),
                MODER_IP               VARCHAR (30),
                MOD_YMD                CHAR (8)       DEFAULT (19700101),
                MOD_HMS                CHAR (6)       DEFAULT (0),
                CUT_FORLEG_WEIGHT      NUMERIC (4, 2),
                CUT_HIP_WEIGHT         NUMERIC (4, 2),
                SAMPLER                CHAR (5),
                PRINT_SEQ              NUMERIC (4),
                SAMPLE_SEQ             NUMERIC (56),
                CALB_IMG_PATH          VARCHAR (400),
                AIDTA_ID               NUMERIC (10),
                MCHN_JGMT_BACKFAT      NUMERIC (3, 1),
                MCHN_JGMT_BACKFAT_PXL  NUMERIC (10),
                MCHN_JGMT_REA          NUMERIC (3),
                MCHN_JGMT_REA_STDUNIT  NUMERIC (3),
                MCHN_JGMT_REA_PXL      NUMERIC (10),
                MCHN_JGMT_REA_UNIT1    NUMERIC (3),
                MCHN_JGMT_REA_UNIT2    NUMERIC (3),
                MCHN_JGMT_REA_UNIT3    NUMERIC (3),
                MCHN_JGMT_REA_UNIT4    NUMERIC (3),
                MCHN_JGMT_REA_UNIT5    NUMERIC (68),
                MCHN_JGMT_INSFAT_MTHD1 VARCHAR (2),
                MCHN_JGMT_INSFAT_MTHD2 VARCHAR (2),
                MCHN_JGMT_FRSTGRD      CHAR (1),
                MCHN_JGMT_YUKSAK       CHAR (1),
                MCHN_JGMT_YUKSAK_RGB   VARCHAR (13),
                MCHN_JGMT_YUKSAK_LAB   VARCHAR (13),
                MCHN_JGMT_FATSAK       CHAR (1),
                MCHN_JGMT_FATSAK_RGB   VARCHAR (13),
                MCHN_JGMT_FATSAK_LAB   VARCHAR (13),
                MCHN_JGMT_TISSUE       VARCHAR (2),
                PRIMARY KEY (
                    ABATT_CODE,
                    JUDGE_DATE,
                    USE_CODE,
                    SEQ
                )
            );";
             
            db.execSQL(create_table);
            */
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("STATE", " The database needs to be upgraded.");
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSTS);
            //db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            //onCreate(db);
        }
    }

    public Object executeRawQuery(String q) {
        // Create or open a database
        SQLiteDatabase db = getWritableDatabase();
        Cursor query_result;
        //assert q == null : "DB Query is not existence";
        //assert db == null : "DB create or open failed";

        query_result = db.rawQuery(q, null);
        //assert query_result == null : "Query output is not existence";

        return query_result;
    }

    public void insertRawQuery(ContentValues v, String tbname) {
        long ret = 0;
        SQLiteDatabase db = getWritableDatabase();
        //assert db == null : "DB Create or open failed";
        // ensures consistency of the database

        DBLog.d("insertRawQuery", "Initiate");
        db.beginTransaction();

        try {
            _class_log(tbname);
            for(String key : v.keySet() ) {
                _class_log("Key :" + key + " Values: " + v.get(key));
            }

            ret = db.insertOrThrow(tbname, null, v);
            if(ret < 0) {
                _class_log("InsertOrThrow error occured");
            }
            db.setTransactionSuccessful();

        }
        catch (Exception e) {
            _class_log("InsertOrThrow error occured" + String.format(" RET STATE : %d", ret));
            Log.d("STATE", "Error while trying to add  to database");
        }
        finally {
            db.endTransaction();
            DBLog.d("insertRawQuery", "Done");
        }

    }

    // UPDATE inspection SET "ContentValues Object" (column1=:arg0,column2=:arg1) WHERE column3 =:arg2

    /**
     * Updating rows in the database
     * @param v a map from column names to new column values. null is a
     *          valid value that will be translated to NULL.
     * @param table the table to update in

     * @param whereClause the optional WHERE clause to apply when updating.
     *                    Passing null will update all rows.
     * @param whereArgs You may include ?s in the where clause, which
     *                  will be replaced by the values from whereArgs. The values
     *                  will be bound as Strings.
     * @return the number of rows affected, in terms of query fail, return the negative value
     */
    public int updateRawQueryForRows(ContentValues v, String table, String whereClause, String whereArgs) {
        SQLiteDatabase db = getWritableDatabase();
        int result = -1;
        //String dbg_msg;
        assert db == null : "DB Create or open failed";

        // ensures consistency of the database
        db.beginTransaction();

        try {
            int rows = db.update(table, v, whereClause, new String[] {whereArgs});
            Log.d("STATE", String.format("Update rows is %d on %s Table !!!", rows, table));
            result = rows;
        }
        catch (Exception e) {
            Log.d("STATE", "Error while trying to update  to database");
        }
        finally {
            db.endTransaction();
        }

        return result;
    }



}

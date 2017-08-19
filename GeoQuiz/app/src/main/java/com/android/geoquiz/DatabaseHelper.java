package com.android.geoquiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elcin on 8/19/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Quiz";
    private  static  final  int DB_VERSION = 1;

    private static final String TABLE_QUIZ = "table_quiz";

    public  static final String COL_1 = "QUESTIONID";
    public  static final String COL_2 = "CATEGORY";
    public  static final String COL_3 = "QUESTION";
    public  static final String COL_4 = "ACHOICE";
    public  static final String COL_5 = "BCHOICE";
    public  static final String COL_6 = "CCHOICE";
    public  static final String COL_7 = "DCHOICE";
    public  static final String COL_8 = "PUAN";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE QUIZTABLE (QUESTIONID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " CATEGORY TEXT,QUESTION TEXT, " +
                "ACHOICE TEXT, " +
                "BCHOICE TEXT," +
                " CCHOICE TEXT, " +
                "DCHOICE TEXT, " +
                "PUAN TEXT); " );


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS QUIZTABLE;" );
    }

/*
    public void addQuestion (String category, int questionid, String question, String achoice, String bchoice, String cchoice, String dchoice, String puan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CATEGORY", category);
        contentValues.put("QUESTIONID", questionid);
        contentValues.put("QUESTION", question);
        contentValues.put("ACHOICE", achoice);
        contentValues.put("BCHOICE", bchoice);
        contentValues.put("CCHOICE", cchoice);
        contentValues.put("DCHOICE", dchoice);
        contentValues.put("PUAN", puan);

        db.insert(TABLE_QUIZ,)
    }
    */
}

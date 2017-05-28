package com.example.paul.projetgsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Paul on 10/11/2016.
 */

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_MALADES= "table_malades";
    private static final String COL_ID = "ID";
    private static final String COL_NOM = "NOM";
    private static final String COL_PRENOM = "PRENOM";
    private static final String COL_GLYCEMIE = "GLYCEMIE";
    private static final String CREATE_TABLE_MALADES = "CREATE TABLE "
            + TABLE_MALADES + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM + " TEXT NOT NULL, "
            + COL_PRENOM + " TEXT NOT NULL, "
            + COL_GLYCEMIE + " TEXT NOT NULL);";

    //Le constructeur
    public MaBaseSQLite(Context context, String nomBDD, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nomBDD, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Création des tables
        db.execSQL(CREATE_TABLE_MALADES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // A écrire
        // actions à exécuter lors d'un changement de version
        db.execSQL("DROP TABLE TABLE_MALADES");
        this.onCreate(db);
    }
}

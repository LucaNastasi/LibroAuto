package it.rizzoli.carbooklogin.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    Context ctx;
    SQLiteDatabase db;

    public static final String DATABASE_NAME_KEY = "persona.db";
    public static final int DATABASE_VER_KEY = 1;
    public static final String PERSONA_TABLE_CREATE = "create table " + PersonaDbAdapter.PERSONA_TABLE_KEY + " ("+
            PersonaDbAdapter.PERSONA_ID_KEY + " Integer primary key autoincrement, "+
            PersonaDbAdapter.PERSONA_EMAIL_KEY + " String not null, " +
            PersonaDbAdapter.PERSONA_NOME_KEY + " String not null, " +
            PersonaDbAdapter.PERSONA_COGNOME_KEY + "  String not null, " +
            PersonaDbAdapter.PERSONA_USERNAME_KEY + " String not null, " +
            PersonaDbAdapter.PERSONA_PASSWORD_KEY + "  String not null, " +
            PersonaDbAdapter.PERSONA_TELEFONO_KEY + " String not null, " +
            PersonaDbAdapter.PERSONA_CITTA_KEY + " String );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME_KEY, null, DATABASE_VER_KEY);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PERSONA_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PersonaDbAdapter.PERSONA_TABLE_KEY);
        onCreate(db);
    }
}

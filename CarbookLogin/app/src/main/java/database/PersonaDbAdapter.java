package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PersonaDbAdapter {
    public static final String PERSONA_TABLE_KEY = "Persona";

    public static final String PERSONA_ID_KEY = "_id";
    public static final String PERSONA_NOME_KEY = "nome";
    public static final String PERSONA_COGNOME_KEY = "cognome";
    public static final String PERSONA_ETA_KEY = "eta";
    public static final String PERSONA_USERNAME_KEY = "username";
    public static final String PERSONA_PASSWORD_KEY = "password";
    public static final String PERSONA_EMAIL_KEY = "email";
    public static final String PERSONA_CITTA_KEY = "citta";

    private Context ctx;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public PersonaDbAdapter(Context context) {

        ctx = context;
    }


    private ContentValues createDictionary(Persona persona) {
        ContentValues values = new ContentValues();
        values.put(PERSONA_ID_KEY, persona.getId());
        values.put(PERSONA_NOME_KEY, persona.getNome());
        values.put(PERSONA_COGNOME_KEY, persona.getCognome());
        values.put(PERSONA_ETA_KEY, persona.getEta());
        values.put(PERSONA_USERNAME_KEY, persona.getUsername());
        values.put(PERSONA_PASSWORD_KEY, persona.getPassword());
        values.put(PERSONA_EMAIL_KEY, persona.getEmail());
        values.put(PERSONA_CITTA_KEY, persona.getCitta());

        return values;
    }
    public PersonaDbAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(ctx);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

    //CRUD = Create/Insert into, R/select..., U/update, D/delete
    //metodi per insert, update, ....
    public long insertPersona(Persona persona) {
        ContentValues values = createDictionary(persona);
        return database.insertOrThrow(PERSONA_TABLE_KEY, null, values);
    }
    public Cursor fetchAllUsers() {
        return database.query(PERSONA_TABLE_KEY, new String[] {  PERSONA_NOME_KEY, PERSONA_COGNOME_KEY, PERSONA_ETA_KEY, PERSONA_USERNAME_KEY, PERSONA_PASSWORD_KEY, PERSONA_EMAIL_KEY, PERSONA_CITTA_KEY}, null, null, null, null, null);
    }
    //select * from Users where username = '<argomento metodo>' AND password = '<argomento metodo>'
    public Cursor fetchUserBy(String email, String password) {
        Cursor mCursor = database.query(true, PERSONA_TABLE_KEY, new String[] {  PERSONA_NOME_KEY, PERSONA_COGNOME_KEY, PERSONA_ETA_KEY, PERSONA_USERNAME_KEY, PERSONA_PASSWORD_KEY, PERSONA_EMAIL_KEY, PERSONA_CITTA_KEY},
                PERSONA_EMAIL_KEY + " = '"+ email + "' AND " + PERSONA_PASSWORD_KEY + " = '"+ password + "'", null, null, null, null, null);

        return mCursor;
    }
    public boolean updateUser(Persona p, String email) {
        ContentValues updateValues = createDictionary(p);
        return database.update(PERSONA_TABLE_KEY, updateValues, PERSONA_EMAIL_KEY + "=" + email, null) > 0;
    }
}

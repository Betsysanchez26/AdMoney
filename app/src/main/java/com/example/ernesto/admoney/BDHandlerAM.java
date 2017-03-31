package com.example.ernesto.admoney;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;



public class BDHandlerAM extends SQLiteOpenHelper implements  Referencias{

    private static final String NOMBRE_BASE_DATOS = "BDAdmoney.db";

    private static final int VERSION_ACTUAL = 1;

    private SQLiteDatabase db;

    private final Context contexto;

    interface Tablas {
	String RECURRENTES = "RECURRENTES";

	String CATEGORIASTIPO = "CATEGORIASTIPO";

	String CATEGORIAS = "CATEGORIAS";

	String EGRESOS = "EGRESOS";

	String PRESTAMOS = "PRESTAMOS";

	String LOGINN = "LOGINN";

	String INGRESOS = "INGRESOS";

	String DEUDAS = "DEUDAS";
    }


    public BDHandlerAM(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        db = getWritableDatabase();
        this.contexto = contexto;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CATEGORIASTIPO(IDCATEGORIASTIPO INT PRIMARY KEY NOT NULL ,TIPO VARCHAR(10))");

        db.execSQL(String.format("CREATE TABLE CATEGORIAS(IDCATEGORIAS INT PRIMARY KEY,IDCATEGORIASTIPO INT " +
                "NOT NULL,NOMBRE VARCHAR(20) NOT NULL,%s)",Referencias.FK_CATEGORIASTIPO));

        db.execSQL(String.format("CREATE TABLE INGRESOS(IDINGRESOS INT PRIMARY KEY,"+
            "IDCATEGORIAS INT NOT NULL,CANTIDAD FLOAT NOT NULL,DESCRIPCION VARCHAR(100) NULL,%s)",Referencias.FK_INGRESOS));

        db.execSQL(String.format("CREATE TABLE DEUDAS(IDDEUDAS INT PRIMARY KEY,"+
            "IDINGRESOS INT,DESCRIPCION VARCHAR(100),%s)",Referencias.FK_DEUDAS));

        db.execSQL(String.format("CREATE TABLE EGRESOS(IDEGRESOS INT PRIMARY KEY,"+
            "IDCATEGORIAS INT NOT NULL,CANTIDAD FLOAT NOT NULL,DESCRIPCION VARCHAR(100) NULL,%s)",Referencias.FK_EGRESOS));

        db.execSQL(String.format("CREATE TABLE PRESTAMOS(IDPRESTAMOS INT PRIMARY KEY,IDEGRESOS INT,DESCRIPCION VARCHAR(100),%s)",
                Referencias.FK_PRESTAMOS));

        db.execSQL("CREATE TABLE LOGINN(IDLOGINN INT PRIMARY KEY,PIN VARCHAR(4),PREGUNTA VARCHAR(30),RESPUESTA VARCHAR(30))");

        db.execSQL("CREATE TABLE RECURRENTES(IDRECURRENTES INT PRIMARY KEY,NOMBRE VARCHAR(50),CANTIDAD FLOAT,FECHA DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.RECURRENTES);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.LOGINN);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CATEGORIASTIPO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CATEGORIAS);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.EGRESOS);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.INGRESOS);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PRESTAMOS);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.DEUDAS);

        onCreate(db);
    }

public Login obtenerLogin(){
    Login l = new Login();
    String sql = "SELECT * FROM LOGINN";
    Cursor c = db.rawQuery(sql,null);
    if(c.moveToFirst()){
        l.setPin(c.getString(1));
        l.setPregunta(c.getString(2));
        l.setRespuesta(c.getString(3));
    }else{
        return null;
    }
    return l;
}
public void insertarLOGINN(String pin, String pre, String resp){
    Login p = new Login(pin,pre,resp);
    db.execSQL("DELETE FROM LOGINN");
    ContentValues valores = new ContentValues();
    valores.put("PIN",p.getPin());
    valores.put("PREGUNTA", p.getRespuesta());
    valores.put("RESPUESTA", p.getRespuesta());

    db.insert("LOGINN", null, valores);
    }
}


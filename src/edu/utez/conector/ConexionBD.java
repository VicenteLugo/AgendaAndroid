package edu.utez.conector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper{
		 
	public ConexionBD(Context contexto){
		super (contexto, "agenda", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		String tabla="CREATE TABLE contactos (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT, " + "nombre TEXT, "+
				"apellidos TEXT," + " telefono TEXT,"+" email TEXT,"+" imagen TEXT)";
		arg0.execSQL(tabla);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL("DROP TABLE IF EXIST contactos");
		this.onCreate(arg0); 
	}
	
	public void insertar (String tabla, ContentValues valores){
		SQLiteDatabase db= this.getWritableDatabase();//conexion establecida
		db.insert(tabla, null, valores);
	}
	public Cursor consultaGeneral(String tabla){
		SQLiteDatabase db=this.getWritableDatabase();//conexion establecida
		String query="SELECT * FROM "+tabla +" ORDER BY apellidos ASC";
		return db.rawQuery(query, null);
	}
	public Cursor consultarEspecifico(String tabla, String[] columnas, String where, String[] argumentosWhere){
		SQLiteDatabase db=this.getWritableDatabase();//conexion establecida
		return db.query(tabla, columnas, where, argumentosWhere, "", "", "", "");	
	}
	public void actualizar(String tabla, ContentValues valores, String where, String [] argumentosWhere){
		 SQLiteDatabase db=this.getWritableDatabase();//conexion establecida
		 db.update(tabla, valores, where, argumentosWhere);
	}
	public void eliminar(String tabla, String where, String [] argumentosWhere){
		SQLiteDatabase db=this.getWritableDatabase();//conexion establecida
		db.delete(tabla, where, argumentosWhere);
	}
	
	
}



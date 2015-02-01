package pe.area51.contentprovidernotas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

	public static final String DATABASE = "notas-database";
	public static final int VERSION = 1;
	public static final String TABLE_NOTAS = "notas";

	public DatabaseManager(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + TABLE_NOTAS
				+ " (_id INTEGER PRIMARY KEY, titulo TEXT, contenido TEXT)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}

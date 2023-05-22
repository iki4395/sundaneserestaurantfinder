package com.example.sundaneserestaurantfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper{
	
	public static final String DATABASE_NAME = "db_restoran";
	public static final String TABLE_NAME = "t_restoran";
	public static final String KEY_ID = "_id";
	public static final String NAMA = "nama_restoran";
	public static final String ALAMAT = "alamat";
	public static final String KOTA = "nama_kota";
	public static final String KETERANGAN = "keterangan";
	public static final String LATITUDE = "lat";
	public static final String LONGITUDE = "lng";
	public static final int DATABASE_VERSION = 1;
	String DB_PATH;
	
	public DatabaseHelper(Context context){
		this.context=context;
		DB_PATH = "/data/data/com.example.sundaneserestaurantfinder/database/";
	}
	
	private static final String STRING_CREATE_DATABASE = 
			"CREATE TABLE if not exists " + TABLE_NAME + "(" + KEY_ID + "integer primary key autoincrement, " + NAMA + "TEXT not null"
			 + ALAMAT + "TEXT not null, " + KOTA + "TEXT not null, " + KETERANGAN + "TEXT, "
			 + LATITUDE + "REAL, " + LONGITUDE + "REAL)";
	
	private static final String STRING_UPDATE_DATABASE =
			"DROP TABLE if exists " + TABLE_NAME ;
	
	private SQLiteDatabase sqlitedatabase;
	private SQLiteHelper sqlitehelper;
	private Context context;
	
	public DatabaseHelper openToRead() throws android.database.SQLException{
		sqlitehelper = new SQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqlitedatabase = sqlitehelper.getReadableDatabase();
		return this;
	}
	
	public DatabaseHelper openToWrite() throws android.database.SQLException{
		sqlitehelper = new SQLiteHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		sqlitedatabase = sqlitehelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		sqlitehelper.close();
	}
	
	public long insert(String nama, String alamat, String kota, String keterangan, String latitude, String longitude){
		ContentValues cv = new ContentValues();
		cv.put(NAMA, nama);
		cv.put(ALAMAT, alamat);
		cv.put(KOTA, kota);
		cv.put(KETERANGAN, keterangan);
		cv.put(LATITUDE, latitude);
		cv.put(LONGITUDE, longitude);
		return sqlitedatabase.insert(TABLE_NAME, null, cv);
	}
	
	public int deleteAll(){
		return sqlitedatabase.delete(TABLE_NAME, null, null);
	}
	
	public Cursor queueAll(){
		String[] columns = new String[]{KEY_ID, NAMA, ALAMAT, KOTA, KETERANGAN, LATITUDE, LONGITUDE};
		Cursor cursor = sqlitedatabase.query(TABLE_NAME, columns, null, null, null, null, null);
		
		return cursor;
	}
	
	public class SQLiteHelper extends SQLiteOpenHelper{
		public SQLiteHelper(Context context, String name, CursorFactory factory, int version){
			super(context, name, factory, version);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(STRING_CREATE_DATABASE);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL(STRING_UPDATE_DATABASE);
			db.execSQL(STRING_CREATE_DATABASE);
		}
	}
	
}

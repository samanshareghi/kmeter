package com.omid.saman.kmeter;

import java.util.LinkedList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	//Database related variables
	private final static String DATABASE_NAME = "KMETER_DATABASE";
	private final static int DATABASE_VERSION = 1;
	
	//Table names
	private final static String PEOPLE_TABLE = "PEOPLE_TABLE";
	
	//table elements
	private final static String PRIME_KEY = "PRIME_KEY";
	private final static String PHONE_NUMBER_KEY = "PHONE_NUMBER";
	private final static String GATE_NUM_KEY = "GATE_NUMBER";
	private final static String ZONE_KEY = "ZONE";
	private final static String TOTAL_PURCHASE_KEY = "TOTAL_PURCHASE";
	private final static String TIP_KEY = "TIP";
	private final static String DANGER_KEY = "DANGER";
	private final static String NAG_KEY = "NAG";
	private final static String DISTANCE_KEY = "DISTANCE";
	private final static String NAME_KEY = "NAME";
	private final static String ADDRESS_KEY = "ADDRESS";
	private final static String COMPLEX_NAME_KEY = "COMPLEX_NAME";
	
	public DatabaseHandler(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_PEOPLE_TABLE = "CREATE TABLE " + PEOPLE_TABLE + " ( "
				+ PRIME_KEY + " INTEGER PRIMARY KEY, "
				+ PHONE_NUMBER_KEY + " TEXT, " 
				+ ZONE_KEY + " TEXT, "
				+ GATE_NUM_KEY + " TEXT, "
				+ TOTAL_PURCHASE_KEY + " REAL, " 
				+ TIP_KEY + " REAL, "
				+ DANGER_KEY + " INTEGER, "
				+ NAG_KEY + " INTEGER, " 
				+ DISTANCE_KEY + " REAL, "
				+ NAME_KEY + " TEXT, "
				+ ADDRESS_KEY + " TEXT, "
				+ COMPLEX_NAME_KEY + " TEXT)";
		
		db.execSQL(CREATE_PEOPLE_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		db.execSQL("DROP TABLE IF EXISTS " + PEOPLE_TABLE);
		onCreate(db);
	}
	
	
	public LinkedList<PersonInfo> getPersonInfo(long phoneNumber) 
	{
		LinkedList<PersonInfo> allInfo = new LinkedList<PersonInfo>();
		
		SQLiteDatabase db = this.getReadableDatabase();
		String selectString = "SELECT * FROM PEOPLE_TABLE WHERE " + PHONE_NUMBER_KEY + "=" + phoneNumber;
		
		Cursor stats = db.rawQuery(selectString, null);
		
		if (stats.moveToFirst()) 
		{
			do 
			{
				allInfo.add(new PersonInfo(stats.getString(1), stats.getString(2), stats.getString(3), stats.getFloat(4), stats.getFloat(5), stats.getInt(6), stats.getInt(7), stats.getFloat(8), stats.getString(9), stats.getString(10), stats.getString(11)));
				
			} while (stats.moveToNext());
			Log.d("-----", "The length is: " + allInfo.size());
			db.close();
			return allInfo;
		}
		return null;
	}
	
	public LinkedList<PersonInfo> getAllPersonInfo(int phoneNumber) 
	{
		LinkedList<PersonInfo> allInfo = new LinkedList<PersonInfo>();
		
		SQLiteDatabase db = this.getReadableDatabase();
		String selectString = "SELECT * FROM PEOPLE_TABLE";
		
		Cursor stats = db.rawQuery(selectString, null);
		
		if (stats.moveToFirst()) 
		{
			do 
			{
				allInfo.add(new PersonInfo(stats.getString(1), stats.getString(2), stats.getString(3), stats.getFloat(4), stats.getFloat(5), stats.getInt(6), stats.getInt(7), stats.getFloat(8), stats.getString(9), stats.getString(10), stats.getString(11)));
				
			} while (stats.moveToNext());
			Log.d("-----", "The length is: " + allInfo.size());
			db.close();
			return allInfo;
		}
		return null;
	}

	public void addCustomer(PersonInfo info) {
		ContentValues values = new ContentValues();

		values.put(PHONE_NUMBER_KEY, info.phone);
		values.put(ZONE_KEY, info.zone);
		values.put(GATE_NUM_KEY, info.gate_num);
		values.put(TOTAL_PURCHASE_KEY, info.total_purchase);
		values.put(TIP_KEY, info.tip);
		values.put(DANGER_KEY, info.danger);
		values.put(NAG_KEY, info.nag);
		values.put(DISTANCE_KEY, info.distance);
		values.put(NAME_KEY, info.name);
		values.put(ADDRESS_KEY, info.address);
		values.put(COMPLEX_NAME_KEY, info.complex_name);		

		// opening of a new writable db connection
		SQLiteDatabase db = this.getWritableDatabase();
		db.insert(PEOPLE_TABLE, null, values);// Inserting Row
		db.close(); // Closing database connection
				
	}
}

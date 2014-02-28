package com.omid.saman.kmeter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	//Database related variables
	private final static String DATABASE_NAME = "KMETER_DATABASE";
	private final static int DATABASE_VERSION = 1;
	
	//Table names
	private final static String PEOPLE_TABLE = "PEOPLE_TABLE";
	
	//table elements
	private final static String PRIME_KEY = "PRIME_KEY";
	private final static String PHONE_NUMBER = "PHONE_NUMBER";
	private final static String GATE_NUM = "GATE_NUMBER";
	private final static String TOTAL_PURCHASE = "TOTAL_PURCHASE";
	private final static String TIP = "TIP";
	private final static String NAG = "NAG";
	private final static String DISTANCE = "DISTANCE";
	private final static String NAME = "NAME";
	private final static String ADDRESS = "ADDRESS";
	private final static String COMPLEX_NAME = "COMPLEX_NAME";
	
	public DatabaseHandler(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_PEOPLE_TABLE = "CREATE TABLE " + PEOPLE_TABLE + " ( "
				+ PHONE_NUMBER + " INTEGER PRIMARY KEY, " 
				+ GATE_NUM + " INTEGER, "
				+ TOTAL_PURCHASE + " INTEGER, " 
				+ TIP+ " INTEGER, "
				+ NAG + " INTEGER, " 
				+ DISTANCE + " INTEGER, "
				+ NAME + " TEXT, "
				+ ADDRESS + " TEXT, "
				+ COMPLEX_NAME + " TEXT)";
		
		db.execSQL(CREATE_PEOPLE_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + PEOPLE_TABLE);
		onCreate(db);
	}
	
	
	public PersonInfo getPersonInfo(int phoneNumber) {
		return null;
	}

	public void addCustomer(PersonInfo info) {
		PersonInfo info1 = new PersonInfo(phone, gate_num, total_purchase, tip, danger, nag, distance, name, address, complex_name);
				
	}
}

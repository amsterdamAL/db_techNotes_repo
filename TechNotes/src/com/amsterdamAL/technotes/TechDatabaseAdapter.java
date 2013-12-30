package com.amsterdamAL.technotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TechDatabaseAdapter {

	TechHelper helper;
	int cPosition;
	int rowCount;
	long id;
	
	public TechDatabaseAdapter(Context context) {
		helper = new TechHelper(context);
	}

	
	public long insertData(String stringFullDate,
							String jobId,
							String name,
							String stringFullAddress,
							String apt,
							String stringFullTn,
							String stringFullCbr,
							String stringFullF1,
							String stringFullF2,
							String stringFullF3,
							String stringFullF4,
							String stringFullXbx,
							String stringFullF2Term,
							String stringFullRt,
							String memo){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		
		contentValues.put(TechHelper.DATE, stringFullDate);
		contentValues.put(TechHelper.JOB_ID, jobId);
		contentValues.put(TechHelper.NAME, name);
		contentValues.put(TechHelper.ADDRESS, stringFullAddress);
		contentValues.put(TechHelper.APT, apt);
		contentValues.put(TechHelper.TRBL_TN, stringFullTn);
		contentValues.put(TechHelper.CBR, stringFullCbr);
		contentValues.put(TechHelper.FONE, stringFullF1);
		contentValues.put(TechHelper.FTWO, stringFullF2);
		contentValues.put(TechHelper.FTHREE, stringFullF3);
		contentValues.put(TechHelper.FFOUR, stringFullF4);
		contentValues.put(TechHelper.XBX, stringFullXbx);
		contentValues.put(TechHelper.F2TRM, stringFullF2Term);
		contentValues.put(TechHelper.RT, stringFullRt);
		contentValues.put(TechHelper.MEMO, memo);
		
		id = db.insert(TechHelper.TABLE_NAME, null, contentValues);
		return id;
	}

	
	public void goBack(){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(TechHelper.TABLE_NAME, null, null, null, null, null, null);
		
		//if therers a new row then do this
		if (rowCount != cursor.getCount()){
			cursor.moveToLast();
			cursor.moveToPrevious();
			cPosition = cursor.getPosition();
			rowCount = cursor.getCount();
			
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Facilities.dateBox.setText(dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			String addressResult = cursor.getString(addressIndex);
			Facilities.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Facilities.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Facilities.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Facilities.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Facilities.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Facilities.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Facilities.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Facilities.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Facilities.f4View.setText(f4Result);
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
			Facilities.rtView.setText(rtResult);
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Facilities.memoView.setText(memoResult);
			
		//if there is no new row and cursor is not -1 then do this....
		}else if (rowCount == cursor.getCount() && cPosition > 0){
			cursor.moveToPosition(cPosition);
			cursor.moveToPrevious();
			cPosition = cursor.getPosition();
			
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Facilities.dateBox.setText(dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			String addressResult = cursor.getString(addressIndex);
			Facilities.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Facilities.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Facilities.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Facilities.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Facilities.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Facilities.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Facilities.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Facilities.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Facilities.f4View.setText(f4Result);
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
			Facilities.rtView.setText(rtResult);
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Facilities.memoView.setText(memoResult);
			
		}else{
			Log.d("AMSTERDAM", "you have reched the start bro");
		}
	}
	
	
	
	
	public void goNext() {
		
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(TechHelper.TABLE_NAME, null, null, null, null, null, null);
		
		
		if (rowCount == cursor.getCount() && cPosition < cursor.getCount()-1){
			cursor.moveToPosition(cPosition);
			cursor.moveToNext();
			cPosition = cursor.getPosition();

			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Facilities.dateBox.setText(dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			String addressResult = cursor.getString(addressIndex);
			Facilities.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Facilities.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Facilities.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Facilities.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Facilities.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Facilities.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Facilities.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Facilities.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Facilities.f4View.setText(f4Result);
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
			Facilities.rtView.setText(rtResult);
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Facilities.memoView.setText(memoResult);
			
		}else{
			Log.d("AMSTERDAM", "This is the end of the line");
		}
	}


	
	
	public String getAllData() {

		SQLiteDatabase db = helper.getWritableDatabase();
		//String[] columns = { TechHelper.UID, TechHelper.DATE,
		//		TechHelper.JOB_ID, TechHelper.NAME,
		//		TechHelper.ADDRESS, TechHelper.APT, TechHelper.TRBL_TN,
		//		TechHelper.CBR, TechHelper.XBX };

		Cursor cursor = db.query(TechHelper.TABLE_NAME, null, null, null,
				null, null, null);

		StringBuffer buffer = new StringBuffer();

		while (cursor.moveToNext()) {
			
			int uidIndex = cursor.getColumnIndex(TechHelper.UID);
			String uidResult = cursor.getString(uidIndex);
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			String addressResult = cursor.getString(addressIndex);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			
			buffer.append(uidResult+ " " +dateResult+ " " +addressResult+ " "
					+jobIdResult+ " " +nameResult+ " " +cbrResult+ " " +trblTnResult+ " " 
					+f1Result+ " " +f2Result+ " " +f3Result+ " " +f4Result+ " "
					+rtResult+ " " +memoResult+ "\n");
		}
		return buffer.toString();
	}


	
				static class TechHelper extends SQLiteOpenHelper {

					private static final String DATABASE_NAME = "tndatabase.db";
					private static final String TABLE_NAME = "TNTABLE";
					private static final String UID = "_id";
					private static final String DATE = "Date";
					private static final String JOB_ID = "JobID";
					private static final String NAME = "Name";
					private static final String ADDRESS = "Adress";
					private static final String APT = "Apt";
					private static final String TRBL_TN = "TrblTn";
					private static final String CBR = "Cbr";
					private static final String FONE = "F1";
					private static final String FTWO = "F2";
					private static final String FTHREE = "F3";
					private static final String FFOUR = "F4";
					private static final String XBX = "Xbx";
					private static final String F2TRM = "F2trm";
					private static final String RT = "Rt";
					private static final String MEMO = "Memo";
					private static final int DATABASE_VERSION = 7;
					private static final String CREATE_TABLE = 
							"CREATE TABLE " +TABLE_NAME+ 
							" (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
							+DATE+ " VARCHAR(255), " 
							+JOB_ID+ " VARCHAR(255), " 
							+NAME+ " VARCHAR(255), " 
							+ADDRESS+ " VARCHAR(255), " 
							+APT+ " VARCHAR(255), " 
							+TRBL_TN+ " VARCHAR(255), " 
							+CBR+ " VARCHAR(255), "
							+FONE+ " VARCHAR(255), "
							+FTWO+ " VARCHAR(255), "
							+FTHREE+ " VARCHAR(255), "
							+FFOUR+ " VARCHAR(255), "
							+XBX+ " VARCHAR(255), "
							+F2TRM+ " VARCHAR(255), "
							+RT+ " VARCHAR(255), "
							+MEMO+ " VARCHAR(255));";

					private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
							+ TABLE_NAME;
					private Context context;

					
					TechHelper(Context context) {
						super(context, DATABASE_NAME, null, DATABASE_VERSION);
						this.context = context;
						Message.message(context, "constructor called");
					}

			
					@Override
					public void onCreate(SQLiteDatabase db) {
						try {
							db.execSQL(CREATE_TABLE);
							Message.message(context, "onCREATE was called");
						} catch (SQLException e) {
							// 	TODO Auto-generated catch block
							Message.message(context, " " + e + "error catched");
						}

					}

					
					@Override
					public void onUpgrade(SQLiteDatabase db, int oldVerson, int newVersion) {
						try {
							Message.message(context, "onUpgrade was called");
							db.execSQL(DROP_TABLE);
							onCreate(db);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							Message.message(context, "" + e);
						}
					}

				}

}

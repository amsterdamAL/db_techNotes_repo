package com.amsterdamAL.technotes;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class TechDatabaseAdapter {

	TechHelper helper;
	long id;
	String addressResult;
	static Cursor cursor;
	static int cPos;
	static SQLiteDatabase db;
	static int rowTotal;
	static int rowCurrent;
	Context c;
	String uidSearchResult;
	public long uidResult;
	
	public TechDatabaseAdapter(Context context) {
		helper = new TechHelper(context);
		c = context;
	}

	
	
	
	
	//insert new record into db
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
							String memo,
							String stringDay,
							String stringMonth,
							String numDate,
							String stringYear){
		
		
		db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		
		//place initial data into contentvalues object for db insertion 
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
		contentValues.put(TechHelper.WEEKDAY, stringDay);
		contentValues.put(TechHelper.MONTH, stringMonth);
		contentValues.put(TechHelper.NUMDATE, numDate);
		contentValues.put(TechHelper.YEAR, stringYear);
		
		id = db.insert(TechHelper.TABLE_NAME, null, contentValues);
		return id;
	}
	
	//called when saveButton is hit, from the editRecords activity
	public long modifyRow(
						String addyViewEdit,
						String orderViewEdit,
						String nameViewEdit,
						String cbrViewEdit, 
						String trblTnViewEdit,
						String f1ViewEdit,
						String f2ViewEdit,
						String f3ViewEdit,
						String f4ViewEdit, 
						String f2TermViewEdit, 
						String rtViewEdit, 
						String memoViewEdit){
					
					
					db = helper.getWritableDatabase();
					ContentValues contentValues = new ContentValues();
					//get modified data into CV object for db modification
					contentValues.put(TechHelper.ADDRESS, addyViewEdit);
					contentValues.put(TechHelper.JOB_ID, orderViewEdit);
					contentValues.put(TechHelper.NAME, nameViewEdit);
					contentValues.put(TechHelper.CBR, cbrViewEdit);
					contentValues.put(TechHelper.TRBL_TN, trblTnViewEdit);
					contentValues.put(TechHelper.FONE, f1ViewEdit);
					contentValues.put(TechHelper.FTWO, f2ViewEdit);
					contentValues.put(TechHelper.FTHREE, f3ViewEdit);
					contentValues.put(TechHelper.FFOUR, f4ViewEdit);
					contentValues.put(TechHelper.F2TRM, f2TermViewEdit);
					contentValues.put(TechHelper.RT, rtViewEdit);
					contentValues.put(TechHelper.MEMO, memoViewEdit);
					
					id = db.update(TechHelper.TABLE_NAME, contentValues, 
							TechHelper.ADDRESS+" = '"+addressResult+"'", null);
					return id;
				}
	
	//called when editRecords starts to get record at cPos (cPos = cursor.getPosition()  ).... 
	public void getAllDisplayCurrent(){
		
		//get data from row located at cPos and display that data  in 
		//EditRecords.class 
		cursor.moveToPosition(cPos);
		int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
		String dateResult = cursor.getString(dateIndex);
		EditRecords.dateBox.setText(dateResult);
		int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
		addressResult = cursor.getString(addressIndex);
		EditRecords.addyView.setText(addressResult);
		int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
		String jobIdResult = cursor.getString(jobIdIndex);
		EditRecords.orderView.setText(jobIdResult);
		int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
		String nameResult = cursor.getString(nameIndex);
		EditRecords.nameView.setText(nameResult);
		int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
		String cbrResult = cursor.getString(cbrIndex);
		EditRecords.cbrView.setText(cbrResult);
		int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
		String trblTnResult = cursor.getString(trblTnIndex);
		EditRecords.trblTnView.setText(trblTnResult);
		int f1Index = cursor.getColumnIndex(TechHelper.FONE);
		String f1Result = cursor.getString(f1Index);
		EditRecords.f1View.setText(f1Result);
		int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
		String f2Result = cursor.getString(f2Index);
		EditRecords.f2View.setText(f2Result);
		int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
		String f3Result = cursor.getString(f3Index);
		EditRecords.f3View.setText(f3Result);
		int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
		String f4Result = cursor.getString(f4Index);
		EditRecords.f4View.setText(f4Result);
		int f2TermIndex = cursor.getColumnIndex(TechHelper.F2TRM);
		String f2TermResult = cursor.getString(f2TermIndex);
		
		
		if (f2TermResult !=null && !f2TermResult.isEmpty()){
			EditRecords.f2TermLeft.setText(" F2 Term:  ");
			EditRecords.f2TermView.setText(f2TermResult);
		}else{
			EditRecords.f2TermLeft.setText("");
		}
		
			
		int rtIndex = cursor.getColumnIndex(TechHelper.RT);
		String rtResult = cursor.getString(rtIndex);
		
		
		if (rtResult !=null && !rtResult.isEmpty()){
			EditRecords.rtLeft.setText(" RT:  ");
			EditRecords.rtView.setText(rtResult);
		}else{
			Records.rtLeft.setText("");
	}
		
		
		int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
		String memoResult = cursor.getString(memoIndex);
		EditRecords.memoView.setText(memoResult);
		
		
			
	}

	//delete record being viewed
	public void deleteRow(){
		Toast.makeText(c, "WHY", Toast.LENGTH_SHORT);
		AlertDialog.Builder popUp = new AlertDialog.Builder(c);
		popUp.setTitle("Confirm Delete");
		popUp.setMessage("Are you sure ?!?!");
//		set icon to dialog
//		popUp.setIcon(R.drawable.whateva);
		popUp.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				db = helper.getWritableDatabase();
				db.delete(TechHelper.TABLE_NAME, TechHelper.ADDRESS+" = '"+addressResult+"'", null);
				
//				Visual Feedback, Empty textview after db row deletion
				Records.addyView.setText("");
				Records.orderView.setText("");
				Records.nameView.setText("");
				Records.cbrView.setText("");
				Records.trblTnView.setText("");
				Records.f1View.setText("");
				Records.f2View.setText("");
				Records.f3View.setText("");
				Records.f4View.setText("");
				Records.rtView.setText("");
				Records.memoView.setText("");
				
				//go back to Records after row deletion			
				getAllRecords();
				Toast.makeText(c, "Done!", Toast.LENGTH_SHORT).show();
			}
		});
		
//		set no button
		popUp.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//Toast.makeText(c, "nothing happened", Toast.LENGTH_SHORT).show();

			}
		});
		
//		show alert dialog
		popUp.show();
		
	}
	
	//toast that displays all data (TEMP)
 	public String getAllData() {


		SQLiteDatabase db = helper.getWritableDatabase();
		
		cursor = db.query(TechHelper.TABLE_NAME, null, null, null,
				null, null, helper.UID+ " DESC" );

		StringBuffer buffer = new StringBuffer();
		buffer.setLength(0);

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
			
			int dayOfWeekIndex = cursor.getColumnIndex(TechHelper.WEEKDAY);
			String dayOfWeekResult = cursor.getString(dayOfWeekIndex);
			
			int monthIndex = cursor.getColumnIndex(TechHelper.MONTH);
			String monthResult = cursor.getString(monthIndex);
			
			int dateOfMonthIndex = cursor.getColumnIndex(TechHelper.NUMDATE);
			String dayOfMonthResult = cursor.getString(dateOfMonthIndex);
			
			int yearIndex = cursor.getColumnIndex(TechHelper.YEAR);
			String yearResult = cursor.getString(yearIndex);
			
			
			
			buffer.append(cursor.getPosition()+" "+uidResult+ " " +addressResult+ " "
					+jobIdResult+ " " +nameResult+ " " +cbrResult+ " " +trblTnResult+ " " 
					 +memoResult+ "\n");
		}
		return buffer.toString();
		
	}

	//gets db and displays last record
	public void getAllRecords() {

		db = helper.getWritableDatabase();
		cursor = db.query(TechHelper.TABLE_NAME, null, null, null,
				null, null, null);
		
		rowTotal=cursor.getCount();
		rowCurrent=cursor.getPosition()+1;

		if (cursor.moveToLast()){
			
			Records.f2TermLeft.setText("");
			Records.rtLeft.setText("");
			Records.f2TermView.setText("");
			Records.rtView.setText("");
			
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Records.dateBox.setText("  "+dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			addressResult = cursor.getString(addressIndex);
			Records.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Records.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Records.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Records.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Records.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Records.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Records.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Records.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Records.f4View.setText(f4Result);
			int f2TermIndex = cursor.getColumnIndex(TechHelper.F2TRM);
			String f2Term = cursor.getString(f2TermIndex);
				
				if (f2Term !=null && !f2Term.isEmpty()){
					Records.f2TermLeft.setText(" F2 Term:  ");
					Records.f2TermView.setText(f2Term);
				}else{
					Records.f2TermLeft.setText("");
				}
			
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
				if (rtResult !=null && !rtResult.isEmpty()){
					Records.rtLeft.setText(" RT:  ");
					Records.rtView.setText(rtResult);
			}else{
					Records.rtLeft.setText("");
			}
			
			
			
			
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Records.memoView.setText(memoResult);
			
			//variables for counter on top right corner of activities
			rowTotal=cursor.getCount();
			rowCurrent=cursor.getPosition()+1;

			Records.theCount.setText( "( " +rowCurrent+ " of " +rowTotal+ " ) " );
			cPos = cursor.getPosition();
			
			
			
			
			
		}else{
			Log.d("AMSTERDAMAL", "move cursor to last failed! so i cant getAllRecords bitch");
		}
		
	}
	
	//goes back one record
	public void backRecords(){
		
			
		//moves back one row in db untill first row is showing
		if (!cursor.isFirst()){
		
		
			cursor.moveToPrevious();
			
			Records.f2TermLeft.setText("");
			Records.rtLeft.setText("");
			Records.f2TermView.setText("");
			Records.rtView.setText("");
			
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Records.dateBox.setText(dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			addressResult = cursor.getString(addressIndex);
			Records.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Records.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Records.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Records.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Records.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Records.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Records.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Records.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Records.f4View.setText(f4Result);
			int f2TermIndex = cursor.getColumnIndex(TechHelper.F2TRM);
			String f2Term = cursor.getString(f2TermIndex);
				
				if (f2Term !=null && !f2Term.isEmpty()){
					Records.f2TermLeft.setText(" F2 Term:  ");
					Records.f2TermView.setText(f2Term);
				}else{
					Records.f2TermLeft.setText("");
				}
			
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
				if (rtResult !=null && !rtResult.isEmpty()){
					Records.rtLeft.setText(" RT:  ");
					Records.rtView.setText(rtResult);
			}else{
					Records.rtLeft.setText("");
			}
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Records.memoView.setText(memoResult);
			
			
			cPos = cursor.getPosition();
			
			//updates job counter on top right corner of avtivities
			rowTotal=cursor.getCount();
			rowCurrent=cursor.getPosition()+1;

			Records.theCount.setText( "( " +rowCurrent+ " of " +rowTotal+ " ) " );

			
		}else{
			Log.d("AMSTERDAM", "you have reched the start bro");
		}

	}	
	
	//goes forward one record
	public void forwardRecords() {
		
		
		//move forward one row untill last record is showing
		if (!cursor.isLast()){
			
			Records.f2TermLeft.setText("");
			Records.rtLeft.setText("");
			Records.f2TermView.setText("");
			Records.rtView.setText("");
			cursor.moveToNext();
			
			int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
			String dateResult = cursor.getString(dateIndex);
			Records.dateBox.setText(dateResult);
			int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
			addressResult = cursor.getString(addressIndex);
			Records.addyView.setText(addressResult);
			int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
			String jobIdResult = cursor.getString(jobIdIndex);
			Records.orderView.setText(jobIdResult);
			int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
			String nameResult = cursor.getString(nameIndex);
			Records.nameView.setText(nameResult);
			int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
			String cbrResult = cursor.getString(cbrIndex);
			Records.cbrView.setText(cbrResult);
			int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
			String trblTnResult = cursor.getString(trblTnIndex);
			Records.trblTnView.setText(trblTnResult);
			int f1Index = cursor.getColumnIndex(TechHelper.FONE);
			String f1Result = cursor.getString(f1Index);
			Records.f1View.setText(f1Result);
			int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
			String f2Result = cursor.getString(f2Index);
			Records.f2View.setText(f2Result);
			int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
			String f3Result = cursor.getString(f3Index);
			Records.f3View.setText(f3Result);
			int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
			String f4Result = cursor.getString(f4Index);
			Records.f4View.setText(f4Result);
			int f2TermIndex = cursor.getColumnIndex(TechHelper.F2TRM);
			String f2Term = cursor.getString(f2TermIndex);
				
				if (f2Term !=null && !f2Term.isEmpty()){
					Records.f2TermLeft.setText(" F2 Term:  ");
					Records.f2TermView.setText(f2Term);
				}else{
					Records.f2TermLeft.setText("");
				}
			
			int rtIndex = cursor.getColumnIndex(TechHelper.RT);
			String rtResult = cursor.getString(rtIndex);
				if (rtResult !=null && !rtResult.isEmpty()){
					Records.rtLeft.setText(" RT:  ");
					Records.rtView.setText(rtResult);
			}else{
					Records.rtLeft.setText("");
			}
			int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
			String memoResult = cursor.getString(memoIndex);
			Records.memoView.setText(memoResult);
			cPos = cursor.getPosition();
			//updates job counter on top right corner of activities
			rowTotal=cursor.getCount();
			rowCurrent=cursor.getPosition()+1;

			Records.theCount.setText( "( " +rowCurrent+ " of " +rowTotal+ " ) " );
			
		}else{
			Log.d("AMSTERDAM", "THis is the end.. my friend");
		}

	}	

	//search db and display results in Records class
	public long searchRecords()
	{
		
		 String jobIdSearchString = Search.searchByJobId.getText().toString().trim();
		 String addressSearchString = Search.searchByAddress.getText().toString().trim().toLowerCase();
		 String aptSearchString = Search.searchByApt.getText().toString().trim().toLowerCase();
		 String tnSearchString = Search.searchByTn.getText().toString().trim().toLowerCase();
		 String cbrSearchString = Search.searchByCbr.getText().toString().trim().toLowerCase();
	        
	     cursor = null;
		 db = helper.getWritableDatabase();
	     cursor = db.query(TechHelper.TABLE_NAME, null, TechHelper.JOB_ID + "='" + jobIdSearchString + "'", null,
							null, null, null);	     
	     
	     if (cursor!=null && cursor.getCount()!=0){
	    	 
     		cursor.moveToFirst();
	    		 
 				int uidIndex = cursor.getColumnIndex(TechHelper.UID);
     			uidResult = cursor.getLong(uidIndex);
	 			//Toast.makeText(c, "cursor is not null or 0 AND movetofirst is ture ", Toast.LENGTH_SHORT).show();
	     }else{
	    	
	     		Toast.makeText(c, "no results found..", Toast.LENGTH_SHORT).show();
		 }
	     	
	     
    	 return uidResult;
		
	}
	
	//Display search result in the records class
	public void displayResult(long uid) {

		db = helper.getWritableDatabase();
		cursor = db.query(TechHelper.TABLE_NAME, null, null, null,
				null, null, null);
		
		rowTotal=cursor.getCount();
		rowCurrent=cursor.getPosition()+1;

		//loop all rows untill match is found
		while (cursor.moveToNext()){
			
			int uidIndex = cursor.getColumnIndex(TechHelper.UID);
			long uidResult = cursor.getLong(uidIndex);
				
				//once match is found break out
				if(uid == uidResult){
					Toast.makeText(c, "flag wasTRUU", Toast.LENGTH_SHORT).show();
					break;
				}
		}
			
		
		//display result 
		Records.f2TermLeft.setText("");
		Records.rtLeft.setText("");
		Records.f2TermView.setText("");
		Records.rtView.setText("");
		
		int dateIndex = cursor.getColumnIndex(TechHelper.DATE);
		String dateResult = cursor.getString(dateIndex);
		Records.dateBox.setText("  "+dateResult);
		int addressIndex = cursor.getColumnIndex(TechHelper.ADDRESS);
		addressResult = cursor.getString(addressIndex);
		Records.addyView.setText(addressResult);
		int jobIdIndex = cursor.getColumnIndex(TechHelper.JOB_ID);
		String jobIdResult = cursor.getString(jobIdIndex);
		Records.orderView.setText(jobIdResult);
		int nameIndex = cursor.getColumnIndex(TechHelper.NAME);
		String nameResult = cursor.getString(nameIndex);
		Records.nameView.setText(nameResult);
		int cbrIndex = cursor.getColumnIndex(TechHelper.CBR);
		String cbrResult = cursor.getString(cbrIndex);
		Records.cbrView.setText(cbrResult);
		int trblTnIndex = cursor.getColumnIndex(TechHelper.TRBL_TN);
		String trblTnResult = cursor.getString(trblTnIndex);
		Records.trblTnView.setText(trblTnResult);
		int f1Index = cursor.getColumnIndex(TechHelper.FONE);
		String f1Result = cursor.getString(f1Index);
		Records.f1View.setText(f1Result);
		int f2Index = cursor.getColumnIndex(TechHelper.FTWO);
		String f2Result = cursor.getString(f2Index);
		Records.f2View.setText(f2Result);
		int f3Index = cursor.getColumnIndex(TechHelper.FTHREE);
		String f3Result = cursor.getString(f3Index);
		Records.f3View.setText(f3Result);
		int f4Index = cursor.getColumnIndex(TechHelper.FFOUR);
		String f4Result = cursor.getString(f4Index);
		Records.f4View.setText(f4Result);
		int f2TermIndex = cursor.getColumnIndex(TechHelper.F2TRM);
		String f2Term = cursor.getString(f2TermIndex);
			
			if (f2Term !=null && !f2Term.isEmpty()){
				Records.f2TermLeft.setText(" F2 Term:  ");
				Records.f2TermView.setText(f2Term);
			}else{
				Records.f2TermLeft.setText("");
			}
		
		int rtIndex = cursor.getColumnIndex(TechHelper.RT);
		String rtResult = cursor.getString(rtIndex);
			if (rtResult !=null && !rtResult.isEmpty()){
				Records.rtLeft.setText(" RT:  ");
				Records.rtView.setText(rtResult);
		}else{
				Records.rtLeft.setText("");
		}
		
		
		
		
		int memoIndex = cursor.getColumnIndex(TechHelper.MEMO);
		String memoResult = cursor.getString(memoIndex);
		Records.memoView.setText(memoResult);
		
		//variables for counter on top right corner of activities
		rowTotal=cursor.getCount();
		rowCurrent=cursor.getPosition()+1;

		Records.theCount.setText( "( " +rowCurrent+ " of " +rowTotal+ " ) " );
		cPos = cursor.getPosition();
				
	}	
			
		
		
	
	
	
	
		//sqlite schema nested class
		//nested so variables can be accessible 
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
					private static final String WEEKDAY = "Weekday";
					private static final String MONTH = "Month";
					private static final String NUMDATE = "NumDate";
					private static final String YEAR = "Year";
					private static final int DATABASE_VERSION = 11;
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
							+MEMO+ " VARCHAR(255), "
							+WEEKDAY+ " VARCHAR(255), "
							+MONTH+ " VARCHAR(255), "
							+NUMDATE+ " VARCHAR(255), "
							+YEAR+ " VARCHAR(255));";

					private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
							+ TABLE_NAME;
					private Context context;

					
					TechHelper(Context context) {
						super(context, DATABASE_NAME, null, DATABASE_VERSION);
						this.context = context;
						//Message.message(context, "constructor called");
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

package com.amsterdamAL.technotes;

import java.util.Calendar;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Technotes extends Activity implements OnItemSelectedListener {

	static EditText nameBox, addy, addy2, aptBox, jobIdBox, cbrBox, tnBox, f1CableBox,
			f1PairBox, f1BpBox, f2CableBox, f2PairBox, f2BpBox, f3CableBox,
			f3PairBox, f3BpBox, f4CableBox, f4PairBox, f4BpBox, addyF2Term1, addyRt1, memoBox;

	String date, name, address, apt, jobId, trblTn, cbr, f1Cable, f1Pair, f1Bp,
			f2Cable, f2Pair, f2Bp, f3Cable, f3Pair, f4Cable, f4Pair, f4Bp,
			f3Bp, memo;
	
	static boolean recordsOrResultsFlag;

	// concatenated strings
	String stringFullAddress, stringFullXbx, stringFullF2Term, stringFullRt,
			stringFullTn, stringFullCbr, stringFullF1, stringFullF2,
			stringFullF3, stringFullF4;
	
	static String uidResult;

	// spinner related strings
	String spinner1Str, spinner3Str, spinnerF1Str, spinnerF2Str, spinnerF3Str,
			spinnerF4Str, spinnerTnStr,	spinnerCbrStr;
	Spinner spinner1, spinner3, spinnerF1, spinnerF2, spinnerF3, spinnerF4,
			spinnerTn, spinnerCbr;

	
	// current Date Values to be added to stringBuilder
	String stringDay;
	String stringMonth;
	String stringDate;
	String stringYear;
	String stringFullDate;
	String stringFullDateChecker;

	TechDatabaseAdapter techhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.technotes_layout);

		// setup SQlite object
		techhelper = new TechDatabaseAdapter(this);

		// get date values to display in Facilities.class
		Calendar c = Calendar.getInstance();
		stringMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		stringDay = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,Locale.US);
		date = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		stringYear = String.valueOf(c.get(Calendar.YEAR));

		nameBox = (EditText) findViewById(R.id.nameBox);
		addy = (EditText) findViewById(R.id.addy);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		addy2 = (EditText) findViewById(R.id.addy2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		aptBox = (EditText) findViewById(R.id.aptBox);
		jobIdBox = (EditText) findViewById(R.id.orderView);
		spinnerTn = (Spinner) findViewById(R.id.spinnerTn);
		cbrBox = (EditText) findViewById(R.id.cbrBox);
		spinnerCbr = (Spinner) findViewById(R.id.spinnerCbr);
		tnBox = (EditText) findViewById(R.id.tnBox);
		spinnerF1 = (Spinner) findViewById(R.id.spinnerF1);
		f1CableBox = (EditText) findViewById(R.id.f1CableBox);
		f1PairBox = (EditText) findViewById(R.id.f1PairBox);
		f1BpBox = (EditText) findViewById(R.id.f1BpBox);
		spinnerF2 = (Spinner) findViewById(R.id.spinnerF2);
		f2CableBox = (EditText) findViewById(R.id.f2CableBox);
		f2PairBox = (EditText) findViewById(R.id.f2PairBox);
		f2BpBox = (EditText) findViewById(R.id.f2BpBox);
		spinnerF3 = (Spinner) findViewById(R.id.spinnerF3);
		f3CableBox = (EditText) findViewById(R.id.f3CableBox);
		f3PairBox = (EditText) findViewById(R.id.f3PairBox);
		f3BpBox = (EditText) findViewById(R.id.f3BpBox);
		spinnerF4 = (Spinner) findViewById(R.id.spinnerF4);
		f4CableBox = (EditText) findViewById(R.id.f4CableBox);
		f4PairBox = (EditText) findViewById(R.id.f4PairBox);
		f4BpBox = (EditText) findViewById(R.id.f4BpBox);
		addyF2Term1 = (EditText) findViewById(R.id.addyF2Term1);
		addyRt1 = (EditText) findViewById(R.id.addyRt1);
		memoBox = (EditText) findViewById(R.id.memoBox);

		spinner1.setFocusable(true);
		spinner1.setFocusableInTouchMode(true);
		spinner1.requestFocus();
		
		spinner3.setFocusable(true);
		spinner3.setFocusableInTouchMode(true);
		spinner3.requestFocus();
		// setup of spinners
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.addyarr1, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner1.setAdapter(adapter);
		// Setup Listener via previously implemented methods
		spinner1.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.addyarr2, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(adapter2);
		spinner3.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
				this, R.array.addyarr3, android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF1.setAdapter(adapter3);
		spinnerF1.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(
				this, R.array.addyarr4, android.R.layout.simple_spinner_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF2.setAdapter(adapter4);
		spinnerF2.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(
				this, R.array.addyarr5, android.R.layout.simple_spinner_item);
		adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF3.setAdapter(adapter5);
		spinnerF3.setOnItemSelectedListener(this);

		
		ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(
				this, R.array.addyarr6, android.R.layout.simple_spinner_item);
		adapter12
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerTn.setAdapter(adapter12);
		spinnerTn.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(
				this, R.array.addyarr6, android.R.layout.simple_spinner_item);
		adapter13
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCbr.setAdapter(adapter13);
		spinnerCbr.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(
				this, R.array.addyarr5, android.R.layout.simple_spinner_item);
		adapter14
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF4.setAdapter(adapter14);
		spinnerF4.setOnItemSelectedListener(this);
	}

	// calls techhelper.insertData which inserts data, then calls viewRecords below
	public void addUser(View view) {

		// gathers user input
		name = nameBox.getText().toString();
		String stringAddy = addy.getText().toString();
		String stringAddy2 = addy2.getText().toString();
		apt = aptBox.getText().toString();
		jobId = jobIdBox.getText().toString();
		trblTn = tnBox.getText().toString();
		cbr = cbrBox.getText().toString();
		f1Cable = f1CableBox.getText().toString();
		f1Pair = f1PairBox.getText().toString();
		f1Bp = f1BpBox.getText().toString();
		f2Cable = f2CableBox.getText().toString();
		f2Pair = f2PairBox.getText().toString();
		f2Bp = f2BpBox.getText().toString();
		f3Cable = f3CableBox.getText().toString();
		f3Pair = f3PairBox.getText().toString();
		f3Bp = f3BpBox.getText().toString();
		f4Cable = f4CableBox.getText().toString();
		f4Pair = f4PairBox.getText().toString();
		f4Bp = f4BpBox.getText().toString();
		
		String addyF2Term1Str = addyF2Term1.getText().toString();
		
		String addyRt1Str = addyRt1.getText().toString();
		
		memo = memoBox.getText().toString();

		// If address is not empty....., Else, toast for more info.
		if (stringAddy != null && !stringAddy.isEmpty()) {

			// Date Builder
			StringBuilder sbDateBuilder = new StringBuilder();
			sbDateBuilder.append(" (" + stringDay + ")  " + stringMonth + " "
					+ date + ", " + stringYear);
			stringFullDate = sbDateBuilder.toString();

			
			// F1 -------------------------------------
			StringBuilder sbF1 = new StringBuilder();
			if (spinnerF1Str.equals("Ca") || spinnerF1Str.equals("PG")
					|| spinnerF1Str.equals("FS") || spinnerF1Str.equals("FPG")) {
				sbF1.append(spinnerF1Str + " " + f1Cable + ", " + f1Pair
						+ " / " + f1Bp);
			} else if (spinnerF1Str.equals("")) {
				sbF1.append("... no f1 Cable / pair");
			}
			stringFullF1 = sbF1.toString();

			// F2 -------------------------------------
			StringBuilder sbF2 = new StringBuilder();
			if (spinnerF2Str.equals("UV") || spinnerF2Str.equals("MRB")
					|| spinnerF2Str.equals("EDX")
					|| spinnerF2Str.equals("AHJ")
					|| spinnerF2Str.equals("AHJX")) {
				sbF2.append(spinnerF2Str + " " + f2Cable + ", " + f2Pair);
			} else if (spinnerF2Str.equals("NPG") || spinnerF2Str.equals("ABB") || spinnerF2Str.equals("EPG")) {
				sbF2.append(spinnerF2Str + " " + f2Cable + ", " + f2Pair
						+ " / " + f2Bp);
			} else if (spinnerF2Str.equals("xbx")) {

				sbF2.append(f2Cable + ", " + f2Pair + " / " + f2Bp);
				stringFullXbx = f2Cable;

			} else if (spinnerF2Str.equals("")
					&& (f2Cable != null && !f2Cable.isEmpty())) {

				sbF2.append(f2Cable + ", " + f2Pair + " / " + f2Bp);
			}
			stringFullF2 = sbF2.toString();

			// F3 -------------------------------------
			StringBuilder sbF3 = new StringBuilder();
			if (spinnerF3Str.equals("UV") || spinnerF3Str.equals("MRB")
					|| spinnerF3Str.equals("EDX")
					|| spinnerF3Str.equals("AHJ")
					|| spinnerF3Str.equals("AHJX")) {
				sbF3.append(spinnerF3Str + " " + f3Cable + ", " + f3Pair);
			} else if (spinnerF3Str.equals("NPG") || spinnerF3Str.equals("ABB") || spinnerF3Str.equals("EPG")) {
				sbF3.append(spinnerF3Str + " " + f3Cable + ", " + f3Pair
						+ " / " + f3Bp);
			} else if (spinnerF3Str.equals("xbx")) {

				sbF3.append(f3Cable + ", " + f3Pair + " / " + f3Bp);
				stringFullXbx = f3Cable;
			
			} else if (spinnerF3Str.equals("")
					&& (f3Cable != null && !f3Cable.isEmpty())) {
				sbF3.append(f3Cable + ", " + f3Pair + " / " + f3Bp);
			}
			stringFullF3 = sbF3.toString();

			// F4 -------------------------------------
			StringBuilder sbF4 = new StringBuilder();
			if (spinnerF4Str.equals("UV") || spinnerF4Str.equals("MRB")
					|| spinnerF4Str.equals("EDX")
					|| spinnerF4Str.equals("AHJ")
					|| spinnerF4Str.equals("AHJX")) {
				sbF4.append(spinnerF4Str + " " + f4Cable + ", " + f4Pair);
			} else if (spinnerF4Str.equals("NPG") || spinnerF4Str.equals("ABB") || spinnerF4Str.equals("EPG")) {
				sbF4.append(spinnerF4Str + " " + f4Cable + ", " + f4Pair
						+ " / " + f4Bp);
			} else if (spinnerF4Str.equals("xbx")) {

				sbF4.append(f4Cable + ", " + f4Pair + " / " + f4Bp);
				stringFullXbx = f4Cable;

			} else if (spinnerF4Str.equals("")
					&& (f4Cable != null && !f4Cable.isEmpty())) {

				sbF4.append(f4Cable + ", " + f4Pair + " / " + f4Bp);
			}
			stringFullF4 = sbF4.toString();

			// Csr asddress
			if (apt != null && !apt.isEmpty()) {

				StringBuilder sbAddressBuilder = new StringBuilder();
				sbAddressBuilder.append(stringAddy).append(" ")
						.append(spinner1Str).append(" ").append(stringAddy2)
						.append(" ").append(spinner3Str).append(" #" + apt);
				stringFullAddress = sbAddressBuilder.toString();

			} else {

				StringBuilder sbAddressBuilder = new StringBuilder();
				sbAddressBuilder.append(stringAddy).append(" ")
						.append(spinner1Str).append(" ").append(stringAddy2)
						.append(" ").append(spinner3Str);
				stringFullAddress = sbAddressBuilder.toString();

			}

			// F2Term Full address
			if (addyF2Term1Str != null && !addyF2Term1Str.isEmpty()) {
			
				stringFullF2Term = addyF2Term1Str;
			}

			// Rt Full address
			if (addyRt1Str != null && !addyRt1Str.isEmpty()) {
			
				stringFullRt = addyRt1Str;
			}

			// Full Tn
			if (trblTn != null && !trblTn.isEmpty()) {
				StringBuilder tnStrBuilder = new StringBuilder();
				tnStrBuilder.append(spinnerTnStr + trblTn);
				stringFullTn = tnStrBuilder.toString();
			} else {
				stringFullTn = null;
			}

			// Full CbR
			if (cbr != null && !cbr.isEmpty()) {
				StringBuilder cbrStrBuilder = new StringBuilder();
				cbrStrBuilder.append(spinnerCbrStr + cbr);
				stringFullCbr = cbrStrBuilder.toString();
			} else {
				stringFullCbr = null;
			}

			// send to db
			long id = techhelper.insertData(stringFullDate, jobId, name,
					stringFullAddress, apt, stringFullTn, stringFullCbr,
					stringFullF1, stringFullF2, stringFullF3, stringFullF4,
					stringFullXbx, stringFullF2Term, stringFullRt, memo,
					stringDay, stringMonth, date, stringYear);

			// check if db insertion was successful
			if (id < 0) {
				Message.message(this, "error adding info to database");
			} else {
				Message.message(this, "info added to database :)");
			}

			// clear userinput
			nameBox.setText("");
			addy.setText("");
			spinner1.setSelection(0);
			addy2.setText("");
			spinner3.setSelection(0);
			aptBox.setText("");
			jobIdBox.setText("");
			spinnerTn.setSelection(0);
			cbrBox.setText("");
			spinnerCbr.setSelection(0);
			tnBox.setText("");
			spinnerF1.setSelection(0);
			f1CableBox.setText("");
			f1PairBox.setText("");
			f1BpBox.setText("");
			spinnerF2.setSelection(0);
			f2CableBox.setText("");
			f2PairBox.setText("");
			f2BpBox.setText("");
			spinnerF3.setSelection(0);
			f3CableBox.setText("");
			f3PairBox.setText("");
			f3BpBox.setText("");
			spinnerF4.setSelection(0);
			f4CableBox.setText("");
			f4PairBox.setText("");
			f4BpBox.setText("");
			addyF2Term1.setText("");
			addyRt1.setText("");
			memoBox.setText("");
			
			stringFullDate = null;
			stringFullF2Term = null;
			stringFullRt = null;
			stringFullXbx = null;
			stringFullAddress = null;
			stringFullF1 = null;
			stringFullF2 = null;
			stringFullF3 = null;
			stringFullF4 = null;

			// Start records activity, and display last record from db
			viewRecords(view);

			// if address was empty
		} else {
			Message.message(this, "enter more info...");
		}
	}

	// TEMP Button shows last few SQlite database entries in toast
	public void viewDetails(View view) {
		String data = techhelper.getAllData();
		Message.message(this, data);
	}

	// starts Records.class, which starts techhelper.getAllRecords if flag is false..
	public void viewRecords(View view) {

		Intent i = new Intent(this, Records.class);
		startActivity(i);
	}

	// starts Search class
	public void searchRecords(View view){
		
		//recordsOrResultsFlag = true;
		Intent i = new Intent(this, Search.class);
		startActivity(i);
		
	}
	
	// Spinner implemented methods
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		spinner1Str = spinner1.getSelectedItem().toString();
		spinner3Str = spinner3.getSelectedItem().toString();
		spinnerF1Str = spinnerF1.getSelectedItem().toString();
		spinnerF2Str = spinnerF2.getSelectedItem().toString();
		spinnerF3Str = spinnerF3.getSelectedItem().toString();
		spinnerF4Str = spinnerF4.getSelectedItem().toString();
		spinnerTnStr = spinnerTn.getSelectedItem().toString();
		spinnerCbrStr = spinnerCbr.getSelectedItem().toString();
	}

	// Spinner implemented methods
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		recordsOrResultsFlag = false;
		
	}
	
	
	
	
	
	
	
}

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

	EditText nameBox, addy, addy2, aptBox, jobIdBox, cbrBox, tnBox, f1CableBox,
			f1PairBox, f1BpBox, f2CableBox, f2PairBox, f2BpBox, f3CableBox,
			f3PairBox, f3BpBox, f4CableBox, f4PairBox, f4BpBox, addyXbx1,
			addyXbx3, addyF2Term1, addyF2Term3, addyRt1, addyRt3, memoBox;

	String date, name, address, apt, jobId, trblTn, cbr, f1Cable, f1Pair, f1Bp,
			f2Cable, f2Pair, f2Bp, f3Cable, f3Pair, f4Cable, f4Pair, f4Bp,
			f3Bp, memo;

	// concatenated strings
	String stringFullAddress, stringFullXbx, stringFullF2Term, stringFullRt,
			stringFullTn, stringFullCbr, stringFullF1, stringFullF2,
			stringFullF3, stringFullF4;

	// spinner related strings
	String spinner1Str, spinner3Str, spinnerF1Str, spinnerF2Str, spinnerF3Str,
			spinnerF4Str, spinnerXbx2Str, spinnerXbx4Str, spinnerF2Term2Str,
			spinnerF2Term4Str, spinnerRt2Str, spinnerRt4Str, spinnerTnStr,
			spinnerCbrStr;
	Spinner spinner1, spinner3, spinnerF1, spinnerF2, spinnerF3, spinnerF4,
			spinnerXbx2, spinnerXbx4, spinnerF2Term2, spinnerF2Term4,
			spinnerRt2, spinnerRt4, spinnerTn, spinnerCbr;

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
		addyXbx1 = (EditText) findViewById(R.id.addyXbx1);
		spinnerXbx2 = (Spinner) findViewById(R.id.spinnerXbx2);
		addyXbx3 = (EditText) findViewById(R.id.addyXbx3);
		spinnerXbx4 = (Spinner) findViewById(R.id.spinnerXbx4);
		addyF2Term1 = (EditText) findViewById(R.id.addyF2Term1);
		spinnerF2Term2 = (Spinner) findViewById(R.id.spinnerF2Term2);
		addyF2Term3 = (EditText) findViewById(R.id.addyF2Term3);
		spinnerF2Term4 = (Spinner) findViewById(R.id.spinnerF2Term4);
		addyRt1 = (EditText) findViewById(R.id.addyRt1);
		spinnerRt2 = (Spinner) findViewById(R.id.spinnerRt2);
		addyRt3 = (EditText) findViewById(R.id.addyRt3);
		spinnerRt4 = (Spinner) findViewById(R.id.spinnerRt4);
		memoBox = (EditText) findViewById(R.id.memoBox);

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

		ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(
				this, R.array.addyarr11, android.R.layout.simple_spinner_item);
		adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerXbx2.setAdapter(adapter6);
		spinnerXbx2.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(
				this, R.array.addyarr22, android.R.layout.simple_spinner_item);
		adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerXbx4.setAdapter(adapter7);
		spinnerXbx4.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(
				this, R.array.addyarr11, android.R.layout.simple_spinner_item);
		adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF2Term2.setAdapter(adapter8);
		spinnerF2Term2.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(
				this, R.array.addyarr22, android.R.layout.simple_spinner_item);
		adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerF2Term4.setAdapter(adapter9);
		spinnerF2Term4.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(
				this, R.array.addyarr11, android.R.layout.simple_spinner_item);
		adapter10
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerRt2.setAdapter(adapter10);
		spinnerRt2.setOnItemSelectedListener(this);

		ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(
				this, R.array.addyarr22, android.R.layout.simple_spinner_item);
		adapter11
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerRt4.setAdapter(adapter11);
		spinnerRt4.setOnItemSelectedListener(this);

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

	// adds info to db, starts records activity
	// calls techhelper.insertData
	// starts Records.class
	// which starts techhelper.getAllRecords..
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
		String addyXbx1Str = addyXbx1.getText().toString();
		String addyXbx3Str = addyXbx3.getText().toString();
		String addyF2Term1Str = addyF2Term1.getText().toString();
		String addyF2Term3Str = addyF2Term3.getText().toString();
		String addyRt1Str = addyRt1.getText().toString();
		String addyRt3Str = addyRt3.getText().toString();
		memo = memoBox.getText().toString();

		// If address is not empty....., Else, toast for more info.
		if (stringAddy != null && !stringAddy.isEmpty()) {

			// Date Builder
			StringBuilder sbDateBuilder = new StringBuilder();
			sbDateBuilder.append(" (" + stringDay + ")  " + stringMonth + " "
					+ date + ", " + stringYear);
			stringFullDate = sbDateBuilder.toString();

			// Xbox Full address
			if (addyXbx1Str != null && !addyXbx1Str.isEmpty()) {
				StringBuilder sbXbxBuilder = new StringBuilder();
				sbXbxBuilder.append(addyXbx1Str).append(" ")
						.append(spinnerXbx2Str).append(" ").append(addyXbx3Str)
						.append(" ").append(spinnerXbx4Str);
				stringFullXbx = sbXbxBuilder.toString();
			}

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
					|| spinnerF2Str.equals("ABB") || spinnerF2Str.equals("EDX")
					|| spinnerF2Str.equals("AHJ")
					|| spinnerF2Str.equals("AHJX")) {
				sbF2.append(spinnerF2Str + " " + f2Cable + ", " + f2Pair);
			} else if (spinnerF2Str.equals("NPG") || spinnerF2Str.equals("EPG")) {
				sbF2.append(spinnerF2Str + " " + f2Cable + ", " + f2Pair
						+ " / " + f2Bp);
			} else if (spinnerF2Str.equals("xbx")) {

				if (addyXbx1Str != null && !addyXbx1Str.isEmpty()) {

					sbF2.append(stringFullXbx + ", " + f2Pair + " / " + f2Bp);

				} else {

					sbF2.append(f2Cable + ", " + f2Pair + " / " + f2Bp);
				}

			} else if (spinnerF2Str.equals("")
					&& (f2Cable != null && !f2Cable.isEmpty())) {

				sbF2.append(f2Cable + ", " + f2Pair + " / " + f2Bp);
			}
			stringFullF2 = sbF2.toString();

			// F3 -------------------------------------
			StringBuilder sbF3 = new StringBuilder();
			if (spinnerF3Str.equals("UV") || spinnerF3Str.equals("MRB")
					|| spinnerF3Str.equals("ABB") || spinnerF3Str.equals("EDX")
					|| spinnerF3Str.equals("AHJ")
					|| spinnerF3Str.equals("AHJX")) {
				sbF3.append(spinnerF3Str + " " + f3Cable + ", " + f3Pair);
			} else if (spinnerF3Str.equals("NPG") || spinnerF3Str.equals("EPG")) {
				sbF3.append(spinnerF3Str + " " + f3Cable + ", " + f3Pair
						+ " / " + f3Bp);
			} else if (spinnerF3Str.equals("xbx")) {

				if (addyXbx1Str != null && !addyXbx1Str.isEmpty()) {
					sbF3.append(stringFullXbx + ", " + f3Pair + " / " + f3Bp);
				} else {
					sbF3.append(f3Cable + ", " + f3Pair + " / " + f3Bp);
				}

			} else if (spinnerF3Str.equals("")
					&& (f3Cable != null && !f3Cable.isEmpty())) {
				sbF3.append(f3Cable + ", " + f3Pair + " / " + f3Bp);
			}
			stringFullF3 = sbF3.toString();

			// F4 -------------------------------------
			StringBuilder sbF4 = new StringBuilder();
			if (spinnerF4Str.equals("UV") || spinnerF4Str.equals("MRB")
					|| spinnerF4Str.equals("ABB") || spinnerF4Str.equals("EDX")
					|| spinnerF4Str.equals("AHJ")
					|| spinnerF4Str.equals("AHJX")) {
				sbF4.append(spinnerF4Str + " " + f4Cable + ", " + f4Pair);
			} else if (spinnerF4Str.equals("NPG") || spinnerF4Str.equals("EPG")) {
				sbF4.append(spinnerF4Str + " " + f4Cable + ", " + f4Pair
						+ " / " + f4Bp);
			} else if (spinnerF4Str.equals("xbx")) {

				if (addyXbx1Str != null && !addyXbx1Str.isEmpty()) {
					sbF4.append(stringFullXbx + ", " + f4Pair + " / " + f4Bp);
				} else {
					sbF4.append(f4Cable + ", " + f4Pair + " / " + f4Bp);
				}

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
				StringBuilder sbF2TermBuilder = new StringBuilder();
				sbF2TermBuilder.append(addyF2Term1Str).append(" ")
						.append(spinnerF2Term2Str).append(" ")
						.append(addyF2Term3Str).append(" ")
						.append(spinnerF2Term4Str);
				stringFullF2Term = sbF2TermBuilder.toString();
			}

			// Rt Full address
			if (addyRt1Str != null && !addyRt1Str.isEmpty()) {
				StringBuilder sbRtBuilder = new StringBuilder();
				sbRtBuilder.append(addyRt1Str).append(" ")
						.append(spinnerRt2Str).append(" ").append(addyRt3Str)
						.append(" ").append(spinnerRt4Str);
				stringFullRt = sbRtBuilder.toString();
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
			// xbx address fields
			addyXbx1.setText("");
			spinnerXbx2.setSelection(0);
			addyXbx3.setText("");
			spinnerXbx4.setSelection(0);
			// F2Term address fields
			addyF2Term1.setText("");
			spinnerF2Term2.setSelection(0);
			addyF2Term3.setText("");
			spinnerF2Term4.setSelection(0);
			// RT address fields
			addyRt1.setText("");
			spinnerRt2.setSelection(0);
			addyRt3.setText("");
			spinnerRt4.setSelection(0);
			memoBox.setText("");
			// stringFullDateChecker = null;
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

	// temp Button shows last few SQlite database entries in toast
	public void viewDetails(View view) {
		String data = techhelper.getAllData();
		Message.message(this, data);
	}

	// Button to View other activity
	public void viewRecords(View view) {

		Intent i = new Intent(this, Records.class);
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
		spinnerXbx2Str = spinnerXbx2.getSelectedItem().toString();
		spinnerXbx4Str = spinnerXbx4.getSelectedItem().toString();
		spinnerF2Term2Str = spinnerF2Term2.getSelectedItem().toString();
		spinnerF2Term4Str = spinnerF2Term4.getSelectedItem().toString();
		spinnerRt2Str = spinnerRt2.getSelectedItem().toString();
		spinnerRt4Str = spinnerRt4.getSelectedItem().toString();
		spinnerTnStr = spinnerTn.getSelectedItem().toString();
		spinnerCbrStr = spinnerCbr.getSelectedItem().toString();
	}

	// Spinner implemented methods
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}
}

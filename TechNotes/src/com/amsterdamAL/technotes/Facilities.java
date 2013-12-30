package com.amsterdamAL.technotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Facilities extends Activity {

	public static TextView dateBox, addyView, orderView, nameView, cbrView, trblTnView,
			f1View, f2View, f3View, f4View, f2TermLeft, f2TermView, rtView,
			rtLeft, addyLeft, orderLeft, nameLeft, cbrLeft, trblTnLeft;
	public static EditText memoView;
	
	TechDatabaseAdapter techhelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facilities_layout);
		
		techhelper = new TechDatabaseAdapter(this);

		dateBox = (TextView) findViewById(R.id.dateBox);
		addyLeft = (TextView) findViewById(R.id.addyLeft);
		addyView = (TextView) findViewById(R.id.addyView);
		orderLeft = (TextView) findViewById(R.id.orderLeft);
		orderView = (TextView) findViewById(R.id.orderView);
		nameLeft = (TextView) findViewById(R.id.nameLeft);
		nameView = (TextView) findViewById(R.id.nameView);
		cbrLeft = (TextView) findViewById(R.id.cbrLeft);
		cbrView = (TextView) findViewById(R.id.cbrView);
		trblTnLeft = (TextView) findViewById(R.id.trblTnLeft);
		trblTnView = (TextView) findViewById(R.id.trblTnView);
		f1View = (TextView) findViewById(R.id.f1View);
		f2View = (TextView) findViewById(R.id.f2View);
		f3View = (TextView) findViewById(R.id.f3View);
		f4View = (TextView) findViewById(R.id.f4View);
		f2TermLeft = (TextView) findViewById(R.id.f2TermLeft);
		f2TermView = (TextView) findViewById(R.id.f2TermView);
		rtLeft = (TextView) findViewById(R.id.rtLeft);
		rtView = (TextView) findViewById(R.id.rtView);
		rtLeft.setText("");
		f2TermLeft.setText("");
		memoView = (EditText) findViewById(R.id.memoView);

		
		// get info from first activity
		Bundle extras = getIntent().getExtras();
		
		String date = extras.getString(Technotes.DATE);
		String jobId = extras.getString(Technotes.JOB_ID);
		String name = extras.getString(Technotes.NAME);
		String stringFullAddress = extras.getString(Technotes.ADDRESS);
		String apt = extras.getString(Technotes.APT);
		String areaCodeTn = extras.getString(Technotes.SPIN_TN);
		String tn = extras.getString(Technotes.TN);
		String areaCodeCbr = extras.getString(Technotes.SPIN_CBR);
		String cbr = extras.getString(Technotes.CBR);
		String stringFullF1 = extras.getString(Technotes.F1);
		String stringFullF2 = extras.getString(Technotes.F2);
		String stringFullF3 = extras.getString(Technotes.F3);
		String stringFullF4 = extras.getString(Technotes.F4);
		String stringFullF2Term = extras.getString(Technotes.F2TERM);
		String stringFullRt = extras.getString(Technotes.RT);
		String memo = extras.getString(Technotes.MEMO);
		
		dateBox.setText("");
		dateBox.setText(date);
		
		// Apartment field check
		if (apt != null && !apt.isEmpty()) {
			addyView.setText(stringFullAddress + " #" + apt);
		} else {
			addyView.setText(stringFullAddress);
		}

					
			orderLeft.setText("order #:");
			orderView.setText(jobId);
			nameView.setText(name);

		if (cbr != null && !cbr.isEmpty()) {
			cbrView.setText("(" + areaCodeCbr + ") " +cbr);
		} else {
			cbrView.setText("none");
		}

		if (tn != null && !tn.isEmpty()) {
			trblTnView.setText("(" + areaCodeTn + ") " + tn);
		} else {
			trblTnView.setText("none");
		}

		
			f1View.setText(stringFullF1);
			f2View.setText(stringFullF2);
			f3View.setText(stringFullF3);
			f4View.setText(stringFullF4);
		
		if (stringFullF2Term != null && !stringFullF2Term.isEmpty()){
			f2TermLeft.setText("F2 term **   ");
			f2TermView.setText(stringFullF2Term);
		}
		
		if (stringFullRt != null && !stringFullRt.isEmpty()){
			rtLeft.setText("RT Loc:   ");
			rtView.setText(stringFullRt);
		}
		
			memoView.setText(memo);
	}
	
	
	public void PrevJob(View view) {
		techhelper.goBack();
	}
	
	
	public void NextJob(View view) {
		techhelper.goNext();
	}

}

package com.omid.saman.kmeter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddCustomer extends Activity implements OnClickListener{

	private Button add_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_customer);
		
		setupAllElements();
	}

	private void setupAllElements()
	{
		setupButtons();
	}
	
	private void setupButtons()
	{
		add_button = (Button) findViewById(R.id.b_add_activity_add_customer);
		add_button.setOnClickListener(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_customer, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		EditText phone_et = (EditText) findViewById(R.id.et_phone_activity_add_customer);
		EditText gate_num_et = (EditText) findViewById(R.id.et_gate_code_activity_add_customer);
		EditText total_purchase_et = (EditText) findViewById(R.id.et_total_purchase_activity_add_customer);
		EditText tip_et = (EditText) findViewById(R.id.et_tip_activity_add_customer);
		EditText danger_et = (EditText) findViewById(R.id.et_danger_activity_add_customer);
		EditText nag_et = (EditText) findViewById(R.id.et_nag_activity_add_customer);
		EditText distance_et = (EditText) findViewById(R.id.et_distance_activity_add_customer);
		EditText name_et = (EditText) findViewById(R.id.et_name_activity_add_customer);
		EditText address_et = (EditText) findViewById(R.id.et_address_activity_add_customer);
		EditText complex_name_et = (EditText) findViewById(R.id.et_complex_name_activity_add_customer);
		
		int phone = Integer.parseInt(phone_et.getText().toString());
		int gate_num = Integer.parseInt(gate_num_et.getText().toString());
		int total_purchase = Integer.parseInt(total_purchase_et.getText().toString());
		int tip = Integer.parseInt(tip_et.getText().toString());
		int danger = Integer.parseInt(danger_et.getText().toString());
		int nag = Integer.parseInt(nag_et.getText().toString());
		int distance = Integer.parseInt(distance_et.getText().toString());
		String name = name_et.getText().toString();
		String address = address_et.getText().toString();
		String complex_name = complex_name_et.getText().toString();
		
		DatabaseHandler db = new DatabaseHandler(this);
		PersonInfo info = new PersonInfo(phone, gate_num, total_purchase, tip, danger, nag, distance, name, address, complex_name);
		db.addCustomer(info);
	}
}

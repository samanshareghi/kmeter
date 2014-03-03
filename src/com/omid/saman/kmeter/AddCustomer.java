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
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.b_add_activity_add_customer:
			String str;
			
			EditText phone_et = (EditText) findViewById(R.id.et_phone_activity_add_customer);
			str = phone_et.getText().toString();
			String phone = str;
			
			EditText zone_et = (EditText) findViewById(R.id.et_zone_activity_add_customer);
			str = zone_et.getText().toString();
			String zone = str.length() == 0 ? "N/A" : str;
			
			EditText name_et = (EditText) findViewById(R.id.et_name_activity_add_customer);
			str = name_et.getText().toString();
			String name = str.length() == 0 ? "N/A" : str;
			
			EditText address_et = (EditText) findViewById(R.id.et_address_activity_add_customer);
			str = address_et.getText().toString();
			String address = str.length() == 0 ? "N/A" : str;
			
			EditText gate_num_et = (EditText) findViewById(R.id.et_gate_code_activity_add_customer);
			str = gate_num_et.getText().toString();
			String gate_num = str.length() == 0 ? "N/A" : str;
			
			EditText complex_name_et = (EditText) findViewById(R.id.et_complex_name_activity_add_customer);
			str = complex_name_et.getText().toString();
			String complex_name = str.length() == 0 ? "N/A" : str;
			
			EditText total_purchase_et = (EditText) findViewById(R.id.et_total_purchase_activity_add_customer);
			str = total_purchase_et.getText().toString();
			float total_purchase = str.length() == 0 ? -1 :Float.parseFloat(str);
			
			EditText tip_et = (EditText) findViewById(R.id.et_tip_activity_add_customer);
			str = tip_et.getText().toString();
			float tip = str.length() == 0 ? -1 :Float.parseFloat(str);
			
			EditText nag_et = (EditText) findViewById(R.id.et_nag_activity_add_customer);
			str = nag_et.getText().toString();
			int nag = str.length() == 0 ? -1 :Integer.parseInt(str);
			
			EditText distance_et = (EditText) findViewById(R.id.et_distance_activity_add_customer);
			str = distance_et.getText().toString();
			float distance = str.length() == 0 ? -1 : Float.parseFloat(str);
			
			EditText danger_et = (EditText) findViewById(R.id.et_danger_activity_add_customer);
			str = danger_et.getText().toString();
			int danger = str.length() == 0 ? -1 :Integer.parseInt(str);
			
			DatabaseHandler db = new DatabaseHandler(this);
			PersonInfo info = new PersonInfo(phone, zone, gate_num, total_purchase, tip, danger, nag, distance, name, address, complex_name);
			db.addCustomer(info);

			break;
			
		default:
		
			break;
		}
	}
}

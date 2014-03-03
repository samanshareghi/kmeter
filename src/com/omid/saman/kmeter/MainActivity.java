package com.omid.saman.kmeter;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,
		OnTabChangeListener {
	TabHost th;
	Button go_button;
	private final String KMETERTAB = "KMeter";
	private final String INFOTAB = "Manage Activities";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupAllElements();
	}

	/*******************************************************************/
	/*******************************************************************/

	/************************* Initial Setup *****************************/
	/*******************************************************************/
	private void setupAllElements() {
		setupTabs();
		setupButtons();
	}

	/*******************************************************************/
	/*******************************************************************/

	/************************* Setup Tabs ******************************/
	/*******************************************************************/
	private void setupTabs() {
		th = (TabHost) findViewById(R.id.th_activity_main);
		th.setup();

		TabSpec specs = th.newTabSpec("Search Result");

		specs = th.newTabSpec("KMeter");
		specs.setContent(R.id.ll_tab_kmeter_activity_main);
		specs.setIndicator(KMETERTAB);

		th.addTab(specs);

		specs = th.newTabSpec("Information");
		specs.setContent(R.id.ll_tab_info_activity_main);
		specs.setIndicator(INFOTAB);

		th.addTab(specs);
		th.setOnTabChangedListener(this);
	}

	/*******************************************************************/
	/*******************************************************************/

	/************************* Setup Buttons ***************************/
	/*******************************************************************/
	private void setupButtons() {
		go_button = (Button) findViewById(R.id.b_go_activity_main);
		go_button.setOnClickListener(this);
	}
 
	/*******************************************************************/
	/*******************************************************************/

	/************************ Listeners **********************************/
	/*******************************************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Each option is its own Activity
		switch (item.getItemId()) {
		case R.id.add_customer_activity:
			Intent resultIntent = new Intent(
					"com.omid.saman.kmeter.ADDCUSTOMER");
			startActivity(resultIntent);
			break;
		}

		return false;
	}


	@Override
	public void onClick(View v) {
		// Go to database get info
		DatabaseHandler db = new DatabaseHandler(this);
		EditText phoneNumebr_et = (EditText) findViewById(R.id.et_searchbar_activity_main);
		String phoneNumber = phoneNumebr_et.getText().toString();
		LinkedList<PersonInfo> allInfo = db.getPersonInfo(Long
				.parseLong(phoneNumber));

		// display info on the screen
		displayInfo(allInfo);
	}

	private void displayInfo(LinkedList<PersonInfo> allInfo) {
		if(allInfo == null)
			return;
		String str = "", strLog = "";
		for (PersonInfo info : allInfo)
		{
			strLog = ("Phone=" + info.phone 
					+ "\n Name=" + info.name 
					+ "\n zone=" + info.zone
					+ "\n Address=" + info.address
					+ "\n Gate code=" + info.gate_num 
					+ "\n ComplexName=" + info.complex_name 
					+ "\n TotalPurchas=" + info.total_purchase
					+ "\n Tip=" + info.tip 
					+ "\n Danger=" + info.danger 
					+ "\n Nag=" + info.nag 
					+ "\n Distance=" + info.distance
					+ "\n\n******\n\n");
			str += strLog;
			Log.d("*********", strLog);
		}
		
		TextView tvResult = (TextView) findViewById(R.id.tv_result_activity_main);
		tvResult.setText(str);
	}
	
	

	@Override
	public void onTabChanged(String arg0) {

	}

}

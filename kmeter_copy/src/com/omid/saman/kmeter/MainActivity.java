package com.omid.saman.kmeter;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity implements OnClickListener, OnTabChangeListener{
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
	private void setupAllElements()
	{
		setupTabs();
		setupButtons();
	}
	/*******************************************************************/
	/*******************************************************************/

	/************************* Setup Tabs ******************************/
	/*******************************************************************/
	private void setupTabs()
	{
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
	private void setupButtons()
	{
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
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		//Go to database get info 
		DatabaseHandler db = new DatabaseHandler(this);
		EditText phoneNumebr_et = (EditText) findViewById(R.id.et_searchbar_activity_main);
		String phoneNumber = phoneNumebr_et.getText().toString();
		PersonInfo info = db.getPersonInfo(Integer.parseInt(phoneNumber));
		
		//display info on the screen
		displayInfo(info);
	}

	private void displayInfo(PersonInfo info)
	{
		
	}
	
	@Override
	public void onTabChanged(String arg0) {
		
	}

}

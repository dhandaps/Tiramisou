package com.amazon.hackday.trms;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class DisplayFeeActivity extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.display_fee);

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, DisplayFeeYouShipActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("YouShip").setIndicator("You Ship").setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, DisplayFeeAmazonShipActivity.class);
	    spec = tabHost.newTabSpec("AmazonShip").setIndicator("Amazon Ship")
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(2);
	}
}

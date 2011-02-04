package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShipMain extends Activity {
	Button button1;
    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipmain);
        
        button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent myIntent = new Intent(ShipMain.this, CameraActivity.class);
				Bundle bnd = new Bundle();
				bnd.putString("Next Page", "Shipping");
				myIntent.putExtras(bnd);
				//myIntent.putExtra("com.android.samples.SpecialValue", "Hello, Joe!"); // key/value pair, where key needs current package prefix.
				startActivity(myIntent);
			}
			
		});
    }
}
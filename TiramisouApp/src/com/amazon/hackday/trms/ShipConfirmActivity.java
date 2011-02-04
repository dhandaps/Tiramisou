package com.amazon.hackday.trms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShipConfirmActivity extends Activity {
	byte[] picture;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Bundle bnd = this.getIntent().getExtras();
		picture = bnd.getByteArray("picture");
		setContentView(R.layout.shipconfirmlayout);
		
		Button retakePicture = (Button) findViewById(R.id.retakepicture);
		retakePicture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		Button confirmShipment = (Button) findViewById(R.id.confirmshipment);
		confirmShipment.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//TODO jump back to home page
			}
		});
	}
}

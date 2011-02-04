package com.amazon.hackday.trms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class ShipConfirmActivity extends Activity {
	byte[] picture;
	Button confirmShipment;
	
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
		
		confirmShipment = (Button) findViewById(R.id.confirmshipment);
		confirmShipment.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//TODO dialog popup
				
		        AlertDialog.Builder dialog = new AlertDialog.Builder(confirmShipment.getContext());

		        dialog.setMessage("Shipment confirmed!");
		        dialog.setNeutralButton("Ok", new DialogInterface.OnClickListener() {

		        public void onClick(DialogInterface arg0, int arg1) {

		        	CameraActivity.done=true;
					finish();
		                }
		            });

		        dialog.show();
				 
				
			}
		});
	}
}

package com.amazon.hackday.trms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amazon.hackday.trms.eventHandlers.DialogFinishClickHandler;
import com.amazon.hackday.trms.eventHandlers.StartIntentClickHandler;

public class ShipConfirmActivity extends Activity {
	Button confirmShipment;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
	
		final Activity me = this;		
		Intent takePictureIntent = new Intent(me, CameraActivity.class);
		startActivity(takePictureIntent);
		
		setContentView(R.layout.shipconfirmlayout);


		View takePicture = (View) findViewById(R.id.ship_takePicture);
		takePicture.setOnClickListener(new StartIntentClickHandler(this, takePictureIntent));
				
		confirmShipment = (Button) findViewById(R.id.confirmshipment);
		confirmShipment.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
		        AlertDialog.Builder dialog = new AlertDialog.Builder(confirmShipment.getContext());
		        dialog.setMessage("Shipment confirmed!");
		        dialog.setNeutralButton("Ok", new DialogFinishClickHandler(me));
		        dialog.show();
			}
		});
	}
}

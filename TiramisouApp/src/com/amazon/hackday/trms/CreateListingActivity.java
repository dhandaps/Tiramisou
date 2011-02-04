package com.amazon.hackday.trms;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CreateListingActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_listing);
        
		Button submitButton = (Button)findViewById(R.id.submit);
		submitButton.setOnClickListener(submitClickListener);
    }
    
    OnClickListener submitClickListener = new OnClickListener() {		
		public void onClick(View view) {
			new AlertDialog.Builder(CreateListingActivity.this)
				.setTitle("amazon.com")
				.setMessage("Listing successfully created!")
				.setNeutralButton("OK",
						new DialogInterface.OnClickListener() {					
						public void onClick(DialogInterface dialog, int which) {
							Context context = ((AlertDialog) dialog).getContext();
							Intent intent = new Intent(CreateListingActivity.this, MainMenu.class);
							try {
								//Start next activity
								context.startActivity(intent);
							} catch (Exception e) {
								e.printStackTrace();
								// TODO: handle exception
							}
						}
				}).show();		
		}
	};
}


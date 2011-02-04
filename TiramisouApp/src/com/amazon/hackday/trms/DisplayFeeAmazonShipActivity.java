package com.amazon.hackday.trms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayFeeAmazonShipActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_fee_amazon_ship);
        
		// start Over button
		ImageView startover = (ImageView)findViewById(R.id.amazonshipstartOver);
		startover.setOnClickListener(startOverClickListener);
		
		// create Listings Button
		ImageView createListing = (ImageView)findViewById(R.id.amazonshipcreateListing);
		createListing.setOnClickListener(createListingClickListener);
		
		// create Listings Button
		ImageView calculate = (ImageView)findViewById(R.id.amazonshipcalculate);
		calculate.setOnClickListener(calculateClickListener);		
		
		// EditText
		EditText itemPrice = (EditText)findViewById(R.id.editItemPrice);
		itemPrice.setOnFocusChangeListener(itemPriceFocusChangeListener);
		
		itemPrice.setText("200.00");
		calculateFee();
    }
    
    private void calculateFee() {
    	EditText text = (EditText)findViewById(R.id.editItemPrice);
		String value = text.getText().toString();
		Double val = Double.parseDouble(value);
		
		TextView referralText = (TextView) findViewById(R.id.editReferralFee);
		Double rFee = 0.08 * val;
		referralText.setText("$" + rFee.toString());	
		
		TextView netAmountText = (TextView) findViewById(R.id.editNetAmount);
		Double netFee = val - rFee - 2.43;
		netAmountText.setText("$" + netFee.toString());			
    }
    
    OnClickListener calculateClickListener = new OnClickListener() {
		
		public void onClick(View view) {
			calculateFee();			
		}
	};
    
    OnClickListener startOverClickListener = new OnClickListener() {
		
		public void onClick(View view) {
			Context context = view.getContext();
			Intent intent = new Intent(DisplayFeeAmazonShipActivity.this, MainMenu.class);
			try {
				//Start next activity
				context.startActivity(intent);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	};
	
    OnFocusChangeListener itemPriceFocusChangeListener = new OnFocusChangeListener() {		
		public void onFocusChange(View view, boolean arg1) {			
			//calculateFee();
		}
	};	
	
    OnClickListener createListingClickListener = new OnClickListener() {
		
		public void onClick(View view) {
			Context context = view.getContext();
			Intent intent = new Intent(DisplayFeeAmazonShipActivity.this, CreateListingActivity.class);
			try {
				//Start next activity
				context.startActivity(intent);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	};  
	
	
}

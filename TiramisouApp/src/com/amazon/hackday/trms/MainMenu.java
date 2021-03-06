package com.amazon.hackday.trms;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amazon.hackday.trms.adapters.SellerNotificationAdapter;
import com.amazon.hackday.trms.eventHandlers.StartIntentClickHandler;
import com.amazon.hackday.trms.model.SellerNotification;
import com.amazon.hackday.trms.model.SellerNotificationFactory;
import com.amazon.hackday.trms.model.SellerNotificationType;
import com.amazon.hackday.trms.util.Sleeper;

public class MainMenu extends ListActivity {
	private static final String TAG = "MainMenuActivity"; 
	private final Executor executor = Executors.newFixedThreadPool(1);
	private SellerNotificationAdapter adapter;
	private SellerNotificationFactory factory;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.factory = new SellerNotificationFactory(getNotificationService(), this);
        this.adapter = new SellerNotificationAdapter(this, R.layout.notification_view);
        
        View shipButton = (View)findViewById(R.id.main_Ship);
        View listButton = (View)findViewById(R.id.main_List);
        Intent shipIntent = new Intent(this, ShipConfirmActivity.class);
        Intent listIntent = new Intent(this, FindAsinActivity.class);
        shipButton.setOnClickListener(new StartIntentClickHandler(this, shipIntent));
        listButton.setOnClickListener(new StartIntentClickHandler(this, listIntent));
        
        spawnNotifications();
        setListAdapter(adapter);        
    }
    
    private void spawnNotifications(){
        Runnable populateNotifications = new Runnable(){
        	public void run(){
        		runOnUiThread(new UpdateNotificationTask(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card is invalid, please update it"));
        		Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BLOCKED, "having a high defect rate"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage"));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery"));
        	}
        };
        
        executor.execute(populateNotifications);
    }
    
    private NotificationManager getNotificationService()
    {
    	return (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    }
    
    private class UpdateNotificationTask implements Runnable
    {
    	private final SellerNotificationType notificationType;
    	private final String context;
    	
    	public UpdateNotificationTask(SellerNotificationType notificationType, String context)
    	{
    		this.notificationType = notificationType;
    		this.context = context;
    	}
    	
    	public void run()
    	{
    		Log.i(TAG, "Updating Data Set!");
    		SellerNotification notification = factory.createNotification(notificationType, context);
    		adapter.insert(notification, 0);
    		adapter.notifyDataSetInvalidated();
    		adapter.notifyDataSetChanged();
    	}
    }
}
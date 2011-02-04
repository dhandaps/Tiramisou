package com.amazon.hackday.trms;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.amazon.hackday.trms.adapters.SellerNotificationAdapter;
import com.amazon.hackday.trms.model.SellerNotification;
import com.amazon.hackday.trms.model.SellerNotificationFactory;
import com.amazon.hackday.trms.model.SellerNotificationType;
import com.amazon.hackday.trms.util.Sleeper;

public class MainMenu extends ListActivity {
	private static final String TAG = "MainMenuActivity"; 
	private final Executor executor = Executors.newFixedThreadPool(1);
	private SellerNotificationAdapter adapter;
	private Intent defaultIntent;
	private SellerNotificationFactory factory;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.defaultIntent = new Intent(this, MainMenu.class);
        this.factory = new SellerNotificationFactory(getNotificationService(), this, defaultIntent);
        this.adapter = new SellerNotificationAdapter(this, R.layout.notification_view);

        spawnNotifications();
        setListAdapter(adapter);        
    }
    
    private void spawnNotifications(){
        Runnable populateNotifications = new Runnable(){
        	public void run(){
        		int i = 0;
        		runOnUiThread(new UpdateNotificationTask(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card is invalid, please update it", i++));
        		Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BLOCKED, "having a high defect rate", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage", i++));
		    	Sleeper.sleep();
		    	runOnUiThread(new UpdateNotificationTask(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery", i++));
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
    	private final int index;
    	
    	public UpdateNotificationTask(SellerNotificationType notificationType, String context, int index)
    	{
    		this.notificationType = notificationType;
    		this.context = context;
    		this.index = index;
    	}
    	
    	public void run()
    	{
    		Log.i(TAG, "Updating Data Set!");
    		SellerNotification notification = factory.createNotification(notificationType, context);
    		adapter.insert(notification, index);
    		adapter.notifyDataSetInvalidated();
    		adapter.notifyDataSetChanged();
    	}
    }
}
package com.amazon.hackday.trms;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;

import com.amazon.hackday.trms.adapters.SellerNotificationAdapter;
import com.amazon.hackday.trms.model.SellerNotification;
import com.amazon.hackday.trms.model.SellerNotificationFactory;
import com.amazon.hackday.trms.model.SellerNotificationType;
import com.google.common.collect.Lists;

public class MainMenu extends ListActivity {
	private static final String TAG = "MainMenuActivity"; 
	private final Executor executor = Executors.newFixedThreadPool(1);
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);       
        setListAdapter(createListAdapter());        
    }
    
    public ListAdapter createListAdapter(){
    	return new SellerNotificationAdapter(this, R.layout.notification_view, createNotifications());
    }
    
    private List<SellerNotification> createNotifications(){
    	final List<SellerNotification> notifications = Lists.newLinkedList();
    	final NotificationManager notificationService = getNotificationService();
    	Intent defaultIntent = new Intent(this, MainMenu.class);
    	final SellerNotificationFactory factory = new SellerNotificationFactory(notificationService, this, defaultIntent);
        Runnable populateNotifications = new Runnable(){
        	public void run(){
     	    	notifications.add(factory.createNotification(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card could not be..."));
		    	notifications.add(factory.createNotification(SellerNotificationType.BLOCKED, "having a high defect rate"));
		    	notifications.add(factory.createNotification(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2"));
		    	notifications.add(factory.createNotification(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots"));
		    	notifications.add(factory.createNotification(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood"));
		    	notifications.add(factory.createNotification(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)"));
		    	notifications.add(factory.createNotification(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32"));
		    	notifications.add(factory.createNotification(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate"));
		    	notifications.add(factory.createNotification(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage"));
		    	notifications.add(factory.createNotification(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery"));
        	}
        };
        
        Log.i(TAG, "Returning the notification list, has " + notifications.size() + "entries so far");
        executor.execute(populateNotifications);
        return notifications;
    }
    
    private NotificationManager getNotificationService()
    {
    	return (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
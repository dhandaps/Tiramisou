package com.amazon.hackday.trms;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lombok.SneakyThrows;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;

import com.amazon.hackday.trms.adapters.SellerNotificationAdapter;
import com.amazon.hackday.trms.model.SellerNotification;
import com.amazon.hackday.trms.model.SellerNotificationFactory;
import com.amazon.hackday.trms.model.SellerNotificationType;
import com.google.common.collect.Lists;

public class MainMenu extends Activity {
	private Executor executor = Executors.newFixedThreadPool(1);
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);                   
        //setListAdapter(createListAdapter());   
    }
    
    public ListAdapter createListAdapter(){
    	return new SellerNotificationAdapter(this, R.layout.notification_view, createNotifications());
    }
    
    private List<SellerNotification> createNotifications(){
    	final List<SellerNotification> notifications = Lists.newLinkedList();
        Runnable populateNotifications = new Runnable(){
        	@SneakyThrows
        	public void run(){
        		int MAX_PERIOD = 800;
		    	Random random = new Random();		    	
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card could not be..."));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.BLOCKED, "having a high defect rate"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage"));
		    	Thread.sleep(100 + random.nextInt(MAX_PERIOD));
		    	notifications.add(SellerNotificationFactory.createNotification(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery"));
        	}
        };
        executor.execute(populateNotifications);
        return notifications;
    }
}
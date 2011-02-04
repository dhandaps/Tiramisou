package com.amazon.hackday.trms.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SellerNotificationFactoryTests 
{	
	@Test
	public void createNotifications()
	{
		SellerNotificationFactory factory = new SellerNotificationFactory(null, null, null);
		assertNotNull(factory.createNotification(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card could not be..."));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.BLOCKED, "having a high defect rate"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage"));    	
    	assertNotNull(factory.createNotification(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery"));    	
	}
}

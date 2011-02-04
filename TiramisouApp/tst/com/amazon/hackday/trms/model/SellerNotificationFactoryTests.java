package com.amazon.hackday.trms.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SellerNotificationFactoryTests 
{
	public SellerNotificationFactoryTests(){}
	@Test
	public void createNotifications()
	{
		assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.AMAZON_COMMUNICATION, "Your credit card could not be..."));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.BLOCKED, "having a high defect rate"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.BUY_BOX_LOST, "Mass Effect 2"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.BUY_BOX_WON, "Mazatlanian Clay Pots"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.BUYER_COMMUNICATION, "guybrush_threepwood"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.CXM_WARNING, "Refund Rate above normal (99%)"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.DISBURSEMENT_RECEIVED, "$1500.32"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.FEEDBACK_RECEIVED, "mighty_pirate"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.ITEM_SOLD, "Dividing by Zero, A Tale of Courage"));    	
    	assertNotNull(SellerNotificationFactory.createNotification(SellerNotificationType.OUT_OF_STOCK, "iPhone replacement battery"));    	
	}
}

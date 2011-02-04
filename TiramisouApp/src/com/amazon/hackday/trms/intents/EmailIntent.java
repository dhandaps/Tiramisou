package com.amazon.hackday.trms.intents;

import android.content.Intent;

public class EmailIntent {
	private EmailIntent(){}
	
	public static Intent create(String to, String subject, String message)
	{
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, message);
		intent.setType("text/plain");
		return Intent.createChooser(intent, "Send Email");
	}
}

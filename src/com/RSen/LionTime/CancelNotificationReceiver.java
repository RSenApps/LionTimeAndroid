package com.RSen.LionTime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CancelNotificationReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		NotificationReceiver.cancelNotification(context);
	}

}

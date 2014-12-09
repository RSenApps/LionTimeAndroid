package com.RSen.LionTime;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class NewDayReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//this is because the widget must be updated when time is set, but android syncs time leading to multiple updates
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		String lastChecked = prefs.getString("lastChecked", "");
		Calendar now = Calendar.getInstance();
		String nowString = "Y" + now.get(Calendar.YEAR) + "M" + now.get(Calendar.MONTH) + "D" + now.get(Calendar.DATE);
		if (!lastChecked.equals(nowString))
		{
			CheckScheduleUpdates.checkScheduleUpdates(context);
			Schedule.cleanIrregularSchedules(context);
			prefs.edit().putString("lastChecked", nowString).commit();
			notifyIfIrregular(context);
			scheduleNextDay(context);
		}
		
		context.sendBroadcast(new Intent("com.RSen.LionTime.SHOW_NOTIFICATION"));
		context.sendBroadcast(new Intent("com.RSen.LionTime.WIDGET_UPDATE"));
		
	}

	private void notifyIfIrregular(Context context) {
		int irregularCode = Schedule.checkIrregular(context,
				Calendar.getInstance());
		if (irregularCode != -1) // regular schedule
		{
			NotificationManager notificationManager = (NotificationManager) context
					.getSystemService(Activity.NOTIFICATION_SERVICE);
			Notification notification = new Notification();
			notification.icon = R.drawable.ic_launcher;
			String scheduleString = Schedule.getReadableScheduleType(context,
					irregularCode);
			notification.tickerText = "Today is a " + scheduleString
					+ " schedule";
			notification.setLatestEventInfo(context, "Schedule Update",
					"Today is a " + scheduleString + " schedule", PendingIntent
							.getActivity(context, 36546436, new Intent(context,
									ViewScheduleActivity.class),
									Intent.FLAG_ACTIVITY_NEW_TASK));
			notificationManager.notify(154501215, notification);
		}
	}

	private void scheduleNextDay(Context context) {
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);
		PendingIntent intent = PendingIntent.getBroadcast(context, 12541656,
				new Intent("com.RSen.LionTime.NEW_DAY"), 0);
		alarmManager.cancel(intent);
		Calendar now = Calendar.getInstance();
		int minUntilEndOfDay = (24 - now.get(Calendar.HOUR_OF_DAY) - 1) * 60
				+ 60 - now.get(Calendar.MINUTE);
		int minUntilSchoolStartFromMidnight = 8 * 60 + 10 - NotificationReceiver
				.getEarliestNotification();
		long alarmTime = (minUntilEndOfDay + minUntilSchoolStartFromMidnight)
				* 60 * 1000 + System.currentTimeMillis();
		alarmManager.set(AlarmManager.RTC, alarmTime, intent);
	}
}

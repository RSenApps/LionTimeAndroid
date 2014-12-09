package com.RSen.LionTime;

import java.util.Arrays;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

public class NotificationReceiver extends BroadcastReceiver {
	private static final int[] notificationTimes = new int[] { 0, 1, 2, 3, 4,
			5, 6, 7, 10, 15, 20, 30 };
	private static final int notificationIDCancellable = 127914472;

	public NotificationReceiver() {
	}

	public static int getEarliestNotification() {
		return notificationTimes[notificationTimes.length - 1];
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(
				"notification_activated", true)) {
			String[] timeInfo = TimeTillCalculator.getTimeTill(context);

			if (Arrays.binarySearch(notificationTimes,
					Integer.parseInt(timeInfo[0])) >= 0) {
				// if found in array
				showNotification(context, timeInfo);
			} else {
				cancelNotification(context);
			}
			scheduleNext(context, Integer.parseInt(timeInfo[0]));
		}
	}

	public static void cancelNotification(Context context) {
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Activity.NOTIFICATION_SERVICE);
		notificationManager.cancel(notificationIDCancellable);
	}

	private void scheduleNext(Context context, int timeTill) {
		int minUntilNotification = 1;
		long alarmTime;
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);
		PendingIntent intent = PendingIntent.getBroadcast(context,
				notificationIDCancellable, new Intent(
						"com.RSen.LionTime.SHOW_NOTIFICATION"), 0);

		if (timeTill != -1) // after school
		{
			while (Arrays.binarySearch(notificationTimes, timeTill
					- minUntilNotification) < 0) {
				// keep incrementing until notification time is hit
				minUntilNotification++;
			}
			// Toast.makeText(context, "Notification in: " +
			// minUntilNotification, Toast.LENGTH_SHORT).show();
			int currentExtraMillis = Calendar.getInstance()
					.get(Calendar.SECOND) * 1000;
			alarmTime = System.currentTimeMillis() - currentExtraMillis + 60
					* 1000 * minUntilNotification;
			alarmManager.set(AlarmManager.RTC, alarmTime, intent);
		}
		// will be called by NewDayReceiver

	}

	@SuppressLint("NewApi")
	private void showNotification(Context context, String[] timeInfo) {
		Intent notiIntent = new Intent(context, SettingsActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(context, 0,
				notiIntent, 0);
		Notification noti;

		// Build notification
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			noti = new Notification.Builder(context)
					.setContentTitle(timeInfo[0] + " min")
					.setContentText("...until " + timeInfo[1])
					.setSmallIcon(R.drawable.ic_launcher)
					.setTicker(timeInfo[0] + " min... until " + timeInfo[1])
					.setContentIntent(pIntent).build();
			/*
			 * .addAction(R.drawable.icon, "Call", pIntent)
			 * .addAction(R.drawable.icon, "More", pIntent)
			 * .addAction(R.drawable.icon, "And more", pIntent).build();
			 */
		} else {
			noti = new Notification(R.drawable.ic_launcher, timeInfo[0]
					+ " min... until " + timeInfo[1],
					System.currentTimeMillis());
			noti.setLatestEventInfo(context, timeInfo[0] + " min", "... until "
					+ timeInfo[1], pIntent);
		}
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(context.NOTIFICATION_SERVICE);

		notificationManager.notify(notificationIDCancellable, noti);
		// schedule cancel in 30 seconds
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);

		PendingIntent intent = PendingIntent.getBroadcast(context,
				notificationIDCancellable, new Intent(
						"com.RSen.LionTime.CANCEL_NOTIFICATION"), 0);

		alarmManager.set(AlarmManager.RTC,
				System.currentTimeMillis() + 30 * 1000, intent);

	}
}

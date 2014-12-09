package com.RSen.LionTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

public class CheckScheduleUpdates {
	public static void checkScheduleUpdates(final Context context) {
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				Gson gson = new Gson();
				// calendar is jsoned seperately as string
				HashMap<String, Double> hashMap = gson.fromJson(
						(String) msg.obj,
						new HashMap<String, Double>().getClass());
				if (!hashMap.isEmpty()) {

					Set<String> set = hashMap.keySet();
					int newIrregulars = 0;
					for (String calString : set) {
						Calendar cal = gson.fromJson(calString, Calendar.class);
						// ensure user hasn't already overriden
						int scheduleCode = (int) Math.round(hashMap
								.get(calString));
						if (Schedule.checkIrregular(context, cal) != scheduleCode) {
							// json converts ints to double thus round
							Schedule.addIrregularSchedule(context, cal,
									scheduleCode);
							if (newIrregulars < 4) {
								CheckScheduleUpdates.notifyNewIrregular(
										context, cal, scheduleCode);
							}
							newIrregulars++;
						}
					}
					if (newIrregulars > 3) {
						CheckScheduleUpdates.notifyMultipleIrregulars(context,
								newIrregulars);
					}
				}

			}
		};
		new Thread(new Runnable() {

			@Override
			public void run() {
				Message msg = Message.obtain();
				msg.obj = callServerForJSON();
				if (msg.obj != "") {
					handler.sendMessage(msg);
				}
			}
		}).start();

	}

	protected static void notifyMultipleIrregulars(Context context,
			int newIrregulars) {
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Activity.NOTIFICATION_SERVICE);
		Notification notification = new Notification();
		notification.number = newIrregulars;
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = newIrregulars
				+ " irregular schedules have been added...";
		notification.setLatestEventInfo(context, "Multiple Schedule Updates",
				newIrregulars + " irregular schedules have been added...",
				PendingIntent.getActivity(context, 36546436, new Intent(
						context, ViewScheduleActivity.class),
						Intent.FLAG_ACTIVITY_NEW_TASK));
		notificationManager.cancelAll();
		notificationManager.notify(35346346, notification);

	}

	private static void notifyNewIrregular(Context context, Calendar cal,
			int scheduleCode) {
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("MM/dd");
		String dateUpdated = df.format(cal.getTime());
		String scheduleType = Schedule.getReadableScheduleType(context,
				scheduleCode);
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Activity.NOTIFICATION_SERVICE);
		Notification notification = new Notification();
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = "Schedule for " + dateUpdated
				+ " updated to " + scheduleType;
		notification.setLatestEventInfo(context, "Schedule Update",
				"Schedule for " + dateUpdated + " updated to " + scheduleType,
				PendingIntent.getActivity(context, 36546436, new Intent(
						context, ViewScheduleActivity.class),
						Intent.FLAG_ACTIVITY_NEW_TASK));
		notificationManager.notify(
				cal.get(Calendar.YEAR) + cal.get(Calendar.DATE), notification);

	}

	private static String callServerForJSON() {

		try {
			URL url = new URL("http://lion-time.appspot.com/irregular");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			return readStream(con.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String readStream(InputStream in) {
		BufferedReader reader = null;
		String returnString = "";
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			String line = "";
			while ((line = reader.readLine()) != null) {
				returnString += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return returnString;

	}

}

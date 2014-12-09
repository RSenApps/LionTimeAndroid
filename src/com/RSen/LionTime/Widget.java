package com.RSen.LionTime;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class Widget extends AppWidgetProvider {

	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		updateWidgets(context, appWidgetManager, appWidgetIds);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		ComponentName thisAppWidget = new ComponentName(
				context.getPackageName(), getClass().getName());
		AppWidgetManager appWidgetManager = AppWidgetManager
				.getInstance(context);
		int ids[] = appWidgetManager.getAppWidgetIds(thisAppWidget);
		updateWidgets(context, appWidgetManager, ids);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if (intent.getAction().equals("com.RSen.LionTime.WIDGET_UPDATE")) {
			ComponentName thisAppWidget = new ComponentName(
					context.getPackageName(), getClass().getName());
			AppWidgetManager appWidgetManager = AppWidgetManager
					.getInstance(context);
			int ids[] = appWidgetManager.getAppWidgetIds(thisAppWidget);
			updateWidgets(context, appWidgetManager, ids);

		}
	}

	private void updateWidgets(Context context,
			AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		final int N = appWidgetIds.length;
		// Perform this loop procedure for each App Widget that belongs to this
		// provider
		String[] timeInfo = TimeTillCalculator.getTimeTill(context);
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			// Create an Intent to launch ExampleActivity
			Intent intentView = new Intent(context, ViewScheduleActivity.class);
			Intent intentChange = new Intent(context,
					ChangeScheduleActivity.class);

			PendingIntent pendingIntentView = PendingIntent.getActivity(
					context, 0, intentView, 0);
			PendingIntent pendingIntentChange = PendingIntent.getActivity(
					context, 0, intentChange, 0);

			// Get the layout for the App Widget and attach an on-click listener
			// to the button
			RemoteViews views = new RemoteViews(context.getPackageName(),
					R.layout.widget_compact);
			views.setOnClickPendingIntent(R.id.viewScheduleWidget,
					pendingIntentView);
			views.setOnClickPendingIntent(R.id.changeScheduleWidget,
					pendingIntentChange);
			// To update a label
			String text;
			if (!timeInfo[0].equals("-1")) {
				text = timeInfo[0] + " min until " + timeInfo[1];
			} else {
				text = "School is Over!";
			}
			views.setTextViewText(R.id.widget1label, text);
			// Tell the AppWidgetManager to perform an update on the current app
			// widget
			appWidgetManager.updateAppWidget(appWidgetId, views);
		}
		// set alarm
		AlarmManager alarmManager = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);
		// TODO: Remove
		// Toast.makeText(context, "Updating widget...", Toast.LENGTH_SHORT)
		// .show();
		PendingIntent intent = PendingIntent.getBroadcast(context, 06566464,
				new Intent("com.RSen.LionTime.WIDGET_UPDATE"), 0);
		Calendar now = Calendar.getInstance();
		if (!timeInfo[0].equals("-1")) {
			// during school set to next minute
			alarmManager.set(AlarmManager.RTC, System.currentTimeMillis()
					+ (60 - now.get(Calendar.SECOND)) * 1000, intent);
		}
		// otherwise will be called by NEW_DAY
	}
}

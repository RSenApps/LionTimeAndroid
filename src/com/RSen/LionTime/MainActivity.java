package com.RSen.LionTime;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean isFirstRun = prefs.getBoolean("FIRSTRUN", true);
		if (isFirstRun) {
			// Code to run once
			SharedPreferences.Editor editor = prefs.edit();
			editor.putBoolean("FIRSTRUN", false);
			editor.commit();
			sendBroadcast(new Intent("com.RSen.LionTime.NEW_DAY"));
			showHelpDialog(this);
		}
		findViewById(R.id.view).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(arg0.getContext(),
						ViewScheduleActivity.class));
			}
		});
		findViewById(R.id.change).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(arg0.getContext(),
						ChangeScheduleActivity.class));
			}
		});
		findViewById(R.id.help).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				showHelpDialog(arg0.getContext());
			}
		});

		findViewById(R.id.settings).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(arg0.getContext(),
						SettingsActivity.class));
			}
		});
	}

	private static void showHelpDialog(Context context) {
		new AlertDialog.Builder(context)
				.setTitle("Add widget")
				.setMessage(
						"To add a widget, showing time until next class, please close this app, go to the homescreen."
								+ "Then long press, select widgets, then Lion Time Compact. Enjoy!")
				.setIcon(R.drawable.ic_help).show();

	}
}

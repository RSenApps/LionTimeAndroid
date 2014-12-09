package com.RSen.LionTime;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

public class ViewScheduleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Lakeside Schedule>internet
		try {
			Intent LaunchIntent = getPackageManager()
					.getLaunchIntentForPackage("com.Rsen.LSSchedule");
			startActivity(LaunchIntent);
			finish();
		} catch (Exception e) {
			openOnInternet();
		}

	}

	private void openOnInternet() {
		final EditText textEntryView = new EditText(this);
		textEntryView.setHeight(LayoutParams.WRAP_CONTENT);
		textEntryView.setWidth(LayoutParams.WRAP_CONTENT);
		textEntryView.setInputType(InputType.TYPE_CLASS_NUMBER);
		textEntryView.setEms(4);
		String studentID = PreferenceManager.getDefaultSharedPreferences(this)
				.getString("studentID", "");
		textEntryView.setText(studentID);
		new AlertDialog.Builder(this)
				.setTitle("View Schedule")
				.setMessage(
						"To view your schedule, please enter your student id...")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {

						String studentID = textEntryView.getText().toString();
						PreferenceManager
								.getDefaultSharedPreferences(
										getApplicationContext()).edit()
								.putString("studentID", studentID).commit();
						Intent browserIntent = new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("https://thesouk.lakesideschool.org/ScheduleSearch/ExtendedSchedule.aspx?SRP=1,1,"
										+ studentID + ",2"));

						startActivity(browserIntent);
						dialog.dismiss();
						ViewScheduleActivity.this.finish();
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								dialog.dismiss();
								ViewScheduleActivity.this.finish();
							}
						}).setOnCancelListener(new OnCancelListener() {

					@Override
					public void onCancel(DialogInterface dialog) {
						dialog.dismiss();
						ViewScheduleActivity.this.finish();
					}
				}).show();
	}

}

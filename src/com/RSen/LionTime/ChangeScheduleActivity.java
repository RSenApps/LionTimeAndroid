package com.RSen.LionTime;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Spinner;
import android.widget.Toast;

public class ChangeScheduleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		final View view = inflater.inflate(R.layout.change_schedule_dialog,
				null);
		final DatePicker datePicker = (DatePicker) view
				.findViewById(R.id.datePicker);
		final Spinner scheduleSpinner = (Spinner) view
				.findViewById(R.id.scheduleSpinner);
		final Calendar now = Calendar.getInstance();
		datePicker.init(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DATE), new OnDateChangedListener() {

					@Override
					public void onDateChanged(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						Calendar selectedDate = Calendar.getInstance();
						selectedDate.set(year, monthOfYear, dayOfMonth);
						scheduleSpinner.setSelection(Schedule.getScheduleType(
								view.getContext(), selectedDate));
					}
				});
		new AlertDialog.Builder(this).setTitle("Change Schedule")
				.setMessage("Select a day and the new schedule...")
				.setView(view)

				.setNegativeButton("Cancel", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						ChangeScheduleActivity.this.finish();
					}
				}).setPositiveButton("Set", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Calendar selectedDate = Calendar.getInstance();
						selectedDate.set(datePicker.getYear(),
								datePicker.getMonth(),
								datePicker.getDayOfMonth());
						int schedule = scheduleSpinner
								.getSelectedItemPosition();

						if (!showConfirmationDialog(selectedDate, schedule)) // operation
																				// successful
						{
							ChangeScheduleActivity.this.finish();
						}

					}
				}).setOnCancelListener(new OnCancelListener() {

					@Override
					public void onCancel(DialogInterface dialog) {
						ChangeScheduleActivity.this.finish();
					}
				}).show();
	}

	// returns true if operation completed
	private boolean showConfirmationDialog(final Calendar selectedDate,
			final int schedule) {
		String oldSchedule = Schedule.getReadableScheduleType(this,
				selectedDate);
		String newSchedule = Schedule.getReadableScheduleType(this, schedule);
		if (oldSchedule.equals(newSchedule)) {
			// no schedule change
			Toast.makeText(this, "Schedule already set to " + newSchedule,
					Toast.LENGTH_SHORT).show();
			return false;
		}
		String text = "Are you sure you want to switch: "
				+ (selectedDate.get(Calendar.MONTH) + 1) + "/"
				+ selectedDate.get(Calendar.DATE) + "/"
				+ selectedDate.get(Calendar.YEAR) + " from " + oldSchedule
				+ " to " + newSchedule + "?";
		new AlertDialog.Builder(this).setTitle("Change Schedule")
				.setMessage(text)
				.setPositiveButton("Yes", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Schedule.addIrregularSchedule(
								ChangeScheduleActivity.this, selectedDate,
								schedule);
						sendBroadcast(new Intent("com.RSen.LionTime.NEW_DAY"));
						ChangeScheduleActivity.this.finish();
					}
				}).setNegativeButton("Cancel", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).setOnCancelListener(new OnCancelListener() {

					@Override
					public void onCancel(DialogInterface dialog) {
						ChangeScheduleActivity.this.finish();
					}
				}).show();
		return true;
	}

}

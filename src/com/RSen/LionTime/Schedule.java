package com.RSen.LionTime;

import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import android.content.Context;
import android.widget.Toast;

public class Schedule {
	// private static HashMap<Calendar, Integer> irregularSchedules = new
	// HashMap<Calendar, Integer>();
	private static final String FILENAME = "irregular_schedules";
	public static final int TYPE_REGULAR = 0;
	public static final int TYPE_WED = 1;
	public static final int TYPE_THU = 2;
	public static final int TYPE_B = 3;
	public static final int TYPE_NOSCHOOL = 4;

	public static String getReadableScheduleType(Context context, Calendar cal) {
		int scheduleType = getScheduleType(context, cal);
		String[] schedules = context.getResources().getStringArray(
				R.array.Schedules);
		return schedules[scheduleType];
	}

	// deletes all irregular schedules before today to free up space
	public static void cleanIrregularSchedules(Context context) {
		HashMap<Calendar, Integer> irregularSchedules = readIrregularsFromFile(context);
		Set<Calendar> dates = irregularSchedules.keySet();
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, -1);
		for (Calendar date : dates) {
			if (now.after(date)) {
				irregularSchedules.remove(date);
			}
		}
		writeIrregularsToFile(context, irregularSchedules);
	}

	public static String getReadableScheduleType(Context context,
			int scheduleType) {
		String[] schedules = context.getResources().getStringArray(
				R.array.Schedules);
		return schedules[scheduleType];
	}

	private static int getRegularScheduleType(Calendar cal) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.WEDNESDAY) // wednesday
		{
			return TYPE_WED;
		} else if (dayOfWeek == Calendar.THURSDAY) // Thursday
		{
			return TYPE_THU;
		} else if (dayOfWeek == Calendar.SATURDAY
				|| dayOfWeek == Calendar.SUNDAY) {
			return TYPE_NOSCHOOL;
		} else {
			return TYPE_REGULAR;
		}
	}

	public static int getScheduleType(Context context, Calendar cal) {
		int irregularCode = checkIrregular(context, cal);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (irregularCode != -1) {
			return irregularCode;
		} else if (dayOfWeek == Calendar.WEDNESDAY) // wednesday
		{
			return TYPE_WED;
		} else if (dayOfWeek == Calendar.THURSDAY) // Thursday
		{
			return TYPE_THU;
		} else if (dayOfWeek == Calendar.SATURDAY
				|| dayOfWeek == Calendar.SUNDAY) {
			return TYPE_NOSCHOOL;
		} else {
			return TYPE_REGULAR;
		}
	}

	public static void addIrregularSchedule(Context context, Calendar cal,
			int scheduleType) {
		HashMap<Calendar, Integer> irregularSchedules = readIrregularsFromFile(context);
		Calendar calSimple = Calendar.getInstance();
		calSimple.clear();
		calSimple.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DATE));
		// check if normal
		if (getRegularScheduleType(cal) != scheduleType) {
			irregularSchedules.put(calSimple, scheduleType);

		} else {
			irregularSchedules.remove(calSimple);
		}
		writeIrregularsToFile(context, irregularSchedules);

	}

	public static int checkIrregular(Context context, Calendar cal) {
		try {

			// if file not found then catch returns -1
			HashMap<Calendar, Integer> irregularSchedules = readIrregularsFromFile(context);
			Calendar calSimple = Calendar.getInstance();
			calSimple.clear();
			calSimple.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
					cal.get(Calendar.DATE));
			Object scheduleCode = irregularSchedules.get(calSimple);
			if (scheduleCode != null) {
				return (Integer) scheduleCode;

			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}

	}

	private static HashMap<Calendar, Integer> readIrregularsFromFile(
			Context context) {
		try {
			ObjectInputStream fis = new ObjectInputStream(
					context.openFileInput(FILENAME));

			Object input = fis.readObject();
			fis.close();
			return (HashMap<Calendar, Integer>) input;
		} catch (Exception e) {
			return new HashMap<Calendar, Integer>();
		}

	}

	private static void writeIrregularsToFile(Context context,
			HashMap<Calendar, Integer> irregulars) {
		try {
			java.io.ObjectOutputStream stream = new java.io.ObjectOutputStream(
					context.openFileOutput("irregular_schedules",
							android.app.Activity.MODE_PRIVATE));
			stream.writeObject(irregulars);
			stream.close();
		} catch (Exception e) {
			Toast.makeText(
					context,
					"Add irregular schedule operation failed, please try again...",
					Toast.LENGTH_SHORT).show();
		}

	}

	public static int[] getScheduleTimes(Context context) {
		Calendar now = Calendar.getInstance();
		int[] schedule;
		int irregularCode = checkIrregular(context, now);
		if (irregularCode == TYPE_B) {
			return new int[] { 490, 540, 590, 640, 690, 740, 790, 810, 860, 905 };
		} else if ((now.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY && irregularCode == -1)
				|| irregularCode == TYPE_WED) // wednesday
		{
			schedule = new int[] { 490, 575, 655, 735, 775, 830, 905 };
		} else if ((now.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY && irregularCode == -1)
				|| irregularCode == TYPE_THU) // Thursday
		{
			schedule = new int[] { 490, 575, 655, 735, 775, 855, 905 };
		} else {
			schedule = new int[] { 490, 540, 605, 655, 705, 755, 805, 855, 900 };
		}
		return schedule;

	}
}

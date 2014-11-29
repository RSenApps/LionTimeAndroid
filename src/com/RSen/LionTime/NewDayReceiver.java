// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            Schedule, ViewScheduleActivity, NotificationReceiver, CheckScheduleUpdates

public class NewDayReceiver extends BroadcastReceiver
{

    public NewDayReceiver()
    {
    }

    private void notifyIfIrregular(Context context)
    {
        int i = Schedule.checkIrregular(context, Calendar.getInstance());
        if (i != -1)
        {
            NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
            Notification notification = new Notification();
            notification.icon = 0x7f020004;
            String s = Schedule.getReadableScheduleType(context, i);
            notification.tickerText = (new StringBuilder("Today is a ")).append(s).append(" schedule").toString();
            notification.setLatestEventInfo(context, "Schedule Update", (new StringBuilder("Today is a ")).append(s).append(" schedule").toString(), PendingIntent.getActivity(context, 0x22da784, new Intent(context, com/RSen/LionTime/ViewScheduleActivity), 0x10000000));
            notificationmanager.notify(0x935805f, notification);
        }
    }

    private void scheduleNextDay(Context context)
    {
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0xbf5ed8, new Intent("com.RSen.LionTime.NEW_DAY"), 0);
        alarmmanager.cancel(pendingintent);
        Calendar calendar = Calendar.getInstance();
        alarmmanager.set(1, (long)(1000 * (60 * (((60 + 60 * (-1 + (24 - calendar.get(11)))) - calendar.get(12)) + (490 - NotificationReceiver.getEarliestNotification())))) + System.currentTimeMillis(), pendingintent);
    }

    public void onReceive(Context context, Intent intent)
    {
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String s = sharedpreferences.getString("lastChecked", "");
        Calendar calendar = Calendar.getInstance();
        String s1 = (new StringBuilder("Y")).append(calendar.get(1)).append("M").append(calendar.get(2)).append("D").append(calendar.get(5)).toString();
        if (!s.equals(s1))
        {
            CheckScheduleUpdates.checkScheduleUpdates(context);
            Schedule.cleanIrregularSchedules(context);
            sharedpreferences.edit().putString("lastChecked", s1).commit();
            notifyIfIrregular(context);
            scheduleNextDay(context);
        }
        context.sendBroadcast(new Intent("com.RSen.LionTime.SHOW_NOTIFICATION"));
        context.sendBroadcast(new Intent("com.RSen.LionTime.WIDGET_UPDATE"));
    }
}

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
import java.util.Arrays;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            SettingsActivity, TimeTillCalculator

public class NotificationReceiver extends BroadcastReceiver
{

    private static final int notificationTimes[];

    public NotificationReceiver()
    {
    }

    public static void cancelNotification(Context context)
    {
        ((NotificationManager)context.getSystemService("notification")).cancel(0x79fd1e8);
    }

    public static int getEarliestNotification()
    {
        return notificationTimes[-1 + notificationTimes.length];
    }

    private void scheduleNext(Context context, int i)
    {
        int j;
        AlarmManager alarmmanager;
        PendingIntent pendingintent;
        j = 1;
        alarmmanager = (AlarmManager)context.getSystemService("alarm");
        pendingintent = PendingIntent.getBroadcast(context, 0x79fd1e8, new Intent("com.RSen.LionTime.SHOW_NOTIFICATION"), 0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        if (Arrays.binarySearch(notificationTimes, i - j) < 0) goto _L4; else goto _L3
_L3:
        int k = 1000 * Calendar.getInstance().get(13);
        alarmmanager.set(1, (System.currentTimeMillis() - (long)k) + (long)(60000 * j), pendingintent);
_L2:
        return;
_L4:
        j++;
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void showNotification(Context context, String as[])
    {
        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, new Intent(context, com/RSen/LionTime/SettingsActivity), 0);
        Notification notification;
        AlarmManager alarmmanager;
        PendingIntent pendingintent1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            notification = (new android.app.Notification.Builder(context)).setContentTitle((new StringBuilder(String.valueOf(as[0]))).append(" min").toString()).setContentText((new StringBuilder("...until ")).append(as[1]).toString()).setSmallIcon(0x7f020004).setTicker((new StringBuilder(String.valueOf(as[0]))).append(" min... until ").append(as[1]).toString()).setContentIntent(pendingintent).build();
        } else
        {
            notification = new Notification(0x7f020004, (new StringBuilder(String.valueOf(as[0]))).append(" min... until ").append(as[1]).toString(), System.currentTimeMillis());
            notification.setLatestEventInfo(context, (new StringBuilder(String.valueOf(as[0]))).append(" min").toString(), (new StringBuilder("... until ")).append(as[1]).toString(), pendingintent);
        }
        ((NotificationManager)context.getSystemService("notification")).notify(0x79fd1e8, notification);
        alarmmanager = (AlarmManager)context.getSystemService("alarm");
        pendingintent1 = PendingIntent.getBroadcast(context, 0x79fd1e8, new Intent("com.RSen.LionTime.CANCEL_NOTIFICATION"), 0);
        alarmmanager.set(1, 30000L + System.currentTimeMillis(), pendingintent1);
    }

    public void onReceive(Context context, Intent intent)
    {
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("notification_activated", true))
        {
            String as[] = TimeTillCalculator.getTimeTill(context);
            if (Arrays.binarySearch(notificationTimes, Integer.parseInt(as[0])) >= 0)
            {
                showNotification(context, as);
            } else
            {
                cancelNotification(context);
            }
            scheduleNext(context, Integer.parseInt(as[0]));
        }
    }

    static 
    {
        int ai[] = new int[12];
        ai[1] = 1;
        ai[2] = 2;
        ai[3] = 3;
        ai[4] = 4;
        ai[5] = 5;
        ai[6] = 6;
        ai[7] = 7;
        ai[8] = 10;
        ai[9] = 15;
        ai[10] = 20;
        ai[11] = 30;
        notificationTimes = ai;
    }
}

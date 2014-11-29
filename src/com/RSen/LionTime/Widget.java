// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            TimeTillCalculator, ViewScheduleActivity, ChangeScheduleActivity

public class Widget extends AppWidgetProvider
{

    public Widget()
    {
    }

    private void updateWidgets(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        int i = ai.length;
        String as[] = TimeTillCalculator.getTimeTill(context);
        int j = 0;
        do
        {
            if (j >= i)
            {
                AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
                PendingIntent pendingintent2 = PendingIntent.getBroadcast(context, 0x1aed34, new Intent("com.RSen.LionTime.WIDGET_UPDATE"), 0);
                Calendar calendar = Calendar.getInstance();
                if (!as[0].equals("-1"))
                {
                    alarmmanager.set(1, System.currentTimeMillis() + (long)(1000 * (60 - calendar.get(13))), pendingintent2);
                }
                return;
            }
            int k = ai[j];
            Intent intent = new Intent(context, com/RSen/LionTime/ViewScheduleActivity);
            Intent intent1 = new Intent(context, com/RSen/LionTime/ChangeScheduleActivity);
            PendingIntent pendingintent = PendingIntent.getActivity(context, 0, intent, 0);
            PendingIntent pendingintent1 = PendingIntent.getActivity(context, 0, intent1, 0);
            RemoteViews remoteviews = new RemoteViews(context.getPackageName(), 0x7f030002);
            remoteviews.setOnClickPendingIntent(0x7f090007, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f090008, pendingintent1);
            String s;
            if (!as[0].equals("-1"))
            {
                s = (new StringBuilder(String.valueOf(as[0]))).append(" min until ").append(as[1]).toString();
            } else
            {
                s = "School is Over!";
            }
            remoteviews.setTextViewText(0x7f090006, s);
            appwidgetmanager.updateAppWidget(k, remoteviews);
            j++;
        } while (true);
    }

    public void onEnabled(Context context)
    {
        super.onEnabled(context);
        ComponentName componentname = new ComponentName(context.getPackageName(), getClass().getName());
        AppWidgetManager appwidgetmanager = AppWidgetManager.getInstance(context);
        updateWidgets(context, appwidgetmanager, appwidgetmanager.getAppWidgetIds(componentname));
    }

    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
        if (intent.getAction().equals("com.RSen.LionTime.WIDGET_UPDATE"))
        {
            ComponentName componentname = new ComponentName(context.getPackageName(), getClass().getName());
            AppWidgetManager appwidgetmanager = AppWidgetManager.getInstance(context);
            updateWidgets(context, appwidgetmanager, appwidgetmanager.getAppWidgetIds(componentname));
        }
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        updateWidgets(context, appwidgetmanager, ai);
    }
}

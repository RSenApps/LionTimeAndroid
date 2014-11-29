// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.RSen.LionTime:
//            ViewScheduleActivity, Schedule

public class CheckScheduleUpdates
{

    private static String callServerForJSON()
    {
        String s;
        try
        {
            s = readStream(((HttpURLConnection)(new URL("http://lion-time.appspot.com/irregular")).openConnection()).getInputStream());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return "";
        }
        return s;
    }

    public static void checkScheduleUpdates(final Context context)
    {
        (new Thread(new Runnable() {

            private final Handler val$handler;

            public void run()
            {
                Message message = Message.obtain();
                message.obj = CheckScheduleUpdates.callServerForJSON();
                if (message.obj != "")
                {
                    handler.sendMessage(message);
                }
            }

            
            {
                handler = handler1;
                super();
            }
        })).start();
    }

    protected static void notifyMultipleIrregulars(Context context, int i)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Notification notification = new Notification();
        notification.number = i;
        notification.icon = 0x7f020004;
        notification.tickerText = (new StringBuilder(String.valueOf(i))).append(" irregular schedules have been added...").toString();
        notification.setLatestEventInfo(context, "Multiple Schedule Updates", (new StringBuilder(String.valueOf(i))).append(" irregular schedules have been added...").toString(), PendingIntent.getActivity(context, 0x22da784, new Intent(context, com/RSen/LionTime/ViewScheduleActivity), 0x10000000));
        notificationmanager.cancelAll();
        notificationmanager.notify(0x21b57aa, notification);
    }

    private static void notifyNewIrregular(Context context, Calendar calendar, int i)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        simpledateformat.applyPattern("MM/dd");
        String s = simpledateformat.format(calendar.getTime());
        String s1 = Schedule.getReadableScheduleType(context, i);
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        Notification notification = new Notification();
        notification.icon = 0x7f020004;
        notification.tickerText = (new StringBuilder("Schedule for ")).append(s).append(" updated to ").append(s1).toString();
        notification.setLatestEventInfo(context, "Schedule Update", (new StringBuilder("Schedule for ")).append(s).append(" updated to ").append(s1).toString(), PendingIntent.getActivity(context, 0x22da784, new Intent(context, com/RSen/LionTime/ViewScheduleActivity), 0x10000000));
        notificationmanager.notify(calendar.get(1) + calendar.get(5), notification);
    }

    private static String readStream(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        String s;
        bufferedreader = null;
        s = "";
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(inputstream));
_L5:
        String s1 = bufferedreader1.readLine();
        if (s1 != null) goto _L2; else goto _L1
_L1:
        if (bufferedreader1 == null) goto _L4; else goto _L3
_L3:
        bufferedreader1.close();
_L7:
        return s;
_L2:
        String s2 = (new StringBuilder(String.valueOf(s))).append(s1).toString();
        s = s2;
          goto _L5
        IOException ioexception;
        ioexception;
_L10:
        ioexception.printStackTrace();
        if (bufferedreader == null) goto _L7; else goto _L6
_L6:
        try
        {
            bufferedreader.close();
        }
        catch (IOException ioexception2)
        {
            ioexception2.printStackTrace();
            return s;
        }
        return s;
        Exception exception;
        exception;
_L9:
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }
        throw exception;
        IOException ioexception3;
        ioexception3;
        ioexception3.printStackTrace();
_L4:
        return s;
        exception;
        bufferedreader = bufferedreader1;
        if (true) goto _L9; else goto _L8
_L8:
        ioexception;
        bufferedreader = bufferedreader1;
          goto _L10
    }



    // Unreferenced inner class com/RSen/LionTime/CheckScheduleUpdates$1

/* anonymous class */
    class _cls1 extends Handler
    {

        private final Context val$context;

        public void handleMessage(Message message)
        {
            Gson gson;
            HashMap hashmap;
            gson = new Gson();
            hashmap = (HashMap)gson.fromJson((String)message.obj, (new HashMap()).getClass());
            if (hashmap.isEmpty()) goto _L2; else goto _L1
_L1:
            int i;
            Iterator iterator;
            Set set = hashmap.keySet();
            i = 0;
            iterator = set.iterator();
_L6:
            if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
            if (i > 3)
            {
                CheckScheduleUpdates.notifyMultipleIrregulars(context, i);
            }
_L2:
            return;
_L4:
            String s = (String)iterator.next();
            Calendar calendar = (Calendar)gson.fromJson(s, java/util/Calendar);
            int j = (int)Math.round(((Double)hashmap.get(s)).doubleValue());
            if (Schedule.checkIrregular(context, calendar) != j)
            {
                Schedule.addIrregularSchedule(context, calendar, j);
                if (i < 4)
                {
                    CheckScheduleUpdates.notifyNewIrregular(context, calendar, j);
                }
                i++;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                context = context1;
                super();
            }
    }

}

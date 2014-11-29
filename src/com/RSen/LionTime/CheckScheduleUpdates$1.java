// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.RSen.LionTime:
//            CheckScheduleUpdates, Schedule

class val.context extends Handler
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
            CheckScheduleUpdates.notifyMultipleIrregulars(val$context, i);
        }
_L2:
        return;
_L4:
        String s = (String)iterator.next();
        Calendar calendar = (Calendar)gson.fromJson(s, java/util/Calendar);
        int j = (int)Math.round(((Double)hashmap.get(s)).doubleValue());
        if (Schedule.checkIrregular(val$context, calendar) != j)
        {
            Schedule.addIrregularSchedule(val$context, calendar, j);
            if (i < 4)
            {
                CheckScheduleUpdates.access$0(val$context, calendar, j);
            }
            i++;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        val$context = context1;
        super();
    }
}

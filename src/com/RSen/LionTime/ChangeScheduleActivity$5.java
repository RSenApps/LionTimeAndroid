// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.DialogInterface;
import android.content.Intent;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            ChangeScheduleActivity, Schedule

class val.schedule
    implements android.content.stener
{

    final ChangeScheduleActivity this$0;
    private final int val$schedule;
    private final Calendar val$selectedDate;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Schedule.addIrregularSchedule(ChangeScheduleActivity.this, val$selectedDate, val$schedule);
        sendBroadcast(new Intent("com.RSen.LionTime.NEW_DAY"));
        finish();
    }

    ener()
    {
        this$0 = final_changescheduleactivity;
        val$selectedDate = calendar;
        val$schedule = I.this;
        super();
    }
}

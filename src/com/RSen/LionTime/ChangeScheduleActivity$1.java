// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.widget.DatePicker;
import android.widget.Spinner;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            ChangeScheduleActivity, Schedule

class val.scheduleSpinner
    implements android.widget.istener
{

    final ChangeScheduleActivity this$0;
    private final Spinner val$scheduleSpinner;

    public void onDateChanged(DatePicker datepicker, int i, int j, int k)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, j, k);
        val$scheduleSpinner.setSelection(Schedule.getScheduleType(datepicker.getContext(), calendar));
    }

    ener()
    {
        this$0 = final_changescheduleactivity;
        val$scheduleSpinner = Spinner.this;
        super();
    }
}

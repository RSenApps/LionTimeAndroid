// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.Spinner;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            ChangeScheduleActivity

class val.scheduleSpinner
    implements android.content.stener
{

    final ChangeScheduleActivity this$0;
    private final DatePicker val$datePicker;
    private final Spinner val$scheduleSpinner;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(val$datePicker.getYear(), val$datePicker.getMonth(), val$datePicker.getDayOfMonth());
        int j = val$scheduleSpinner.getSelectedItemPosition();
        if (!ChangeScheduleActivity.access$0(ChangeScheduleActivity.this, calendar, j))
        {
            finish();
        }
    }

    ener()
    {
        this$0 = final_changescheduleactivity;
        val$datePicker = datepicker;
        val$scheduleSpinner = Spinner.this;
        super();
    }
}

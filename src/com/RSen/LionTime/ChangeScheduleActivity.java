// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            Schedule

public class ChangeScheduleActivity extends Activity
{

    public ChangeScheduleActivity()
    {
    }

    private boolean showConfirmationDialog(final Calendar selectedDate, final int schedule)
    {
        String s = Schedule.getReadableScheduleType(this, selectedDate);
        String s1 = Schedule.getReadableScheduleType(this, schedule);
        if (s.equals(s1))
        {
            Toast.makeText(this, (new StringBuilder("Schedule already set to ")).append(s1).toString(), 0).show();
            return false;
        } else
        {
            String s2 = (new StringBuilder("Are you sure you want to switch: ")).append(1 + selectedDate.get(2)).append("/").append(selectedDate.get(5)).append("/").append(selectedDate.get(1)).append(" from ").append(s).append(" to ").append(s1).append("?").toString();
            (new android.app.AlertDialog.Builder(this)).setTitle("Change Schedule").setMessage(s2).setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener() {

                final ChangeScheduleActivity this$0;
                private final int val$schedule;
                private final Calendar val$selectedDate;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Schedule.addIrregularSchedule(ChangeScheduleActivity.this, selectedDate, schedule);
                    sendBroadcast(new Intent("com.RSen.LionTime.NEW_DAY"));
                    finish();
                }

            
            {
                this$0 = ChangeScheduleActivity.this;
                selectedDate = calendar;
                schedule = i;
                super();
            }
            }).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

                final ChangeScheduleActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.cancel();
                }

            
            {
                this$0 = ChangeScheduleActivity.this;
                super();
            }
            }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final ChangeScheduleActivity this$0;

                public void onCancel(DialogInterface dialoginterface)
                {
                    finish();
                }

            
            {
                this$0 = ChangeScheduleActivity.this;
                super();
            }
            }).show();
            return true;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030001, null);
        final DatePicker datePicker = (DatePicker)view.findViewById(0x7f090004);
        final Spinner scheduleSpinner = (Spinner)view.findViewById(0x7f090005);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(1), calendar.get(2), calendar.get(5), new android.widget.DatePicker.OnDateChangedListener() {

            final ChangeScheduleActivity this$0;
            private final Spinner val$scheduleSpinner;

            public void onDateChanged(DatePicker datepicker, int i, int j, int k)
            {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(i, j, k);
                scheduleSpinner.setSelection(Schedule.getScheduleType(datepicker.getContext(), calendar1));
            }

            
            {
                this$0 = ChangeScheduleActivity.this;
                scheduleSpinner = spinner;
                super();
            }
        });
        (new android.app.AlertDialog.Builder(this)).setTitle("Change Schedule").setMessage("Select a day and the new schedule...").setView(view).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final ChangeScheduleActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                finish();
            }

            
            {
                this$0 = ChangeScheduleActivity.this;
                super();
            }
        }).setPositiveButton("Set", new android.content.DialogInterface.OnClickListener() {

            final ChangeScheduleActivity this$0;
            private final DatePicker val$datePicker;
            private final Spinner val$scheduleSpinner;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                int j = scheduleSpinner.getSelectedItemPosition();
                if (!showConfirmationDialog(calendar1, j))
                {
                    finish();
                }
            }

            
            {
                this$0 = ChangeScheduleActivity.this;
                datePicker = datepicker;
                scheduleSpinner = spinner;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ChangeScheduleActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                finish();
            }

            
            {
                this$0 = ChangeScheduleActivity.this;
                super();
            }
        }).show();
    }

}

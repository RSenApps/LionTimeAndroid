// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.widget.EditText;

// Referenced classes of package com.RSen.LionTime:
//            ViewScheduleActivity

class val.textEntryView
    implements android.content.Listener
{

    final ViewScheduleActivity this$0;
    private final EditText val$textEntryView;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = val$textEntryView.getText().toString();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("studentID", s).commit();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://thesouk.lakesideschool.org/ScheduleSearch/ExtendedSchedule.aspx?SRP=1,1,")).append(s).append(",2").toString()));
        startActivity(intent);
        dialoginterface.dismiss();
        finish();
    }

    stener()
    {
        this$0 = final_viewscheduleactivity;
        val$textEntryView = EditText.this;
        super();
    }
}

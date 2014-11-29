// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.widget.EditText;

public class ViewScheduleActivity extends Activity
{

    public ViewScheduleActivity()
    {
    }

    private void openOnInternet()
    {
        final EditText textEntryView = new EditText(this);
        textEntryView.setHeight(-2);
        textEntryView.setWidth(-2);
        textEntryView.setInputType(2);
        textEntryView.setEms(4);
        textEntryView.setText(PreferenceManager.getDefaultSharedPreferences(this).getString("studentID", ""));
        (new android.app.AlertDialog.Builder(this)).setTitle("View Schedule").setMessage("To view your schedule, please enter your student id...").setView(textEntryView).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final ViewScheduleActivity this$0;
            private final EditText val$textEntryView;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                String s = textEntryView.getText().toString();
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("studentID", s).commit();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://thesouk.lakesideschool.org/ScheduleSearch/ExtendedSchedule.aspx?SRP=1,1,")).append(s).append(",2").toString()));
                startActivity(intent);
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = ViewScheduleActivity.this;
                textEntryView = edittext;
                super();
            }
        }).setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final ViewScheduleActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = ViewScheduleActivity.this;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final ViewScheduleActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
                finish();
            }

            
            {
                this$0 = ViewScheduleActivity.this;
                super();
            }
        }).show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            startActivity(getPackageManager().getLaunchIntentForPackage("com.Rsen.LSSchedule"));
            finish();
            return;
        }
        catch (Exception exception)
        {
            openOnInternet();
        }
    }
}

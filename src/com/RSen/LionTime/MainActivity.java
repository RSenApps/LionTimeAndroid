// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

// Referenced classes of package com.RSen.LionTime:
//            ViewScheduleActivity, ChangeScheduleActivity, SettingsActivity

public class MainActivity extends Activity
{

    public MainActivity()
    {
    }

    private static void showHelpDialog(Context context)
    {
        (new android.app.AlertDialog.Builder(context)).setTitle("Add widget").setMessage("To add a widget, showing time until next class, please close this app, go to the homescreen.Then long press, select widgets, then Lion Time Compact. Enjoy!").setIcon(0x7f020003).show();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedpreferences.getBoolean("FIRSTRUN", true))
        {
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
            sendBroadcast(new Intent("com.RSen.LionTime.NEW_DAY"));
            showHelpDialog(this);
        }
        findViewById(0x7f090000).setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(view.getContext(), com/RSen/LionTime/ViewScheduleActivity));
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        findViewById(0x7f090001).setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(view.getContext(), com/RSen/LionTime/ChangeScheduleActivity));
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        findViewById(0x7f090002).setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                MainActivity.showHelpDialog(view.getContext());
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        findViewById(0x7f090003).setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(view.getContext(), com/RSen/LionTime/SettingsActivity));
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
    }

}

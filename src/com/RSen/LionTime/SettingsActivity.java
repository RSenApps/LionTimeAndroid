// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity
{

    private static android.preference.Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new android.preference.Preference.OnPreferenceChangeListener() {

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            preference.setSummary(obj.toString());
            if (((Boolean)obj).booleanValue())
            {
                preference.getContext().sendBroadcast(new Intent("com.RSen.LionTime.SHOW_NOTIFICATION"));
            } else
            {
                preference.getContext().sendBroadcast(new Intent("com.RSen.LionTime.CANCEL_NOTIFICATION"));
            }
            return true;
        }

    };

    public SettingsActivity()
    {
    }

    private static void bindPreferenceSummaryToValue(Preference preference)
    {
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference, Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getBoolean(preference.getKey(), true)));
    }

    private void setupSimplePreferencesScreen()
    {
        addPreferencesFromResource(0x7f040000);
        bindPreferenceSummaryToValue(findPreference("notification_activated"));
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        setupSimplePreferencesScreen();
    }

}

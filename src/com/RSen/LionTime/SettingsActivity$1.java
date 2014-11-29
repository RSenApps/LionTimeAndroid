// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;

// Referenced classes of package com.RSen.LionTime:
//            SettingsActivity

class renceChangeListener
    implements android.preference.enceChangeListener
{

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

    renceChangeListener()
    {
    }
}

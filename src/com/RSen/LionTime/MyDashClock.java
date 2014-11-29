// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Intent;
import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

// Referenced classes of package com.RSen.LionTime:
//            TimeTillCalculator, ViewScheduleActivity

public class MyDashClock extends DashClockExtension
{

    public MyDashClock()
    {
    }

    protected void onInitialize(boolean flag)
    {
        super.onInitialize(flag);
        setUpdateWhenScreenOn(true);
    }

    protected void onUpdateData(int i)
    {
        String as[] = TimeTillCalculator.getTimeTill(this);
        if (!as[0].equals("-1"))
        {
            String s = (new StringBuilder(String.valueOf(as[0]))).append(" min until ").append(as[1]).toString();
            publishUpdate((new ExtensionData()).visible(true).icon(0x7f020002).status(s).expandedTitle(s).expandedBody("Click to view schedule...").clickIntent(new Intent(this, com/RSen/LionTime/ViewScheduleActivity)));
            return;
        } else
        {
            publishUpdate(null);
            return;
        }
    }
}

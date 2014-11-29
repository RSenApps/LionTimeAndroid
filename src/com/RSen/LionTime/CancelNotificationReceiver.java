// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.RSen.LionTime:
//            NotificationReceiver

public class CancelNotificationReceiver extends BroadcastReceiver
{

    public CancelNotificationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        NotificationReceiver.cancelNotification(context);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.RSen.LionTime:
//            CheckScheduleUpdates

class val.handler
    implements Runnable
{

    private final Handler val$handler;

    public void run()
    {
        Message message = Message.obtain();
        message.obj = CheckScheduleUpdates.access$1();
        if (message.obj != "")
        {
            val$handler.sendMessage(message);
        }
    }

    ()
    {
        val$handler = handler1;
        super();
    }
}

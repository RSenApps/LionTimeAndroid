// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.apps.dashclock.api.internal.IExtensionHost;

// Referenced classes of package com.google.android.apps.dashclock.api:
//            DashClockExtension

class tub extends com.google.android.apps.dashclock.api.internal.>
{

    final DashClockExtension this$0;

    public void onInitialize(IExtensionHost iextensionhost, boolean flag)
        throws RemoteException
    {
        if (checkCallingOrSelfPermission("com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA") != 0)
        {
            throw new SecurityException("Caller does not have the READ_EXTENSION_DATA permission.");
        }
        DashClockExtension.access$002(DashClockExtension.this, iextensionhost);
        if (!DashClockExtension.access$100(DashClockExtension.this))
        {
            DashClockExtension.this.onInitialize(flag);
            DashClockExtension.access$102(DashClockExtension.this, true);
        }
    }

    public void onUpdate(final int reason)
        throws RemoteException
    {
        if (checkCallingOrSelfPermission("com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA") != 0)
        {
            throw new SecurityException("Caller does not have the READ_EXTENSION_DATA permission.");
        }
        if (!DashClockExtension.access$100(DashClockExtension.this))
        {
            return;
        } else
        {
            DashClockExtension.access$200(DashClockExtension.this).post(new Runnable() {

                final DashClockExtension._cls1 this$1;
                final int val$reason;

                public void run()
                {
                    onUpdateData(reason);
                }

            
            {
                this$1 = DashClockExtension._cls1.this;
                reason = i;
                super();
            }
            });
            return;
        }
    }

    _cls1.val.reason()
    {
        this$0 = DashClockExtension.this;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.apps.dashclock.api.internal.IExtensionHost;

// Referenced classes of package com.google.android.apps.dashclock.api:
//            DashClockExtension

class val.reason
    implements Runnable
{

    final val.reason this$1;
    final int val$reason;

    public void run()
    {
        onUpdateData(val$reason);
    }

    b()
    {
        this$1 = final_b;
        val$reason = I.this;
        super();
    }

    // Unreferenced inner class com/google/android/apps/dashclock/api/DashClockExtension$1

/* anonymous class */
    class DashClockExtension._cls1 extends com.google.android.apps.dashclock.api.internal.IExtension.Stub
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

        public void onUpdate(int i)
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
                DashClockExtension.access$200(DashClockExtension.this).post(i. new DashClockExtension._cls1._cls1());
                return;
            }
        }

            
            {
                this$0 = DashClockExtension.this;
                super();
            }
    }

}

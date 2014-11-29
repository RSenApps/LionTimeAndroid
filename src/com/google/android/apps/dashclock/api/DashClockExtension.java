// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.apps.dashclock.api.internal.IExtensionHost;

// Referenced classes of package com.google.android.apps.dashclock.api:
//            ExtensionData

public abstract class DashClockExtension extends Service
{

    private com.google.android.apps.dashclock.api.internal.IExtension.Stub mBinder;
    private IExtensionHost mHost;
    private boolean mInitialized;
    private volatile Handler mServiceHandler;
    private volatile Looper mServiceLooper;

    protected DashClockExtension()
    {
        mInitialized = false;
        mBinder = new com.google.android.apps.dashclock.api.internal.IExtension.Stub() {

            final DashClockExtension this$0;

            public void onInitialize(IExtensionHost iextensionhost, boolean flag)
                throws RemoteException
            {
                if (checkCallingOrSelfPermission("com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA") != 0)
                {
                    throw new SecurityException("Caller does not have the READ_EXTENSION_DATA permission.");
                }
                mHost = iextensionhost;
                if (!mInitialized)
                {
                    DashClockExtension.this.onInitialize(flag);
                    mInitialized = true;
                }
            }

            public void onUpdate(int i)
                throws RemoteException
            {
                if (checkCallingOrSelfPermission("com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA") != 0)
                {
                    throw new SecurityException("Caller does not have the READ_EXTENSION_DATA permission.");
                }
                if (!mInitialized)
                {
                    return;
                } else
                {
                    mServiceHandler.post(i. new Runnable() {

                        final _cls1 this$1;
                        final int val$reason;

                        public void run()
                        {
                            onUpdateData(reason);
                        }

            
            {
                this$1 = final__pcls1;
                reason = I.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = DashClockExtension.this;
                super();
            }
        };
    }

    public final IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        super.onCreate();
        HandlerThread handlerthread = new HandlerThread((new StringBuilder()).append("DashClockExtension:").append(getClass().getSimpleName()).toString());
        handlerthread.start();
        mServiceLooper = handlerthread.getLooper();
        mServiceHandler = new Handler(mServiceLooper);
    }

    public void onDestroy()
    {
        mServiceHandler.removeCallbacksAndMessages(null);
        mServiceLooper.quit();
    }

    protected void onInitialize(boolean flag)
    {
    }

    protected abstract void onUpdateData(int i);

    protected final void publishUpdate(ExtensionData extensiondata)
    {
        try
        {
            mHost.publishUpdate(extensiondata);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("DashClockExtension", "Couldn't publish updated extension data.", remoteexception);
        }
    }

    protected final void setUpdateWhenScreenOn(boolean flag)
    {
        try
        {
            mHost.setUpdateWhenScreenOn(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("DashClockExtension", "Couldn't set the extension to update upon ACTION_SCREEN_ON.", remoteexception);
        }
    }


/*
    static IExtensionHost access$002(DashClockExtension dashclockextension, IExtensionHost iextensionhost)
    {
        dashclockextension.mHost = iextensionhost;
        return iextensionhost;
    }

*/



/*
    static boolean access$102(DashClockExtension dashclockextension, boolean flag)
    {
        dashclockextension.mInitialized = flag;
        return flag;
    }

*/

}

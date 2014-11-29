// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.apps.dashclock.api.ExtensionData;

// Referenced classes of package com.google.android.apps.dashclock.api.internal:
//            IExtensionHost

private static class mRemote
    implements IExtensionHost
{

    private IBinder mRemote;

    public void addWatchContentUris(String as[])
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.apps.dashclock.api.internal.IExtensionHost");
        parcel.writeStringArray(as);
        mRemote.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public IBinder asBinder()
    {
        return mRemote;
    }

    public void publishUpdate(ExtensionData extensiondata)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.apps.dashclock.api.internal.IExtensionHost");
        if (extensiondata == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        extensiondata.writeToParcel(parcel, 0);
_L1:
        mRemote.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void setUpdateWhenScreenOn(boolean flag)
        throws RemoteException
    {
        int i;
        Parcel parcel;
        i = 1;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.apps.dashclock.api.internal.IExtensionHost");
        if (!flag)
        {
            i = 0;
        }
        parcel.writeInt(i);
        mRemote.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}

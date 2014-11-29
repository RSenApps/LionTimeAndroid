// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.apps.dashclock.api.ExtensionData;

// Referenced classes of package com.google.android.apps.dashclock.api.internal:
//            IExtensionHost

public static abstract class Proxy.mRemote extends Binder
    implements IExtensionHost
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IExtensionHost asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.apps.dashclock.api.internal.IExtensionHost");
        if (iinterface != null && (iinterface instanceof IExtensionHost))
        {
            return (IExtensionHost)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.apps.dashclock.api.internal.IExtensionHost");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.apps.dashclock.api.internal.IExtensionHost");
            ExtensionData extensiondata;
            if (parcel.readInt() != 0)
            {
                extensiondata = (ExtensionData)ExtensionData.CREATOR.reateFromParcel(parcel);
            } else
            {
                extensiondata = null;
            }
            publishUpdate(extensiondata);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.apps.dashclock.api.internal.IExtensionHost");
            addWatchContentUris(parcel.createStringArray());
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.apps.dashclock.api.internal.IExtensionHost");
            break;
        }
        boolean flag;
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setUpdateWhenScreenOn(flag);
        return true;
    }
}

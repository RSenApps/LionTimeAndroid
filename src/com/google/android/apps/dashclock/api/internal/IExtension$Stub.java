// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.apps.dashclock.api.internal:
//            IExtension

public static abstract class attachInterface extends Binder
    implements IExtension
{

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.apps.dashclock.api.internal.IExtension");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.apps.dashclock.api.internal.IExtension");
            IExtensionHost iextensionhost = tub.asInterface(parcel.readStrongBinder());
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            onInitialize(iextensionhost, flag);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.apps.dashclock.api.internal.IExtension");
            onUpdate(parcel.readInt());
            return true;
        }
    }

    public tub()
    {
        attachInterface(this, "com.google.android.apps.dashclock.api.internal.IExtension");
    }
}

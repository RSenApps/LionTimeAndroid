// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api;

import android.os.Parcel;

// Referenced classes of package com.google.android.apps.dashclock.api:
//            ExtensionData

static final class 
    implements android.os.or
{

    public ExtensionData createFromParcel(Parcel parcel)
    {
        return new ExtensionData(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ExtensionData[] newArray(int i)
    {
        return new ExtensionData[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}

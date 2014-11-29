// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.dashclock.api;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.URISyntaxException;

public class ExtensionData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ExtensionData createFromParcel(Parcel parcel)
        {
            return new ExtensionData(parcel);
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

    };
    private Intent mClickIntent;
    private String mExpandedBody;
    private String mExpandedTitle;
    private int mIcon;
    private String mStatus;
    private boolean mVisible;

    public ExtensionData()
    {
        mVisible = false;
        mIcon = 0;
        mStatus = null;
        mExpandedTitle = null;
        mExpandedBody = null;
        mClickIntent = null;
    }

    private ExtensionData(Parcel parcel)
    {
        boolean flag = true;
        super();
        mVisible = false;
        mIcon = 0;
        mStatus = null;
        mExpandedTitle = null;
        mExpandedBody = null;
        mClickIntent = null;
        int i = parcel.readInt();
        int j = parcel.readInt();
        if (i >= flag)
        {
            if (parcel.readInt() == 0)
            {
                flag = false;
            }
            mVisible = flag;
            mIcon = parcel.readInt();
            mStatus = parcel.readString();
            if (TextUtils.isEmpty(mStatus))
            {
                mStatus = null;
            }
            mExpandedTitle = parcel.readString();
            if (TextUtils.isEmpty(mExpandedTitle))
            {
                mExpandedTitle = null;
            }
            mExpandedBody = parcel.readString();
            if (TextUtils.isEmpty(mExpandedBody))
            {
                mExpandedBody = null;
            }
            try
            {
                mClickIntent = Intent.parseUri(parcel.readString(), 0);
            }
            catch (URISyntaxException urisyntaxexception) { }
        }
        parcel.setDataPosition(parcel.dataPosition() + (6 - j));
    }


    private static boolean intentEquals(Intent intent, Intent intent1)
    {
        if (intent == null || intent1 == null)
        {
            return intent == intent1;
        } else
        {
            return intent.equals(intent1);
        }
    }

    public ExtensionData clickIntent(Intent intent)
    {
        mClickIntent = intent;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        ExtensionData extensiondata;
        return false;
_L2:
        boolean flag;
        if ((extensiondata = (ExtensionData)obj).mVisible != mVisible || extensiondata.mIcon != mIcon || !TextUtils.equals(extensiondata.mStatus, mStatus) || !TextUtils.equals(extensiondata.mExpandedTitle, mExpandedTitle) || !TextUtils.equals(extensiondata.mExpandedBody, mExpandedBody) || !(flag = intentEquals(extensiondata.mClickIntent, mClickIntent))) goto _L1; else goto _L3
_L3:
        return true;
        ClassCastException classcastexception;
        classcastexception;
        return false;
    }

    public ExtensionData expandedBody(String s)
    {
        mExpandedBody = s;
        return this;
    }

    public ExtensionData expandedTitle(String s)
    {
        mExpandedTitle = s;
        return this;
    }

    public ExtensionData icon(int i)
    {
        mIcon = i;
        return this;
    }

    public ExtensionData status(String s)
    {
        mStatus = s;
        return this;
    }

    public ExtensionData visible(boolean flag)
    {
        mVisible = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j = 1;
        parcel.writeInt(j);
        parcel.writeInt(6);
        String s;
        String s1;
        String s2;
        String s3;
        if (!mVisible)
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeInt(mIcon);
        if (TextUtils.isEmpty(mStatus))
        {
            s = "";
        } else
        {
            s = mStatus;
        }
        parcel.writeString(s);
        if (TextUtils.isEmpty(mExpandedTitle))
        {
            s1 = "";
        } else
        {
            s1 = mExpandedTitle;
        }
        parcel.writeString(s1);
        if (TextUtils.isEmpty(mExpandedBody))
        {
            s2 = "";
        } else
        {
            s2 = mExpandedBody;
        }
        parcel.writeString(s2);
        if (mClickIntent == null)
        {
            s3 = "";
        } else
        {
            s3 = mClickIntent.toUri(0);
        }
        parcel.writeString(s3);
    }

}

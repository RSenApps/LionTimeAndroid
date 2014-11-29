// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;


// Referenced classes of package android.support.v4.view.accessibility:
//            AccessibilityNodeInfoCompatIcs

public class AccessibilityNodeInfoCompat
{
    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl
    {

        public void addAction(Object obj, int i)
        {
            AccessibilityNodeInfoCompatIcs.addAction(obj, i);
        }

        public void setClassName(Object obj, CharSequence charsequence)
        {
            AccessibilityNodeInfoCompatIcs.setClassName(obj, charsequence);
        }

        public void setScrollable(Object obj, boolean flag)
        {
            AccessibilityNodeInfoCompatIcs.setScrollable(obj, flag);
        }

        AccessibilityNodeInfoIcsImpl()
        {
        }
    }

    static interface AccessibilityNodeInfoImpl
    {

        public abstract void addAction(Object obj, int i);

        public abstract void setClassName(Object obj, CharSequence charsequence);

        public abstract void setScrollable(Object obj, boolean flag);
    }

    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl
    {

        AccessibilityNodeInfoJellybeanImpl()
        {
        }
    }

    static class AccessibilityNodeInfoStubImpl
        implements AccessibilityNodeInfoImpl
    {

        public void addAction(Object obj, int i)
        {
        }

        public void setClassName(Object obj, CharSequence charsequence)
        {
        }

        public void setScrollable(Object obj, boolean flag)
        {
        }

        AccessibilityNodeInfoStubImpl()
        {
        }
    }


    private static final AccessibilityNodeInfoImpl IMPL;
    private final Object mInfo;

    public AccessibilityNodeInfoCompat(Object obj)
    {
        mInfo = obj;
    }

    public void addAction(int i)
    {
        IMPL.addAction(mInfo, i);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        accessibilitynodeinfocompat = (AccessibilityNodeInfoCompat)obj;
        if (mInfo != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (accessibilitynodeinfocompat.mInfo == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mInfo.equals(accessibilitynodeinfocompat.mInfo)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public Object getInfo()
    {
        return mInfo;
    }

    public int hashCode()
    {
        if (mInfo == null)
        {
            return 0;
        } else
        {
            return mInfo.hashCode();
        }
    }

    public void setClassName(CharSequence charsequence)
    {
        IMPL.setClassName(mInfo, charsequence);
    }

    public void setScrollable(boolean flag)
    {
        IMPL.setScrollable(mInfo, flag);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            IMPL = new AccessibilityNodeInfoJellybeanImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new AccessibilityNodeInfoIcsImpl();
        } else
        {
            IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }
}

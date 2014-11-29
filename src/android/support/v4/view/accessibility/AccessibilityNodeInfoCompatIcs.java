// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatIcs
{

    public static void addAction(Object obj, int i)
    {
        ((AccessibilityNodeInfo)obj).addAction(i);
    }

    public static void setClassName(Object obj, CharSequence charsequence)
    {
        ((AccessibilityNodeInfo)obj).setClassName(charsequence);
    }

    public static void setScrollable(Object obj, boolean flag)
    {
        ((AccessibilityNodeInfo)obj).setScrollable(flag);
    }
}

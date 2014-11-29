// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ViewCompat, AccessibilityDelegateCompat

static interface t
{

    public abstract boolean canScrollHorizontally(View view, int i);

    public abstract int getImportantForAccessibility(View view);

    public abstract int getOverScrollMode(View view);

    public abstract void postInvalidateOnAnimation(View view);

    public abstract void postOnAnimation(View view, Runnable runnable);

    public abstract void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat);

    public abstract void setImportantForAccessibility(View view, int i);

    public abstract void setLayerType(View view, int i, Paint paint);
}

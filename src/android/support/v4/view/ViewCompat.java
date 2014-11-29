// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            AccessibilityDelegateCompat, ViewCompatGingerbread, ViewCompatHC, ViewCompatICS, 
//            ViewCompatJB

public class ViewCompat
{
    static class BaseViewCompatImpl
        implements ViewCompatImpl
    {

        public boolean canScrollHorizontally(View view, int i)
        {
            return false;
        }

        long getFrameTime()
        {
            return 10L;
        }

        public int getImportantForAccessibility(View view)
        {
            return 0;
        }

        public int getOverScrollMode(View view)
        {
            return 2;
        }

        public void postInvalidateOnAnimation(View view)
        {
            view.postInvalidateDelayed(getFrameTime());
        }

        public void postOnAnimation(View view, Runnable runnable)
        {
            view.postDelayed(runnable, getFrameTime());
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
        {
        }

        public void setImportantForAccessibility(View view, int i)
        {
        }

        public void setLayerType(View view, int i, Paint paint)
        {
        }

        BaseViewCompatImpl()
        {
        }
    }

    static class GBViewCompatImpl extends BaseViewCompatImpl
    {

        public int getOverScrollMode(View view)
        {
            return ViewCompatGingerbread.getOverScrollMode(view);
        }

        GBViewCompatImpl()
        {
        }
    }

    static class HCViewCompatImpl extends GBViewCompatImpl
    {

        long getFrameTime()
        {
            return ViewCompatHC.getFrameTime();
        }

        public void setLayerType(View view, int i, Paint paint)
        {
            ViewCompatHC.setLayerType(view, i, paint);
        }

        HCViewCompatImpl()
        {
        }
    }

    static class ICSViewCompatImpl extends HCViewCompatImpl
    {

        public boolean canScrollHorizontally(View view, int i)
        {
            return ViewCompatICS.canScrollHorizontally(view, i);
        }

        public void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
        {
            ViewCompatICS.setAccessibilityDelegate(view, accessibilitydelegatecompat.getBridge());
        }

        ICSViewCompatImpl()
        {
        }
    }

    static class JBViewCompatImpl extends ICSViewCompatImpl
    {

        public int getImportantForAccessibility(View view)
        {
            return ViewCompatJB.getImportantForAccessibility(view);
        }

        public void postInvalidateOnAnimation(View view)
        {
            ViewCompatJB.postInvalidateOnAnimation(view);
        }

        public void postOnAnimation(View view, Runnable runnable)
        {
            ViewCompatJB.postOnAnimation(view, runnable);
        }

        public void setImportantForAccessibility(View view, int i)
        {
            ViewCompatJB.setImportantForAccessibility(view, i);
        }

        JBViewCompatImpl()
        {
        }
    }

    static class JbMr1ViewCompatImpl extends JBViewCompatImpl
    {

        JbMr1ViewCompatImpl()
        {
        }
    }

    static interface ViewCompatImpl
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


    static final ViewCompatImpl IMPL;

    public static boolean canScrollHorizontally(View view, int i)
    {
        return IMPL.canScrollHorizontally(view, i);
    }

    public static int getImportantForAccessibility(View view)
    {
        return IMPL.getImportantForAccessibility(view);
    }

    public static int getOverScrollMode(View view)
    {
        return IMPL.getOverScrollMode(view);
    }

    public static void postInvalidateOnAnimation(View view)
    {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilitydelegatecompat)
    {
        IMPL.setAccessibilityDelegate(view, accessibilitydelegatecompat);
    }

    public static void setImportantForAccessibility(View view, int i)
    {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static void setLayerType(View view, int i, Paint paint)
    {
        IMPL.setLayerType(view, i, paint);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 17)
        {
            IMPL = new JbMr1ViewCompatImpl();
        } else
        if (i >= 16)
        {
            IMPL = new JBViewCompatImpl();
        } else
        if (i >= 14)
        {
            IMPL = new ICSViewCompatImpl();
        } else
        if (i >= 11)
        {
            IMPL = new HCViewCompatImpl();
        } else
        if (i >= 9)
        {
            IMPL = new GBViewCompatImpl();
        } else
        {
            IMPL = new BaseViewCompatImpl();
        }
    }
}

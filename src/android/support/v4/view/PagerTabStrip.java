// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

// Referenced classes of package android.support.v4.view:
//            PagerTitleStrip, ViewPager

public class PagerTabStrip extends PagerTitleStrip
{

    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(Context context)
    {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTabPaint = new Paint();
        mTempRect = new Rect();
        mTabAlpha = 255;
        mDrawFullUnderline = false;
        mDrawFullUnderlineSet = false;
        mIndicatorColor = mTextColor;
        mTabPaint.setColor(mIndicatorColor);
        float f = context.getResources().getDisplayMetrics().density;
        mIndicatorHeight = (int)(0.5F + 3F * f);
        mMinPaddingBottom = (int)(0.5F + 6F * f);
        mMinTextSpacing = (int)(64F * f);
        mTabPadding = (int)(0.5F + 16F * f);
        mFullUnderlineHeight = (int)(0.5F + 1.0F * f);
        mMinStripHeight = (int)(0.5F + 32F * f);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        mPrevText.setFocusable(true);
        mPrevText.setOnClickListener(new android.view.View.OnClickListener() {

            final PagerTabStrip this$0;

            public void onClick(View view)
            {
                mPager.setCurrentItem(-1 + mPager.getCurrentItem());
            }

            
            {
                this$0 = PagerTabStrip.this;
                super();
            }
        });
        mNextText.setFocusable(true);
        mNextText.setOnClickListener(new android.view.View.OnClickListener() {

            final PagerTabStrip this$0;

            public void onClick(View view)
            {
                mPager.setCurrentItem(1 + mPager.getCurrentItem());
            }

            
            {
                this$0 = PagerTabStrip.this;
                super();
            }
        });
        if (getBackground() == null)
        {
            mDrawFullUnderline = true;
        }
    }

    int getMinHeight()
    {
        return Math.max(super.getMinHeight(), mMinStripHeight);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = getHeight();
        int j = mCurrText.getLeft() - mTabPadding;
        int k = mCurrText.getRight() + mTabPadding;
        int l = i - mIndicatorHeight;
        mTabPaint.setColor(mTabAlpha << 24 | 0xffffff & mIndicatorColor);
        canvas.drawRect(j, l, k, i, mTabPaint);
        if (mDrawFullUnderline)
        {
            mTabPaint.setColor(0xff000000 | 0xffffff & mIndicatorColor);
            canvas.drawRect(getPaddingLeft(), i - mFullUnderlineHeight, getWidth() - getPaddingRight(), i, mTabPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        float f;
        float f1;
        i = motionevent.getAction();
        if (i != 0 && mIgnoreTap)
        {
            return false;
        }
        f = motionevent.getX();
        f1 = motionevent.getY();
        i;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 58
    //                   1 122
    //                   2 77;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        mInitialMotionX = f;
        mInitialMotionY = f1;
        mIgnoreTap = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (Math.abs(f - mInitialMotionX) > (float)mTouchSlop || Math.abs(f1 - mInitialMotionY) > (float)mTouchSlop)
        {
            mIgnoreTap = true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (f < (float)(mCurrText.getLeft() - mTabPadding))
        {
            mPager.setCurrentItem(-1 + mPager.getCurrentItem());
        } else
        if (f > (float)(mCurrText.getRight() + mTabPadding))
        {
            mPager.setCurrentItem(1 + mPager.getCurrentItem());
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setBackgroundColor(int i)
    {
        super.setBackgroundColor(i);
        if (!mDrawFullUnderlineSet)
        {
            boolean flag;
            if ((0xff000000 & i) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mDrawFullUnderline = flag;
        }
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(drawable);
        if (!mDrawFullUnderlineSet)
        {
            boolean flag;
            if (drawable == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mDrawFullUnderline = flag;
        }
    }

    public void setBackgroundResource(int i)
    {
        super.setBackgroundResource(i);
        if (!mDrawFullUnderlineSet)
        {
            boolean flag;
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mDrawFullUnderline = flag;
        }
    }

    public void setDrawFullUnderline(boolean flag)
    {
        mDrawFullUnderline = flag;
        mDrawFullUnderlineSet = true;
        invalidate();
    }

    public void setPadding(int i, int j, int k, int l)
    {
        if (l < mMinPaddingBottom)
        {
            l = mMinPaddingBottom;
        }
        super.setPadding(i, j, k, l);
    }

    public void setTabIndicatorColor(int i)
    {
        mIndicatorColor = i;
        mTabPaint.setColor(mIndicatorColor);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i)
    {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public void setTextSpacing(int i)
    {
        if (i < mMinTextSpacing)
        {
            i = mMinTextSpacing;
        }
        super.setTextSpacing(i);
    }

    void updateTextPositions(int i, float f, boolean flag)
    {
        Rect rect = mTempRect;
        int j = getHeight();
        int k = mCurrText.getLeft() - mTabPadding;
        int l = mCurrText.getRight() + mTabPadding;
        int i1 = j - mIndicatorHeight;
        rect.set(k, i1, l, j);
        super.updateTextPositions(i, f, flag);
        mTabAlpha = (int)(255F * (2.0F * Math.abs(f - 0.5F)));
        rect.union(mCurrText.getLeft() - mTabPadding, i1, mCurrText.getRight() + mTabPadding, j);
        invalidate(rect);
    }
}

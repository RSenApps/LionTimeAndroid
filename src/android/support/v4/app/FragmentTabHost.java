// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            FragmentManager, FragmentTransaction, Fragment

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{
    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        String curTab;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(curTab).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(curTab);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            curTab = parcel.readString();
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    static final class TabInfo
    {

        private final Bundle args;
        private final Class clss;
        private Fragment fragment;
        private final String tag;



/*
        static Fragment access$102(TabInfo tabinfo, Fragment fragment1)
        {
            tabinfo.fragment = fragment1;
            return fragment1;
        }

*/



    }


    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private android.widget.TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList mTabs;

    public FragmentTabHost(Context context)
    {
        super(context, null);
        mTabs = new ArrayList();
        initFragmentTabHost(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTabs = new ArrayList();
        initFragmentTabHost(context, attributeset);
    }

    private FragmentTransaction doTabChanged(String s, FragmentTransaction fragmenttransaction)
    {
        TabInfo tabinfo = null;
        for (int i = 0; i < mTabs.size(); i++)
        {
            TabInfo tabinfo1 = (TabInfo)mTabs.get(i);
            if (tabinfo1.tag.equals(s))
            {
                tabinfo = tabinfo1;
            }
        }

        if (tabinfo == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s).toString());
        }
        if (mLastTab != tabinfo)
        {
            if (fragmenttransaction == null)
            {
                fragmenttransaction = mFragmentManager.beginTransaction();
            }
            if (mLastTab != null && mLastTab.fragment != null)
            {
                fragmenttransaction.detach(mLastTab.fragment);
            }
            if (tabinfo != null)
            {
                if (tabinfo.fragment == null)
                {
                    tabinfo.fragment = Fragment.instantiate(mContext, tabinfo.clss.getName(), tabinfo.args);
                    fragmenttransaction.add(mContainerId, tabinfo.fragment, tabinfo.tag);
                } else
                {
                    fragmenttransaction.attach(tabinfo.fragment);
                }
            }
            mLastTab = tabinfo;
        }
        return fragmenttransaction;
    }

    private void ensureContent()
    {
        if (mRealTabContent == null)
        {
            mRealTabContent = (FrameLayout)findViewById(mContainerId);
            if (mRealTabContent == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("No tab content FrameLayout found for id ").append(mContainerId).toString());
            }
        }
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, new int[] {
            0x10100f3
        }, 0, 0);
        mContainerId = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        super.setOnTabChangedListener(this);
        if (findViewById(0x1020013) == null)
        {
            LinearLayout linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(1);
            addView(linearlayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            TabWidget tabwidget = new TabWidget(context);
            tabwidget.setId(0x1020013);
            tabwidget.setOrientation(0);
            linearlayout.addView(tabwidget, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
            FrameLayout framelayout = new FrameLayout(context);
            framelayout.setId(0x1020011);
            linearlayout.addView(framelayout, new android.widget.LinearLayout.LayoutParams(0, 0, 0.0F));
            FrameLayout framelayout1 = new FrameLayout(context);
            mRealTabContent = framelayout1;
            mRealTabContent.setId(mContainerId);
            linearlayout.addView(framelayout1, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        int i = 0;
        while (i < mTabs.size()) 
        {
            TabInfo tabinfo = (TabInfo)mTabs.get(i);
            tabinfo.fragment = mFragmentManager.findFragmentByTag(tabinfo.tag);
            if (tabinfo.fragment != null && !tabinfo.fragment.isDetached())
            {
                if (tabinfo.tag.equals(s))
                {
                    mLastTab = tabinfo;
                } else
                {
                    if (fragmenttransaction == null)
                    {
                        fragmenttransaction = mFragmentManager.beginTransaction();
                    }
                    fragmenttransaction.detach(tabinfo.fragment);
                }
            }
            i++;
        }
        mAttached = true;
        FragmentTransaction fragmenttransaction1 = doTabChanged(s, fragmenttransaction);
        if (fragmenttransaction1 != null)
        {
            fragmenttransaction1.commit();
            mFragmentManager.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAttached = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setCurrentTabByTag(savedstate.curTab);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.curTab = getCurrentTabTag();
        return savedstate;
    }

    public void onTabChanged(String s)
    {
        if (mAttached)
        {
            FragmentTransaction fragmenttransaction = doTabChanged(s, null);
            if (fragmenttransaction != null)
            {
                fragmenttransaction.commit();
            }
        }
        if (mOnTabChangeListener != null)
        {
            mOnTabChangeListener.onTabChanged(s);
        }
    }

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        mOnTabChangeListener = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentmanager)
    {
        super.setup();
        mContext = context;
        mFragmentManager = fragmentmanager;
        ensureContent();
    }

    public void setup(Context context, FragmentManager fragmentmanager, int i)
    {
        super.setup();
        mContext = context;
        mFragmentManager = fragmentmanager;
        mContainerId = i;
        ensureContent();
        mRealTabContent.setId(i);
        if (getId() == -1)
        {
            setId(0x1020012);
        }
    }
}

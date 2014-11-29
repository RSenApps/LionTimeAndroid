// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;


public class SparseArrayCompat
{

    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int mKeys[];
    private int mSize;
    private Object mValues[];

    public SparseArrayCompat()
    {
        this(10);
    }

    public SparseArrayCompat(int i)
    {
        mGarbage = false;
        int j = idealIntArraySize(i);
        mKeys = new int[j];
        mValues = new Object[j];
        mSize = 0;
    }

    private void gc()
    {
        int i = mSize;
        int j = 0;
        int ai[] = mKeys;
        Object aobj[] = mValues;
        for (int k = 0; k < i; k++)
        {
            Object obj = aobj[k];
            if (obj == DELETED)
            {
                continue;
            }
            if (k != j)
            {
                ai[j] = ai[k];
                aobj[j] = obj;
            }
            j++;
        }

        mGarbage = false;
        mSize = j;
    }

    static int idealByteArraySize(int i)
    {
        int j = 4;
        do
        {
label0:
            {
                if (j < 32)
                {
                    if (i > -12 + (1 << j))
                    {
                        break label0;
                    }
                    i = -12 + (1 << j);
                }
                return i;
            }
            j++;
        } while (true);
    }

    static int idealIntArraySize(int i)
    {
        return idealByteArraySize(i * 4) / 4;
    }

    public void clear()
    {
        int i = mSize;
        Object aobj[] = mValues;
        for (int j = 0; j < i; j++)
        {
            aobj[j] = null;
        }

        mSize = 0;
        mGarbage = false;
    }

    public int keyAt(int i)
    {
        if (mGarbage)
        {
            gc();
        }
        return mKeys[i];
    }

    public int size()
    {
        if (mGarbage)
        {
            gc();
        }
        return mSize;
    }

    public Object valueAt(int i)
    {
        if (mGarbage)
        {
            gc();
        }
        return mValues[i];
    }

}

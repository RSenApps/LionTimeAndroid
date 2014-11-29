// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;


// Referenced classes of package android.support.v4.view:
//            KeyEventCompat

static class 
    implements 
{

    private static int metaStateFilterDirectionalModifiers(int i, int j, int k, int l, int i1)
    {
        boolean flag = true;
        boolean flag1;
        int j1;
        if ((j & k) != 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        j1 = l | i1;
        if ((j & j1) == 0)
        {
            flag = false;
        }
        if (flag1)
        {
            if (flag)
            {
                throw new IllegalArgumentException("bad arguments");
            }
            i &= ~j1;
        } else
        if (flag)
        {
            return i & ~k;
        }
        return i;
    }

    public boolean metaStateHasModifiers(int i, int j)
    {
        return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(0xf7 & normalizeMetaState(i), j, 1, 64, 128), j, 2, 16, 32) == j;
    }

    public boolean metaStateHasNoModifiers(int i)
    {
        return (0xf7 & normalizeMetaState(i)) == 0;
    }

    public int normalizeMetaState(int i)
    {
        if ((i & 0xc0) != 0)
        {
            i |= 1;
        }
        if ((i & 0x30) != 0)
        {
            i |= 2;
        }
        return i & 0xf7;
    }

    ()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

private static final class upperBound
    implements Serializable, WildcardType
{

    private final Type lowerBound;
    private final Type upperBound;

    public boolean equals(Object obj)
    {
        return (obj instanceof WildcardType) && upperBound(this, (WildcardType)obj);
    }

    public Type[] getLowerBounds()
    {
        if (lowerBound != null)
        {
            Type atype[] = new Type[1];
            atype[0] = lowerBound;
            return atype;
        } else
        {
            return lowerBound;
        }
    }

    public Type[] getUpperBounds()
    {
        Type atype[] = new Type[1];
        atype[0] = upperBound;
        return atype;
    }

    public int hashCode()
    {
        int i;
        if (lowerBound != null)
        {
            i = 31 + lowerBound.hashCode();
        } else
        {
            i = 1;
        }
        return i ^ 31 + upperBound.hashCode();
    }

    public String toString()
    {
        if (lowerBound != null)
        {
            return (new StringBuilder()).append("? super ").append(lowerBound(lowerBound)).toString();
        }
        if (upperBound == java/lang/Object)
        {
            return "?";
        } else
        {
            return (new StringBuilder()).append("? extends ").append(upperBound(upperBound)).toString();
        }
    }

    public (Type atype[], Type atype1[])
    {
        boolean flag = true;
        super();
        boolean flag1;
        boolean flag2;
        if (atype1.length <= flag)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        ment(flag1);
        if (atype.length == flag)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        ment(flag2);
        if (atype1.length == flag)
        {
            ull(atype1[0]);
            ull(atype1[0]);
            if (atype[0] != java/lang/Object)
            {
                flag = false;
            }
            ment(flag);
            lowerBound = lowerBound(atype1[0]);
            upperBound = java/lang/Object;
            return;
        } else
        {
            ull(atype[0]);
            ull(atype[0]);
            lowerBound = null;
            upperBound = upperBound(atype[0]);
            return;
        }
    }
}

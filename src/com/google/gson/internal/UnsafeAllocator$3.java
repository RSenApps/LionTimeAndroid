// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.lang.reflect.Method;

// Referenced classes of package com.google.gson.internal:
//            UnsafeAllocator

static final class nit> extends UnsafeAllocator
{

    final int val$constructorId;
    final Method val$newInstance;

    public Object newInstance(Class class1)
        throws Exception
    {
        Method method = val$newInstance;
        Object aobj[] = new Object[2];
        aobj[0] = class1;
        aobj[1] = Integer.valueOf(val$constructorId);
        return method.invoke(null, aobj);
    }

    (Method method, int i)
    {
        val$newInstance = method;
        val$constructorId = i;
        super();
    }
}

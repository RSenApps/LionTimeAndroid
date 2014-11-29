// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;

// Referenced classes of package com.google.gson.internal.bind:
//            ArrayTypeAdapter

static final class 
    implements TypeAdapterFactory
{

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        java.lang.reflect.Type type = typetoken.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class)type).isArray()))
        {
            return null;
        } else
        {
            java.lang.reflect.Type type1 = com.google.gson.internal.yComponentType(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(type1)), com.google.gson.internal.ype(type1));
        }
    }

    ()
    {
    }
}

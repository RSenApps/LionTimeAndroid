// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.gson.internal.bind:
//            TypeAdapters

private static final class constantToName extends TypeAdapter
{

    private final Map constantToName;
    private final Map nameToConstant;

    public Enum read(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return (Enum)nameToConstant.get(jsonreader.nextString());
        }
    }

    public volatile Object read(JsonReader jsonreader)
        throws IOException
    {
        return read(jsonreader);
    }

    public void write(JsonWriter jsonwriter, Enum enum)
        throws IOException
    {
        String s;
        if (enum == null)
        {
            s = null;
        } else
        {
            s = (String)constantToName.get(enum);
        }
        jsonwriter.value(s);
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        write(jsonwriter, (Enum)obj);
    }

    public (Class class1)
    {
        nameToConstant = new HashMap();
        constantToName = new HashMap();
        Enum aenum[];
        int i;
        int j;
        Enum enum;
        String s;
        SerializedName serializedname;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            i = aenum.length;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new AssertionError();
        }
        j = 0;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[j];
        s = enum.name();
        serializedname = (SerializedName)class1.getField(s).getAnnotation(com/google/gson/annotations/SerializedName);
        if (serializedname == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = serializedname.value();
        nameToConstant.put(s, enum);
        constantToName.put(enum, s);
        j++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_41;
_L1:
    }
}

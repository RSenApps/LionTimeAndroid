// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class Streams
{

    public static void write(JsonElement jsonelement, JsonWriter jsonwriter)
        throws IOException
    {
        TypeAdapters.JSON_ELEMENT.write(jsonwriter, jsonelement);
    }
}

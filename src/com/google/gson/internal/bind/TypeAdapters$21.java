// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.google.gson.internal.bind:
//            TypeAdapters

static final class  extends TypeAdapter
{

    public volatile Object read(JsonReader jsonreader)
        throws IOException
    {
        return read(jsonreader);
    }

    public UUID read(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return UUID.fromString(jsonreader.nextString());
        }
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        write(jsonwriter, (UUID)obj);
    }

    public void write(JsonWriter jsonwriter, UUID uuid)
        throws IOException
    {
        String s;
        if (uuid == null)
        {
            s = null;
        } else
        {
            s = uuid.toString();
        }
        jsonwriter.value(s);
    }

    ()
    {
    }
}

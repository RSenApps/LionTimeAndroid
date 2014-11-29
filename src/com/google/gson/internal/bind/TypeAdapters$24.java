// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

// Referenced classes of package com.google.gson.internal.bind:
//            TypeAdapters

static final class  extends TypeAdapter
{

    public volatile Object read(JsonReader jsonreader)
        throws IOException
    {
        return read(jsonreader);
    }

    public Locale read(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        StringTokenizer stringtokenizer = new StringTokenizer(jsonreader.nextString(), "_");
        boolean flag = stringtokenizer.hasMoreElements();
        String s = null;
        if (flag)
        {
            s = stringtokenizer.nextToken();
        }
        boolean flag1 = stringtokenizer.hasMoreElements();
        String s1 = null;
        if (flag1)
        {
            s1 = stringtokenizer.nextToken();
        }
        boolean flag2 = stringtokenizer.hasMoreElements();
        String s2 = null;
        if (flag2)
        {
            s2 = stringtokenizer.nextToken();
        }
        if (s1 == null && s2 == null)
        {
            return new Locale(s);
        }
        if (s2 == null)
        {
            return new Locale(s, s1);
        } else
        {
            return new Locale(s, s1, s2);
        }
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        write(jsonwriter, (Locale)obj);
    }

    public void write(JsonWriter jsonwriter, Locale locale)
        throws IOException
    {
        String s;
        if (locale == null)
        {
            s = null;
        } else
        {
            s = locale.toString();
        }
        jsonwriter.value(s);
    }

    ()
    {
    }
}

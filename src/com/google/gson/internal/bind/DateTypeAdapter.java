// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateTypeAdapter extends TypeAdapter
{

    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {

        public TypeAdapter create(Gson gson, TypeToken typetoken)
        {
            if (typetoken.getRawType() == java/util/Date)
            {
                return new DateTypeAdapter();
            } else
            {
                return null;
            }
        }

    };
    private final DateFormat enUsFormat;
    private final DateFormat iso8601Format = buildIso8601Format();
    private final DateFormat localFormat = DateFormat.getDateTimeInstance(2, 2);

    public DateTypeAdapter()
    {
        enUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    }

    private static DateFormat buildIso8601Format()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpledateformat;
    }

    private Date deserializeToDate(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date3 = localFormat.parse(s);
        Date date1 = date3;
_L1:
        this;
        JVM INSTR monitorexit ;
        return date1;
        ParseException parseexception;
        parseexception;
        Date date2 = enUsFormat.parse(s);
        date1 = date2;
          goto _L1
        ParseException parseexception1;
        parseexception1;
        Date date = iso8601Format.parse(s);
        date1 = date;
          goto _L1
        ParseException parseexception2;
        parseexception2;
        throw new JsonSyntaxException(s, parseexception2);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object read(JsonReader jsonreader)
        throws IOException
    {
        return read(jsonreader);
    }

    public Date read(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return deserializeToDate(jsonreader.nextString());
        }
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        write(jsonwriter, (Date)obj);
    }

    public void write(JsonWriter jsonwriter, Date date)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null) goto _L2; else goto _L1
_L1:
        jsonwriter.nullValue();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        jsonwriter.value(enUsFormat.format(date));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}

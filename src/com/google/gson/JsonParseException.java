// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;


public class JsonParseException extends RuntimeException
{

    public JsonParseException(String s)
    {
        super(s);
    }

    public JsonParseException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public JsonParseException(Throwable throwable)
    {
        super(throwable);
    }
}

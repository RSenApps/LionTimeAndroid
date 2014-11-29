// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import com.google.gson.internal.StringMap;
import java.util.Set;

// Referenced classes of package com.google.gson:
//            JsonElement, JsonNull

public final class JsonObject extends JsonElement
{

    private final StringMap members = new StringMap();

    public JsonObject()
    {
    }

    public void add(String s, JsonElement jsonelement)
    {
        if (jsonelement == null)
        {
            jsonelement = JsonNull.INSTANCE;
        }
        members.put((String)com.google.gson.internal..Gson.Preconditions.checkNotNull(s), jsonelement);
    }

    public Set entrySet()
    {
        return members.entrySet();
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof JsonObject) && ((JsonObject)obj).members.equals(members);
    }

    public int hashCode()
    {
        return members.hashCode();
    }
}

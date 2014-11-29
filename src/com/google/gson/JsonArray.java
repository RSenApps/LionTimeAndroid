// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.gson:
//            JsonElement, JsonNull

public final class JsonArray extends JsonElement
    implements Iterable
{

    private final List elements = new ArrayList();

    public JsonArray()
    {
    }

    public void add(JsonElement jsonelement)
    {
        if (jsonelement == null)
        {
            jsonelement = JsonNull.INSTANCE;
        }
        elements.add(jsonelement);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof JsonArray) && ((JsonArray)obj).elements.equals(elements);
    }

    public boolean getAsBoolean()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsBoolean();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public double getAsDouble()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsDouble();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int getAsInt()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsInt();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public long getAsLong()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsLong();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public Number getAsNumber()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsNumber();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public String getAsString()
    {
        if (elements.size() == 1)
        {
            return ((JsonElement)elements.get(0)).getAsString();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public int hashCode()
    {
        return elements.hashCode();
    }

    public Iterator iterator()
    {
        return elements.iterator();
    }
}

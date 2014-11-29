// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;


final class StringPool
{

    private final String pool[] = new String[512];

    StringPool()
    {
    }

    public String get(char ac[], int i, int j)
    {
        int k = 0;
        for (int l = i; l < i + j; l++)
        {
            k = k * 31 + ac[l];
        }

        int i1 = k ^ (k >>> 20 ^ k >>> 12);
        int j1 = (i1 ^ (i1 >>> 7 ^ i1 >>> 4)) & -1 + pool.length;
        String s = pool[j1];
        if (s == null || s.length() != j)
        {
            String s1 = new String(ac, i, j);
            pool[j1] = s1;
            return s1;
        }
        for (int k1 = 0; k1 < j; k1++)
        {
            if (s.charAt(k1) != ac[i + k1])
            {
                String s2 = new String(ac, i, j);
                pool[j1] = s2;
                return s2;
            }
        }

        return s;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Context;
import java.util.Calendar;

// Referenced classes of package com.RSen.LionTime:
//            Schedule

public class TimeTillCalculator
{

    public static String[] getTimeTill(Context context)
    {
        int i;
        int j;
        String s;
        int ai[];
        int k;
        int l;
        Calendar calendar = Calendar.getInstance();
        i = 60 * calendar.get(11) + calendar.get(12);
        j = -1;
        s = "Period ";
        ai = Schedule.getScheduleTimes(context);
        k = Schedule.getScheduleType(context, calendar);
        if (k == 4)
        {
            return (new String[] {
                "-1", "No School"
            });
        }
        l = 0;
_L5:
        if (l < ai.length) goto _L2; else goto _L1
_L1:
        String as1[] = new String[2];
        as1[0] = (new StringBuilder(String.valueOf(j))).toString();
        as1[1] = s;
        return as1;
_L2:
        if (ai[l] <= i)
        {
            break; /* Loop/switch isn't completed */
        }
        j = ai[l] - i;
        if (k == 3)
        {
            String as[] = {
                "1", "2", "3", "4", "5", "6A", "6B", "7", "8", "End of School"
            };
            if (l == -1 + as.length)
            {
                s = as[l];
            } else
            {
                s = (new StringBuilder(String.valueOf(s))).append(as[l]).toString();
            }
        } else
        if (k == 1)
        {
            String as2[] = {
                "1", "3", "5", "Lunch", "Assembly", "7", "End of School"
            };
            if (l == -1 + as2.length)
            {
                s = as2[l];
            } else
            {
                s = (new StringBuilder(String.valueOf(s))).append(as2[l]).toString();
            }
        } else
        if (k == 2)
        {
            String as3[] = {
                "2", "4", "6", "Lunch", "8", "Activity", "End of School"
            };
            if (l == -1 + as3.length)
            {
                s = as3[l];
            } else
            {
                s = (new StringBuilder(String.valueOf(s))).append(as3[l]).toString();
            }
        } else
        if (l + 1 > 8)
        {
            s = "End of School";
        } else
        if (l == 2 && 590 - i > 0)
        {
            j = 590 - i;
            s = "Advisory";
        } else
        {
            s = (new StringBuilder(String.valueOf(s))).append(l + 1).toString();
        }
        if (true) goto _L1; else goto _L3
_L3:
        l++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}

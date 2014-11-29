// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Schedule
{

    public static void addIrregularSchedule(Context context, Calendar calendar, int i)
    {
        HashMap hashmap = readIrregularsFromFile(context);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.clear();
        calendar1.set(calendar.get(1), calendar.get(2), calendar.get(5));
        if (getRegularScheduleType(calendar) != i)
        {
            hashmap.put(calendar1, Integer.valueOf(i));
        } else
        {
            hashmap.remove(calendar1);
        }
        writeIrregularsToFile(context, hashmap);
    }

    public static int checkIrregular(Context context, Calendar calendar)
    {
        int i = -1;
        Object obj;
        int j;
        try
        {
            HashMap hashmap = readIrregularsFromFile(context);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.clear();
            calendar1.set(calendar.get(1), calendar.get(2), calendar.get(5));
            obj = hashmap.get(calendar1);
        }
        catch (Exception exception)
        {
            return i;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        j = ((Integer)obj).intValue();
        i = j;
        return i;
    }

    public static void cleanIrregularSchedules(Context context)
    {
        HashMap hashmap = readIrregularsFromFile(context);
        Set set = hashmap.keySet();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        Iterator iterator = set.iterator();
        do
        {
            Calendar calendar1;
            do
            {
                if (!iterator.hasNext())
                {
                    writeIrregularsToFile(context, hashmap);
                    return;
                }
                calendar1 = (Calendar)iterator.next();
            } while (!calendar.after(calendar1));
            hashmap.remove(calendar1);
        } while (true);
    }

    public static String getReadableScheduleType(Context context, int i)
    {
        return context.getResources().getStringArray(0x7f050000)[i];
    }

    public static String getReadableScheduleType(Context context, Calendar calendar)
    {
        int i = getScheduleType(context, calendar);
        return context.getResources().getStringArray(0x7f050000)[i];
    }

    private static int getRegularScheduleType(Calendar calendar)
    {
        int i = calendar.get(7);
        if (i == 4)
        {
            return 1;
        }
        if (i == 5)
        {
            return 2;
        }
        return i != 7 && i != 1 ? 0 : 4;
    }

    public static int[] getScheduleTimes(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        int i = checkIrregular(context, calendar);
        if (i == 3)
        {
            return (new int[] {
                490, 540, 590, 640, 690, 740, 790, 810, 860, 905
            });
        }
        if (calendar.get(7) == 4 && i == -1 || i == 1)
        {
            return (new int[] {
                490, 575, 655, 735, 775, 830, 905
            });
        }
        if (calendar.get(7) == 5 && i == -1 || i == 2)
        {
            return (new int[] {
                490, 575, 655, 735, 775, 855, 905
            });
        } else
        {
            return (new int[] {
                490, 540, 605, 655, 705, 755, 805, 855, 900
            });
        }
    }

    public static int getScheduleType(Context context, Calendar calendar)
    {
        int i = checkIrregular(context, calendar);
        int j = calendar.get(7);
        if (i != -1)
        {
            return i;
        }
        if (j == 4)
        {
            return 1;
        }
        if (j == 5)
        {
            return 2;
        }
        return j != 7 && j != 1 ? 0 : 4;
    }

    private static HashMap readIrregularsFromFile(Context context)
    {
        HashMap hashmap;
        try
        {
            ObjectInputStream objectinputstream = new ObjectInputStream(context.openFileInput("irregular_schedules"));
            Object obj = objectinputstream.readObject();
            objectinputstream.close();
            hashmap = (HashMap)obj;
        }
        catch (Exception exception)
        {
            return new HashMap();
        }
        return hashmap;
    }

    private static void writeIrregularsToFile(Context context, HashMap hashmap)
    {
        try
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(context.openFileOutput("irregular_schedules", 0));
            objectoutputstream.writeObject(hashmap);
            objectoutputstream.close();
            return;
        }
        catch (Exception exception)
        {
            Toast.makeText(context, "Add irregular schedule operation failed, please try again...", 0).show();
        }
    }
}

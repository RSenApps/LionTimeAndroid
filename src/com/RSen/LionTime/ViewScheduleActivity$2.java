// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.DialogInterface;

// Referenced classes of package com.RSen.LionTime:
//            ViewScheduleActivity

class this._cls0
    implements android.content.Listener
{

    final ViewScheduleActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        finish();
    }

    stener()
    {
        this$0 = ViewScheduleActivity.this;
        super();
    }
}

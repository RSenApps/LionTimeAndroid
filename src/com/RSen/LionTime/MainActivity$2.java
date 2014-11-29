// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.RSen.LionTime;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.RSen.LionTime:
//            MainActivity, ChangeScheduleActivity

class this._cls0
    implements android.view.tener
{

    final MainActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent(view.getContext(), com/RSen/LionTime/ChangeScheduleActivity));
    }

    ctivity()
    {
        this$0 = MainActivity.this;
        super();
    }
}

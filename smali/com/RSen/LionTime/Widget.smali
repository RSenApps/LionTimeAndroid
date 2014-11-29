.class public Lcom/RSen/LionTime/Widget;
.super Landroid/appwidget/AppWidgetProvider;
.source "Widget.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/appwidget/AppWidgetProvider;-><init>()V

    return-void
.end method

.method private updateWidgets(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    .locals 22
    .parameter "context"
    .parameter "appWidgetManager"
    .parameter "appWidgetIds"

    .prologue
    .line 51
    move-object/from16 v0, p3

    array-length v4, v0

    .line 54
    .local v4, N:I
    invoke-static/range {p1 .. p1}, Lcom/RSen/LionTime/TimeTillCalculator;->getTimeTill(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v15

    .line 55
    .local v15, timeInfo:[Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, i:I
    :goto_0
    if-lt v7, v4, :cond_1

    .line 89
    const-string v17, "alarm"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 88
    check-cast v5, Landroid/app/AlarmManager;

    .line 93
    .local v5, alarmManager:Landroid/app/AlarmManager;
    const v17, 0x1aed34

    .line 94
    new-instance v18, Landroid/content/Intent;

    const-string v19, "com.RSen.LionTime.WIDGET_UPDATE"

    invoke-direct/range {v18 .. v19}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/16 v19, 0x0

    .line 93
    move-object/from16 v0, p1

    move/from16 v1, v17

    move-object/from16 v2, v18

    move/from16 v3, v19

    invoke-static {v0, v1, v2, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 95
    .local v8, intent:Landroid/app/PendingIntent;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v11

    .line 96
    .local v11, now:Ljava/util/Calendar;
    const/16 v17, 0x0

    aget-object v17, v15, v17

    const-string v18, "-1"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_0

    .line 98
    const/16 v17, 0x1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v18

    .line 99
    const/16 v20, 0xd

    move/from16 v0, v20

    invoke-virtual {v11, v0}, Ljava/util/Calendar;->get(I)I

    move-result v20

    rsub-int/lit8 v20, v20, 0x3c

    move/from16 v0, v20

    mul-int/lit16 v0, v0, 0x3e8

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-long v0, v0

    move-wide/from16 v20, v0

    add-long v18, v18, v20

    .line 98
    move/from16 v0, v17

    move-wide/from16 v1, v18

    invoke-virtual {v5, v0, v1, v2, v8}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 102
    :cond_0
    return-void

    .line 56
    .end local v5           #alarmManager:Landroid/app/AlarmManager;
    .end local v8           #intent:Landroid/app/PendingIntent;
    .end local v11           #now:Ljava/util/Calendar;
    :cond_1
    aget v6, p3, v7

    .line 58
    .local v6, appWidgetId:I
    new-instance v10, Landroid/content/Intent;

    const-class v17, Lcom/RSen/LionTime/ViewScheduleActivity;

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-direct {v10, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 59
    .local v10, intentView:Landroid/content/Intent;
    new-instance v9, Landroid/content/Intent;

    .line 60
    const-class v17, Lcom/RSen/LionTime/ChangeScheduleActivity;

    .line 59
    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-direct {v9, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 63
    .local v9, intentChange:Landroid/content/Intent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    .line 62
    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v10, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v13

    .line 65
    .local v13, pendingIntentView:Landroid/app/PendingIntent;
    const/16 v17, 0x0

    const/16 v18, 0x0

    .line 64
    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v0, v1, v9, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v12

    .line 69
    .local v12, pendingIntentChange:Landroid/app/PendingIntent;
    new-instance v16, Landroid/widget/RemoteViews;

    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v17

    .line 70
    const v18, 0x7f030002

    .line 69
    invoke-direct/range {v16 .. v18}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 71
    .local v16, views:Landroid/widget/RemoteViews;
    const v17, 0x7f090007

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v13}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 73
    const v17, 0x7f090008

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v12}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 77
    const/16 v17, 0x0

    aget-object v17, v15, v17

    const-string v18, "-1"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_2

    .line 78
    new-instance v17, Ljava/lang/StringBuilder;

    const/16 v18, 0x0

    aget-object v18, v15, v18

    invoke-static/range {v18 .. v18}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v18, " min until "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const/16 v18, 0x1

    aget-object v18, v15, v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    .line 82
    .local v14, text:Ljava/lang/String;
    :goto_1
    const v17, 0x7f090006

    move-object/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v0, v1, v14}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 85
    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-virtual {v0, v6, v1}, Landroid/appwidget/AppWidgetManager;->updateAppWidget(ILandroid/widget/RemoteViews;)V

    .line 55
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_0

    .line 80
    .end local v14           #text:Ljava/lang/String;
    :cond_2
    const-string v14, "School is Over!"

    .restart local v14       #text:Ljava/lang/String;
    goto :goto_1
.end method


# virtual methods
.method public onEnabled(Landroid/content/Context;)V
    .locals 5
    .parameter "context"

    .prologue
    .line 25
    invoke-super {p0, p1}, Landroid/appwidget/AppWidgetProvider;->onEnabled(Landroid/content/Context;)V

    .line 26
    new-instance v2, Landroid/content/ComponentName;

    .line 27
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    .line 26
    invoke-direct {v2, v3, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    .local v2, thisAppWidget:Landroid/content/ComponentName;
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    .line 30
    .local v0, appWidgetManager:Landroid/appwidget/AppWidgetManager;
    invoke-virtual {v0, v2}, Landroid/appwidget/AppWidgetManager;->getAppWidgetIds(Landroid/content/ComponentName;)[I

    move-result-object v1

    .line 31
    .local v1, ids:[I
    invoke-direct {p0, p1, v0, v1}, Lcom/RSen/LionTime/Widget;->updateWidgets(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V

    .line 32
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 37
    invoke-super {p0, p1, p2}, Landroid/appwidget/AppWidgetProvider;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V

    .line 38
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.RSen.LionTime.WIDGET_UPDATE"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 39
    new-instance v2, Landroid/content/ComponentName;

    .line 40
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    .line 39
    invoke-direct {v2, v3, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .local v2, thisAppWidget:Landroid/content/ComponentName;
    invoke-static {p1}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v0

    .line 43
    .local v0, appWidgetManager:Landroid/appwidget/AppWidgetManager;
    invoke-virtual {v0, v2}, Landroid/appwidget/AppWidgetManager;->getAppWidgetIds(Landroid/content/ComponentName;)[I

    move-result-object v1

    .line 44
    .local v1, ids:[I
    invoke-direct {p0, p1, v0, v1}, Lcom/RSen/LionTime/Widget;->updateWidgets(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V

    .line 47
    .end local v0           #appWidgetManager:Landroid/appwidget/AppWidgetManager;
    .end local v1           #ids:[I
    .end local v2           #thisAppWidget:Landroid/content/ComponentName;
    :cond_0
    return-void
.end method

.method public onUpdate(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V
    .locals 0
    .parameter "context"
    .parameter "appWidgetManager"
    .parameter "appWidgetIds"

    .prologue
    .line 19
    invoke-direct {p0, p1, p2, p3}, Lcom/RSen/LionTime/Widget;->updateWidgets(Landroid/content/Context;Landroid/appwidget/AppWidgetManager;[I)V

    .line 20
    return-void
.end method

.class public Lcom/RSen/LionTime/NewDayReceiver;
.super Landroid/content/BroadcastReceiver;
.source "NewDayReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method private notifyIfIrregular(Landroid/content/Context;)V
    .locals 9
    .parameter "context"

    .prologue
    .line 40
    .line 41
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    .line 40
    invoke-static {p1, v4}, Lcom/RSen/LionTime/Schedule;->checkIrregular(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v0

    .line 42
    .local v0, irregularCode:I
    const/4 v4, -0x1

    if-eq v0, v4, :cond_0

    .line 45
    const-string v4, "notification"

    invoke-virtual {p1, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 44
    check-cast v2, Landroid/app/NotificationManager;

    .line 46
    .local v2, notificationManager:Landroid/app/NotificationManager;
    new-instance v1, Landroid/app/Notification;

    invoke-direct {v1}, Landroid/app/Notification;-><init>()V

    .line 47
    .local v1, notification:Landroid/app/Notification;
    const v4, 0x7f020004

    iput v4, v1, Landroid/app/Notification;->icon:I

    .line 48
    invoke-static {p1, v0}, Lcom/RSen/LionTime/Schedule;->getReadableScheduleType(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v3

    .line 50
    .local v3, scheduleString:Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Today is a "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 51
    const-string v5, " schedule"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 50
    iput-object v4, v1, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 52
    const-string v4, "Schedule Update"

    .line 53
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Today is a "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " schedule"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 54
    const v6, 0x22da784

    new-instance v7, Landroid/content/Intent;

    .line 55
    const-class v8, Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-direct {v7, p1, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    const/high16 v8, 0x1000

    .line 54
    invoke-static {p1, v6, v7, v8}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v6

    .line 52
    invoke-virtual {v1, p1, v4, v5, v6}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 57
    const v4, 0x935805f

    invoke-virtual {v2, v4, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 59
    .end local v1           #notification:Landroid/app/Notification;
    .end local v2           #notificationManager:Landroid/app/NotificationManager;
    .end local v3           #scheduleString:Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private scheduleNextDay(Landroid/content/Context;)V
    .locals 11
    .parameter "context"

    .prologue
    .line 62
    .line 63
    const-string v7, "alarm"

    invoke-virtual {p1, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 62
    check-cast v0, Landroid/app/AlarmManager;

    .line 64
    .local v0, alarmManager:Landroid/app/AlarmManager;
    const v7, 0xbf5ed8

    .line 65
    new-instance v8, Landroid/content/Intent;

    const-string v9, "com.RSen.LionTime.NEW_DAY"

    invoke-direct {v8, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/4 v9, 0x0

    .line 64
    invoke-static {p1, v7, v8, v9}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 66
    .local v3, intent:Landroid/app/PendingIntent;
    invoke-virtual {v0, v3}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 67
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v6

    .line 68
    .local v6, now:Ljava/util/Calendar;
    const/16 v7, 0xb

    invoke-virtual {v6, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    rsub-int/lit8 v7, v7, 0x18

    add-int/lit8 v7, v7, -0x1

    mul-int/lit8 v7, v7, 0x3c

    add-int/lit8 v7, v7, 0x3c

    .line 69
    const/16 v8, 0xc

    invoke-virtual {v6, v8}, Ljava/util/Calendar;->get(I)I

    move-result v8

    .line 68
    sub-int v4, v7, v8

    .line 71
    .local v4, minUntilEndOfDay:I
    invoke-static {}, Lcom/RSen/LionTime/NotificationReceiver;->getEarliestNotification()I

    move-result v7

    .line 70
    rsub-int v5, v7, 0x1ea

    .line 72
    .local v5, minUntilSchoolStartFromMidnight:I
    add-int v7, v4, v5

    mul-int/lit8 v7, v7, 0x3c

    mul-int/lit16 v7, v7, 0x3e8

    int-to-long v7, v7

    .line 73
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    .line 72
    add-long v1, v7, v9

    .line 74
    .local v1, alarmTime:J
    const/4 v7, 0x1

    invoke-virtual {v0, v7, v1, v2, v3}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 75
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .parameter "context"
    .parameter "intent"

    .prologue
    .line 21
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 22
    .local v3, prefs:Landroid/content/SharedPreferences;
    const-string v4, "lastChecked"

    const-string v5, ""

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 23
    .local v0, lastChecked:Ljava/lang/String;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 24
    .local v1, now:Ljava/util/Calendar;
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Y"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v5, 0x1

    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "M"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x2

    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "D"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/4 v5, 0x5

    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 25
    .local v2, nowString:Ljava/lang/String;
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 27
    invoke-static {p1}, Lcom/RSen/LionTime/CheckScheduleUpdates;->checkScheduleUpdates(Landroid/content/Context;)V

    .line 28
    invoke-static {p1}, Lcom/RSen/LionTime/Schedule;->cleanIrregularSchedules(Landroid/content/Context;)V

    .line 29
    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    const-string v5, "lastChecked"

    invoke-interface {v4, v5, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 30
    invoke-direct {p0, p1}, Lcom/RSen/LionTime/NewDayReceiver;->notifyIfIrregular(Landroid/content/Context;)V

    .line 31
    invoke-direct {p0, p1}, Lcom/RSen/LionTime/NewDayReceiver;->scheduleNextDay(Landroid/content/Context;)V

    .line 34
    :cond_0
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.RSen.LionTime.SHOW_NOTIFICATION"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 35
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.RSen.LionTime.WIDGET_UPDATE"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 37
    return-void
.end method

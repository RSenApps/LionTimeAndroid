.class public Lcom/RSen/LionTime/NotificationReceiver;
.super Landroid/content/BroadcastReceiver;
.source "NotificationReceiver.java"


# static fields
.field private static final notificationTimes:[I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x4

    const/4 v3, 0x3

    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 18
    const/16 v0, 0xc

    new-array v0, v0, [I

    aput v1, v0, v1

    aput v2, v0, v2

    aput v3, v0, v3

    aput v4, v0, v4

    .line 19
    aput v5, v0, v5

    const/4 v1, 0x6

    const/4 v2, 0x6

    aput v2, v0, v1

    const/4 v1, 0x7

    const/4 v2, 0x7

    aput v2, v0, v1

    const/16 v1, 0x8

    const/16 v2, 0xa

    aput v2, v0, v1

    const/16 v1, 0x9

    const/16 v2, 0xf

    aput v2, v0, v1

    const/16 v1, 0xa

    const/16 v2, 0x14

    aput v2, v0, v1

    const/16 v1, 0xb

    const/16 v2, 0x1e

    aput v2, v0, v1

    .line 18
    sput-object v0, Lcom/RSen/LionTime/NotificationReceiver;->notificationTimes:[I

    .line 20
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 23
    return-void
.end method

.method public static cancelNotification(Landroid/content/Context;)V
    .locals 2
    .parameter "context"

    .prologue
    .line 47
    .line 48
    const-string v1, "notification"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 47
    check-cast v0, Landroid/app/NotificationManager;

    .line 49
    .local v0, notificationManager:Landroid/app/NotificationManager;
    const v1, 0x79fd1e8

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    .line 50
    return-void
.end method

.method public static getEarliestNotification()I
    .locals 2

    .prologue
    .line 26
    sget-object v0, Lcom/RSen/LionTime/NotificationReceiver;->notificationTimes:[I

    sget-object v1, Lcom/RSen/LionTime/NotificationReceiver;->notificationTimes:[I

    array-length v1, v1

    add-int/lit8 v1, v1, -0x1

    aget v0, v0, v1

    return v0
.end method

.method private scheduleNext(Landroid/content/Context;I)V
    .locals 10
    .parameter "context"
    .parameter "timeTill"

    .prologue
    .line 53
    const/4 v5, 0x1

    .line 56
    .local v5, minUntilNotification:I
    const-string v6, "alarm"

    invoke-virtual {p1, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 55
    check-cast v0, Landroid/app/AlarmManager;

    .line 58
    .local v0, alarmManager:Landroid/app/AlarmManager;
    const v6, 0x79fd1e8

    new-instance v7, Landroid/content/Intent;

    .line 59
    const-string v8, "com.RSen.LionTime.SHOW_NOTIFICATION"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/4 v8, 0x0

    .line 57
    invoke-static {p1, v6, v7, v8}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v4

    .line 61
    .local v4, intent:Landroid/app/PendingIntent;
    const/4 v6, -0x1

    if-eq p2, v6, :cond_0

    .line 63
    :goto_0
    sget-object v6, Lcom/RSen/LionTime/NotificationReceiver;->notificationTimes:[I

    .line 64
    sub-int v7, p2, v5

    .line 63
    invoke-static {v6, v7}, Ljava/util/Arrays;->binarySearch([II)I

    move-result v6

    if-ltz v6, :cond_1

    .line 70
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v6

    .line 71
    const/16 v7, 0xd

    invoke-virtual {v6, v7}, Ljava/util/Calendar;->get(I)I

    move-result v6

    .line 70
    mul-int/lit16 v3, v6, 0x3e8

    .line 72
    .local v3, currentExtraMillis:I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    int-to-long v8, v3

    sub-long/2addr v6, v8

    const v8, 0xea60

    .line 73
    mul-int/2addr v8, v5

    int-to-long v8, v8

    .line 72
    add-long v1, v6, v8

    .line 74
    .local v1, alarmTime:J
    const/4 v6, 0x1

    invoke-virtual {v0, v6, v1, v2, v4}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 78
    .end local v1           #alarmTime:J
    .end local v3           #currentExtraMillis:I
    :cond_0
    return-void

    .line 66
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method

.method private showNotification(Landroid/content/Context;[Ljava/lang/String;)V
    .locals 13
    .parameter "context"
    .parameter "timeInfo"
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const v12, 0x7f020004

    const v11, 0x79fd1e8

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 82
    new-instance v3, Landroid/content/Intent;

    const-class v6, Lcom/RSen/LionTime/SettingsActivity;

    invoke-direct {v3, p1, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 83
    .local v3, notiIntent:Landroid/content/Intent;
    invoke-static {p1, v9, v3, v9}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v5

    .line 88
    .local v5, pIntent:Landroid/app/PendingIntent;
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0xb

    if-lt v6, v7, :cond_0

    .line 89
    new-instance v6, Landroid/app/Notification$Builder;

    invoke-direct {v6, p1}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 90
    new-instance v7, Ljava/lang/StringBuilder;

    aget-object v8, p2, v9

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " min"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v6

    .line 91
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "...until "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v8, p2, v10

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v6

    .line 92
    invoke-virtual {v6, v12}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v6

    .line 93
    new-instance v7, Ljava/lang/StringBuilder;

    aget-object v8, p2, v9

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, " min... until "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    aget-object v8, p2, v10

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/app/Notification$Builder;->setTicker(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v6

    .line 94
    invoke-virtual {v6, v5}, Landroid/app/Notification$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v2

    .line 108
    .local v2, noti:Landroid/app/Notification;
    :goto_0
    const-string v6, "notification"

    invoke-virtual {p1, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 107
    check-cast v4, Landroid/app/NotificationManager;

    .line 110
    .local v4, notificationManager:Landroid/app/NotificationManager;
    invoke-virtual {v4, v11, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 113
    const-string v6, "alarm"

    invoke-virtual {p1, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 112
    check-cast v0, Landroid/app/AlarmManager;

    .line 116
    .local v0, alarmManager:Landroid/app/AlarmManager;
    new-instance v6, Landroid/content/Intent;

    .line 117
    const-string v7, "com.RSen.LionTime.CANCEL_NOTIFICATION"

    invoke-direct {v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 115
    invoke-static {p1, v11, v6, v9}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 120
    .local v1, intent:Landroid/app/PendingIntent;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    const-wide/16 v8, 0x7530

    add-long/2addr v6, v8

    .line 119
    invoke-virtual {v0, v10, v6, v7, v1}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 122
    return-void

    .line 101
    .end local v0           #alarmManager:Landroid/app/AlarmManager;
    .end local v1           #intent:Landroid/app/PendingIntent;
    .end local v2           #noti:Landroid/app/Notification;
    .end local v4           #notificationManager:Landroid/app/NotificationManager;
    :cond_0
    new-instance v2, Landroid/app/Notification;

    new-instance v6, Ljava/lang/StringBuilder;

    aget-object v7, p2, v9

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 102
    const-string v7, " min... until "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    aget-object v7, p2, v10

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 103
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 101
    invoke-direct {v2, v12, v6, v7, v8}, Landroid/app/Notification;-><init>(ILjava/lang/CharSequence;J)V

    .line 104
    .restart local v2       #noti:Landroid/app/Notification;
    new-instance v6, Ljava/lang/StringBuilder;

    aget-object v7, p2, v9

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, " min"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "... until "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 105
    aget-object v8, p2, v10

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 104
    invoke-virtual {v2, p1, v6, v7, v5}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    goto :goto_0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .parameter "context"
    .parameter "intent"

    .prologue
    const/4 v4, 0x0

    .line 31
    invoke-static {p1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 32
    const-string v2, "notification_activated"

    const/4 v3, 0x1

    .line 31
    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 32
    if-eqz v1, :cond_0

    .line 33
    invoke-static {p1}, Lcom/RSen/LionTime/TimeTillCalculator;->getTimeTill(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v0

    .line 35
    .local v0, timeInfo:[Ljava/lang/String;
    sget-object v1, Lcom/RSen/LionTime/NotificationReceiver;->notificationTimes:[I

    .line 36
    aget-object v2, v0, v4

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 35
    invoke-static {v1, v2}, Ljava/util/Arrays;->binarySearch([II)I

    move-result v1

    if-ltz v1, :cond_1

    .line 38
    invoke-direct {p0, p1, v0}, Lcom/RSen/LionTime/NotificationReceiver;->showNotification(Landroid/content/Context;[Ljava/lang/String;)V

    .line 42
    :goto_0
    aget-object v1, v0, v4

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-direct {p0, p1, v1}, Lcom/RSen/LionTime/NotificationReceiver;->scheduleNext(Landroid/content/Context;I)V

    .line 44
    .end local v0           #timeInfo:[Ljava/lang/String;
    :cond_0
    return-void

    .line 40
    .restart local v0       #timeInfo:[Ljava/lang/String;
    :cond_1
    invoke-static {p1}, Lcom/RSen/LionTime/NotificationReceiver;->cancelNotification(Landroid/content/Context;)V

    goto :goto_0
.end method

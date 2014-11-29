.class public Lcom/RSen/LionTime/CheckScheduleUpdates;
.super Ljava/lang/Object;
.source "CheckScheduleUpdates.java"


# direct methods
.method static synthetic access$0(Landroid/content/Context;Ljava/util/Calendar;I)V
    .locals 0
    .parameter
    .parameter
    .parameter

    .prologue
    .line 96
    invoke-static {p0, p1, p2}, Lcom/RSen/LionTime/CheckScheduleUpdates;->notifyNewIrregular(Landroid/content/Context;Ljava/util/Calendar;I)V

    return-void
.end method

.method static synthetic access$1()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    invoke-static {}, Lcom/RSen/LionTime/CheckScheduleUpdates;->callServerForJSON()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static callServerForJSON()Ljava/lang/String;
    .locals 4

    .prologue
    .line 122
    :try_start_0
    new-instance v2, Ljava/net/URL;

    const-string v3, "http://lion-time.appspot.com/irregular"

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 123
    .local v2, url:Ljava/net/URL;
    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 124
    .local v0, con:Ljava/net/HttpURLConnection;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    invoke-static {v3}, Lcom/RSen/LionTime/CheckScheduleUpdates;->readStream(Ljava/io/InputStream;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 129
    .end local v0           #con:Ljava/net/HttpURLConnection;
    :goto_0
    return-object v3

    .line 125
    :catch_0
    move-exception v1

    .line 127
    .local v1, e:Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 129
    const-string v3, ""

    goto :goto_0
.end method

.method public static checkScheduleUpdates(Landroid/content/Context;)V
    .locals 3
    .parameter "context"

    .prologue
    .line 27
    new-instance v0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;

    invoke-direct {v0, p0}, Lcom/RSen/LionTime/CheckScheduleUpdates$1;-><init>(Landroid/content/Context;)V

    .line 63
    .local v0, handler:Landroid/os/Handler;
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/RSen/LionTime/CheckScheduleUpdates$2;

    invoke-direct {v2, v0}, Lcom/RSen/LionTime/CheckScheduleUpdates$2;-><init>(Landroid/os/Handler;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 73
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 75
    return-void
.end method

.method protected static notifyMultipleIrregulars(Landroid/content/Context;I)V
    .locals 7
    .parameter "context"
    .parameter "newIrregulars"

    .prologue
    .line 79
    .line 80
    const-string v2, "notification"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 79
    check-cast v1, Landroid/app/NotificationManager;

    .line 81
    .local v1, notificationManager:Landroid/app/NotificationManager;
    new-instance v0, Landroid/app/Notification;

    invoke-direct {v0}, Landroid/app/Notification;-><init>()V

    .line 82
    .local v0, notification:Landroid/app/Notification;
    iput p1, v0, Landroid/app/Notification;->number:I

    .line 83
    const v2, 0x7f020004

    iput v2, v0, Landroid/app/Notification;->icon:I

    .line 84
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 85
    const-string v3, " irregular schedules have been added..."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 84
    iput-object v2, v0, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 86
    const-string v2, "Multiple Schedule Updates"

    .line 87
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " irregular schedules have been added..."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 88
    const v4, 0x22da784

    new-instance v5, Landroid/content/Intent;

    .line 89
    const-class v6, Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-direct {v5, p0, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 90
    const/high16 v6, 0x1000

    .line 88
    invoke-static {p0, v4, v5, v6}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v4

    .line 86
    invoke-virtual {v0, p0, v2, v3, v4}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 91
    invoke-virtual {v1}, Landroid/app/NotificationManager;->cancelAll()V

    .line 92
    const v2, 0x21b57aa

    invoke-virtual {v1, v2, v0}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 94
    return-void
.end method

.method private static notifyNewIrregular(Landroid/content/Context;Ljava/util/Calendar;I)V
    .locals 10
    .parameter "context"
    .parameter "cal"
    .parameter "scheduleCode"

    .prologue
    .line 98
    new-instance v1, Ljava/text/SimpleDateFormat;

    invoke-direct {v1}, Ljava/text/SimpleDateFormat;-><init>()V

    .line 99
    .local v1, df:Ljava/text/SimpleDateFormat;
    const-string v5, "MM/dd"

    invoke-virtual {v1, v5}, Ljava/text/SimpleDateFormat;->applyPattern(Ljava/lang/String;)V

    .line 100
    invoke-virtual {p1}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, dateUpdated:Ljava/lang/String;
    invoke-static {p0, p2}, Lcom/RSen/LionTime/Schedule;->getReadableScheduleType(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v4

    .line 104
    .local v4, scheduleType:Ljava/lang/String;
    const-string v5, "notification"

    invoke-virtual {p0, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 103
    check-cast v3, Landroid/app/NotificationManager;

    .line 105
    .local v3, notificationManager:Landroid/app/NotificationManager;
    new-instance v2, Landroid/app/Notification;

    invoke-direct {v2}, Landroid/app/Notification;-><init>()V

    .line 106
    .local v2, notification:Landroid/app/Notification;
    const v5, 0x7f020004

    iput v5, v2, Landroid/app/Notification;->icon:I

    .line 107
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Schedule for "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 108
    const-string v6, " updated to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 107
    iput-object v5, v2, Landroid/app/Notification;->tickerText:Ljava/lang/CharSequence;

    .line 109
    const-string v5, "Schedule Update"

    .line 110
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Schedule for "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " updated to "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 111
    const v7, 0x22da784

    new-instance v8, Landroid/content/Intent;

    .line 112
    const-class v9, Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-direct {v8, p0, v9}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 113
    const/high16 v9, 0x1000

    .line 111
    invoke-static {p0, v7, v8, v9}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v7

    .line 109
    invoke-virtual {v2, p0, v5, v6, v7}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 115
    const/4 v5, 0x1

    invoke-virtual {p1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    const/4 v6, 0x5

    invoke-virtual {p1, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    add-int/2addr v5, v6

    .line 114
    invoke-virtual {v3, v5, v2}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 117
    return-void
.end method

.method private static readStream(Ljava/io/InputStream;)Ljava/lang/String;
    .locals 7
    .parameter "in"

    .prologue
    .line 133
    const/4 v2, 0x0

    .line 134
    .local v2, reader:Ljava/io/BufferedReader;
    const-string v4, ""

    .line 136
    .local v4, returnString:Ljava/lang/String;
    :try_start_0
    new-instance v3, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    invoke-direct {v5, p0}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v3, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 137
    .end local v2           #reader:Ljava/io/BufferedReader;
    .local v3, reader:Ljava/io/BufferedReader;
    :try_start_1
    const-string v1, ""

    .line 138
    .local v1, line:Ljava/lang/String;
    :goto_0
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4

    move-result-object v1

    if-nez v1, :cond_1

    .line 144
    if-eqz v3, :cond_3

    .line 146
    :try_start_2
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    move-object v2, v3

    .line 152
    .end local v1           #line:Ljava/lang/String;
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v2       #reader:Ljava/io/BufferedReader;
    :cond_0
    :goto_1
    return-object v4

    .line 139
    .end local v2           #reader:Ljava/io/BufferedReader;
    .restart local v1       #line:Ljava/lang/String;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    :cond_1
    :try_start_3
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    move-result-object v4

    goto :goto_0

    .line 141
    .end local v1           #line:Ljava/lang/String;
    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v2       #reader:Ljava/io/BufferedReader;
    :catch_0
    move-exception v0

    .line 142
    .local v0, e:Ljava/io/IOException;
    :goto_2
    :try_start_4
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 144
    if-eqz v2, :cond_0

    .line 146
    :try_start_5
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_1

    .line 147
    :catch_1
    move-exception v0

    .line 148
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 143
    .end local v0           #e:Ljava/io/IOException;
    :catchall_0
    move-exception v5

    .line 144
    :goto_3
    if-eqz v2, :cond_2

    .line 146
    :try_start_6
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 151
    :cond_2
    :goto_4
    throw v5

    .line 147
    :catch_2
    move-exception v0

    .line 148
    .restart local v0       #e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    .line 147
    .end local v0           #e:Ljava/io/IOException;
    .end local v2           #reader:Ljava/io/BufferedReader;
    .restart local v1       #line:Ljava/lang/String;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    :catch_3
    move-exception v0

    .line 148
    .restart local v0       #e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .end local v0           #e:Ljava/io/IOException;
    :cond_3
    move-object v2, v3

    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v2       #reader:Ljava/io/BufferedReader;
    goto :goto_1

    .line 143
    .end local v1           #line:Ljava/lang/String;
    .end local v2           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    :catchall_1
    move-exception v5

    move-object v2, v3

    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v2       #reader:Ljava/io/BufferedReader;
    goto :goto_3

    .line 141
    .end local v2           #reader:Ljava/io/BufferedReader;
    .restart local v3       #reader:Ljava/io/BufferedReader;
    :catch_4
    move-exception v0

    move-object v2, v3

    .end local v3           #reader:Ljava/io/BufferedReader;
    .restart local v2       #reader:Ljava/io/BufferedReader;
    goto :goto_2
.end method

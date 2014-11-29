.class public Lcom/RSen/LionTime/Schedule;
.super Ljava/lang/Object;
.source "Schedule.java"


# direct methods
.method public static addIrregularSchedule(Landroid/content/Context;Ljava/util/Calendar;I)V
    .locals 5
    .parameter "context"
    .parameter "cal"
    .parameter "scheduleType"

    .prologue
    .line 86
    invoke-static {p0}, Lcom/RSen/LionTime/Schedule;->readIrregularsFromFile(Landroid/content/Context;)Ljava/util/HashMap;

    move-result-object v1

    .line 87
    .local v1, irregularSchedules:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/util/Calendar;Ljava/lang/Integer;>;"
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 88
    .local v0, calSimple:Ljava/util/Calendar;
    invoke-virtual {v0}, Ljava/util/Calendar;->clear()V

    .line 89
    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Ljava/util/Calendar;->get(I)I

    move-result v2

    const/4 v3, 0x2

    invoke-virtual {p1, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    .line 90
    const/4 v4, 0x5

    invoke-virtual {p1, v4}, Ljava/util/Calendar;->get(I)I

    move-result v4

    .line 89
    invoke-virtual {v0, v2, v3, v4}, Ljava/util/Calendar;->set(III)V

    .line 92
    invoke-static {p1}, Lcom/RSen/LionTime/Schedule;->getRegularScheduleType(Ljava/util/Calendar;)I

    move-result v2

    if-eq v2, p2, :cond_0

    .line 93
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    :goto_0
    invoke-static {p0, v1}, Lcom/RSen/LionTime/Schedule;->writeIrregularsToFile(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 100
    return-void

    .line 96
    :cond_0
    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static checkIrregular(Landroid/content/Context;Ljava/util/Calendar;)I
    .locals 8
    .parameter "context"
    .parameter "cal"

    .prologue
    const/4 v4, -0x1

    .line 106
    :try_start_0
    invoke-static {p0}, Lcom/RSen/LionTime/Schedule;->readIrregularsFromFile(Landroid/content/Context;)Ljava/util/HashMap;

    move-result-object v2

    .line 107
    .local v2, irregularSchedules:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/util/Calendar;Ljava/lang/Integer;>;"
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 108
    .local v0, calSimple:Ljava/util/Calendar;
    invoke-virtual {v0}, Ljava/util/Calendar;->clear()V

    .line 109
    const/4 v5, 0x1

    invoke-virtual {p1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    const/4 v6, 0x2

    invoke-virtual {p1, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    .line 110
    const/4 v7, 0x5

    invoke-virtual {p1, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    .line 109
    invoke-virtual {v0, v5, v6, v7}, Ljava/util/Calendar;->set(III)V

    .line 111
    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 112
    .local v3, scheduleCode:Ljava/lang/Object;
    if-eqz v3, :cond_0

    .line 113
    check-cast v3, Ljava/lang/Integer;

    .end local v3           #scheduleCode:Ljava/lang/Object;
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    .line 119
    .end local v0           #calSimple:Ljava/util/Calendar;
    .end local v2           #irregularSchedules:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/util/Calendar;Ljava/lang/Integer;>;"
    :cond_0
    :goto_0
    return v4

    .line 118
    :catch_0
    move-exception v1

    .line 119
    .local v1, e:Ljava/lang/Exception;
    goto :goto_0
.end method

.method public static cleanIrregularSchedules(Landroid/content/Context;)V
    .locals 6
    .parameter "context"

    .prologue
    .line 30
    invoke-static {p0}, Lcom/RSen/LionTime/Schedule;->readIrregularsFromFile(Landroid/content/Context;)Ljava/util/HashMap;

    move-result-object v2

    .line 31
    .local v2, irregularSchedules:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/util/Calendar;Ljava/lang/Integer;>;"
    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 32
    .local v1, dates:Ljava/util/Set;,"Ljava/util/Set<Ljava/util/Calendar;>;"
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v3

    .line 33
    .local v3, now:Ljava/util/Calendar;
    const/4 v4, 0x5

    const/4 v5, -0x1

    invoke-virtual {v3, v4, v5}, Ljava/util/Calendar;->add(II)V

    .line 34
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 39
    invoke-static {p0, v2}, Lcom/RSen/LionTime/Schedule;->writeIrregularsToFile(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 40
    return-void

    .line 34
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Calendar;

    .line 35
    .local v0, date:Ljava/util/Calendar;
    invoke-virtual {v3, v0}, Ljava/util/Calendar;->after(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 36
    invoke-virtual {v2, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static getReadableScheduleType(Landroid/content/Context;I)Ljava/lang/String;
    .locals 3
    .parameter "context"
    .parameter "scheduleType"

    .prologue
    .line 44
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 45
    const/high16 v2, 0x7f05

    .line 44
    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, schedules:[Ljava/lang/String;
    aget-object v1, v0, p1

    return-object v1
.end method

.method public static getReadableScheduleType(Landroid/content/Context;Ljava/util/Calendar;)Ljava/lang/String;
    .locals 4
    .parameter "context"
    .parameter "cal"

    .prologue
    .line 22
    invoke-static {p0, p1}, Lcom/RSen/LionTime/Schedule;->getScheduleType(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v0

    .line 23
    .local v0, scheduleType:I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 24
    const/high16 v3, 0x7f05

    .line 23
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    .line 25
    .local v1, schedules:[Ljava/lang/String;
    aget-object v2, v1, v0

    return-object v2
.end method

.method private static getRegularScheduleType(Ljava/util/Calendar;)I
    .locals 5
    .parameter "cal"

    .prologue
    const/4 v4, 0x7

    const/4 v2, 0x4

    const/4 v1, 0x1

    .line 50
    invoke-virtual {p0, v4}, Ljava/util/Calendar;->get(I)I

    move-result v0

    .line 51
    .local v0, dayOfWeek:I
    if-ne v0, v2, :cond_0

    .line 61
    :goto_0
    return v1

    .line 54
    :cond_0
    const/4 v3, 0x5

    if-ne v0, v3, :cond_1

    .line 56
    const/4 v1, 0x2

    goto :goto_0

    .line 57
    :cond_1
    if-eq v0, v4, :cond_2

    .line 58
    if-ne v0, v1, :cond_3

    :cond_2
    move v1, v2

    .line 59
    goto :goto_0

    .line 61
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getScheduleTimes(Landroid/content/Context;)[I
    .locals 7
    .parameter "context"

    .prologue
    const/4 v6, -0x1

    const/4 v5, 0x7

    .line 157
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 159
    .local v1, now:Ljava/util/Calendar;
    invoke-static {p0, v1}, Lcom/RSen/LionTime/Schedule;->checkIrregular(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v0

    .line 160
    .local v0, irregularCode:I
    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    .line 161
    const/16 v3, 0xa

    new-array v2, v3, [I

    fill-array-data v2, :array_0

    .line 173
    :goto_0
    return-object v2

    .line 162
    :cond_0
    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v3

    const/4 v4, 0x4

    if-ne v3, v4, :cond_1

    if-eq v0, v6, :cond_2

    .line 163
    :cond_1
    const/4 v3, 0x1

    if-ne v0, v3, :cond_3

    .line 165
    :cond_2
    new-array v2, v5, [I

    fill-array-data v2, :array_1

    .line 166
    .local v2, schedule:[I
    goto :goto_0

    .end local v2           #schedule:[I
    :cond_3
    invoke-virtual {v1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v3

    const/4 v4, 0x5

    if-ne v3, v4, :cond_4

    if-eq v0, v6, :cond_5

    .line 167
    :cond_4
    const/4 v3, 0x2

    if-ne v0, v3, :cond_6

    .line 169
    :cond_5
    new-array v2, v5, [I

    fill-array-data v2, :array_2

    .line 170
    .restart local v2       #schedule:[I
    goto :goto_0

    .line 171
    .end local v2           #schedule:[I
    :cond_6
    const/16 v3, 0x9

    new-array v2, v3, [I

    fill-array-data v2, :array_3

    .restart local v2       #schedule:[I
    goto :goto_0

    .line 161
    nop

    :array_0
    .array-data 0x4
        0xeat 0x1t 0x0t 0x0t
        0x1ct 0x2t 0x0t 0x0t
        0x4et 0x2t 0x0t 0x0t
        0x80t 0x2t 0x0t 0x0t
        0xb2t 0x2t 0x0t 0x0t
        0xe4t 0x2t 0x0t 0x0t
        0x16t 0x3t 0x0t 0x0t
        0x2at 0x3t 0x0t 0x0t
        0x5ct 0x3t 0x0t 0x0t
        0x89t 0x3t 0x0t 0x0t
    .end array-data

    .line 165
    :array_1
    .array-data 0x4
        0xeat 0x1t 0x0t 0x0t
        0x3ft 0x2t 0x0t 0x0t
        0x8ft 0x2t 0x0t 0x0t
        0xdft 0x2t 0x0t 0x0t
        0x7t 0x3t 0x0t 0x0t
        0x3et 0x3t 0x0t 0x0t
        0x89t 0x3t 0x0t 0x0t
    .end array-data

    .line 169
    :array_2
    .array-data 0x4
        0xeat 0x1t 0x0t 0x0t
        0x3ft 0x2t 0x0t 0x0t
        0x8ft 0x2t 0x0t 0x0t
        0xdft 0x2t 0x0t 0x0t
        0x7t 0x3t 0x0t 0x0t
        0x57t 0x3t 0x0t 0x0t
        0x89t 0x3t 0x0t 0x0t
    .end array-data

    .line 171
    :array_3
    .array-data 0x4
        0xeat 0x1t 0x0t 0x0t
        0x1ct 0x2t 0x0t 0x0t
        0x5dt 0x2t 0x0t 0x0t
        0x8ft 0x2t 0x0t 0x0t
        0xc1t 0x2t 0x0t 0x0t
        0xf3t 0x2t 0x0t 0x0t
        0x25t 0x3t 0x0t 0x0t
        0x57t 0x3t 0x0t 0x0t
        0x84t 0x3t 0x0t 0x0t
    .end array-data
.end method

.method public static getScheduleType(Landroid/content/Context;Ljava/util/Calendar;)I
    .locals 6
    .parameter "context"
    .parameter "cal"

    .prologue
    const/4 v5, 0x7

    const/4 v3, 0x4

    const/4 v2, 0x1

    .line 66
    invoke-static {p0, p1}, Lcom/RSen/LionTime/Schedule;->checkIrregular(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v1

    .line 67
    .local v1, irregularCode:I
    invoke-virtual {p1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v0

    .line 68
    .local v0, dayOfWeek:I
    const/4 v4, -0x1

    if-eq v1, v4, :cond_0

    .line 80
    .end local v1           #irregularCode:I
    :goto_0
    return v1

    .line 70
    .restart local v1       #irregularCode:I
    :cond_0
    if-ne v0, v3, :cond_1

    move v1, v2

    .line 72
    goto :goto_0

    .line 73
    :cond_1
    const/4 v4, 0x5

    if-ne v0, v4, :cond_2

    .line 75
    const/4 v1, 0x2

    goto :goto_0

    .line 76
    :cond_2
    if-eq v0, v5, :cond_3

    .line 77
    if-ne v0, v2, :cond_4

    :cond_3
    move v1, v3

    .line 78
    goto :goto_0

    .line 80
    :cond_4
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private static readIrregularsFromFile(Landroid/content/Context;)Ljava/util/HashMap;
    .locals 4
    .parameter "context"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/util/Calendar;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 127
    :try_start_0
    new-instance v1, Ljava/io/ObjectInputStream;

    .line 128
    const-string v3, "irregular_schedules"

    invoke-virtual {p0, v3}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v3

    .line 127
    invoke-direct {v1, v3}, Ljava/io/ObjectInputStream;-><init>(Ljava/io/InputStream;)V

    .line 130
    .local v1, fis:Ljava/io/ObjectInputStream;
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v2

    .line 131
    .local v2, input:Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/io/ObjectInputStream;->close()V

    .line 132
    check-cast v2, Ljava/util/HashMap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    .end local v1           #fis:Ljava/io/ObjectInputStream;
    .end local v2           #input:Ljava/lang/Object;
    :goto_0
    return-object v2

    .line 133
    :catch_0
    move-exception v0

    .line 134
    .local v0, e:Ljava/lang/Exception;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    goto :goto_0
.end method

.method private static writeIrregularsToFile(Landroid/content/Context;Ljava/util/HashMap;)V
    .locals 5
    .parameter "context"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/util/Calendar;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, irregulars:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/util/Calendar;Ljava/lang/Integer;>;"
    const/4 v4, 0x0

    .line 142
    :try_start_0
    new-instance v1, Ljava/io/ObjectOutputStream;

    .line 143
    const-string v2, "irregular_schedules"

    .line 144
    const/4 v3, 0x0

    .line 143
    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    .line 142
    invoke-direct {v1, v2}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 145
    .local v1, stream:Ljava/io/ObjectOutputStream;
    invoke-virtual {v1, p1}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    .line 146
    invoke-virtual {v1}, Ljava/io/ObjectOutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 154
    .end local v1           #stream:Ljava/io/ObjectOutputStream;
    :goto_0
    return-void

    .line 147
    :catch_0
    move-exception v0

    .line 150
    .local v0, e:Ljava/lang/Exception;
    const-string v2, "Add irregular schedule operation failed, please try again..."

    .line 148
    invoke-static {p0, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 151
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

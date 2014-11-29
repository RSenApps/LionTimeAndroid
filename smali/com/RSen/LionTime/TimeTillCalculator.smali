.class public Lcom/RSen/LionTime/TimeTillCalculator;
.super Ljava/lang/Object;
.source "TimeTillCalculator.java"


# direct methods
.method public static getTimeTill(Landroid/content/Context;)[Ljava/lang/String;
    .locals 12
    .parameter "context"

    .prologue
    .line 21
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 23
    .local v2, now:Ljava/util/Calendar;
    const/16 v9, 0xb

    invoke-virtual {v2, v9}, Ljava/util/Calendar;->get(I)I

    move-result v9

    mul-int/lit8 v9, v9, 0x3c

    .line 24
    const/16 v10, 0xc

    invoke-virtual {v2, v10}, Ljava/util/Calendar;->get(I)I

    move-result v10

    .line 23
    add-int v3, v9, v10

    .line 25
    .local v3, nowMin:I
    const/4 v8, -0x1

    .line 26
    .local v8, timeTill:I
    const-string v1, "Period "

    .line 28
    .local v1, nextPeriod:Ljava/lang/String;
    invoke-static {p0}, Lcom/RSen/LionTime/Schedule;->getScheduleTimes(Landroid/content/Context;)[I

    move-result-object v6

    .line 29
    .local v6, schedule:[I
    invoke-static {p0, v2}, Lcom/RSen/LionTime/Schedule;->getScheduleType(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v7

    .line 30
    .local v7, scheduleType:I
    const/4 v9, 0x4

    if-ne v7, v9, :cond_0

    .line 31
    const/4 v9, 0x2

    new-array v5, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "-1"

    aput-object v10, v5, v9

    const/4 v9, 0x1

    const-string v10, "No School"

    aput-object v10, v5, v9

    .line 89
    :goto_0
    return-object v5

    .line 33
    :cond_0
    const/4 v0, 0x0

    .local v0, ii:I
    :goto_1
    array-length v9, v6

    if-lt v0, v9, :cond_1

    .line 88
    :goto_2
    const/4 v9, 0x2

    new-array v5, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v5, v9

    const/4 v9, 0x1

    aput-object v1, v5, v9

    .line 89
    .local v5, returnArray:[Ljava/lang/String;
    goto :goto_0

    .line 34
    .end local v5           #returnArray:[Ljava/lang/String;
    :cond_1
    aget v9, v6, v0

    if-le v9, v3, :cond_a

    .line 35
    aget v9, v6, v0

    sub-int v8, v9, v3

    .line 37
    const/4 v9, 0x3

    if-ne v7, v9, :cond_3

    .line 38
    const/16 v9, 0xa

    new-array v4, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "1"

    aput-object v10, v4, v9

    const/4 v9, 0x1

    const-string v10, "2"

    aput-object v10, v4, v9

    const/4 v9, 0x2

    const-string v10, "3"

    aput-object v10, v4, v9

    const/4 v9, 0x3

    const-string v10, "4"

    aput-object v10, v4, v9

    const/4 v9, 0x4

    const-string v10, "5"

    aput-object v10, v4, v9

    const/4 v9, 0x5

    .line 39
    const-string v10, "6A"

    aput-object v10, v4, v9

    const/4 v9, 0x6

    const-string v10, "6B"

    aput-object v10, v4, v9

    const/4 v9, 0x7

    const-string v10, "7"

    aput-object v10, v4, v9

    const/16 v9, 0x8

    const-string v10, "8"

    aput-object v10, v4, v9

    const/16 v9, 0x9

    const-string v10, "End of School"

    aput-object v10, v4, v9

    .line 40
    .local v4, periods:[Ljava/lang/String;
    array-length v9, v4

    add-int/lit8 v9, v9, -0x1

    if-ne v0, v9, :cond_2

    .line 43
    aget-object v1, v4, v0

    .line 44
    goto :goto_2

    .line 45
    :cond_2
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v10, v4, v0

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 48
    goto :goto_2

    .end local v4           #periods:[Ljava/lang/String;
    :cond_3
    const/4 v9, 0x1

    if-ne v7, v9, :cond_5

    .line 49
    const/4 v9, 0x7

    new-array v4, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "1"

    aput-object v10, v4, v9

    const/4 v9, 0x1

    const-string v10, "3"

    aput-object v10, v4, v9

    const/4 v9, 0x2

    const-string v10, "5"

    aput-object v10, v4, v9

    const/4 v9, 0x3

    const-string v10, "Lunch"

    aput-object v10, v4, v9

    const/4 v9, 0x4

    .line 50
    const-string v10, "Assembly"

    aput-object v10, v4, v9

    const/4 v9, 0x5

    const-string v10, "7"

    aput-object v10, v4, v9

    const/4 v9, 0x6

    const-string v10, "End of School"

    aput-object v10, v4, v9

    .line 51
    .restart local v4       #periods:[Ljava/lang/String;
    array-length v9, v4

    add-int/lit8 v9, v9, -0x1

    if-ne v0, v9, :cond_4

    .line 54
    aget-object v1, v4, v0

    .line 55
    goto/16 :goto_2

    .line 56
    :cond_4
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v10, v4, v0

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 59
    goto/16 :goto_2

    .end local v4           #periods:[Ljava/lang/String;
    :cond_5
    const/4 v9, 0x2

    if-ne v7, v9, :cond_7

    .line 60
    const/4 v9, 0x7

    new-array v4, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "2"

    aput-object v10, v4, v9

    const/4 v9, 0x1

    const-string v10, "4"

    aput-object v10, v4, v9

    const/4 v9, 0x2

    const-string v10, "6"

    aput-object v10, v4, v9

    const/4 v9, 0x3

    const-string v10, "Lunch"

    aput-object v10, v4, v9

    const/4 v9, 0x4

    .line 61
    const-string v10, "8"

    aput-object v10, v4, v9

    const/4 v9, 0x5

    const-string v10, "Activity"

    aput-object v10, v4, v9

    const/4 v9, 0x6

    const-string v10, "End of School"

    aput-object v10, v4, v9

    .line 62
    .restart local v4       #periods:[Ljava/lang/String;
    array-length v9, v4

    add-int/lit8 v9, v9, -0x1

    if-ne v0, v9, :cond_6

    .line 65
    aget-object v1, v4, v0

    .line 66
    goto/16 :goto_2

    .line 67
    :cond_6
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v10, v4, v0

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 69
    goto/16 :goto_2

    .line 71
    .end local v4           #periods:[Ljava/lang/String;
    :cond_7
    add-int/lit8 v9, v0, 0x1

    const/16 v10, 0x8

    if-le v9, v10, :cond_8

    .line 72
    const-string v1, "End of School"

    .line 73
    goto/16 :goto_2

    .line 75
    :cond_8
    const/4 v9, 0x2

    if-ne v0, v9, :cond_9

    rsub-int v9, v3, 0x24e

    if-lez v9, :cond_9

    .line 76
    rsub-int v8, v3, 0x24e

    .line 77
    const-string v1, "Advisory"

    .line 78
    goto/16 :goto_2

    .line 81
    :cond_9
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    add-int/lit8 v10, v0, 0x1

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 83
    goto/16 :goto_2

    .line 33
    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1
.end method

.class Lcom/RSen/LionTime/CheckScheduleUpdates$1;
.super Landroid/os/Handler;
.source "CheckScheduleUpdates.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/CheckScheduleUpdates;->checkScheduleUpdates(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;->val$context:Landroid/content/Context;

    .line 27
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 11
    .parameter "msg"

    .prologue
    .line 30
    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    .line 33
    .local v2, gson:Lcom/google/gson/Gson;
    iget-object v7, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v7, Ljava/lang/String;

    .line 34
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    .line 32
    invoke-virtual {v2, v7, v8}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/HashMap;

    .line 35
    .local v3, hashMap:Ljava/util/HashMap;,"Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Double;>;"
    invoke-virtual {v3}, Ljava/util/HashMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_1

    .line 37
    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    .line 38
    .local v6, set:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v4, 0x0

    .line 39
    .local v4, newIrregulars:I
    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_2

    .line 55
    const/4 v7, 0x3

    if-le v4, v7, :cond_1

    .line 56
    iget-object v7, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;->val$context:Landroid/content/Context;

    invoke-static {v7, v4}, Lcom/RSen/LionTime/CheckScheduleUpdates;->notifyMultipleIrregulars(Landroid/content/Context;I)V

    .line 61
    .end local v4           #newIrregulars:I
    .end local v6           #set:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    return-void

    .line 39
    .restart local v4       #newIrregulars:I
    .restart local v6       #set:Ljava/util/Set;,"Ljava/util/Set<Ljava/lang/String;>;"
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 40
    .local v1, calString:Ljava/lang/String;
    const-class v7, Ljava/util/Calendar;

    invoke-virtual {v2, v1, v7}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Calendar;

    .line 43
    .local v0, cal:Ljava/util/Calendar;
    invoke-virtual {v3, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Double;

    invoke-virtual {v7}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v9

    .line 42
    invoke-static {v9, v10}, Ljava/lang/Math;->round(D)J

    move-result-wide v9

    long-to-int v5, v9

    .line 44
    .local v5, scheduleCode:I
    iget-object v7, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;->val$context:Landroid/content/Context;

    invoke-static {v7, v0}, Lcom/RSen/LionTime/Schedule;->checkIrregular(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v7

    if-eq v7, v5, :cond_0

    .line 46
    iget-object v7, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;->val$context:Landroid/content/Context;

    invoke-static {v7, v0, v5}, Lcom/RSen/LionTime/Schedule;->addIrregularSchedule(Landroid/content/Context;Ljava/util/Calendar;I)V

    .line 48
    const/4 v7, 0x4

    if-ge v4, v7, :cond_3

    .line 50
    iget-object v7, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$1;->val$context:Landroid/content/Context;

    .line 49
    #calls: Lcom/RSen/LionTime/CheckScheduleUpdates;->notifyNewIrregular(Landroid/content/Context;Ljava/util/Calendar;I)V
    invoke-static {v7, v0, v5}, Lcom/RSen/LionTime/CheckScheduleUpdates;->access$0(Landroid/content/Context;Ljava/util/Calendar;I)V

    .line 52
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.class public Lcom/RSen/LionTime/MyDashClock;
.super Lcom/google/android/apps/dashclock/api/DashClockExtension;
.source "MyDashClock.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/google/android/apps/dashclock/api/DashClockExtension;-><init>()V

    return-void
.end method


# virtual methods
.method protected onInitialize(Z)V
    .locals 1
    .parameter "isReconnect"

    .prologue
    .line 29
    invoke-super {p0, p1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->onInitialize(Z)V

    .line 30
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/RSen/LionTime/MyDashClock;->setUpdateWhenScreenOn(Z)V

    .line 31
    return-void
.end method

.method protected onUpdateData(I)V
    .locals 6
    .parameter "reason"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 10
    invoke-static {p0}, Lcom/RSen/LionTime/TimeTillCalculator;->getTimeTill(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v1

    .line 12
    .local v1, timeInfo:[Ljava/lang/String;
    aget-object v2, v1, v4

    const-string v3, "-1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 14
    new-instance v2, Ljava/lang/StringBuilder;

    aget-object v3, v1, v4

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " min until "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v3, v1, v5

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 15
    .local v0, text:Ljava/lang/String;
    new-instance v2, Lcom/google/android/apps/dashclock/api/ExtensionData;

    invoke-direct {v2}, Lcom/google/android/apps/dashclock/api/ExtensionData;-><init>()V

    .line 16
    invoke-virtual {v2, v5}, Lcom/google/android/apps/dashclock/api/ExtensionData;->visible(Z)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 17
    const v3, 0x7f020002

    invoke-virtual {v2, v3}, Lcom/google/android/apps/dashclock/api/ExtensionData;->icon(I)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 18
    invoke-virtual {v2, v0}, Lcom/google/android/apps/dashclock/api/ExtensionData;->status(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 19
    invoke-virtual {v2, v0}, Lcom/google/android/apps/dashclock/api/ExtensionData;->expandedTitle(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 20
    const-string v3, "Click to view schedule..."

    invoke-virtual {v2, v3}, Lcom/google/android/apps/dashclock/api/ExtensionData;->expandedBody(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 21
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-direct {v3, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v2, v3}, Lcom/google/android/apps/dashclock/api/ExtensionData;->clickIntent(Landroid/content/Intent;)Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-result-object v2

    .line 15
    invoke-virtual {p0, v2}, Lcom/RSen/LionTime/MyDashClock;->publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V

    .line 26
    .end local v0           #text:Ljava/lang/String;
    :goto_0
    return-void

    .line 23
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/RSen/LionTime/MyDashClock;->publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V

    goto :goto_0
.end method

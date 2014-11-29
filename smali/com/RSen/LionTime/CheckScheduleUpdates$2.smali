.class Lcom/RSen/LionTime/CheckScheduleUpdates$2;
.super Ljava/lang/Object;
.source "CheckScheduleUpdates.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/CheckScheduleUpdates;->checkScheduleUpdates(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$handler:Landroid/os/Handler;


# direct methods
.method constructor <init>(Landroid/os/Handler;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$2;->val$handler:Landroid/os/Handler;

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 67
    invoke-static {}, Landroid/os/Message;->obtain()Landroid/os/Message;

    move-result-object v0

    .line 68
    .local v0, msg:Landroid/os/Message;
    #calls: Lcom/RSen/LionTime/CheckScheduleUpdates;->callServerForJSON()Ljava/lang/String;
    invoke-static {}, Lcom/RSen/LionTime/CheckScheduleUpdates;->access$1()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 69
    iget-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    const-string v2, ""

    if-eq v1, v2, :cond_0

    .line 70
    iget-object v1, p0, Lcom/RSen/LionTime/CheckScheduleUpdates$2;->val$handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 72
    :cond_0
    return-void
.end method

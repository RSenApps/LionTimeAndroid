.class Lcom/google/android/apps/dashclock/api/DashClockExtension$1;
.super Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;
.source "DashClockExtension.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/apps/dashclock/api/DashClockExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;


# direct methods
.method constructor <init>(Lcom/google/android/apps/dashclock/api/DashClockExtension;)V
    .locals 0
    .parameter

    .prologue
    .line 209
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    invoke-direct {p0}, Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onInitialize(Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;Z)V
    .locals 2
    .parameter "host"
    .parameter "isReconnect"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 213
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    const-string v1, "com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA"

    invoke-virtual {v0, v1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 215
    new-instance v0, Ljava/lang/SecurityException;

    const-string v1, "Caller does not have the READ_EXTENSION_DATA permission."

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 219
    :cond_0
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    #setter for: Lcom/google/android/apps/dashclock/api/DashClockExtension;->mHost:Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;
    invoke-static {v0, p1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->access$002(Lcom/google/android/apps/dashclock/api/DashClockExtension;Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;)Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    .line 221
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    #getter for: Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z
    invoke-static {v0}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->access$100(Lcom/google/android/apps/dashclock/api/DashClockExtension;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 222
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    invoke-virtual {v0, p2}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->onInitialize(Z)V

    .line 223
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    const/4 v1, 0x1

    #setter for: Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z
    invoke-static {v0, v1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->access$102(Lcom/google/android/apps/dashclock/api/DashClockExtension;Z)Z

    .line 225
    :cond_1
    return-void
.end method

.method public onUpdate(I)V
    .locals 2
    .parameter "reason"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    const-string v1, "com.google.android.apps.dashclock.permission.READ_EXTENSION_DATA"

    invoke-virtual {v0, v1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 231
    new-instance v0, Ljava/lang/SecurityException;

    const-string v1, "Caller does not have the READ_EXTENSION_DATA permission."

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    #getter for: Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z
    invoke-static {v0}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->access$100(Lcom/google/android/apps/dashclock/api/DashClockExtension;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 246
    :goto_0
    return-void

    .line 240
    :cond_1
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    #getter for: Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->access$200(Lcom/google/android/apps/dashclock/api/DashClockExtension;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;

    invoke-direct {v1, p0, p1}, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;-><init>(Lcom/google/android/apps/dashclock/api/DashClockExtension$1;I)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

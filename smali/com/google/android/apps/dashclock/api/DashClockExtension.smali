.class public abstract Lcom/google/android/apps/dashclock/api/DashClockExtension;
.super Landroid/app/Service;
.source "DashClockExtension.java"


# instance fields
.field private mBinder:Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;

.field private mHost:Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

.field private mInitialized:Z

.field private volatile mServiceHandler:Landroid/os/Handler;

.field private volatile mServiceLooper:Landroid/os/Looper;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 184
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 177
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z

    .line 209
    new-instance v0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;

    invoke-direct {v0, p0}, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;-><init>(Lcom/google/android/apps/dashclock/api/DashClockExtension;)V

    iput-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mBinder:Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;

    .line 185
    return-void
.end method

.method static synthetic access$002(Lcom/google/android/apps/dashclock/api/DashClockExtension;Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;)Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;
    .locals 0
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 122
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mHost:Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    return-object p1
.end method

.method static synthetic access$100(Lcom/google/android/apps/dashclock/api/DashClockExtension;)Z
    .locals 1
    .parameter "x0"

    .prologue
    .line 122
    iget-boolean v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z

    return v0
.end method

.method static synthetic access$102(Lcom/google/android/apps/dashclock/api/DashClockExtension;Z)Z
    .locals 0
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 122
    iput-boolean p1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mInitialized:Z

    return p1
.end method

.method static synthetic access$200(Lcom/google/android/apps/dashclock/api/DashClockExtension;)Landroid/os/Handler;
    .locals 1
    .parameter "x0"

    .prologue
    .line 122
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public final onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .parameter "intent"

    .prologue
    .line 206
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mBinder:Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;

    return-object v0
.end method

.method public onCreate()V
    .locals 3

    .prologue
    .line 189
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 190
    new-instance v0, Landroid/os/HandlerThread;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DashClockExtension:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 192
    .local v0, thread:Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 194
    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceLooper:Landroid/os/Looper;

    .line 195
    new-instance v1, Landroid/os/Handler;

    iget-object v2, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceLooper:Landroid/os/Looper;

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceHandler:Landroid/os/Handler;

    .line 196
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 200
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 201
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mServiceLooper:Landroid/os/Looper;

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    .line 202
    return-void
.end method

.method protected onInitialize(Z)V
    .locals 0
    .parameter "isReconnect"

    .prologue
    .line 259
    return-void
.end method

.method protected abstract onUpdateData(I)V
.end method

.method protected final publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V
    .locals 3
    .parameter "data"

    .prologue
    .line 285
    :try_start_0
    iget-object v1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mHost:Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    invoke-interface {v1, p1}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;->publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 289
    :goto_0
    return-void

    .line 286
    :catch_0
    move-exception v0

    .line 287
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "DashClockExtension"

    const-string v2, "Couldn\'t publish updated extension data."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected final setUpdateWhenScreenOn(Z)V
    .locals 3
    .parameter "updateWhenScreenOn"

    .prologue
    .line 319
    :try_start_0
    iget-object v1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension;->mHost:Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    invoke-interface {v1, p1}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;->setUpdateWhenScreenOn(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 323
    :goto_0
    return-void

    .line 320
    :catch_0
    move-exception v0

    .line 321
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "DashClockExtension"

    const-string v2, "Couldn\'t set the extension to update upon ACTION_SCREEN_ON."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.class public interface abstract Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;
.super Ljava/lang/Object;
.source "IExtensionHost.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub;
    }
.end annotation


# virtual methods
.method public abstract addWatchContentUris([Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract setUpdateWhenScreenOn(Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

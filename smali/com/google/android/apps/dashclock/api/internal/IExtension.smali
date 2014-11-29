.class public interface abstract Lcom/google/android/apps/dashclock/api/internal/IExtension;
.super Ljava/lang/Object;
.source "IExtension.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/apps/dashclock/api/internal/IExtension$Stub;
    }
.end annotation


# virtual methods
.method public abstract onInitialize(Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method public abstract onUpdate(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

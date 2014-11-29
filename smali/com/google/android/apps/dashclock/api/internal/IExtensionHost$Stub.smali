.class public abstract Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub;
.super Landroid/os/Binder;
.source "IExtensionHost.java"

# interfaces
.implements Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub$Proxy;
    }
.end annotation


# direct methods
.method public static asInterface(Landroid/os/IBinder;)Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;
    .locals 2
    .parameter "obj"

    .prologue
    .line 23
    if-nez p0, :cond_0

    .line 24
    const/4 v0, 0x0

    .line 30
    :goto_0
    return-object v0

    .line 26
    :cond_0
    const-string v1, "com.google.android.apps.dashclock.api.internal.IExtensionHost"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 27
    .local v0, iin:Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    if-eqz v1, :cond_1

    .line 28
    check-cast v0, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost;

    goto :goto_0

    .line 30
    :cond_1
    new-instance v0, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub$Proxy;

    .end local v0           #iin:Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 3
    .parameter "code"
    .parameter "data"
    .parameter "reply"
    .parameter "flags"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 38
    sparse-switch p1, :sswitch_data_0

    .line 75
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v1

    :goto_0
    return v1

    .line 42
    :sswitch_0
    const-string v2, "com.google.android.apps.dashclock.api.internal.IExtensionHost"

    invoke-virtual {p3, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 47
    :sswitch_1
    const-string v2, "com.google.android.apps.dashclock.api.internal.IExtensionHost"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 49
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_0

    .line 50
    sget-object v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v2, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/apps/dashclock/api/ExtensionData;

    .line 55
    .local v0, _arg0:Lcom/google/android/apps/dashclock/api/ExtensionData;
    :goto_1
    invoke-virtual {p0, v0}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub;->publishUpdate(Lcom/google/android/apps/dashclock/api/ExtensionData;)V

    goto :goto_0

    .line 53
    .end local v0           #_arg0:Lcom/google/android/apps/dashclock/api/ExtensionData;
    :cond_0
    const/4 v0, 0x0

    .restart local v0       #_arg0:Lcom/google/android/apps/dashclock/api/ExtensionData;
    goto :goto_1

    .line 60
    .end local v0           #_arg0:Lcom/google/android/apps/dashclock/api/ExtensionData;
    :sswitch_2
    const-string v2, "com.google.android.apps.dashclock.api.internal.IExtensionHost"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 62
    invoke-virtual {p2}, Landroid/os/Parcel;->createStringArray()[Ljava/lang/String;

    move-result-object v0

    .line 63
    .local v0, _arg0:[Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub;->addWatchContentUris([Ljava/lang/String;)V

    goto :goto_0

    .line 68
    .end local v0           #_arg0:[Ljava/lang/String;
    :sswitch_3
    const-string v2, "com.google.android.apps.dashclock.api.internal.IExtensionHost"

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 70
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_1

    move v0, v1

    .line 71
    .local v0, _arg0:Z
    :goto_2
    invoke-virtual {p0, v0}, Lcom/google/android/apps/dashclock/api/internal/IExtensionHost$Stub;->setUpdateWhenScreenOn(Z)V

    goto :goto_0

    .line 70
    .end local v0           #_arg0:Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_2

    .line 38
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x2 -> :sswitch_2
        0x3 -> :sswitch_3
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method

.class Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;
.super Ljava/lang/Object;
.source "DashClockExtension.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->onUpdate(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/android/apps/dashclock/api/DashClockExtension$1;

.field final synthetic val$reason:I


# direct methods
.method constructor <init>(Lcom/google/android/apps/dashclock/api/DashClockExtension$1;I)V
    .locals 0
    .parameter
    .parameter

    .prologue
    .line 240
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;->this$1:Lcom/google/android/apps/dashclock/api/DashClockExtension$1;

    iput p2, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;->val$reason:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 243
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;->this$1:Lcom/google/android/apps/dashclock/api/DashClockExtension$1;

    iget-object v0, v0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1;->this$0:Lcom/google/android/apps/dashclock/api/DashClockExtension;

    iget v1, p0, Lcom/google/android/apps/dashclock/api/DashClockExtension$1$1;->val$reason:I

    invoke-virtual {v0, v1}, Lcom/google/android/apps/dashclock/api/DashClockExtension;->onUpdateData(I)V

    .line 244
    return-void
.end method

.class Lcom/RSen/LionTime/ChangeScheduleActivity$4;
.super Ljava/lang/Object;
.source "ChangeScheduleActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/ChangeScheduleActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$4;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .parameter "dialog"

    .prologue
    .line 76
    iget-object v0, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$4;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    invoke-virtual {v0}, Lcom/RSen/LionTime/ChangeScheduleActivity;->finish()V

    .line 77
    return-void
.end method

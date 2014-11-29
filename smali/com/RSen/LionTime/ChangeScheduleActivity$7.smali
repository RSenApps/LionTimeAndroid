.class Lcom/RSen/LionTime/ChangeScheduleActivity$7;
.super Ljava/lang/Object;
.source "ChangeScheduleActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/ChangeScheduleActivity;->showConfirmationDialog(Ljava/util/Calendar;I)Z
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
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$7;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .parameter "dialog"

    .prologue
    .line 120
    iget-object v0, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$7;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    invoke-virtual {v0}, Lcom/RSen/LionTime/ChangeScheduleActivity;->finish()V

    .line 121
    return-void
.end method

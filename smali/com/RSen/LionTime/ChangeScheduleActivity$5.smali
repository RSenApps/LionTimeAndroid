.class Lcom/RSen/LionTime/ChangeScheduleActivity$5;
.super Ljava/lang/Object;
.source "ChangeScheduleActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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

.field private final synthetic val$schedule:I

.field private final synthetic val$selectedDate:Ljava/util/Calendar;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Ljava/util/Calendar;I)V
    .locals 0
    .parameter
    .parameter
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    iput-object p2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->val$selectedDate:Ljava/util/Calendar;

    iput p3, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->val$schedule:I

    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .parameter "dialog"
    .parameter "which"

    .prologue
    .line 105
    iget-object v0, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    iget-object v1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->val$selectedDate:Ljava/util/Calendar;

    .line 106
    iget v2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->val$schedule:I

    .line 104
    invoke-static {v0, v1, v2}, Lcom/RSen/LionTime/Schedule;->addIrregularSchedule(Landroid/content/Context;Ljava/util/Calendar;I)V

    .line 107
    iget-object v0, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.RSen.LionTime.NEW_DAY"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/RSen/LionTime/ChangeScheduleActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 108
    iget-object v0, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$5;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    invoke-virtual {v0}, Lcom/RSen/LionTime/ChangeScheduleActivity;->finish()V

    .line 109
    return-void
.end method

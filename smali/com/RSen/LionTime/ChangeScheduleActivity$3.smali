.class Lcom/RSen/LionTime/ChangeScheduleActivity$3;
.super Ljava/lang/Object;
.source "ChangeScheduleActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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

.field private final synthetic val$datePicker:Landroid/widget/DatePicker;

.field private final synthetic val$scheduleSpinner:Landroid/widget/Spinner;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Landroid/widget/DatePicker;Landroid/widget/Spinner;)V
    .locals 0
    .parameter
    .parameter
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    iput-object p2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$datePicker:Landroid/widget/DatePicker;

    iput-object p3, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$scheduleSpinner:Landroid/widget/Spinner;

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .parameter "dialog"
    .parameter "which"

    .prologue
    .line 58
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 59
    .local v1, selectedDate:Ljava/util/Calendar;
    iget-object v2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$datePicker:Landroid/widget/DatePicker;

    invoke-virtual {v2}, Landroid/widget/DatePicker;->getYear()I

    move-result v2

    .line 60
    iget-object v3, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$datePicker:Landroid/widget/DatePicker;

    invoke-virtual {v3}, Landroid/widget/DatePicker;->getMonth()I

    move-result v3

    .line 61
    iget-object v4, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$datePicker:Landroid/widget/DatePicker;

    invoke-virtual {v4}, Landroid/widget/DatePicker;->getDayOfMonth()I

    move-result v4

    .line 59
    invoke-virtual {v1, v2, v3, v4}, Ljava/util/Calendar;->set(III)V

    .line 62
    iget-object v2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->val$scheduleSpinner:Landroid/widget/Spinner;

    .line 63
    invoke-virtual {v2}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v0

    .line 65
    .local v0, schedule:I
    iget-object v2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    #calls: Lcom/RSen/LionTime/ChangeScheduleActivity;->showConfirmationDialog(Ljava/util/Calendar;I)Z
    invoke-static {v2, v1, v0}, Lcom/RSen/LionTime/ChangeScheduleActivity;->access$0(Lcom/RSen/LionTime/ChangeScheduleActivity;Ljava/util/Calendar;I)Z

    move-result v2

    if-nez v2, :cond_0

    .line 68
    iget-object v2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$3;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    invoke-virtual {v2}, Lcom/RSen/LionTime/ChangeScheduleActivity;->finish()V

    .line 71
    :cond_0
    return-void
.end method

.class Lcom/RSen/LionTime/ChangeScheduleActivity$1;
.super Ljava/lang/Object;
.source "ChangeScheduleActivity.java"

# interfaces
.implements Landroid/widget/DatePicker$OnDateChangedListener;


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

.field private final synthetic val$scheduleSpinner:Landroid/widget/Spinner;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Landroid/widget/Spinner;)V
    .locals 0
    .parameter
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$1;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    iput-object p2, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$1;->val$scheduleSpinner:Landroid/widget/Spinner;

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDateChanged(Landroid/widget/DatePicker;III)V
    .locals 3
    .parameter "view"
    .parameter "year"
    .parameter "monthOfYear"
    .parameter "dayOfMonth"

    .prologue
    .line 38
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 39
    .local v0, selectedDate:Ljava/util/Calendar;
    invoke-virtual {v0, p2, p3, p4}, Ljava/util/Calendar;->set(III)V

    .line 40
    iget-object v1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$1;->val$scheduleSpinner:Landroid/widget/Spinner;

    .line 41
    invoke-virtual {p1}, Landroid/widget/DatePicker;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 40
    invoke-static {v2, v0}, Lcom/RSen/LionTime/Schedule;->getScheduleType(Landroid/content/Context;Ljava/util/Calendar;)I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/Spinner;->setSelection(I)V

    .line 42
    return-void
.end method

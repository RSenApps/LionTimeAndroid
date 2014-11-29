.class public Lcom/RSen/LionTime/ChangeScheduleActivity;
.super Landroid/app/Activity;
.source "ChangeScheduleActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/RSen/LionTime/ChangeScheduleActivity;Ljava/util/Calendar;I)Z
    .locals 1
    .parameter
    .parameter
    .parameter

    .prologue
    .line 82
    invoke-direct {p0, p1, p2}, Lcom/RSen/LionTime/ChangeScheduleActivity;->showConfirmationDialog(Ljava/util/Calendar;I)Z

    move-result v0

    return v0
.end method

.method private showConfirmationDialog(Ljava/util/Calendar;I)Z
    .locals 7
    .parameter "selectedDate"
    .parameter "schedule"

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 84
    invoke-static {p0, p1}, Lcom/RSen/LionTime/Schedule;->getReadableScheduleType(Landroid/content/Context;Ljava/util/Calendar;)Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, oldSchedule:Ljava/lang/String;
    invoke-static {p0, p2}, Lcom/RSen/LionTime/Schedule;->getReadableScheduleType(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, newSchedule:Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 89
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Schedule already set to "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v4, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    .line 90
    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 123
    :goto_0
    return v3

    .line 93
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v5, "Are you sure you want to switch: "

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 94
    const/4 v5, 0x2

    invoke-virtual {p1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "/"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 95
    const/4 v5, 0x5

    invoke-virtual {p1, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "/"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 96
    invoke-virtual {p1, v4}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " from "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 97
    const-string v5, " to "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "?"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 93
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 98
    .local v2, text:Ljava/lang/String;
    new-instance v3, Landroid/app/AlertDialog$Builder;

    invoke-direct {v3, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v5, "Change Schedule"

    invoke-virtual {v3, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 99
    invoke-virtual {v3, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 100
    const-string v5, "Yes"

    new-instance v6, Lcom/RSen/LionTime/ChangeScheduleActivity$5;

    invoke-direct {v6, p0, p1, p2}, Lcom/RSen/LionTime/ChangeScheduleActivity$5;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Ljava/util/Calendar;I)V

    invoke-virtual {v3, v5, v6}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 110
    const-string v5, "Cancel"

    new-instance v6, Lcom/RSen/LionTime/ChangeScheduleActivity$6;

    invoke-direct {v6, p0}, Lcom/RSen/LionTime/ChangeScheduleActivity$6;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V

    invoke-virtual {v3, v5, v6}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 116
    new-instance v5, Lcom/RSen/LionTime/ChangeScheduleActivity$7;

    invoke-direct {v5, p0}, Lcom/RSen/LionTime/ChangeScheduleActivity$7;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V

    invoke-virtual {v3, v5}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 122
    invoke-virtual {v3}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move v3, v4

    .line 123
    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .parameter "savedInstanceState"

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    const-string v5, "layout_inflater"

    invoke-virtual {p0, v5}, Lcom/RSen/LionTime/ChangeScheduleActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 25
    .local v1, inflater:Landroid/view/LayoutInflater;
    const v5, 0x7f030001

    .line 26
    const/4 v6, 0x0

    .line 25
    invoke-virtual {v1, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 28
    .local v4, view:Landroid/view/View;
    const v5, 0x7f090004

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 27
    check-cast v0, Landroid/widget/DatePicker;

    .line 30
    .local v0, datePicker:Landroid/widget/DatePicker;
    const v5, 0x7f090005

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 29
    check-cast v3, Landroid/widget/Spinner;

    .line 31
    .local v3, scheduleSpinner:Landroid/widget/Spinner;
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 32
    .local v2, now:Ljava/util/Calendar;
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    const/4 v6, 0x2

    invoke-virtual {v2, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    .line 33
    const/4 v7, 0x5

    invoke-virtual {v2, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    new-instance v8, Lcom/RSen/LionTime/ChangeScheduleActivity$1;

    invoke-direct {v8, p0, v3}, Lcom/RSen/LionTime/ChangeScheduleActivity$1;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Landroid/widget/Spinner;)V

    .line 32
    invoke-virtual {v0, v5, v6, v7, v8}, Landroid/widget/DatePicker;->init(IIILandroid/widget/DatePicker$OnDateChangedListener;)V

    .line 44
    new-instance v5, Landroid/app/AlertDialog$Builder;

    invoke-direct {v5, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v6, "Change Schedule"

    invoke-virtual {v5, v6}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 45
    const-string v6, "Select a day and the new schedule..."

    invoke-virtual {v5, v6}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 46
    invoke-virtual {v5, v4}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 48
    const-string v6, "Cancel"

    new-instance v7, Lcom/RSen/LionTime/ChangeScheduleActivity$2;

    invoke-direct {v7, p0}, Lcom/RSen/LionTime/ChangeScheduleActivity$2;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V

    invoke-virtual {v5, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 54
    const-string v6, "Set"

    new-instance v7, Lcom/RSen/LionTime/ChangeScheduleActivity$3;

    invoke-direct {v7, p0, v0, v3}, Lcom/RSen/LionTime/ChangeScheduleActivity$3;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;Landroid/widget/DatePicker;Landroid/widget/Spinner;)V

    invoke-virtual {v5, v6, v7}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 72
    new-instance v6, Lcom/RSen/LionTime/ChangeScheduleActivity$4;

    invoke-direct {v6, p0}, Lcom/RSen/LionTime/ChangeScheduleActivity$4;-><init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V

    invoke-virtual {v5, v6}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    .line 78
    invoke-virtual {v5}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 79
    return-void
.end method

.class public Lcom/RSen/LionTime/ViewScheduleActivity;
.super Landroid/app/Activity;
.source "ViewScheduleActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private openOnInternet()V
    .locals 5

    .prologue
    const/4 v2, -0x2

    .line 33
    new-instance v1, Landroid/widget/EditText;

    invoke-direct {v1, p0}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 34
    .local v1, textEntryView:Landroid/widget/EditText;
    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setHeight(I)V

    .line 35
    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setWidth(I)V

    .line 36
    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setInputType(I)V

    .line 37
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setEms(I)V

    .line 38
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 39
    const-string v3, "studentID"

    const-string v4, ""

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, studentID:Ljava/lang/String;
    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 41
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 42
    const-string v3, "View Schedule"

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 44
    const-string v3, "To view your schedule, please enter your student id..."

    .line 43
    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 45
    invoke-virtual {v2, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 46
    const-string v3, "OK"

    new-instance v4, Lcom/RSen/LionTime/ViewScheduleActivity$1;

    invoke-direct {v4, p0, v1}, Lcom/RSen/LionTime/ViewScheduleActivity$1;-><init>(Lcom/RSen/LionTime/ViewScheduleActivity;Landroid/widget/EditText;)V

    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 64
    const-string v3, "Cancel"

    .line 65
    new-instance v4, Lcom/RSen/LionTime/ViewScheduleActivity$2;

    invoke-direct {v4, p0}, Lcom/RSen/LionTime/ViewScheduleActivity$2;-><init>(Lcom/RSen/LionTime/ViewScheduleActivity;)V

    .line 64
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 71
    new-instance v3, Lcom/RSen/LionTime/ViewScheduleActivity$3;

    invoke-direct {v3, p0}, Lcom/RSen/LionTime/ViewScheduleActivity$3;-><init>(Lcom/RSen/LionTime/ViewScheduleActivity;)V

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 78
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 79
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .parameter "savedInstanceState"

    .prologue
    .line 19
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 22
    :try_start_0
    invoke-virtual {p0}, Lcom/RSen/LionTime/ViewScheduleActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 23
    const-string v3, "com.Rsen.LSSchedule"

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 24
    .local v0, LaunchIntent:Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/RSen/LionTime/ViewScheduleActivity;->startActivity(Landroid/content/Intent;)V

    .line 25
    invoke-virtual {p0}, Lcom/RSen/LionTime/ViewScheduleActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 30
    .end local v0           #LaunchIntent:Landroid/content/Intent;
    :goto_0
    return-void

    .line 26
    :catch_0
    move-exception v1

    .line 27
    .local v1, e:Ljava/lang/Exception;
    invoke-direct {p0}, Lcom/RSen/LionTime/ViewScheduleActivity;->openOnInternet()V

    goto :goto_0
.end method

.class public Lcom/RSen/LionTime/MainActivity;
.super Landroid/app/Activity;
.source "MainActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static synthetic access$0(Landroid/content/Context;)V
    .locals 0
    .parameter

    .prologue
    .line 64
    invoke-static {p0}, Lcom/RSen/LionTime/MainActivity;->showHelpDialog(Landroid/content/Context;)V

    return-void
.end method

.method private static showHelpDialog(Landroid/content/Context;)V
    .locals 2
    .parameter "context"

    .prologue
    .line 65
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 66
    const-string v1, "Add widget"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 68
    const-string v1, "To add a widget, showing time until next class, please close this app, go to the homescreen.Then long press, select widgets, then Lion Time Compact. Enjoy!"

    .line 67
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 70
    const v1, 0x7f020003

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 72
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .parameter "savedInstanceState"

    .prologue
    .line 17
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 18
    const/high16 v3, 0x7f03

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->setContentView(I)V

    .line 20
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 21
    .local v2, prefs:Landroid/content/SharedPreferences;
    const-string v3, "FIRSTRUN"

    const/4 v4, 0x1

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    .line 22
    .local v1, isFirstRun:Z
    if-eqz v1, :cond_0

    .line 24
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 25
    .local v0, editor:Landroid/content/SharedPreferences$Editor;
    const-string v3, "FIRSTRUN"

    const/4 v4, 0x0

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 26
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 27
    new-instance v3, Landroid/content/Intent;

    const-string v4, "com.RSen.LionTime.NEW_DAY"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 28
    invoke-static {p0}, Lcom/RSen/LionTime/MainActivity;->showHelpDialog(Landroid/content/Context;)V

    .line 30
    .end local v0           #editor:Landroid/content/SharedPreferences$Editor;
    :cond_0
    const/high16 v3, 0x7f09

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/RSen/LionTime/MainActivity$1;

    invoke-direct {v4, p0}, Lcom/RSen/LionTime/MainActivity$1;-><init>(Lcom/RSen/LionTime/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    const v3, 0x7f090001

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/RSen/LionTime/MainActivity$2;

    invoke-direct {v4, p0}, Lcom/RSen/LionTime/MainActivity$2;-><init>(Lcom/RSen/LionTime/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 46
    const v3, 0x7f090002

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/RSen/LionTime/MainActivity$3;

    invoke-direct {v4, p0}, Lcom/RSen/LionTime/MainActivity$3;-><init>(Lcom/RSen/LionTime/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    const v3, 0x7f090003

    invoke-virtual {p0, v3}, Lcom/RSen/LionTime/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    new-instance v4, Lcom/RSen/LionTime/MainActivity$4;

    invoke-direct {v4, p0}, Lcom/RSen/LionTime/MainActivity$4;-><init>(Lcom/RSen/LionTime/MainActivity;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    return-void
.end method

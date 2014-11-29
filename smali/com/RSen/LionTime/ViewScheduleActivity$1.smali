.class Lcom/RSen/LionTime/ViewScheduleActivity$1;
.super Ljava/lang/Object;
.source "ViewScheduleActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/ViewScheduleActivity;->openOnInternet()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

.field private final synthetic val$textEntryView:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ViewScheduleActivity;Landroid/widget/EditText;)V
    .locals 0
    .parameter
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    iput-object p2, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->val$textEntryView:Landroid/widget/EditText;

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .parameter "dialog"
    .parameter "whichButton"

    .prologue
    .line 49
    iget-object v2, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->val$textEntryView:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-interface {v2}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 52
    .local v1, studentID:Ljava/lang/String;
    iget-object v2, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-virtual {v2}, Lcom/RSen/LionTime/ViewScheduleActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 51
    invoke-static {v2}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 52
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 53
    const-string v3, "studentID"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 54
    new-instance v0, Landroid/content/Intent;

    .line 55
    const-string v2, "android.intent.action.VIEW"

    .line 56
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://thesouk.lakesideschool.org/ScheduleSearch/ExtendedSchedule.aspx?SRP=1,1,"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 57
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ",2"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 56
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 54
    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 59
    .local v0, browserIntent:Landroid/content/Intent;
    iget-object v2, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-virtual {v2, v0}, Lcom/RSen/LionTime/ViewScheduleActivity;->startActivity(Landroid/content/Intent;)V

    .line 60
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 61
    iget-object v2, p0, Lcom/RSen/LionTime/ViewScheduleActivity$1;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-virtual {v2}, Lcom/RSen/LionTime/ViewScheduleActivity;->finish()V

    .line 62
    return-void
.end method

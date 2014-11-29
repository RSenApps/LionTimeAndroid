.class Lcom/RSen/LionTime/ViewScheduleActivity$2;
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


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ViewScheduleActivity;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ViewScheduleActivity$2;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .parameter "dialog"
    .parameter "whichButton"

    .prologue
    .line 68
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 69
    iget-object v0, p0, Lcom/RSen/LionTime/ViewScheduleActivity$2;->this$0:Lcom/RSen/LionTime/ViewScheduleActivity;

    invoke-virtual {v0}, Lcom/RSen/LionTime/ViewScheduleActivity;->finish()V

    .line 70
    return-void
.end method

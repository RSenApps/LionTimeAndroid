.class Lcom/RSen/LionTime/ChangeScheduleActivity$6;
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


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/ChangeScheduleActivity;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/ChangeScheduleActivity$6;->this$0:Lcom/RSen/LionTime/ChangeScheduleActivity;

    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .parameter "dialog"
    .parameter "which"

    .prologue
    .line 114
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 115
    return-void
.end method

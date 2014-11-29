.class Lcom/RSen/LionTime/MainActivity$3;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/RSen/LionTime/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/RSen/LionTime/MainActivity;


# direct methods
.method constructor <init>(Lcom/RSen/LionTime/MainActivity;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/RSen/LionTime/MainActivity$3;->this$0:Lcom/RSen/LionTime/MainActivity;

    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .parameter "arg0"

    .prologue
    .line 50
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    #calls: Lcom/RSen/LionTime/MainActivity;->showHelpDialog(Landroid/content/Context;)V
    invoke-static {v0}, Lcom/RSen/LionTime/MainActivity;->access$0(Landroid/content/Context;)V

    .line 51
    return-void
.end method

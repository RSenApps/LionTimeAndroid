.class Lcom/RSen/LionTime/MainActivity$4;
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
    iput-object p1, p0, Lcom/RSen/LionTime/MainActivity$4;->this$0:Lcom/RSen/LionTime/MainActivity;

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .parameter "arg0"

    .prologue
    .line 58
    iget-object v0, p0, Lcom/RSen/LionTime/MainActivity$4;->this$0:Lcom/RSen/LionTime/MainActivity;

    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    .line 59
    const-class v3, Lcom/RSen/LionTime/SettingsActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 58
    invoke-virtual {v0, v1}, Lcom/RSen/LionTime/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 60
    return-void
.end method

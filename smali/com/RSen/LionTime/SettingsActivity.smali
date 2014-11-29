.class public Lcom/RSen/LionTime/SettingsActivity;
.super Landroid/preference/PreferenceActivity;
.source "SettingsActivity.java"


# static fields
.field private static sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lcom/RSen/LionTime/SettingsActivity$1;

    invoke-direct {v0}, Lcom/RSen/LionTime/SettingsActivity$1;-><init>()V

    sput-object v0, Lcom/RSen/LionTime/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    .line 64
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/preference/PreferenceActivity;-><init>()V

    return-void
.end method

.method private static bindPreferenceSummaryToValue(Landroid/preference/Preference;)V
    .locals 4
    .parameter "preference"

    .prologue
    .line 77
    .line 78
    sget-object v0, Lcom/RSen/LionTime/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    invoke-virtual {p0, v0}, Landroid/preference/Preference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 82
    sget-object v0, Lcom/RSen/LionTime/SettingsActivity;->sBindPreferenceSummaryToValueListener:Landroid/preference/Preference$OnPreferenceChangeListener;

    .line 85
    invoke-virtual {p0}, Landroid/preference/Preference;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 84
    invoke-static {v1}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 86
    invoke-virtual {p0}, Landroid/preference/Preference;->getKey()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    .line 85
    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    .line 82
    invoke-interface {v0, p0, v1}, Landroid/preference/Preference$OnPreferenceChangeListener;->onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z

    .line 87
    return-void
.end method

.method private setupSimplePreferencesScreen()V
    .locals 1

    .prologue
    .line 35
    const/high16 v0, 0x7f04

    invoke-virtual {p0, v0}, Lcom/RSen/LionTime/SettingsActivity;->addPreferencesFromResource(I)V

    .line 40
    const-string v0, "notification_activated"

    invoke-virtual {p0, v0}, Lcom/RSen/LionTime/SettingsActivity;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    invoke-static {v0}, Lcom/RSen/LionTime/SettingsActivity;->bindPreferenceSummaryToValue(Landroid/preference/Preference;)V

    .line 41
    return-void
.end method


# virtual methods
.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 0
    .parameter "savedInstanceState"

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/preference/PreferenceActivity;->onPostCreate(Landroid/os/Bundle;)V

    .line 25
    invoke-direct {p0}, Lcom/RSen/LionTime/SettingsActivity;->setupSimplePreferencesScreen()V

    .line 26
    return-void
.end method

.class public Lcom/google/android/apps/dashclock/api/ExtensionData;
.super Ljava/lang/Object;
.source "ExtensionData.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/google/android/apps/dashclock/api/ExtensionData;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mClickIntent:Landroid/content/Intent;

.field private mExpandedBody:Ljava/lang/String;

.field private mExpandedTitle:Ljava/lang/String;

.field private mIcon:I

.field private mStatus:Ljava/lang/String;

.field private mVisible:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 289
    new-instance v0, Lcom/google/android/apps/dashclock/api/ExtensionData$1;

    invoke-direct {v0}, Lcom/google/android/apps/dashclock/api/ExtensionData$1;-><init>()V

    sput-object v0, Lcom/google/android/apps/dashclock/api/ExtensionData;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    iput-boolean v1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    .line 104
    iput v1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    .line 105
    iput-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    .line 106
    iput-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    .line 107
    iput-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    .line 108
    iput-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    .line 111
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .parameter "in"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v5, 0x0

    .line 300
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    iput-boolean v3, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    .line 104
    iput v3, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    .line 105
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    .line 106
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    .line 107
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    .line 108
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    .line 301
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 302
    .local v1, parcelableVersion:I
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 304
    .local v0, parcelableSize:I
    if-lt v1, v2, :cond_3

    .line 305
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-eqz v4, :cond_4

    :goto_0
    iput-boolean v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    .line 306
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    .line 307
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    .line 308
    iget-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 309
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    .line 311
    :cond_0
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    .line 312
    iget-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 313
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    .line 315
    :cond_1
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    .line 316
    iget-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 317
    iput-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    .line 320
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 329
    :cond_3
    :goto_1
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v2

    rsub-int/lit8 v3, v0, 0x6

    add-int/2addr v2, v3

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->setDataPosition(I)V

    .line 330
    return-void

    :cond_4
    move v2, v3

    .line 305
    goto :goto_0

    .line 321
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/google/android/apps/dashclock/api/ExtensionData$1;)V
    .locals 0
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 68
    invoke-direct {p0, p1}, Lcom/google/android/apps/dashclock/api/ExtensionData;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private static intentEquals(Landroid/content/Intent;Landroid/content/Intent;)Z
    .locals 1
    .parameter "x"
    .parameter "y"

    .prologue
    .line 377
    if-eqz p0, :cond_0

    if-nez p1, :cond_2

    .line 378
    :cond_0
    if-ne p0, p1, :cond_1

    const/4 v0, 0x1

    .line 380
    :goto_0
    return v0

    .line 378
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 380
    :cond_2
    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public clickIntent(Landroid/content/Intent;)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "clickIntent"

    .prologue
    .line 222
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    .line 223
    return-object p0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 352
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .parameter "o"

    .prologue
    const/4 v3, 0x0

    .line 358
    if-nez p1, :cond_1

    .line 372
    :cond_0
    :goto_0
    return v3

    .line 363
    :cond_1
    :try_start_0
    move-object v0, p1

    check-cast v0, Lcom/google/android/apps/dashclock/api/ExtensionData;

    move-object v2, v0

    .line 364
    .local v2, other:Lcom/google/android/apps/dashclock/api/ExtensionData;
    iget-boolean v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    iget-boolean v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    if-ne v4, v5, :cond_0

    iget v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    iget v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    if-ne v4, v5, :cond_0

    iget-object v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    invoke-static {v4, v5}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, v2, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    iget-object v5, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    invoke-static {v4, v5}, Lcom/google/android/apps/dashclock/api/ExtensionData;->intentEquals(Landroid/content/Intent;Landroid/content/Intent;)Z
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-eqz v4, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    .line 371
    .end local v2           #other:Lcom/google/android/apps/dashclock/api/ExtensionData;
    :catch_0
    move-exception v1

    .line 372
    .local v1, e:Ljava/lang/ClassCastException;
    goto :goto_0
.end method

.method public expandedBody(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "expandedBody"

    .prologue
    .line 202
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    .line 203
    return-object p0
.end method

.method public expandedTitle(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "expandedTitle"

    .prologue
    .line 184
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    .line 185
    return-object p0
.end method

.method public icon(I)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "icon"

    .prologue
    .line 145
    iput p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    .line 146
    return-object p0
.end method

.method public status(Ljava/lang/String;)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "status"

    .prologue
    .line 165
    iput-object p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    .line 166
    return-object p0
.end method

.method public visible(Z)Lcom/google/android/apps/dashclock/api/ExtensionData;
    .locals 0
    .parameter "visible"

    .prologue
    .line 126
    iput-boolean p1, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    .line 127
    return-object p0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 3
    .parameter "parcel"
    .parameter "i"

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 338
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 339
    const/4 v2, 0x6

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 341
    iget-boolean v2, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mVisible:Z

    if-eqz v2, :cond_0

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 342
    iget v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mIcon:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 343
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, ""

    :goto_1
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 344
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, ""

    :goto_2
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 345
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, ""

    :goto_3
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 346
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    if-nez v0, :cond_4

    const-string v0, ""

    :goto_4
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 348
    return-void

    :cond_0
    move v0, v1

    .line 341
    goto :goto_0

    .line 343
    :cond_1
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mStatus:Ljava/lang/String;

    goto :goto_1

    .line 344
    :cond_2
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedTitle:Ljava/lang/String;

    goto :goto_2

    .line 345
    :cond_3
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mExpandedBody:Ljava/lang/String;

    goto :goto_3

    .line 346
    :cond_4
    iget-object v0, p0, Lcom/google/android/apps/dashclock/api/ExtensionData;->mClickIntent:Landroid/content/Intent;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4
.end method

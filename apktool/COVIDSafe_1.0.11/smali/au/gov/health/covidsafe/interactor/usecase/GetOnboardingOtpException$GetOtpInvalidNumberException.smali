.class public final Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;
.super Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;
.source "GetOnboardingOtp.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "GetOtpInvalidNumberException"
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"
    }
    d2 = {
        "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;",
        "Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;",
        "()V",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# static fields
.field public static final INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 59
    new-instance v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;

    invoke-direct {v0}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;-><init>()V

    sput-object v0, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;->INSTANCE:Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException$GetOtpInvalidNumberException;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    .line 59
    invoke-direct {p0, v0}, Lau/gov/health/covidsafe/interactor/usecase/GetOnboardingOtpException;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    return-void
.end method

.class final Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;
.super Lkotlin/jvm/internal/Lambda;
.source "EnterNumberPresenter.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->makeOTPCall(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function1<",
        "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    bv = {
        0x1,
        0x0,
        0x3
    }
    d1 = {
        "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\u0008\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "<anonymous>",
        "",
        "it",
        "Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;",
        "invoke",
        "au/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$1$1"
    }
    k = 0x3
    mv = {
        0x1,
        0x1,
        0x10
    }
.end annotation


# instance fields
.field final synthetic $phoneNumber$inlined:Ljava/lang/String;

.field final synthetic this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;


# direct methods
.method constructor <init>(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;

    iput-object p2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;->$phoneNumber$inlined:Ljava/lang/String;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 16
    check-cast p1, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;

    invoke-virtual {p0, p1}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;->invoke(Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;)V

    sget-object p1, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p1
.end method

.method public final invoke(Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;)V
    .locals 3

    const-string v0, "it"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkParameterIsNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 59
    iget-object v0, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;->this$0:Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;

    invoke-static {v0}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;->access$getEnterNumberFragment$p(Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter;)Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;

    move-result-object v0

    .line 60
    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;->getSession()Ljava/lang/String;

    move-result-object v1

    .line 61
    invoke-virtual {p1}, Lau/gov/health/covidsafe/networking/response/OTPChallengeResponse;->getChallengeName()Ljava/lang/String;

    move-result-object p1

    .line 62
    iget-object v2, p0, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberPresenter$makeOTPCall$$inlined$let$lambda$1;->$phoneNumber$inlined:Ljava/lang/String;

    .line 59
    invoke-virtual {v0, v1, p1, v2}, Lau/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment;->navigateToOTPPage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

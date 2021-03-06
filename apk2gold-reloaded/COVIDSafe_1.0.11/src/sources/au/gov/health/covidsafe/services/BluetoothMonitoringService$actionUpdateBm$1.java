package au.gov.health.covidsafe.services;

import au.gov.health.covidsafe.networking.response.BroadcastMessageResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lau/gov/health/covidsafe/networking/response/BroadcastMessageResponse;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: BluetoothMonitoringService.kt */
final class BluetoothMonitoringService$actionUpdateBm$1 extends Lambda implements Function1<BroadcastMessageResponse, Unit> {
    public static final BluetoothMonitoringService$actionUpdateBm$1 INSTANCE = new BluetoothMonitoringService$actionUpdateBm$1();

    BluetoothMonitoringService$actionUpdateBm$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BroadcastMessageResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BroadcastMessageResponse broadcastMessageResponse) {
        Intrinsics.checkParameterIsNotNull(broadcastMessageResponse, "it");
        BluetoothMonitoringService.Companion.setBroadcastMessage(broadcastMessageResponse.getTempId());
    }
}

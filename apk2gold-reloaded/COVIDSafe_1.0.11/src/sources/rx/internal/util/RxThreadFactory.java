package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory NONE = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    };
    private static final long serialVersionUID = -8841098858898482335L;
    final String prefix;

    public RxThreadFactory(String str) {
        this.prefix = str;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.prefix);
        sb.append(incrementAndGet());
        Thread thread = new Thread(runnable, sb.toString());
        thread.setDaemon(true);
        return thread;
    }
}

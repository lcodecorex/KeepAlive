package com.boolbird.keepalive;

import android.content.Context;

public interface IKeepAliveProcess {
    /**
     * Initialization some files or other when 1st time
     */
    boolean onInit(Context context, KeepAliveConfigs configs);

    /**
     * when Persistent processName create
     */
    void onPersistentCreate(Context context, KeepAliveConfigs configs);

    /**
     * when DaemonAssistant processName create
     */
    void onDaemonAssistantCreate(Context context, KeepAliveConfigs configs);

    /**
     * when watches the processName dead which it watched
     */
    void onDaemonDead();


    class Fetcher {

        private static volatile IKeepAliveProcess mDaemonStrategy;

        /**
         * fetch the strategy for this device
         *
         * @return the daemon strategy for this device
         */
        static IKeepAliveProcess fetchStrategy() {
            if (mDaemonStrategy != null) {
                return mDaemonStrategy;
            }
            mDaemonStrategy = new KeepAliveProcessImpl();
            return mDaemonStrategy;
        }
    }
}

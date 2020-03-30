package com.boolbird.keepalive;

/* package */class NativeKeepAlive {

    static {
        try {
            System.loadLibrary("keep_alive");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public native void doDaemon(String indicatorSelfPath, String indicatorDaemonPath, String observerSelfPath, String observerDaemonPath, int code, long parcelPtr);

    public void onDaemonDead() {
        IKeepAliveProcess.Fetcher.fetchStrategy().onDaemonDead();
    }
}

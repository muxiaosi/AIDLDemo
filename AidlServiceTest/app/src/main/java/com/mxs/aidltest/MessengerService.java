package com.mxs.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

import androidx.annotation.Nullable;

/**
 * @author Fs972
 * @date 2020/4/22 6:37 PM
 * @description Messenger
 */
public class MessengerService extends Service {

    private static final int MSG_SUM = 0x110;

//    private Messenger mMessenger = new Messenger();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

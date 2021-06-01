package com.example.smartsocketteste87634257.Activities.Activities.CoisasRotinaRelogio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class InicializarBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            // Chame aqui o seu serviço
            context.startService(new Intent(context, ReceiverClass.class));
            context.startService(new Intent(context, ReceiverClass2.class));
            context.startService(new Intent(context, ReceiverClass3.class));
            context.startService(new Intent(context, ReceiverClass4.class));
            context.startService(new Intent(context, ReceiverClass5.class));
            context.startService(new Intent(context, ReceiverClass6.class));
            context.startService(new Intent(context, ReceiverClass7.class));
            context.startService(new Intent(context, ReceiverClass8.class));
            context.startService(new Intent(context, ReceiverClass9.class));
            context.startService(new Intent(context, ReceiverClass10.class));
            context.startService(new Intent(context, ReceiverClass11.class));
            context.startService(new Intent(context, ReceiverClass12.class));
            context.startService(new Intent(context, ReceiverClass13.class));
            context.startService(new Intent(context, ReceiverClass14.class));
            context.startService(new Intent(context, ReceiverClass15.class));
            context.startService(new Intent(context, ReceiverClass16.class));


        }
    }
}

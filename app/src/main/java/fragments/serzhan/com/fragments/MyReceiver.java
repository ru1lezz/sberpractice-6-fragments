package fragments.serzhan.com.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    private IActivityCallbacks mIActivityCallbacks;

    public MyReceiver() {

    }

    public MyReceiver(IActivityCallbacks IActivityCallbacks) {
        this.mIActivityCallbacks = IActivityCallbacks;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mIActivityCallbacks.setText(String.valueOf(intent.getStringExtra("RANDOM_NUMBERS")));
    }
}

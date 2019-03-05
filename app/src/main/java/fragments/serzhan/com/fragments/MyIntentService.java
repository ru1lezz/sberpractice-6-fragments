package fragments.serzhan.com.fragments;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import java.util.Random;

public class MyIntentService extends IntentService {
    private static final String SEND_MESSAGE_FILTER = "fragments.serzhan.com.fragments.SEND_MESSAGES_FILTER";

    private Random random = new Random();

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        while(true) {
            Intent broadcastIntent = new Intent(SEND_MESSAGE_FILTER);
            broadcastIntent.putExtra("RANDOM_NUMBERS", getRandomNumbers());
            sendBroadcast(broadcastIntent);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getRandomNumbers() {
        return String.valueOf(random.nextInt(100));
    }

    public static final Intent newIntent(Context context) {
        return new Intent(context, MyIntentService.class);
    }
}

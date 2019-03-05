package fragments.serzhan.com.fragments;

import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements IActivityCallbacks{

    private static final String SEND_MESSAGE_FILTER = "fragments.serzhan.com.fragments.SEND_MESSAGES_FILTER";
    private MyReceiver myReceiver;
    private IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initFragments();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(MyIntentService.newIntent(MainActivity.this));
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(MyIntentService.newIntent(MainActivity.this));
        unregisterReceiver(myReceiver);
    }

    private void init() {
        myReceiver = new MyReceiver(this);
        intentFilter = new IntentFilter(SEND_MESSAGE_FILTER);
    }

    private void initFragments() {
       FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentEditText, EditTextFragment.newInstance(), "fragmentEditText")
                .add(R.id.fragmentButton, ButtonFragment.newInstance(), "fragmentButton")
                .commitNow();
    }

    @Override
    public void pressButton() {
        EditTextFragment editTextFragment = (EditTextFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentEditText);
        String data = editTextFragment.getData();
        ButtonFragment buttonFragment = (ButtonFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentButton);
        buttonFragment.setData(data);
    }

    @Override
    public void setText(String text) {
        EditTextFragment editTextFragment = (EditTextFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentEditText);
        editTextFragment.setText(text);
    }
}

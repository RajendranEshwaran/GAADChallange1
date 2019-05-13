package com.gomathi.gaadchallange1;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.gomathi.gaadchallange1.extra.REPLY";
    // Unique tag for the intent reply.

    EditText mReply;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "OnCreate");

        mReply = (EditText)findViewById(R.id.editText4);
        button = (Button)findViewById(R.id.button2);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Put that message into the text_message TextView
        TextView textView = (TextView) findViewById(R.id.textView2);
        if (textView != null) {
            textView.setText(message);
        }



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    public void returnReply(View view) {

        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();

        replyIntent.putExtra(EXTRA_REPLY, reply);

        setResult(RESULT_OK, replyIntent);

        Log.d(LOG_TAG, "End SecondActivity");

        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "OnStart");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d(LOG_TAG, "OnDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "OnRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "OnResume");
    }


}

package com.gomathi.gaadchallange1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int TEXT_REQUEST = 1;
    // Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE = "com.gomathi.gaadchallange1.extra.MESSAGE";

    EditText editText1,editText2,editText3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "OnCreate");


        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);

        // Restore the saved state. See onSaveInstanceState() for what gets saved.

        if (savedInstanceState != null) {

            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

// Show both the header and the message views. If isVisible is

// false or missing from the bundle, use the default layout.

            if (isVisible) {

                editText2.setVisibility(View.VISIBLE);

                editText3.setText(savedInstanceState.getString("reply_text"));

                editText3.setVisibility(View.VISIBLE);

            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // If the heading is visible, we have a message that needs to be saved.

// Otherwise we're still using default layout.

        if (editText2.getVisibility() == View.VISIBLE) {

            outState.putBoolean("reply_visible", true);

            outState.putString("reply_text", editText3.getText().toString());

        }
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

    public void gotoSecondActivity(View view)
    {
        Log.d(LOG_TAG, "Button Clicked");

        String message = editText1.getText().toString();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                // Make the reply head visible.
                editText2.setVisibility(View.VISIBLE);

                // Set the reply and make it visible.
                editText3.setText(reply);
                editText3.setVisibility(View.VISIBLE);
            }
        }
    }


}

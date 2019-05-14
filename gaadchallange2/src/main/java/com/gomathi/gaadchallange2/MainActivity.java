package com.gomathi.gaadchallange2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public  static final String LOG_TAG = "rajay 1";

    Button button;
    TextView restTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.button);
        restTextView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String value = intent.getStringExtra(ProductListActivity.EXTRA_MESSAGE);
        if(restTextView != null && value != null) {

            restTextView.setText(value);
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

    public void gotoProductListActivity(View view)
    {
        Log.d(LOG_TAG, "Button Clicked");

//        String message = editText1.getText().toString();
        Intent intent = new Intent(MainActivity.this,ProductListActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivityForResult(intent, TEXT_REQUEST);
//
//        finish();
        startActivity(intent);


    }
}

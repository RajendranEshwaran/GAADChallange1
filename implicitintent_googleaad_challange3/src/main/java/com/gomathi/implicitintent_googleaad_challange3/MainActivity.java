package com.gomathi.implicitintent_googleaad_challange3;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "rajay";

    EditText editText1,editText2,editText3;
    Button button1, button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
    }

    public void openWebsite(View view)
    {
        String url = editText1.getText().toString();
        Uri webUrl = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webUrl);
        if(intent.resolveActivity(getPackageManager())!= null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("Implicit Intent", "Canot Handle it!!!");
        }

    }

    public void openLocation(View view)
    {
        String location = editText2.getText().toString();
        Uri locationUri = Uri.parse("geo:0,0?q="+location);
        Intent intent = new Intent(Intent.ACTION_VIEW,locationUri);
        if(intent.resolveActivity(getPackageManager())!= null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d("Implicit Intent", "Canot Handle it!!!");
        }
    }

    public void shareText(View view)
    {
        String txt = editText3.getText().toString();
        String type = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(type)
                .setChooserTitle("Message")
                .setText(txt)
                .startChooser();


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

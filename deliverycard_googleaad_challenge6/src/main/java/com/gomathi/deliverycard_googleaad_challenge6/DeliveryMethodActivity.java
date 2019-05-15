package com.gomathi.deliverycard_googleaad_challenge6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DeliveryMethodActivity extends AppCompatActivity {

    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_method);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DELIVERY");

        radioButton = (RadioButton)findViewById(R.id.radioButton);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);

      radioButton.setOnCheckedChangeListener(new radioCheck());
      radioButton2.setOnCheckedChangeListener(new radioCheck());
      radioButton3.setOnCheckedChangeListener(new radioCheck());
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    class radioCheck implements CompoundButton.OnCheckedChangeListener{

        /**
         * Called when the checked state of a compound button has changed.
         *
         * @param buttonView The compound button view whose state has changed.
         * @param isChecked  The new checked state of buttonView.
         */
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            if(radioButton.isChecked())
            {
                Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
            if(radioButton2.isChecked())
            {
                Toast.makeText(getApplicationContext(), radioButton2.getText(), Toast.LENGTH_SHORT).show();
            }
            if(radioButton3.isChecked())
            {
                Toast.makeText(getApplicationContext(), radioButton3.getText(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

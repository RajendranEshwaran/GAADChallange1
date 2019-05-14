package com.gomathi.gaadchallange2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    public static final String LOG_TAG = "rajay ";
    public static final String EXTRA_MESSAGE = "com.gomathi.gaadchallange2.extra.MESSAGE";
    private static final int RESULT_CODE = 1;

    public ArrayList<String> productList;
    public ListView listView;
    public ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        productList = new ArrayList<>();
        productList.add("Rice");
        productList.add("Wheat");
        productList.add("Raki");
        productList.add("Chicken");
        productList.add("Beans");
        productList.add("Apple");
        productList.add("Eggs");
        productList.add("Milk");
        productList.add("Banana");

        listView = (ListView)findViewById(R.id.productListView);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productList);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = productList.get(position).toString();
                Log.d(LOG_TAG, value);
                Toast.makeText(getApplicationContext(), "Clicked item is: "+value, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ProductListActivity.this,MainActivity.class);
                intent.putExtra(EXTRA_MESSAGE, value);
                startActivity(intent);
            }
        });

    }


    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);

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

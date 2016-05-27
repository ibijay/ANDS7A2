package com.example.bijay.myapp_autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ActSQLiteOpenHelperP db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ActSQLiteOpenHelperP(this);
        db.getWritableDatabase();

        db.createProduct(new Product("HP Inkjet 1100 printer"));
        db.createProduct(new Product("HP Inkjet 1200 printer"));
        db.createProduct(new Product("HP Inkjet 1300 printer"));
        db.createProduct(new Product("HP Inkjet 1400 printer"));
        db.createProduct(new Product("HP Inkjet 1500 printer"));
        db.createProduct(new Product("HP Laserjet 2100 printer"));
        db.createProduct(new Product("HP Laserjet 2200 printer"));
        db.createProduct(new Product("HP Laserjet 2300 printer"));
        db.createProduct(new Product("HP Laserjet 2400 printer"));
        db.createProduct(new Product("HP Deskjet 3100 printer"));
        db.createProduct(new Product("HP Deskjet 3200 printer"));
        db.createProduct(new Product("HP Deskjet 3400 printer"));
        db.createProduct(new Product("HP Deskjet 3500 printer"));

        AutoCompleteTextView view = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        List<Product> list = db.getProducts();

        ArrayAdapter<String> myAdapter;
        List<String> stringProducts = new ArrayList<>();

        for (int i = 0; i<list.size();i++){
            stringProducts.add(i, list.get(i).toString());
        }

        myAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,stringProducts);
        view.setAdapter(myAdapter);

    }
}

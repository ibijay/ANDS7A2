package com.example.bijay.myapp_autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ActSQLiteOpenHelperP db = new ActSQLiteOpenHelperP(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.onUpgrade(db.getWritableDatabase(), 1, 2);
        db.createProduct(new Product("HP Inkjet printer"));
        db.createProduct(new Product("HP Inkjet1 printer"));
        db.createProduct(new Product("HP Inkjet2 printer"));
        db.createProduct(new Product("HP Inkjet3 printer"));
        db.createProduct(new Product("HP Inkjet4 printer"));
        db.createProduct(new Product("HP Laserjet1 printer"));
        db.createProduct(new Product("HP Laserjet2 printer"));
        db.createProduct(new Product("HP Laserjet3 printer"));
        db.createProduct(new Product("HP Laserjet4 printer"));
        db.createProduct(new Product("HP Deskjet1 printer"));
        db.createProduct(new Product("HP Deskjet2 printer"));
        db.createProduct(new Product("HP Deskjet3 printer"));
        db.createProduct(new Product("HP Deskjet4 printer"));

        AutoCompleteTextView view = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        List<Product> list = db.getProducts();

        ArrayAdapter<String> myAdapter;
        List<String> stringProducts = new ArrayList<>();

        for (int i = 0; i<list.size();i++){
            stringProducts.add(i, list.get(i).toString());
        }

        myAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,stringProducts);
        view.setAdapter(myAdapter);

        finish();
    }
}

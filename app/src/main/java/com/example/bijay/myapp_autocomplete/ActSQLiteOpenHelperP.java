package com.example.bijay.myapp_autocomplete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bijay on 14-05-2016.
 */
public class ActSQLiteOpenHelperP extends SQLiteOpenHelper {

    private static final int db_version = 1;
    private static final String db_name = "dbProducts";
    private static final String tb_name = "tbProducts";
    private static final String product_id = "pid";
    private static final String product_name = "pname";

    private static final String[] columns={product_id ,product_name};

    public ActSQLiteOpenHelperP(Context context){super(context, db_name, null, db_version);}

    public void onCreate(SQLiteDatabase db){
        String create_products_table = "CREATE TABLE " + tb_name + " ( " + product_id + " INTEGER PRIMARY KEY AUTOINCREAMENT, " + product_name +" TEXT )";
        db.execSQL(create_products_table);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVesion){
        String drop_names_table = "DROP TABLE IF EXISTS " + tb_name;
        db.execSQL(drop_names_table);
    }

    public void createProduct(Product product){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(product_name, product.getpName());
        db.insert(tb_name,null,values);
        db.close();
    }

    public List<Product> getProducts(){
        List<Product> products = new LinkedList<>();

        String query = "Select * from " + tb_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Product product = null;
        if (cursor.moveToFirst()){
            do {
                product = new Product();
                product.setpId(Integer.parseInt(cursor.getString(0)));
                product.setpName(cursor.getString(1));
                products.add(product);
            } while (cursor.moveToNext());
        }
        db.close();
        return products;



    }
}
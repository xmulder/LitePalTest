package com.example.rindou11.litepaltest;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    private Button button_create_litepal_test;
    private Button button_add_data;
    private Button button_update_data;
    private Button button_delete_data;

    private EditText edit_text_name;
    private EditText edit_text_price;
    private EditText edit_text_author;
    private EditText edit_text_id;
    private EditText edit_text_pages;
    private EditText edit_text_press;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Book book1;
        book1 = new Book();


        button_create_litepal_test=(Button)findViewById(R.id.button_create_litepal);
        button_create_litepal_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                if(Connector.getDatabase()!=null){
                    Toast.makeText(MainActivity.this,"Successful.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Please clear data files.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_add_data=(Button)findViewById(R.id.button_add_litepal_book);
        edit_text_name=(EditText)findViewById(R.id.edittext_name);
        edit_text_price=(EditText)findViewById(R.id.edittext_price);
        edit_text_author=(EditText)findViewById(R.id.edittext_author);
        edit_text_id=(EditText)findViewById(R.id.edittext_id);
        edit_text_pages=(EditText)findViewById(R.id.edittext_pages);
        edit_text_press=(EditText)findViewById(R.id.edittext_press);

        button_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_text_author.getText().toString().length()==0 ||
                        edit_text_id.getText().toString().length()==0||
                        edit_text_name.getText().toString().length()==0||
                        edit_text_pages.getText().toString().length()==0||
                        edit_text_press.getText().toString().length()==0||
                        edit_text_price.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please check your input.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setAuthor(edit_text_author.getText().toString());
                    book1.setId(Integer.parseInt(edit_text_id.getText().toString()));
                    book1.setName(edit_text_name.getText().toString());
                    book1.setPages(Integer.parseInt(edit_text_pages.getText().toString()));
                    book1.setPress(edit_text_press.getText().toString());
                    book1.setPrice(Double.parseDouble(edit_text_price.getText().toString()));
                    book1.save();
                    Toast.makeText(MainActivity.this,"Saved!",Toast.LENGTH_SHORT).show();
                }


                /*if(edit_text_author.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input Author.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setAuthor(edit_text_author.getText().toString());
                }

                if(edit_text_id.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input ID.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setId(Integer.parseInt(edit_text_id.getText().toString()));
                }

                if(edit_text_name.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input Name.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setName(edit_text_name.getText().toString());
                }

                if(edit_text_pages.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input Pages.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setPages(Integer.parseInt(edit_text_pages.getText().toString()));
                }

                if(edit_text_press.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input Press.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setPress(edit_text_press.getText().toString());
                }

                if(edit_text_price.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please input Price.",Toast.LENGTH_SHORT).show();
                }
                else{
                    book1.setPrice(Double.parseDouble(edit_text_price.getText().toString()));
                }


                //book1.setAuthor(edit_text_author.getText().toString());
                //book1.setId(Integer.parseInt(edit_text_id.getText().toString()));
                //book1.setName(edit_text_name.getText().toString());
                //book1.setPages(Integer.parseInt(edit_text_pages.getText().toString()));
                //book1.setPress(edit_text_press.getText().toString());
                //book1.setPrice(Double.parseDouble(edit_text_price.getText().toString()));
                */

            }
        });

        button_update_data=(Button)findViewById(R.id.button_update_litepal_book);
        button_update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book1.setPrice(Double.parseDouble(edit_text_price.getText().toString()));
                book1.updateAll();
                Toast.makeText(MainActivity.this,"Update Successful.",Toast.LENGTH_SHORT).show();
            }
        });

        button_delete_data=(Button)findViewById(R.id.button_delete_litepal_book);
        button_delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book1.deleteAsync();

            }
        });

    }
}

package com.example.foysal.dhopabari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.spark.submitbutton.SubmitButton;

public class OrderActivity extends AppCompatActivity {

    private SubmitButton sb;
    private EditText et_name, et_number, et_address;
    private String name,number,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_name = (EditText) findViewById(R.id.Name);
        et_number = (EditText) findViewById(R.id.Number);
        et_address = (EditText) findViewById(R.id.Address);

        //for submit
        sb = (SubmitButton) findViewById(R.id.submit);
        sb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = et_name.getText().toString();
                number = et_number.getText().toString();
                address = et_address.getText().toString();
            }
        });
    }
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

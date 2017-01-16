package com.example.bhavyasapra.authorslistapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ArrayList<authorname> gd;

    //GenreDetail detail;
    authorsArrayAdapter adapter;

    ListView lv;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gd=new ArrayList<authorname>();

        lv=(ListView)findViewById(R.id.authorsListview);


        Call<authorlistdata> call = ApiClient.getApiInterface().getauthorlist(Apikeyclass.API_KEY);
        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Fetching authors list");
        progressDialog.setMessage("Wait");
        progressDialog.show();


        call.enqueue(new Callback<authorlistdata>() {
            @Override
            public void onResponse(Call<authorlistdata> call, Response<authorlistdata> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    authorlistdata authordata = response.body();
                    gd = authordata.authorlist;
                    adapter=new authorsArrayAdapter(MainActivity.this,gd);
                    lv.setAdapter(adapter);



                } else
                    Toast.makeText(MainActivity.this, response.message() + response.code(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<authorlistdata> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "On Failure", Toast.LENGTH_LONG).show();

            }



        });









    }
}

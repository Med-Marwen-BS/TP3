package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar ;
    private EditText t1 ;
    private EditText t2 ;
    private EditText t3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         toolbar= findViewById(R.id.MyToolBar) ;
         setSupportActionBar(toolbar);


        // toolbar.setTitle("FirstApp");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar = findViewById(R.id.MyToolBa;
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);


    }


    @SuppressLint("QueryPermissionsNeeded")
    public void url(View view) {

      /**  String url = t1.getText().toString();
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntent.setAction(Intent.ACTION_SEND);
        Intent shareIntent = Intent.createChooser(browserIntent, null);
        startActivity(shareIntent);*/


        String url = t1.getText().toString();
        if (!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;

        //String url = "http://www.google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        intent.putExtra("url", url);
        // Note the Chooser below. If no applications match,
        // Android displays a system message.So here there is no need for try-catch.
        startActivity(Intent.createChooser(intent, "Browse with"));
    }

    public void location(View view) {

        String Search = t2.getText().toString();
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+Search);

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void shareText(View view) {

        String Search = t3.getText().toString();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Search);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
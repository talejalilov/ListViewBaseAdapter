package com.example.lab5.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.lab5.R;
import com.example.lab5.databinding.ActivityDescriptionBinding;

public class DescriptionActivity extends AppCompatActivity {

    ActivityDescriptionBinding binding;

    String all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.myToolBar.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               helpButton();
            }
        });

        binding.myToolBar.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.myToolBar.shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareTxt();
            }
        });

        Intent intent = this.getIntent();
        if(intent!=null){
            String name  = intent.getStringExtra("name");
            String des = intent.getStringExtra("des");

            all = name +des;
            binding.fastNameDes.setText(name);
            binding.fastDescription.setText(des);
        }


    }

    private void helpButton(){
        AlertDialog alertDialog = new AlertDialog.Builder(DescriptionActivity.this)
                .setTitle("Help")
                .setMessage("Do you need help?")
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).create();
        alertDialog.show();
    }

    public void shareTxt() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, all);
        startActivity(Intent.createChooser(shareIntent, all));
    }
}
package com.example.lab5.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.lab5.R;
import com.example.lab5.adapter.MyAdapter;
import com.example.lab5.databinding.ActivityMainBinding;
import com.example.lab5.model.FastFoodClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyAdapter myAdapter;
    ArrayList<FastFoodClass> fastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fastList = new ArrayList<>();

        Resources resources =getResources();
        String[] fastFoodName = resources.getStringArray(R.array.FastFoodName);
        int [] fastPic = {R.drawable.burger, R.drawable.cat_1, R.drawable.cat_2, R.drawable.cat_3,
                R.drawable.cat_4, R.drawable.cat_6, R.drawable.pizza_cat,R.drawable.burger, R.drawable.cat_1, R.drawable.cat_2, R.drawable.cat_3,
                R.drawable.cat_4, R.drawable.cat_6, R.drawable.pizza_cat};
        String[] description = resources.getStringArray(R.array.Description);

        for (int i = 0; i <fastPic.length ; i++) {
            fastList.add(new FastFoodClass(fastFoodName[i], description[i],fastPic[i]));
        }

        myAdapter = new MyAdapter(fastList, getApplicationContext());
        binding.listView.setAdapter(myAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener((adapterView, view, i, l) -> {

            Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
            intent.putExtra("name", fastFoodName[i]);
            intent.putExtra("des", description[i]);
            startActivity(intent);
        });

        binding.myToolBarMain.back.setVisibility(View.INVISIBLE);

        binding.myToolBarMain.shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareTxt();
            }
        });

        binding.myToolBarMain.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helpButton();
            }
        });
    }

    private void helpButton(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
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
        String app = getApplication().getPackageName();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, app);
        startActivity(Intent.createChooser(shareIntent, app));
    }
        }


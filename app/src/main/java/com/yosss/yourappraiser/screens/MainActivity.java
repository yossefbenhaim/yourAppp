package com.yosss.yourappraiser.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yosss.yourappraiser.Frgment.Ads;
import com.yosss.yourappraiser.Frgment.Apartment_price;
import com.yosss.yourappraiser.Frgment.Search;
import com.yosss.yourappraiser.Frgment.price_card;
import com.yosss.yourappraiser.R;
import com.yosss.yourappraiser.objects_for_chat.User;
import com.yosss.yourappraiser.objects_for_chat.Utils;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView MyNovigishen;
    private SharedPreferences sharedPreferences;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportFragmentManager().beginTransaction().replace(R.id.ScrenToShou,new Apartment_price()).commit();
    MyNovigishen = findViewById(R.id.MyNovigishen);
    MyNovigishen.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.price:

                    getSupportFragmentManager().beginTransaction().replace(R.id.ScrenToShou,new Apartment_price()).commit();
                    break;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.ScrenToShou,new Search()).commit();
                    break;

                case R.id.ads:
                    getSupportFragmentManager().beginTransaction().replace(R.id.ScrenToShou,new Ads()).commit();
                    break;
                case R.id.adver:
                    getSupportFragmentManager().beginTransaction().replace(R.id.ScrenToShou,new price_card()).commit();
                    break;
            }
            return false;
        }

    });
    init();
    }

    private void init() {
        sharedPreferences=getSharedPreferences(Utils.SP_NAME,MODE_PRIVATE);
        checkIfUserIsConnected();
    }

    private void checkIfUserIsConnected() {
        if(sharedPreferences.getBoolean(Utils.IS_CONNECTED,false)){
            db.
                    collection("users").
                    document(sharedPreferences.getString(Utils.USER_NAME,"")).
                    get().
                    addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Utils.user=documentSnapshot.toObject(User.class);



                        }
                    });

        }else{
            startActivity(new Intent(MainActivity.this, Login.class));

        }
    }
}
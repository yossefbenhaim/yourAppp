package com.yosss.yourappraiser.Frgment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import com.yosss.yourappraiser.R;
import com.yosss.yourappraiser.recyclerView_for_messange.Card;

import java.util.Date;

public class price_card extends Fragment {
    public static int SPLASH_TIMER = 5000;

    EditText foolName,phone,cite, neighborhood,floor,metrim,rooms,luxuly,on_hone;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button ad;

    Animation google1,whatsApp1,fb1,en1,ploos1;
    Animation foolName1,phone1,cite1, neighborhood1,floor1,metrim1,rooms1,luxuly1,on_hone1,ad1;

    FloatingActionButton google,whatsApp,fb,en,ploos;

    boolean ploose = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_price_card, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        send_ad();


        foolName1= AnimationUtils.loadAnimation(getActivity(),R.anim.test1_anim);
        phone1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test2_anim);
        cite1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test3_anim);
        neighborhood1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test4_anim);
        metrim1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test5_anim);
        floor1= AnimationUtils.loadAnimation(getActivity(),R.anim.test6_anim);
        rooms1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test7_anim);
        luxuly1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test8_anim);
        on_hone1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test9_anim);
        ad1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test10_anim);


        foolName.setAnimation(foolName1);
        phone.setAnimation(phone1);
        cite.setAnimation(cite1);
        neighborhood.setAnimation(neighborhood1);
        floor.setAnimation(floor1);
        metrim.setAnimation(metrim1);
        rooms.setAnimation(rooms1);
        luxuly.setAnimation(luxuly1);
        on_hone.setAnimation(on_hone1);
        ad.setAnimation(ad1);
    }

    public void init(){



        google= getActivity().findViewById(R.id.google);
        whatsApp= getActivity().findViewById(R.id.whatsapp);
        fb= getActivity().findViewById(R.id.fb);
        en= getActivity().findViewById(R.id.en);
        ploos= getActivity().findViewById(R.id.ploos100);

        foolName = getActivity().findViewById(R.id.fool_name1);
        phone  = getActivity().findViewById(R.id.phone_of_card);
        cite   = getActivity().findViewById(R.id.cite1);
         neighborhood   = getActivity().findViewById(R.id.neighborhood1);
         floor  = getActivity().findViewById(R.id.floor_of_card1);
        metrim   = getActivity().findViewById(R.id.metrim1);
        rooms    = getActivity().findViewById(R.id.rooms_of_card1);
        luxuly   = getActivity().findViewById(R.id.luxuly_card1);
        on_hone   = getActivity().findViewById(R.id.on_home1);
        ad = getActivity().findViewById(R.id.ad);

        ploos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ploose){
                    google.setVisibility(View.VISIBLE);
                    fb.setVisibility(View.VISIBLE);
                    en.setVisibility(View.VISIBLE);
                    whatsApp.setVisibility(View.VISIBLE);

                    google1= AnimationUtils.loadAnimation(getActivity(),R.anim.test1_anim);
                    fb1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test2_anim);
                    en1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test3_anim);
                    whatsApp1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test5_anim);


                    google.setAnimation(google1);
                    fb.setAnimation(fb1);
                    en.setAnimation(en1);
                    whatsApp.setAnimation(whatsApp1);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                        }
                    },SPLASH_TIMER);
                }else {
                    google.setVisibility(View.GONE);
                    fb.setVisibility(View.GONE);
                    en.setVisibility(View.GONE);

                    whatsApp.setVisibility(View.GONE);
                }
                ploose=!ploose;
            }
        });


    }
private void  send_ad(){
        ad.
                setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.
                        collection("cards").
                        document(""+new Date().getTime()).
                        set(new Card(
                                foolName.getText().toString(),
                                phone.getText().toString(),
                                cite.getText().toString(),
                                neighborhood.getText().toString(),
                                floor.getText().toString(),
                                metrim.getText().toString(),
                                rooms.getText().toString(),
                                luxuly.getText().toString(),
                                on_hone.getText().toString()));
            }
        });
}
}
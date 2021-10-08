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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.anastr.speedviewlib.ProgressiveGauge;
import com.yosss.yourappraiser.R;

public class Apartment_price extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {


    public static int SPLASH_TIMER = 5000;



    Animation cite1,nebors1,floor11,rooms11,meters1,luxury1,linearLayout1, post1_of_hose1,price_of_home1,price1;

    int sumForPrice;
    String name;
    char x ;
   private TextView price , name1;

    private Spinner spinnerCites;
    private Button cite,nebors,floor,rooms,meters,luxury;
    private Button price_of_hose,post_of_home;
    private CheckBox
            ahifa,
            bat_galim,kiaiaat,ahdar,neve,ckarmel,
            floor10,floor9,floor8,floor7,floor6,floor5,floor4,floor3,floor2,floor1,
            rooms2,rooms3,rooms4,rooms5,
            met1,met2,met3,met4,met5,met6,
            terrace,parking,garden;
    boolean flag= true;
    boolean flag1 = true;


LinearLayout linearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_apartment__price, container, false);
        return root;


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();



    }


    public void init(){

        LinearLayout linearLayout=getActivity().findViewById(R.id.main_layout);
        int count = linearLayout.getChildCount();

        for(int i=0; i<count; i++) {

          if(linearLayout.getChildAt(i) instanceof CheckBox){
              linearLayout.getChildAt(i).setOnClickListener(this);
          }
            //do something with your child element
        }
        price_of_hose = getActivity().findViewById(R.id.priceOfHome);
        post_of_home = getActivity().findViewById(R.id.post_of_home);
        price = getActivity().findViewById(R.id.price1);

        cite = getActivity().findViewById(R.id.citys);
        nebors = getActivity().findViewById(R.id.neiber);
        floor =getActivity().findViewById(R.id.floor);
        rooms = getActivity().findViewById(R.id.rooms);
        meters = getActivity().findViewById(R.id.metrs);
        luxury = getActivity().findViewById(R.id.luxury);

        ahifa= getActivity().findViewById(R.id.haifa);

        bat_galim = getActivity().findViewById(R.id.bat_galim);
        kiaiaat = getActivity().findViewById(R.id.kiriat);
        ahdar = getActivity().findViewById(R.id.ahdar);
        neve = getActivity().findViewById(R.id.neve);
        ckarmel= getActivity().findViewById(R.id.ckarmel);

        floor10 = getActivity().findViewById(R.id.floor10);
        floor9 = getActivity().findViewById(R.id.floor9);
        floor8 = getActivity().findViewById(R.id.floor8);
        floor7 = getActivity().findViewById(R.id.floor7);
        floor6 = getActivity().findViewById(R.id.floor6);
        floor5 = getActivity().findViewById(R.id.floor5);
        floor4 = getActivity().findViewById(R.id.floor4);
        floor3 = getActivity().findViewById(R.id.floor3);
        floor2 = getActivity().findViewById(R.id.floor2);
        floor1 = getActivity().findViewById(R.id.floor1);


        rooms2 = getActivity().findViewById(R.id.rooms2);
        rooms3 = getActivity().findViewById(R.id.rooms3);
        rooms4 = getActivity().findViewById(R.id.rooms4);
        rooms5 = getActivity().findViewById(R.id.rooms5);


        met1 = getActivity().findViewById(R.id.met1);
        met2 = getActivity().findViewById(R.id.met2);
        met3 = getActivity().findViewById(R.id.met3);
        met4 = getActivity().findViewById(R.id.met4);
        met5 = getActivity().findViewById(R.id.met5);
        met6 = getActivity().findViewById(R.id.met6);


        terrace = getActivity().findViewById(R.id.terrace);
        parking = getActivity().findViewById(R.id.parking);
        garden= getActivity().findViewById(R.id.gorden);

        cite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    ahifa.setVisibility(View.VISIBLE);
                }else {
                    ahifa.setVisibility(View.GONE);
                }
                flag=!flag;
            }
        });
        nebors .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                    bat_galim.setVisibility(View.VISIBLE);
                    kiaiaat .setVisibility(View.VISIBLE);
                    ahdar .setVisibility(View.VISIBLE);
                    neve .setVisibility(View.VISIBLE);
                    ckarmel.setVisibility(View.VISIBLE);
                }else {

                    bat_galim.setVisibility(View.GONE);
                    kiaiaat .setVisibility(View.GONE);
                    ahdar.setVisibility(View.GONE);
                    neve.setVisibility(View.GONE);
                    ckarmel.setVisibility(View.GONE);
                }
                flag=!flag;
            }
        });
        floor .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                    floor10 .setVisibility(View.VISIBLE);
                    floor9 .setVisibility(View.VISIBLE);
                    floor8.setVisibility(View.VISIBLE);
                    floor7.setVisibility(View.VISIBLE);
                    floor6 .setVisibility(View.VISIBLE);
                    floor5 .setVisibility(View.VISIBLE);
                    floor4 .setVisibility(View.VISIBLE);
                    floor3.setVisibility(View.VISIBLE);
                    floor2 .setVisibility(View.VISIBLE);
                    floor1.setVisibility(View.VISIBLE);
                }else {
                    floor10 .setVisibility(View.GONE);
                    floor9.setVisibility(View.GONE);
                    floor8.setVisibility(View.GONE);;
                    floor7.setVisibility(View.GONE);
                    floor6 .setVisibility(View.GONE);
                    floor5 .setVisibility(View.GONE);
                    floor4 .setVisibility(View.GONE);
                    floor3.setVisibility(View.GONE);
                    floor2 .setVisibility(View.GONE);
                    floor1.setVisibility(View.GONE);
                }
                flag=!flag;
            }
        });
        rooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){

                    rooms2 .setVisibility(View.VISIBLE);
                    rooms3 .setVisibility(View.VISIBLE);
                    rooms4.setVisibility(View.VISIBLE);
                    rooms5 .setVisibility(View.VISIBLE);

                }else {
                    rooms2 .setVisibility(View.GONE);
                    rooms3 .setVisibility(View.GONE);
                    rooms4.setVisibility(View.GONE);
                    rooms5 .setVisibility(View.GONE);
                }
                flag=!flag;
            }
        });
         meters.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(flag){

                     met1 .setVisibility(View.VISIBLE);
                     met2.setVisibility(View.VISIBLE);
                     met3 .setVisibility(View.VISIBLE);
                     met4 .setVisibility(View.VISIBLE);
                     met5 .setVisibility(View.VISIBLE);
                     met6 .setVisibility(View.VISIBLE);

                 }else {
                     met1 .setVisibility(View.GONE);
                     met2.setVisibility(View.GONE);
                     met3.setVisibility(View.GONE);
                     met4 .setVisibility(View.GONE);
                     met5 .setVisibility(View.GONE);
                     met6 .setVisibility(View.GONE);
                 }
                 flag=!flag;
             }
         });
         luxury.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(flag){

                     terrace .setVisibility(View.VISIBLE);
                     parking .setVisibility(View.VISIBLE);
                     garden.setVisibility(View.VISIBLE);
                 }else {
                     terrace .setVisibility(View.GONE);
                     parking .setVisibility(View.GONE);
                     garden.setVisibility(View.GONE);
                 }
                 flag=!flag;
             }
         });


       price_of_hose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


              if(flag1) {
                  ahifa.setVisibility(View.GONE);

                  bat_galim.setVisibility(View.GONE);
                  kiaiaat.setVisibility(View.GONE);
                  ahdar.setVisibility(View.GONE);
                  neve.setVisibility(View.GONE);
                  ckarmel.setVisibility(View.GONE);

                  floor10.setVisibility(View.GONE);
                  floor9.setVisibility(View.GONE);
                  floor8.setVisibility(View.GONE);

                  floor7.setVisibility(View.GONE);
                  floor6.setVisibility(View.GONE);
                  floor5.setVisibility(View.GONE);
                  floor4.setVisibility(View.GONE);
                  floor3.setVisibility(View.GONE);
                  floor2.setVisibility(View.GONE);
                  floor1.setVisibility(View.GONE);

                  rooms2.setVisibility(View.GONE);
                  rooms3.setVisibility(View.GONE);
                  rooms4.setVisibility(View.GONE);
                  rooms5.setVisibility(View.GONE);

                  met1.setVisibility(View.GONE);
                  met2.setVisibility(View.GONE);
                  met3.setVisibility(View.GONE);
                  met4.setVisibility(View.GONE);
                  met5.setVisibility(View.GONE);
                  met6.setVisibility(View.GONE);

                  terrace.setVisibility(View.GONE);
                  parking.setVisibility(View.GONE);
                  garden.setVisibility(View.GONE);

                  price.setText(Integer.toString(sumForPrice));
                  ProgressiveGauge speedometer = getView().findViewById(R.id.speedView);
                  speedometer.speedTo(sumForPrice, 2000);
                  speedometer.setUnit("מחיר הדירה");
              }else {

                  price.setText("0");
                  sumForPrice = 0;
                  ProgressiveGauge speedometer = getView().findViewById(R.id.speedView);
                  speedometer.speedTo(0, 2000);
                  speedometer.setUnit("מחיר הדירה");

              }
               flag1=!flag1;
           }
       });

        linearLayout = getActivity().findViewById(R.id.main_layout);
        linearLayout1 = AnimationUtils.loadAnimation(getActivity(),R.anim.edit_anim);
        linearLayout.setAnimation(linearLayout1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },SPLASH_TIMER);


        price1= AnimationUtils.loadAnimation(getActivity(),R.anim.test5_anim);
        post1_of_hose1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test6_anim);
        price_of_home1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test6_anim);


        price.setAnimation(price1);
        post_of_home.setAnimation(post1_of_hose1);
        price_of_hose.setAnimation(price_of_home1);

        cite1= AnimationUtils.loadAnimation(getActivity(),R.anim.test4_anim);
        nebors1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test5_anim);
        floor11 = AnimationUtils.loadAnimation(getActivity(),R.anim.test6_anim);
        rooms11 = AnimationUtils.loadAnimation(getActivity(),R.anim.test7_anim);
        meters1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test8_anim);
        luxury1 = AnimationUtils.loadAnimation(getActivity(),R.anim.test9_anim);

        cite.setAnimation(cite1);
        nebors.setAnimation(nebors1);
        floor.setAnimation(floor11);
        rooms.setAnimation(rooms11);
        meters.setAnimation(meters1);
        luxury.setAnimation(luxury1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },SPLASH_TIMER);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
          int flag = 0;

        name = getView().getResources().getResourceEntryName(v.getId());

        x=name.charAt(0);
        if (x == 'A')

        name1.setText(x);
        switch (v.getId()){

            case  R.id.haifa:
                sumForPrice += 50000;

                break;
            case  R.id.bat_galim:
                sumForPrice+= 400000;

                break;
            case  R.id.kiriat:
                sumForPrice+= 500000;

                break;
            case  R.id.ahdar:
                sumForPrice+= 400000;
                break;
            case  R.id.neve:
                sumForPrice+= 600000;
                break;
            case  R.id.ckarmel:
                sumForPrice+= 800000;
                break;
            case  R.id.floor1:
                sumForPrice+= 700000;
                break;
            case  R.id.floor2:
                sumForPrice+= 400000;
                break;
            case  R.id.floor3:
                sumForPrice+= 400000;
                break;
            case  R.id.floor4:
                sumForPrice+= 350000;
                break;
            case  R.id.floor5:
                sumForPrice+= 350000;
                break;
            case  R.id.floor6:
                sumForPrice+= 400000;
                break;
            case  R.id.floor7:
                sumForPrice+= 400000;
                break;
            case  R.id.floor8:
                sumForPrice+= 500000;
                break;
            case  R.id.floor9:
                sumForPrice+= 600000;
                break;
            case  R.id.floor10:
                sumForPrice+= 800000;
                break;

            case  R.id.rooms2:
                sumForPrice+= 200000;
                break;
            case  R.id.rooms3:
                sumForPrice+= 300000;
                break;
            case  R.id.rooms4:
                sumForPrice+= 400000;
                break;
            case  R.id.rooms5:
                sumForPrice+= 500000;
                break;

            case  R.id.met1:
                sumForPrice+= 275000;
                break;
            case  R.id.met2:
                sumForPrice+= 300000;
                break;
            case  R.id.met3:
                sumForPrice+= 315000;
                break;
            case  R.id.met4:
                sumForPrice+= 350000;

                break;
            case  R.id.met5:
                sumForPrice+= 375000;
                break;
            case  R.id.met6:
                sumForPrice+= 400000;
                break;
            case  R.id.terrace:
                sumForPrice+= 200000;
                break;
            case  R.id.parking:
                sumForPrice+= 300000;
                break;
            case  R.id.gorden:
                sumForPrice+= 200000;
                break;
        }

    }
}
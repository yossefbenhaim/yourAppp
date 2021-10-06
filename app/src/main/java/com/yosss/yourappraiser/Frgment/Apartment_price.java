package com.yosss.yourappraiser.Frgment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.anastr.speedviewlib.ProgressiveGauge;
import com.yosss.yourappraiser.R;

public class Apartment_price extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    int sumForPrice;
    String name;
    char x ;
   private TextView price , name1;
    private Spinner spinnerCites;
    private Button Cite,nebors,floor,rooms,meters,luxury;
    private Button post_of_hose;
    private CheckBox
            ahifa,
            bat_galim,kiaiaat,ahdar,neve,ckarmel,
            floor10,floor9,floor8,floor7,floor6,floor5,floor4,floor3,floor2,floor1,
            rooms2,rooms3,rooms4,rooms5,
            met1,met2,met3,met4,met5,met6,
            terrace,parking,garden;
          String Cite1,nebors1,floor_for_chat,rooms1,meters1,luxury1;
    boolean flag= true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_apartment__price, container, false);
        return root;


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressiveGauge speedometer = getView().findViewById(R.id.speedView);
        speedometer.speedTo(7500000, 2000);
        speedometer.setUnit("מחיר הדירה");

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
         name1 = getActivity().findViewById(R.id.nametest);
        price = getActivity().findViewById(R.id.price1);
        Cite = getActivity().findViewById(R.id.citys);
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

        Cite.setOnClickListener(new View.OnClickListener() {
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

        post_of_hose = getActivity().findViewById(R.id.spot_of_);
        post_of_hose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }



    @Override
    public void onClick(View v) {

        name = getView().getResources().getResourceEntryName(v.getId());

        x=name.charAt(0);
        if (x == 'A')

        name1.setText(x);
        switch (v.getId()){

            case  R.id.haifa:
                sumForPrice += 50000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.bat_galim:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.kiriat:
                sumForPrice+= 500000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.ahdar:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.neve:
                sumForPrice+= 600000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.ckarmel:
                sumForPrice+= 800000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor1:
                sumForPrice+= 700000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor2:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor3:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor4:
                sumForPrice+= 350000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor5:
                sumForPrice+= 350000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor6:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor7:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor8:
                sumForPrice+= 500000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor9:
                sumForPrice+= 600000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.floor10:
                sumForPrice+= 800000;
                price.setText(Integer.toString(sumForPrice));
                break;

            case  R.id.rooms2:
                sumForPrice+= 200000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.rooms3:
                sumForPrice+= 300000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.rooms4:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.rooms5:
                sumForPrice+= 500000;
                price.setText(Integer.toString(sumForPrice));
                break;

            case  R.id.met1:
                sumForPrice+= 275000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.met2:
                sumForPrice+= 300000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.met3:
                sumForPrice+= 315000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.met4:
                sumForPrice+= 350000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.met5:
                sumForPrice+= 375000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.met6:
                sumForPrice+= 400000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.terrace:
                sumForPrice+= 200000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.parking:
                sumForPrice+= 300000;
                price.setText(Integer.toString(sumForPrice));
                break;
            case  R.id.gorden:
                sumForPrice+= 200000;
                price.setText(Integer.toString(sumForPrice));
                break;
        }
    }
}
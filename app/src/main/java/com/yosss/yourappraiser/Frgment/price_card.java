package com.yosss.yourappraiser.Frgment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import com.yosss.yourappraiser.R;
import com.yosss.yourappraiser.recyclerView_for_messange.ad;
import com.yosss.yourappraiser.screens.Card;

import java.util.Date;

public class price_card extends Fragment {
    EditText foolName,phone,cite, neighborhood,floor,metrim,rooms,luxuly,on_hone;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button ad;


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

    }

    public void init(){

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
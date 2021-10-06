package com.yosss.yourappraiser.Frgment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.yosss.yourappraiser.R;
import com.yosss.yourappraiser.objects_for_chat.ChatConversation;
import com.yosss.yourappraiser.objects_for_chat.RecyclerChat;
import com.yosss.yourappraiser.objects_for_chat.Utils;
import com.yosss.yourappraiser.screens.MainActivity;

import java.util.ArrayList;
import java.util.Date;

public class Ads extends Fragment {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private RecyclerView recyclerView;

    private ArrayList<ChatConversation> chats;
    private SharedPreferences sharedPreferences;
    private EditText textOfUser,editText;
    private ImageButton send_messange;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ads, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        getChatsFromServer();
        sendMassage();
        sharedPreferences = getActivity().getSharedPreferences("userData", Context.MODE_PRIVATE);
    }
    public void init(){
        editText=getActivity().findViewById(R.id.message_to_send);
        send_messange=getActivity().findViewById(R.id.send_message);

    }

    private void sendMassage (){

        send_messange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.
                        collection("chats")
                        .document(""+new Date().getTime())
                        .set(new ChatConversation(Utils.user.getName(),
                                new Date().toGMTString(),editText.getText().toString(), " "));
            }
        });
    }
    private  void getChatsFromServer(){
        db.
                collection("chats").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error==null){
                    chats = (ArrayList<ChatConversation>) value.toObjects(ChatConversation.class);

                }
                setRecyclerView();
            }

        });
        db.collection("chats").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                chats = (ArrayList<ChatConversation>) queryDocumentSnapshots.toObjects(ChatConversation.class);
                if(chats.size()>0){

                }
                setRecyclerView();
            }
        });
    }
    private void setRecyclerView(){
        recyclerView = getActivity().findViewById(R.id.recyclerView_to_chat);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerChat mAdapter = new RecyclerChat(chats);
        recyclerView.setAdapter(mAdapter);
    }
}
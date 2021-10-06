package com.yosss.yourappraiser.Frgment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.yosss.yourappraiser.screens.Card;
import com.yosss.yourappraiser.R;
import com.yosss.yourappraiser.recyclerView_for_messange.RecyclerViewCards;





import java.util.ArrayList;
import java.util.List;

public class Search<RecyclerViewAdater> extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
     private Button show;
     private TextView metrers,floor_card,rooms_card;
    private RecyclerView recyclerView;
    private List<Card> cards;
   private RecyclerViewAdater adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        getCards();
        recyclerViewAdapter();

    }

    public void init(){
        recyclerView = getView().findViewById(R.id.recyclerViewA);
        metrers = getActivity().findViewById(R.id.metrim_of_card);
        floor_card = getActivity().findViewById(R.id.floor_card);
        rooms_card  = getActivity().findViewById(R.id.rooms_card);
    }
    public void getCards(){
        cards = new ArrayList<>();

        /*
        here you want to get the info from firebase, for our example think you have on firebase
        title and text so you get the title and the text and put it here
        */
        db.collection("cards").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error==null){
                    cards=value.toObjects(Card.class);
                }
                recyclerViewAdapter();
            }
        });
    }
    private void recyclerViewAdapter(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = (RecyclerViewAdater) new RecyclerViewCards(getContext(),cards);
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sesrch_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                /*adapter.getFilter().filter(newText);*/
                return true;
            }
        });
        return true;
    }

    private MenuInflater getMenuInflater() {
        return null;
    }

}

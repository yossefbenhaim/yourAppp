package com.yosss.yourappraiser.objects_for_chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.yosss.yourappraiser.R;

import java.util.ArrayList;

public class RecyclerChat extends RecyclerView.Adapter<RecyclerChat.ViewHolder> {
    private ArrayList<ChatConversation> chats = new ArrayList<>();



    public RecyclerChat( ArrayList<ChatConversation> chats) {
        this.chats = chats;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat,parent,false);

        return new RecyclerChat.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameOfSender.setText(chats.get(position).getSender());
        holder.date.setText(chats.get(position).getDate());
        holder.text.setText(chats.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameOfSender,date,text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOfSender=itemView.findViewById(R.id.city_of_card);
            date=itemView.findViewById(R.id.date_on_chat);
            text=itemView.findViewById(R.id.text_on_chat);

        }
    }
}

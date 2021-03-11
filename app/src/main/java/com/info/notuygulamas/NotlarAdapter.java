package com.info.notuygulamas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu> {
    private Context mContext;
    private ArrayList<Notlar> notlarArrayList;

    public NotlarAdapter(Context mContext, ArrayList<Notlar> notlarArrayList) {
        this.mContext = mContext;
        this.notlarArrayList = notlarArrayList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        final Notlar notlar = notlarArrayList.get(position);

        holder.textViewDers.setText(notlar.getDers_adi());
        holder.textViewNot1.setText(String.valueOf(notlar.getNot1()));
        holder.textViewNot2.setText(String.valueOf(notlar.getNot2()));

        holder.kart_tutucu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("notlar", notlar);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notlarArrayList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardView kart_tutucu;
        private TextView textViewDers;
        private TextView textViewNot1;
        private TextView textViewNot2;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            kart_tutucu = itemView.findViewById(R.id.kart_tutucu);
            textViewDers = itemView.findViewById(R.id.textViewDers);
            textViewNot1 = itemView.findViewById(R.id.textViewNot1);
            textViewNot2 = itemView.findViewById(R.id.textViewNot2);
        }
    }

}

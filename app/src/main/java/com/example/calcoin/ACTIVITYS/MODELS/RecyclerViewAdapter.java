package com.example.calcoin.ACTIVITYS.MODELS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calcoin.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {
    private ArrayList<CryptoModel> cryptoList;

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(cryptoList.get(position));

    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }
    // class
    public class RowHolder extends RecyclerView.ViewHolder {
        TextView text_name,text_price;
        public RowHolder(@NonNull View itemView) {
            super(itemView);


        }

        public void bind(CryptoModel cryptoModel){
            // public void bind(CryptoModel cryptoModel,int position) yapmılmıştı örnekte!
            text_name=itemView.findViewById(R.id.textName);
            text_price=itemView.findViewById(R.id.textPrice);
            text_name.setText(cryptoModel.currency+":");
            text_price.setText(cryptoModel.price+" $");
        }
    }
}

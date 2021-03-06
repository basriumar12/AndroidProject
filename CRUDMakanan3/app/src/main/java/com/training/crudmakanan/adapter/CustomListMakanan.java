package com.training.crudmakanan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.training.crudmakanan.R;
import com.training.crudmakanan.model.DataMakanan;

import java.util.List;

/**
 * Created by Blackswan on 5/23/2017.
 */

public class CustomListMakanan extends  RecyclerView.Adapter<CustomListMakanan.MyViewHolder> {
    Context context;
    List<DataMakanan> listmakanan;

    private OnItemClicked onClick;

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }


    //make interface like this
    public interface OnItemClicked {
        void onItemClick(int position);
    }

    public CustomListMakanan(Context c, List<DataMakanan> listdatamakanan) {
        context = c;
        listmakanan = listdatamakanan;
    }

    @Override
    public CustomListMakanan.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tampilancustommakanan, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomListMakanan.MyViewHolder holder, final int position) {
        holder.txtmakanan.setText(listmakanan.get(position).getMakanan());
        Picasso.with(context).load(listmakanan.get(position).getFotoMakanan().toString())
                .error(R.drawable.noimage).into(holder.imgmakanan);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listmakanan.size();
    }

    //
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgmakanan;
        TextView txtmakanan;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgmakanan = (ImageView) itemView.findViewById(R.id.imgmakanan);
            txtmakanan = (TextView) itemView.findViewById(R.id.txtmakanan);
        }
    }
}

package com.example.photocalendar_app1.DTA;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.photocalendar_app1.DTO.Filter;
import com.example.photocalendar_app1.R;
import com.example.photocalendar_app1.export_calendar;

//import net.alhazmy13.imagefilter.ImageFilter;

import org.jetbrains.annotations.NotNull;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView_adapter.viewholder> {


    private ArrayList<Filter> arrayList_filter;
    private Context context;
    private OnItemClickListener mlisten;
    public   int ckeckpossition=0;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mlisten=listener;
    }




    public RecyclerView_adapter(Context context, ArrayList<Filter> arrayList_filter) {
        this.arrayList_filter = arrayList_filter;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new viewholder(view,mlisten);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView_adapter.viewholder holder, int position) {
        Filter filter= arrayList_filter.get(position);
        holder.circleImageView.setImageResource(filter.getImgae_frame());
        if(position==ckeckpossition)
        {
            holder.imageView.setVisibility(View.VISIBLE);
        }
        else   holder.imageView.setVisibility(View.GONE);

    }

    public void ckeck(int position)
    {
        ckeckpossition=position;
    }
    @Override
    public int getItemCount() {
        return arrayList_filter.size();
    }


    public static class  viewholder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        ImageView imageView;
        public viewholder(@NonNull @NotNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_ckeck);
            circleImageView = itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });



    }


    }
    public interface OnItemClickListener {
        void onItemClick(int position);

    }
}

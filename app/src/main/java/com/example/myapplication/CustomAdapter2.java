package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<com.example.myapplication.CustomAdapter2.CustomViewHolder> {

        private ArrayList<User> arrayList;
        private Context context;

        public CustomAdapter2(ArrayList<User> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public com.example.myapplication.CustomAdapter2.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            com.example.myapplication.CustomAdapter2.CustomViewHolder holder = new com.example.myapplication.CustomAdapter2.CustomViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.myapplication.CustomAdapter2.CustomViewHolder holder, int position) {
//        //서버에서 이미지 가져오기
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile())
//                .into(holder.iv_profile);

            holder.tv_name.setText(arrayList.get(position).getName());
            holder.tv_number.setText((arrayList.get(position).getAddr()));
//            holder.tv_location.setText(arrayList.get(position).getNo());
        }

        @Override
        public int getItemCount() {
            //삼항연산자
            return (arrayList !=null ? arrayList.size() : 0);
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {

            ImageView iv_profile;
            TextView tv_name;
            TextView tv_number;
    //        TextView tv_location;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                // this.iv_profile = itemView.findViewById(R.id.iv_profile);
                this.tv_name = itemView.findViewById(R.id.tv_name);
                this.tv_number = itemView.findViewById(R.id.tv_number);
  //              this.tv_location = itemView.findViewById(R.id.tv_location);
            }
        }



}

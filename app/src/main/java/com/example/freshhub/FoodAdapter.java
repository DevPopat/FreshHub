package com.example.freshhub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class FoodAdapter  extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context context;
    private List<Food> foods;

    public FoodAdapter(Context context, int item_food, List<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foods.get(position);
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.size() ;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivImage;
        private TextView tvQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }

        public void bind(Food food) {

            tvQuantity.setText("Quantity: "+Integer.toString(food.getQuantity()));
            tvName.setText("Name: "+food.getName());
            ParseFile image = food.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }

        }
    }
}

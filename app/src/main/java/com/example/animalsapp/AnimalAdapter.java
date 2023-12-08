package com.example.animalsapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*the purpose of recyclerView is to preserve memory. Whenever we scroll, the above part gets hidden and
the bottom part is visible. Essentially, the above part is deleted from the memory for a while via recycler
view.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal>animalData;
    Context context;

    public AnimalAdapter(ArrayList<Animal>animalData, Context context){
        this.animalData = animalData;
        this.context = context;
    }
    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txtAnimalName.setText(animalData.get(position).getName());
        holder.imgAnimal.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return animalData.size();
    }

    class AnimalRowHolder extends RecyclerView.ViewHolder{
        TextView txtAnimalName;
        ImageView imgAnimal;
        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);

            txtAnimalName = itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = itemView.findViewById(R.id.img_animal);
        }
    }
}

package com.example.friends;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView characterName;
    private TextView characterDescription;
    private ImageView characterImage;

    public ViewHolder(@NonNull View itemView, AdapterView.OnItemClickListener onItemClickListener) {
        super(itemView);
        characterName = itemView.findViewById(R.id.characterName);
        characterDescription = itemView.findViewById(R.id.characterDescription);
        characterImage = itemView.findViewById(R.id.characterImage);
    }
}

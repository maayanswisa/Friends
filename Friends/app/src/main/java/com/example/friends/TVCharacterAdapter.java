package com.example.friends;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TVCharacterAdapter extends RecyclerView.Adapter<TVCharacterAdapter.ViewHolder> {
    private List<TVCharacter> characters;
    private OnItemClickListener onItemClickListener;

    public TVCharacterAdapter(List<TVCharacter> characters, OnItemClickListener onItemClickListener) {
        this.characters = characters;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(TVCharacter character);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView characterName;
        private TextView characterDescription;
        private ImageView characterImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.characterName);
            characterDescription = itemView.findViewById(R.id.characterDescription);
            characterImage = itemView.findViewById(R.id.characterImage);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TVCharacter character = characters.get(position);
        holder.characterName.setText(character.getName());
        holder.characterDescription.setText(character.getDescription());
        holder.characterImage.setImageResource(character.getImageResId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(character);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}

package com.example.friends;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText searchEditText;
    private List<TVCharacter> allCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        allCharacters = createCharacters();

        TVCharacterAdapter adapter = new TVCharacterAdapter(allCharacters, new TVCharacterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TVCharacter character) {
                showCharacterName(character.getName());
            }
        });

        recyclerView.setAdapter(adapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        searchEditText = findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not required
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterCharacters(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not required
            }
        });
    }

    private void showCharacterName(String characterName) {
        // Update TextView or show a Toast with the character name
        Toast.makeText(MainActivity.this, "Clicked on " + characterName, Toast.LENGTH_SHORT).show();
    }

    private void filterCharacters(String query) {
        List<TVCharacter> filteredList = new ArrayList<>();

        if (!query.isEmpty()) {
            for (TVCharacter character : allCharacters) {
                if (character.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(character);
                }
            }
        } else {
            filteredList.addAll(allCharacters);
        }

        TVCharacterAdapter adapter = new TVCharacterAdapter(filteredList,null);
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    private List<TVCharacter> createCharacters() {
        List<TVCharacter> characters = new ArrayList<>();
        characters.add(new TVCharacter("Jennifer Aniston", "Jennifer Joanna Aniston is an American actress, comedian, director, producer and businesswoman.", R.drawable.jenifer));
        characters.add(new TVCharacter("Lisa Kudrow", "Lisa Valerie Kudrow is a Jewish-American actress and comedian, best known for her portrayal of Phoebe Buffa in the sitcom Friends.", R.drawable.lisa));
        characters.add(new TVCharacter("David Schwimmer", "Jewish-American film and television actor, director and producer. Best known for his portrayal of Ross Geller in the hit sitcom Friends.", R.drawable.david));
        characters.add(new TVCharacter("Matthew Perry", "Canadian-American actor and comedian who was nominated for a Golden Globe Award and five Emmy Awards.", R.drawable.chendler));
        characters.add(new TVCharacter("Courtney Cox", "Courtney Bess Cox is an American actress and filmmaker, best known for her portrayal of Monica Geller in the sitcom \"Friends\".", R.drawable.kortni));
        characters.add(new TVCharacter("Matt LeBlanc", "Matthew Stephen LeBlanc is an American actor. He gained worldwide recognition for his portrayal of Joey Tribiani on the NBC sitcom ``Friends'' and the spin-off series his, \"Joey\".", R.drawable.mat));
        characters.add(new TVCharacter("James Michael Tyler", "American actor, best known for portraying the character of Gunther, the manager of the cafe, in the sitcom \"Friends\".", R.drawable.james));
        characters.add(new TVCharacter("Paul Steven Rudd", "Jewish-American film actor and screenwriter. Known for his appearances in the successful comedy films.", R.drawable.poll));
        characters.add(new TVCharacter("Maggie Wheeler", "American-Jewish actress. Known especially for her roles as Janice in the series \"Friends\", and as Anita in the series \"Ellen\".", R.drawable.maggie)) ;
        characters.add(new TVCharacter("Tom Selleck", "Thomas William \"Tom\" Selleck is an American actor and director.", R.drawable.tom));
        characters.add(new TVCharacter("Eliot Gould", "Jewish-American film, television and theater actor. Was nominated for an Academy Award for Best Supporting Actor. ", R.drawable.eliot));

        return characters;
    }
}

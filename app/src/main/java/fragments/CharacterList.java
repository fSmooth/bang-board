package fragments;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fsmooth.bangboard.Character;
import com.fsmooth.bangboard.R;

import java.lang.*;


public class CharacterList extends Fragment{

    private Character[] characters;
    private ListView listCharacters;
    private CharacterListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_character_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Resources res = getContext().getResources();
        String[] names = res.getStringArray(R.array.charactersNames);
        int[] lifes = res.getIntArray(R.array.charactersLifes);
        String[] descriptions = res.getStringArray(R.array.charactersDescriptions);

        characters = new Character[] {
                new Character(names[0], lifes[0], descriptions[0]),
                new Character(names[1], lifes[1], descriptions[1]),
                new Character(names[2], lifes[2], descriptions[2]),
                new Character(names[3], lifes[3], descriptions[3])
        };

        listCharacters = (ListView) getView().findViewById(R.id.characterList);

        listCharacters.setAdapter(new CharactersAdapter(this));

        listCharacters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener!=null) {
                    listener.onCharacterSeleccionado((Character)listCharacters
                    .getAdapter().getItem(position));
                }
            }
        });

    }

    class CharactersAdapter extends ArrayAdapter<Character> {
        Activity context;

        CharactersAdapter(Fragment context) {
            super(context.getActivity(), R.layout.listitem_character, characters);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_character, null);

            TextView lblName = (TextView)item.findViewById(R.id.lblName);
            lblName.setText(characters[position].getName());

            TextView lblLifes = (TextView)item.findViewById(R.id.lblLifes);
            lblLifes.setText(String.valueOf(characters[position].getLifes()));

            return(item);
        }
    }

    public interface CharacterListener {
        void onCharacterSeleccionado(Character c);
    }

    public void setCharacterListener(CharacterListener listener) {
        this.listener=listener;
    }


}



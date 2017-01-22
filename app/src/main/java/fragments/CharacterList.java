package fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fsmooth.bangboard.R;

import java.lang.*;


public class CharacterList extends Fragment {
    Resources res = getResources();

    private String[] namesArray = res.getStringArray(R.array.charactersNames);
    private int[] lifesArray = res.getIntArray(R.array.charactersLifes);
    private String[] descriptionArray = res.getStringArray(R.array.charactersDescriptions);

    private Character[] characters = new Character[] {
            new Character(namesArray[0], lifesArray[0], descriptionArray[0]),
            new Character(namesArray[1], lifesArray[1], descriptionArray[1]),
            new Character(namesArray[2], lifesArray[2], descriptionArray[2]),
            new Character(namesArray[3], lifesArray[3], descriptionArray[3]),

    };


    private ListView listCharacters;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_character_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listCharacters = (ListView) getView().findViewById(R.id.characterList);


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

            TextView lblDe = (TextView)item.findViewById(R.id.lblName);
            lblDe.setText(characters[position].getName());

            TextView lblAsunto = (TextView)item.findViewById(R.id.lblLifes);
            lblAsunto.setText(characters[position].getLifes());

            return(item);
        }
    }
}



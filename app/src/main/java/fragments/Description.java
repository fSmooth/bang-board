package fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fsmooth.bangboard.R;


public class Description extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    public void showDescription(String texto) {
        TextView txtDescription =
                (TextView)getView().findViewById(R.id.txtDescription);

        txtDescription.setText(texto);
    }

}

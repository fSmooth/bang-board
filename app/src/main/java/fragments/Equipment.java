package fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.fsmooth.bangboard.R;

import java.util.ArrayList;
import java.util.zip.Adler32;


public class Equipment extends Fragment implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ListView listEquip;
    EditText editText;
    Button butAdd;
    ArrayList<String> arrayListEquip;
    ArrayAdapter<String> adapter_list;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equipment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        editText = (EditText) getView().findViewById(R.id.edTxtElement);
        butAdd = (Button) getView().findViewById(R.id.butAdd);
        listEquip = (ListView) getView().findViewById(R.id.listElements);

        // persistencia de la lista
        if(savedInstanceState != null)
            arrayListEquip = savedInstanceState.getStringArrayList("equipment");
        else
            arrayListEquip = new ArrayList<>();

        adapter_list = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                arrayListEquip);

        listEquip.setAdapter(adapter_list);

        butAdd.setOnClickListener(this);
        listEquip.setOnItemLongClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(!editText.getText().toString().trim().equals(""))
            arrayListEquip.add(editText.getText().toString());
            adapter_list.notifyDataSetChanged();
            editText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        final int pos = position;
        String dialog_tittle = getResources().getString(R.string.dialog_tittle);
        String dialog_message = getResources().getString(R.string.dialog_message);
        String dialog_positive_button = getResources().getString(R.string.dialog_positive_button);
        String dialog_negative_button = getResources().getString(R.string.dialog_negative_button);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());


        // Dialog to confirm deletion
        dialog.setTitle(dialog_tittle);
        dialog.setMessage(dialog_message);
        dialog.setCancelable(false);
        dialog.setPositiveButton(dialog_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayListEquip.remove(pos);
                adapter_list.notifyDataSetChanged();
            }
        });
        dialog.setNegativeButton(dialog_negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
            }
        });
        dialog.show();



        return false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList("equipment", arrayListEquip);

        super.onSaveInstanceState(outState);
    }


}

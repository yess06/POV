package com.example.pov;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class dialog extends AppCompatDialogFragment {
    private EditText code;
    private codedialog dialog;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_code, null);
        builder.setView(view).setTitle("Code Teacher")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            //Intent intent = new Intent(getContext(), loginTeacher.class);
                            //startActivity(intent);
                        String co = code.getText().toString();
                        dialog.applyText(co);
                    }
                });
        code = view.findViewById(R.id.codeteacher);
        return  builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            dialog = (codedialog) activity;
        }catch (ClassCastException e){
            throw  new  ClassCastException(activity.toString() + "must implement");
        }
    }

    public interface codedialog{
        void applyText(String code);
    }
}

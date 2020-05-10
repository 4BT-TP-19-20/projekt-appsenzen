package com.example.appsenzen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Locale;

public class AddStudentDialog extends AppCompatDialogFragment {
    private EditText editText ;
    private addStudentDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (addStudentDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement addStudentDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_student,null);
        assert getArguments() != null;

        setLanguage(builder, view);

        editText = view.findViewById(R.id.edit_student_name);

        return builder.create();
    }

    public interface addStudentDialogListener{
        void showToast(String studentName);
    }

    private void setLanguage(AlertDialog.Builder builder, View view){
        switch (Locale.getDefault().getLanguage()){
            case "en" : builder.setView(view).setTitle("Add Student").setNegativeButton("Cancel", (dialog, which) -> {

                        }).setPositiveButton("Add", (dialog, which) -> {
                            String studentName = editText.getText().toString();
                            listener.showToast(studentName);
                        });
                        break;
            case "de" :builder.setView(view).setTitle("Schüler hinzufügen").setNegativeButton("Abbrechen", (dialog, which) -> {

                        }).setPositiveButton("Hinzufügen", (dialog, which) -> {
                            String studentName = editText.getText().toString();
                            listener.showToast(studentName);
                        });
                        break;
            case "it" :builder.setView(view).setTitle("Aggiungi Studente").setNegativeButton("Annulla", (dialog, which) -> {

                        }).setPositiveButton("Aggiungi", (dialog, which) -> {
                            String studentName = editText.getText().toString();
                            listener.showToast(studentName);
                        });
                break;
        }
    }
}

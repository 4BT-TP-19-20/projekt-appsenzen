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

<<<<<<< Updated upstream
import java.util.Objects;
=======
import java.util.Locale;
>>>>>>> Stashed changes

public class AddClassDialog extends AppCompatDialogFragment {
    private EditText editText;
    private addClassDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (addClassDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement addClassDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_class, null);

        builder.setView(view).setTitle("Add Class").setNegativeButton("Cancel", (dialog, which) -> {

        }).setPositiveButton("Add", (dialog, which) -> {
            String classname = editText.getText().toString().toUpperCase();
            SchoolClassHandler.addSchoolClass(classname);
            listener.showToast(classname);
        });

        editText = view.findViewById(R.id.edit_class_name);

        return builder.create();
    }

    public interface addClassDialogListener {
        void showToast(String classname);
    }
}

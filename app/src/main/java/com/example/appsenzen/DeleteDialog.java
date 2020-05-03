package com.example.appsenzen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class DeleteDialog extends AppCompatDialogFragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_delete, null);

        builder.setView(view).setTitle(R.string.delete_title
        ).setPositiveButton(R.string.button_delete_yes, (dialog, which) -> {
            SchoolClassHandler.clear();
            Objects.requireNonNull(getActivity()).finish();
            Toast.makeText(getActivity(), R.string.delete_success, Toast.LENGTH_LONG).show();
        }).setNegativeButton(R.string.button_delete_no, (dialog, which) -> {
            //nothing
        });

        return builder.create();
    }
}

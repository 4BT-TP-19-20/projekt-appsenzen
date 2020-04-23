package com.example.appsenzen;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddStudentDialog extends AppCompatDialogFragment {
    private EditText editText ;
    private addStudentDialogListener listener;
    private String className;

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

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add_student_dialog,null);
        className = getArguments().getString("className");
        builder.setView(view).setTitle("Add Student").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String studentName = editText.getText().toString();
                SchoolClassHandler.getSchoolClass(className).addStudent(studentName);
                listener.showToast(studentName);

            }
        });

        editText = view.findViewById(R.id.edit_student_name);

        return builder.create();
    }
    public interface addStudentDialogListener{
        void showToast(String studentName);
    }

}

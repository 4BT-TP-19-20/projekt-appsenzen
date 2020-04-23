package com.example.appsenzen;

import android.os.Bundle;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences_main, rootKey);

        //tells the preference to only use numbers
        final EditTextPreference editTextPreference = findPreference("pushups_per_skip");
        assert editTextPreference != null;

        editTextPreference.setSummary(getString(R.string.pushups_per_skip) + ": " + SchoolClassHandler.getMultiplier());

        editTextPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            @Override
            public void onBindEditText(@NonNull EditText editText) {
                editText.setInputType(InputType.TYPE_CLASS_PHONE);
            }
        });

        editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                preference.setSummary(getString(R.string.pushups_per_skip) + ": " + newValue);
                SchoolClassHandler.setMultiplier(new Integer((String) newValue));
                return true;
            }
        });

        final Preference deletePreference = findPreference("delete_all_data");
        assert deletePreference != null;

        deletePreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
            @Override
            public boolean onPreferenceClick(Preference preference) {
                DeleteDialog deleteDialog = new DeleteDialog();
                deleteDialog.show(getParentFragmentManager(), "example delete dialog");

                return true;
            }
        });



    }


}

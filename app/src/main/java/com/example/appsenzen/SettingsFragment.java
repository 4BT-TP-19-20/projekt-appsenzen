package com.example.appsenzen;

import android.os.Bundle;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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

        editTextPreference.setOnBindEditTextListener(editText -> editText.setInputType(InputType.TYPE_CLASS_PHONE));

        editTextPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            preference.setSummary(getString(R.string.pushups_per_skip) + ": " + newValue);
            SchoolClassHandler.setMultiplier(new Integer((String) newValue));
            return true;
        });

        final Preference deletePreference = findPreference("delete_all_data");
        assert deletePreference != null;

        deletePreference.setOnPreferenceClickListener(preference -> {
            DeleteDialog deleteDialog = new DeleteDialog();
            deleteDialog.show(getParentFragmentManager(), "example delete dialog");

            return true;
        });

    }


}

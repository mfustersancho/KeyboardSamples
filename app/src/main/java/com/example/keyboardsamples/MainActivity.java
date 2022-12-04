package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import com.example.keyboardsamples.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final String TAG = getClass().getSimpleName();

    private ActivityMainBinding mBinding;
    private String mSpinnerLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonEditName.setOnClickListener(view -> {
            showText(mBinding.editName.getText().toString());
        });

        mBinding.buttonEditPassword.setOnClickListener(view -> {
            showText(mBinding.editPassword.getText().toString());
        });

        mBinding.buttonEditEmail.setOnClickListener(view -> {
            showText(mBinding.editEmail.getText().toString());
        });

        mBinding.buttonEditPhone.setOnClickListener(view -> {
            showText(mBinding.editPhone.getText().toString() + " - " + mSpinnerLabel);
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_label_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mBinding.spinnerEditPhone.setAdapter(adapter);

        mBinding.spinnerEditPhone.setOnItemSelectedListener(this);
    }

    private void showText(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, getString(R.string.nothing_selected));
    }
}
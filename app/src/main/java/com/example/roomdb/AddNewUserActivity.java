package com.example.roomdb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdb.db.AppDatabase;
import com.example.roomdb.db.User;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewUserActivity extends AppCompatActivity {
    public TextInputEditText mInputName, mInputSurname, mInputEmail, mInputPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        mInputName = findViewById(R.id.inputName);
        mInputSurname = findViewById(R.id.inputSurname);
        mInputEmail = findViewById(R.id.inputEmail);
        mInputPhone = findViewById(R.id.inputPhone);
        Button saveButton = findViewById(R.id.btnSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = mInputEmail.getText().toString();

                if (TextUtils.isEmpty(mInputName.getText().toString())) {
                    mInputName.requestFocus();
                    mInputName.setError("Enter your name");
                    return;
                }
                if (TextUtils.isDigitsOnly(mInputName.getText().toString())) {
                    mInputName.requestFocus();
                    mInputName.setError("Enter only alphabetical character");
                    return;
                }
                if (TextUtils.isEmpty(mInputSurname.getText().toString())) {
                    mInputSurname.requestFocus();
                    mInputSurname.setError("Enter your surname");
                    return;
                }
                if (TextUtils.isDigitsOnly(mInputSurname.getText().toString())) {
                    mInputSurname.requestFocus();
                    mInputSurname.setError("Enter only alphabetical character");
                    return;
                }
                if (TextUtils.isEmpty(mInputEmail.getText().toString())) {
                    mInputEmail.requestFocus();
                    mInputEmail.setError("Enter your Email");
                    return;
                }
                if (!emailInput.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    mInputEmail.requestFocus();
                    mInputEmail.setError("Invalid Email address");
                    return;
                }
                if (TextUtils.isEmpty(mInputPhone.getText().toString())) {
                    mInputPhone.requestFocus();
                    mInputPhone.setError("Enter your phone number");
                    return;
                }
                saveNewUser(mInputName.getText().toString(), mInputSurname.getText().toString(),
                        mInputEmail.getText().toString(), mInputPhone.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String surname, String Email, String phone) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        User user = new User();
        user.name = firstName;
        user.surname = surname;
        user.phone = phone;
        user.Email = Email;
        db.userDao().insertUser(user);
        finish();
    }
}
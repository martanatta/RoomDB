package com.example.roomdb;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdb.db.AppDatabase;
import com.example.roomdb.db.User;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        EditText firstNameInput = findViewById(R.id.firstNameInput);
        EditText lastNameInput = findViewById(R.id.lastNameInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(firstNameInput.getText().toString())) {
                    firstNameInput.requestFocus();
                    firstNameInput.setError("Enter first name");
                    return;
                }
                if (TextUtils.isEmpty(lastNameInput.getText().toString())) {
                    lastNameInput.requestFocus();
                    lastNameInput.setError("Enter last name");
                    return;
                }
                saveNewUser(firstNameInput.getText().toString(), lastNameInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String lastName) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);
        finish();
    }
}
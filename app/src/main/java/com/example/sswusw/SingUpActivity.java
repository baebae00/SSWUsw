package com.example.sswusw;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.text.Editable;

import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    private ArrayAdapter collegeadapter;
    private Spinner collegespinner;

    private ArrayAdapter majoradapter;
    private Spinner majorspinner;

    EditText emailEditText, nicknameEditText, idEditText, passwordEditText, passwordCheckEditText, correctEditText, studentNumberEditText, contestCountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);

        // 단과대 스크롤
        collegespinner = (Spinner) findViewById(R.id.collegeSpinner);
        collegeadapter = ArrayAdapter.createFromResource(this, R.array.college, android.R.layout.simple_spinner_dropdown_item);
        collegespinner.setAdapter(collegeadapter);

        // 학과 스크롤
        majorspinner = (Spinner) findViewById(R.id.majorSpinner);
        majoradapter = ArrayAdapter.createFromResource(this, R.array.major, android.R.layout.simple_spinner_dropdown_item);
        majorspinner.setAdapter(majoradapter);

        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        passwordCheckEditText = (EditText)findViewById(R.id.passwordCheckEditText);
        correctEditText = (EditText) findViewById(R.id.correctEditText);
        passwordCheckEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (passwordEditText.getText().toString().equals(passwordCheckEditText.getText().toString())) {
                    // correct
                    correctEditText.setText("일치합니다.");
                } else {
                    // incorrect
                    correctEditText.setText("일치하지 않습니다.");
                }
            }
        });

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String userEmail = emailEditText.getText().toString();
            String userNickname = nicknameEditText.getText().toString();
            String userId = idEditText.getText().toString();
            String userPassword = passwordEditText.getText().toString();
            String userPasswordCheck = passwordCheckEditText.getText().toString();
            String StudentNumber = studentNumberEditText.getText().toString();
            String ContestCount = contestCountEditText.getText().toString();

            switch (v.getId())
            {
                case R.id.signUpButton:
                    Log.e("클릭", "클릭");
                    break;
            }
        }
    };
}
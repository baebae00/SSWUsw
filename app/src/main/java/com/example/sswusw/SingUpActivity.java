package com.example.sswusw;

import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.text.Editable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SingUpActivity extends AppCompatActivity {

    private ArrayAdapter collegeadapter;
    private Spinner collegespinner;

    private ArrayAdapter majoradapter;
    private Spinner majorspinner;

    private AlertDialog dialog;

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

            /* switch (v.getId())
            {
                case R.id.signUpButton:
                    Log.e("클릭", "클릭");
                    break;
            }*/

            //아이디 중복체크 했는지 확인
            /* if (!validate) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                dialog.show();
                return;
            } */

            //한 칸이라도 입력 안했을 경우
            if (userEmail.equals("") || userNickname.equals("") || userId.equals("") || userPassword.equals("") || userPasswordCheck.equals("") ||
                    StudentNumber.equals("") || ContestCount.equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SingUpActivity.this);
                dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                dialog.show();
                return;
            }

           /*  Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonObject = new JSONObject( response );
                        boolean success = jsonObject.getBoolean( "success" );

                        //회원가입 성공시
                        if(UserPwd.equals(PassCk)) {
                            if (success) {

                                Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", UserName), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);

                                //회원가입 실패시
                            } else {
                                Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                            dialog.show();
                            return;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            };

            //서버로 Volley를 이용해서 요청
            RegisterRequest registerRequest = new RegisterRequest( UserEmail, UserPwd, UserName, responseListener);
            RequestQueue queue = Volley.newRequestQueue( RegisterActivity.this );
            queue.add( registerRequest ); */
        }
    };
}
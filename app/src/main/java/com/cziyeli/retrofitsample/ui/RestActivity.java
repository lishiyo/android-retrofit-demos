package com.cziyeli.retrofitsample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.models.UserVo;


public class RestActivity extends ActionBarActivity {

    private EditText login_editText_userName;
    private EditText login_editText_password;
    private UserVo model;
    private Button mGithubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        login_editText_userName = (EditText) findViewById(R.id.login_editText_userName);
        login_editText_password = (EditText) findViewById(R.id.login_editText_password);
        mGithubButton = (Button) findViewById(R.id.github_btn);
        model = new UserVo();
        model.setPassword(login_editText_password.getText().toString());
        model.setUsername(login_editText_userName.getText().toString());

        mGithubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goGithub();
            }
        });
    }

    public void goGithub() {
        final Intent intent = new Intent(this, GithubActivity.class);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

/*
* This method will help to call login api with the help of retrofit
* */

//    public void doLogin() {
//        RestClient.createService().login(model, new RestCallback<LoginResponse>() {
//            @Override
//            public void success(LoginResponse loginResponse, Response response) {
//                // success!
//
//                BufferedReader reader = null;
//                StringBuilder sb = new StringBuilder();
//                try {
//
//                    reader = new BufferedReader(new InputStreamReader(response.getBody().in()));
//
//                    String line;
//
//                    try {
//                        while ((line = reader.readLine()) != null) {
//                            sb.append(line);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                String result = sb.toString();
//                Log.v("Success", result);
//            }
//
//            @Override
//            public void failure(RestError error) {
//                // something went wrong
//                Log.e("There are some problem", error.toJSON());
//            }
//        });
//    }
}
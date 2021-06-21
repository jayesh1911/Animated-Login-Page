package com.example.animatedlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    Button signUp;
    ConstraintLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.layout);

        signUp = findViewById(R.id.signupBtn);

        AnimationDrawable animationDrawable = (AnimationDrawable) layout1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
    }

    public void signUpPage(View v){
        setContentView(R.layout.sign_up);
    }

    public void continueSignUp(View v){
        EditText enterName = findViewById(R.id.enterName);
        EditText enterMail = findViewById(R.id.enterMail);
        EditText enterPhone = findViewById(R.id.enterPhone);
        EditText enterPassword = findViewById(R.id.enterPassword);
        if( TextUtils.isEmpty(enterName.getText())){
            Toasty.error( this,"Name is required!",Toasty.LENGTH_SHORT ).show();

        }else if( TextUtils.isEmpty(enterMail.getText())){
            Toasty.error( this,"E-mail is required!",Toasty.LENGTH_SHORT ).show();

        }else if( TextUtils.isEmpty(enterPhone.getText())){
            Toasty.error( this,"Phone is required!",Toasty.LENGTH_SHORT ).show();

        }else if( TextUtils.isEmpty(enterPassword.getText())){
            Toasty.error( this,"Password is required!",Toasty.LENGTH_SHORT ).show();

        }else{
            Toasty.success(this, "Sign Up successful!",Toasty.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }

    }

    public void loginBtnPressed(View view){
        EditText loginMail = findViewById(R.id.loginMail);
        EditText loginPassword = findViewById(R.id.loginPassword);

        if( TextUtils.isEmpty(loginMail.getText())){
            Toasty.error( this,"E-mail is required!",Toasty.LENGTH_SHORT ).show();

        }else if( TextUtils.isEmpty(loginPassword.getText())){
            Toasty.error( this,"Password is required!",Toasty.LENGTH_SHORT ).show();
        }else{
            if(TextUtils.equals(loginMail.getText(), "kjmj004@gmail.com")) {
                if (TextUtils.equals(loginPassword.getText(),"12345"))
                    Toasty.success(this, "Login successful!",Toasty.LENGTH_SHORT).show();
                else
                    Toasty.error( this,"Incorrect Password!",Toasty.LENGTH_SHORT ).show();
            }
            else
                Toasty.error( this,"Incorrect E-mail!",Toasty.LENGTH_SHORT ).show();
        }
    }

    public void backPressed(View view){
        setContentView(R.layout.activity_main);
        layout1 = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout1.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
    }

}
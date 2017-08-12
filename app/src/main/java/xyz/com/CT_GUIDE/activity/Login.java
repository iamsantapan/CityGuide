package xyz.com.CT_GUIDE.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import xyz.com.CT_GUIDE.R;


/**
 * Created by aruna on 09-May-17.
 */

public class Login extends Activity {
    EditText email,pwd;
    Button lb,skip,clr,ex;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.pwd);
        lb = (Button) findViewById(R.id.lb);
        skip = (Button) findViewById(R.id.skip);
        clr = (Button) findViewById(R.id.clr);
        ex = (Button) findViewById(R.id.ex);


        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String pwd1 = pwd.getText().toString();
                if ((email1.equals("admin") && pwd1.equals("avd123")) || ((email1.equals("abhishek") && pwd1.equals("abhishek123")) || ((email1.equals("gaurav") && pwd1.equals("gaurav123")) || ((email1.equals("rishav") && pwd1.equals("rishav123")) || ((email1.equals("santapan") && pwd1.equals("santapan123")) || (email1.equals("sayantan") && pwd1.equals("sayantan123")) || (email1.equals("guest") && pwd1.equals("guest123")))))))

                {
                    Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "WELCOME TO CT_GUIDE", Toast.LENGTH_LONG).show();
                    Intent login = new Intent(Login.this,MainActivity.class);
                    startActivity(login);
                }
                else {
                    Toast.makeText(getApplicationContext(), "WRONG CREDENTIALS", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "PROVIDE VALID LOGIN OR USE SKIP BUTTON", Toast.LENGTH_LONG).show();
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skip = new Intent(Login.this,MainActivity.class);
                startActivity(skip);
            }
        });

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email.setText("");
                pwd.setText("");
            }
        });

        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "THANK YOU FOR USING CT_GUIDE", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
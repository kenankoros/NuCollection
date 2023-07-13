package com.example.nucollection

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var Edt_email:EditText
    lateinit var Edt_password:EditText
    lateinit var Btn_login:Button
    lateinit var Txt_gotoregister:TextView
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Edt_email = findViewById(R.id.loginemail)
        Edt_password = findViewById(R.id.loginpassword)
        Btn_login = findViewById(R.id.login_button)
        Txt_gotoregister = findViewById(R.id.signupRedirectText)
        auth = Firebase.auth

        Txt_gotoregister.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        Btn_login.setOnClickListener {
            login()
        }
    }
    private fun login(){
        val email=Edt_email.text.toString()
        val pass=Edt_password.text.toString()
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Successfully Logged in",Toast.LENGTH_LONG).show()
                var intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this,"Log in failed",Toast.LENGTH_LONG).show()
                Toast.makeText(this,"Invalid email or password",Toast.LENGTH_LONG).show()
            }
        }
    }
}





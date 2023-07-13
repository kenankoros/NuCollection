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

class SignupActivity : AppCompatActivity() {
    lateinit var Txt_register:TextView
    lateinit var Edt_signupname:EditText
    lateinit var Edt_signmail:EditText
    lateinit var Edt_password:EditText
    lateinit var Edt_conpassword:EditText
    lateinit var Btn_signup:Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        Txt_register=findViewById(R.id.loginRedirectText)
        Edt_signupname=findViewById(R.id.signup_name)
        Edt_signmail=findViewById(R.id.signup_email)
        Edt_password=findViewById(R.id.signup_password)
        Edt_conpassword=findViewById(R.id.conpassword)
        Btn_signup=findViewById(R.id.signup_button)
        auth=Firebase.auth

        Txt_register.setOnClickListener{
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        Btn_signup.setOnClickListener {
            Signupuser()

        }
    }
    private fun Signupuser(){

        val name=Edt_signupname.text.toString()
        val email=Edt_signmail.text.toString()
        val pass=Edt_password.text.toString()
        val conpass=Edt_conpassword.text.toString()

        if (email.isBlank()||pass.isBlank()){
            Toast.makeText(this,"Please insert password and email",Toast.LENGTH_LONG).show()
            return
        }else if (pass != conpass){
            Toast.makeText(this,"Password do not match",Toast.LENGTH_LONG).show()

        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) {
            if (it.isSuccessful){
                Toast.makeText(this,"Signed up successfully", Toast.LENGTH_LONG).show()
                val intent= Intent(this,LoginActivity::class.java)
                finish()
                startActivity(intent)
            }else{
                Toast.makeText(this,"Failed to create user",Toast.LENGTH_LONG).show()
            }
        }

    }
}


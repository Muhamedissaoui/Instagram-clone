package com.codinginflow.imagesearchapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
    }
    //Login methode using firebase:
    fun login(view: View) {
        //Requesting attributes from the view
        val email = findViewById<EditText>(R.id.editTextEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()
        //Firebase request/response methode:
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                task
            ->
            //if login is successful redirect to mainActivity screen:
            if(task.isSuccessful){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
    //On click methode to open the register screen:
    fun goToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
package com.codinginflow.imagesearchapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity: AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
    }
    //Register methode using firebase:
    fun register(view : View){
        //Requesting attributes from the view:
        val email = findViewById<EditText>(R.id.editTextEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()
        //Firebase request/response methode:
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                task
            ->
            //if register is successful redirect to mainActivity screen:
            if (task.isSuccessful){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }
    //On click methode to open the login screen:
    fun goToLogin(view: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
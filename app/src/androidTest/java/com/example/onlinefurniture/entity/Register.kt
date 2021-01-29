package com.example.onlinefurniture.entity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.onlinefurniture.R
import com.example.onlinefurniture.dao.User
import com.example.onlinefurniture.db.UserDB
import java.security.AlgorithmParameterGenerator.getInstance
import java.util.Currency.getInstance

class RegisterActivity : AppCompatActivity() {
        private lateinit var Fname: EditText
        private lateinit var Lname: EditText
        private lateinit var Username: EditText
        private lateinit var Password: EditText
        private lateinit var ConfirmPassword: EditText
        private lateinit var btnAddUser: Button
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.add_user)

            Fname = findViewById(R.id.Fname)
            Lname = findViewById(R.id.Lname)
            Username = findViewById(R.id.Username)
            Password = findViewById(R.id.Password)
            ConfirmPassword = findViewById(R.id.ConfirmPassword)
            btnAddUser = findViewById(R.id.btnAddUser)

            btnAddUser.setOnClickListener {
                val fname = Fname.text.toString()
                val lname = Lname.text.toString()
                val username = Username.text.toString()
                val password = Password.text.toString()
                val confirmPassword = ConfirmPassword.text.toString()

                if (password != confirmPassword) {
                    Password.error = "Password does not match"
                    Password.requestFocus()
                    return@setOnClickListener
                } else {
                    val user = User (fname,lname,username.)
                    // code goes here
                    val user = User(fname, lname, username, password)
                    CoroutineScope(Dispatchers.IO).launch {
                        StudentDB
                            .getInstance(this@RegisterActivity)
                            .getUserDAO()
                            .registerUser(user)
                        //Switch to main thread
                        withContext(Main) {
                            Toast.makeText(this@RegisterActivity, "User Saved", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                }
            }
        }
}

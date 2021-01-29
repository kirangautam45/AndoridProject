package com.example.onlinefurniture.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinefurniture.R

class RegisterUser:AppCompatActivity() {
 private lateinit var Fname:EditText
 private lateinit var Lname:EditText
 private lateinit var Username:EditText
 private lateinit var Password:EditText
 private lateinit var Confirmpassword:EditText
 private lateinit var btnAddUser: Button
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.add_user)
  Fname = findViewById(R.id.Fname)
  Lname = findViewById(R.id.Lname)
  Username = findViewById(R.id.Username)
  Password = findViewById(R.id.Password)
  Confirmpassword = findViewById(R.id.ConfirmPassword)
   btnAddUser=findViewById(R.id.btnAddUser)

  btnAddUser.setOnClickListener{
   val fname=Fname.text.toString()
   val lname=Lname.text.toString()
   val username=Username.text.toString()
   val password=Password.text.toString()
   val confirmpassword=Confirmpassword.text.toString()

   if(password!= confirmpassword){
    Password.error="password does not match "
    Password.requestFocus()
    return@setOnClickListener
   } else {
    val user = User(fname, lname, username, password)
    CoroutineScope(Dispatchers.IO).launch {
     //StudentDB(this@RegisterUserActivity).getUserDAO().registerUser(user)
     userDB.getInstance(this@RegisterUser).getUserDAO().registerUser(user)
    }
    Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
   }
  }

   }

  }

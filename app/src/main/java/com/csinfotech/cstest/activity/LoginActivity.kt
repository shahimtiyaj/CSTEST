package com.csinfotech.cstest.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.csinfotech.cstest.R

class LoginActivity : AppCompatActivity() {
    var btn_login: Button? = null
    var btn_NewUser: Button? = null
    private var inputUser_Name: EditText? = null
    private var inputPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        actionBar?.hide()

        btn_login = findViewById<View>(R.id.btn_login) as Button
        btn_NewUser = findViewById<View>(R.id.btn_NewUser) as Button
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        inputUser_Name = findViewById<View>(R.id.input_userName) as EditText
        inputPassword = findViewById<View>(R.id.input_password) as EditText

        // Login button Click Event
        btn_login?.setOnClickListener {
            val user_name =
                inputUser_Name!!.text.toString().trim { it <= ' ' }
            val password = inputPassword!!.text.toString().trim { it <= ' ' }

            // Check for empty data in the form
            if (!user_name.isEmpty() && !password.isEmpty()) {
                // login user
                if (user_name == "cs@gmail.com" && password == "123") {
                    sucessFullToast()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(
                        this,
                        "Wrong information!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else if (inputUser_Name!!.text.toString().length == 0) {
                inputUser_Name!!.error = "Please enter email"
                inputUser_Name!!.requestFocus()
            } else if (inputPassword!!.text.toString().length == 0) {
                inputPassword!!.error = "Please enter password"
                inputPassword!!.requestFocus()
            }
        }
    }

    fun sucessFullToast() {
        val context: Context = applicationContext
        val inflater = layoutInflater
        val customToastroot: View = inflater.inflate(R.layout.red_toast, null)
        val customtoast = Toast(context)
        customtoast.view = customToastroot
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG
        customtoast.show()
    }

    override fun onBackPressed() {
        //super.onBackPressed();
        showExit()
    }

    fun showExit() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to exit from CS Test App?")
            .setTitle("Exit")
            .setPositiveButton("YES"
            ) { dialog, id -> finish() }
            .setNegativeButton("CANCEL"
            ) { dialog, which -> }
        builder.show()
    }
}
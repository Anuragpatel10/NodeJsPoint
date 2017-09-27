package com.nodejspoint.app

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.View
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

/**<p>
 * Created by anurag on 23/9/17.
 * </p>
 */

public class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var emailEdt: TextInputEditText
    lateinit var nameEdt: TextInputEditText
    lateinit var passEdt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.register_button -> {
                if (nameEdt.text?.isEmpty()!!) {
                    nameEdt.requestFocus()
                    emailEdt.setError("This field is mandatory")
                    return
                }
                if (emailEdt.text?.isEmpty()!!) {
                    emailEdt.requestFocus()
                    emailEdt.setError("This field is mandatory")
                    return
                }
                if (passEdt.text?.isEmpty()!!) {
                    passEdt.requestFocus()
                    passEdt.setError("This field is mandatory")
                    return
                }

                val queue = Volley.newRequestQueue(this)
                val url = "http://nodejspoint.com/keystone/api/session/signin"

                val obj = JSONObject()
                obj.put("nameEdt", nameEdt.text.toString())
                obj.put("email", emailEdt.text.toString())
                obj.put("password", passEdt.text.toString())
                val jsonRequest = object : JsonObjectRequest(Request.Method.POST, url,
                        obj, Response.Listener<JSONObject> { response ->
                    Log.e("TAG", response.toString())

                }, Response.ErrorListener {
                    error: VolleyError? ->
                    error?.printStackTrace()
                }) {}
                queue.add(jsonRequest)
            }
        }
    }
}
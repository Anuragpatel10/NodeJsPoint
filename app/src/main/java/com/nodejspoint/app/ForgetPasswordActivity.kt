package com.nodejspoint.app

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

/**<p>
 * Created by anurag on 23/9/17.
 * </p>
 */

public class ForgetPasswordActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var emailEdt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.action_forg_pass -> {
                if (emailEdt.text?.isEmpty()!!) {
                    emailEdt.requestFocus()
                    emailEdt.setError("This field is mandatory")
                    return
                }

                val queue = Volley.newRequestQueue(this)
                val url = "http://nodejspoint.com/keystone/api/session/signin"

                val obj = JSONObject()
                obj.put("email", emailEdt.text.toString())
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
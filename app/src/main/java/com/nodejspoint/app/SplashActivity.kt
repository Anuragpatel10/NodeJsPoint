package com.nodejspoint.app

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**<p>
 * Created by anurag on 23/9/17.
 * </p>
 */

public class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val T1 = Thread({
            try {
                Thread.sleep(5000)
            } catch(e : InterruptedException) {
                e.printStackTrace();
            } finally {
                runOnUiThread({
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                })
            }
        })
        T1.start()
    }
}
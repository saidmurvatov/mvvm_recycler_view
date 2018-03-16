package e.sigare.opstalenthelp

import android.content.Intent
import android.os.Bundle
import e.sigare.opstalenthelp.Managers_Adapters.FirebaseService

class LaunchScreen : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        startService(Intent(this, FirebaseService::class.java))

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}

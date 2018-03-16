package e.sigare.opstalenthelp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show.setOnClickListener { startActivity(Intent(this, TasksActivity::class.java)) }
        request.setOnClickListener {  }
    }

    private fun setupDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.request_dialog)
        dialog.setCancelable(false)
        var title = dialog.findViewById<EditText>(R.id.title_text)
        var content = dialog.findViewById<EditText>(R.id.content_text)

    }
}

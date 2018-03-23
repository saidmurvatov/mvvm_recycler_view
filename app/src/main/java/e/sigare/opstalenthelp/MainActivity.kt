package e.sigare.opstalenthelp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import e.sigare.opstalenthelp.Managers_Adapters.FirebaseService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startService(Intent(this, FirebaseService::class.java))
        show.setOnClickListener { startActivity(Intent(this, TasksActivity::class.java)) }
        request.setOnClickListener { setupDialog() }
    }

    private fun setupDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.request_dialog)
        dialog.setCancelable(false)
        dialog.show()
        val title = dialog.findViewById<EditText>(R.id.title_text)
        val content = dialog.findViewById<EditText>(R.id.content_text)
        val addButton = dialog.findViewById<Button>(R.id.add_request)

        addButton?.setOnClickListener {
            FirebaseService.instance.addNewRequest(title?.text.toString(), content?.text.toString())
            dialog.dismiss()
        }


    }
}

package e.sigare.opstalenthelp.Managers_Adapters

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import org.greenrobot.eventbus.EventBus
import javax.inject.Singleton


/**
 * Created by Said Murvatov on 14.03.2018.
 */
@Singleton
class FirebaseService : Service() {

    companion object {
        lateinit var instance: FirebaseService
    }


    private lateinit var firebase: FirebaseFirestore

    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "SERVICE TURNED ON")
        firebase = FirebaseFirestore.getInstance()
        instance = this
        return START_STICKY
    }

    fun addNewRequest() {
        val newContact = HashMap<String, Any>()

        newContact.put("Name", "Said Murvatov")
        newContact.put("Content", "lALALALALALAALALALlalalalalalala")

        firebase.collection("Request").document("I9NQ9Jw58Ly7E3kZM2nH").set(newContact)
                .addOnCompleteListener { showToast("new Object added", this) }
                .addOnFailureListener { showToast("new Object wasn't added", this) }
    }

    fun showToast(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun getRequest() {
        firebase.collection("Request").document("I9NQ9Jw58Ly7E3kZM2nH").addSnapshotListener(EventListener<DocumentSnapshot> { documentSnapshot, e ->
            if (e != null) {
                Log.d("ERROR", e.message)
                return@EventListener
            }
            if (documentSnapshot != null && documentSnapshot.exists()) {
                EventBus.getDefault().post(documentSnapshot.data)
            }
        })

    }

    fun getCurrentRequests() : Map<String, Any> {
        return firebase.collection("Request").document("I9NQ9Jw58Ly7E3kZM2nH").get().result.data
    }

}

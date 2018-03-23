package e.sigare.opstalenthelp.Managers_Adapters

import android.app.Service
import android.content.Context
import android.content.Intent
import android.databinding.ObservableField
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import e.sigare.opstalenthelp.Models.Model
import io.reactivex.Observable
import io.reactivex.Scheduler
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Singleton
import kotlin.collections.ArrayList


/**
 * Created by Said Murvatov on 14.03.2018.
 */
@Singleton
class FirebaseService : Service() {



    companion object {
        lateinit var instance: FirebaseService
    }

    val ob: ObservableField<ArrayList<DocumentSnapshot>> = ObservableField(ArrayList<DocumentSnapshot>())
    var observable: Observable<QuerySnapshot> = Observable.empty()
    var firebase: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "SERVICE TURNED ON")
        instance = FirebaseService()
        return START_STICKY
    }

    fun addNewRequest(title: String, content: String) {
        val newContact = HashMap<String, Any>()

        newContact["Name"] = title
        newContact["Content"] = content
        newContact["Done"] = false

        firebase.collection("Request").add(newContact)
                .addOnCompleteListener { Log.d("Request", "Added")}
                .addOnFailureListener { Log.d("Request", "not added") }
    }

    private fun showToast(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun getRequest() { //: ObservableField<ArrayList<DocumentSnapshot>> {


        firebase.collection("Request").whereEqualTo("Done", false).get().addOnCompleteListener {

            EventBus.getDefault().post(it.result.documents as? ArrayList<DocumentSnapshot>)
            //ob.set(it.result.documents as ArrayList<DocumentSnapshot>)
            //observable = Observable.just(it.result)
        }

        //return ob
    }

    fun completeRequest(id: Int) {

    }

}

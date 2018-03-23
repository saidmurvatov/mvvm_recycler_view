package e.sigare.opstalenthelp

import android.databinding.PropertyChangeRegistry
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.android.synthetic.main.activity_tasks.*
import e.sigare.opstalenthelp.Managers_Adapters.FirebaseService
import e.sigare.opstalenthelp.Models.IModel
import e.sigare.opstalenthelp.Models.Model
import e.sigare.qaranqus.RecyclerViewAdapter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class TasksActivity : AppCompatActivity() {



    private val registry = PropertyChangeRegistry()
    private val request: ArrayList<IModel> = ArrayList()
    private val recyclerViewAdapter = RecyclerViewAdapter(request, R.layout.recycler_item_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)



        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL




        recyclerView.layoutManager = llm
        recyclerView.adapter = recyclerViewAdapter


        FirebaseService.instance.getRequest()

                /*.subscribe {
            request.add(it.toObjects(Model::class.java))
            recyclerViewAdapter.notifyDataSetChanged()
            Log.d("Request", "added to arraylist + " + request.size)
        }*/

    }
    @Subscribe
    fun onEvent(requests: ArrayList<DocumentSnapshot>) {
        requests.forEach{request.add(Model(it["Name"] as String, it["Content"] as String, it["Done"] as Boolean)) }
        recyclerViewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        EventBus.getDefault().unregister(this)
        super.onPause()
    }
}

package e.sigare.opstalenthelp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import e.sigare.opstalenthelp.Managers_Adapters.FirebaseService
import e.sigare.opstalenthelp.Models.Request
import e.sigare.qaranqus.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_tasks.*
import kotlinx.android.synthetic.main.activity_tasks.view.*
import android.support.v7.widget.LinearLayoutManager
import android.util.Log


class TasksActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        val request = ArrayList<Request>()

        request.add(Request("Chuj", "CHUUUUUJ"))
        recyclerViewAdapter = RecyclerViewAdapter(request)


        recyclerView.layoutManager = llm

        recyclerView.adapter = recyclerViewAdapter




        addButton.setOnClickListener {
            request.add(Request("Lalalal", "tratata"))
            recyclerViewAdapter.notifyDataSetChanged()
            Log.d("Size", "${recyclerViewAdapter.itemCount}")
        }


    }
}

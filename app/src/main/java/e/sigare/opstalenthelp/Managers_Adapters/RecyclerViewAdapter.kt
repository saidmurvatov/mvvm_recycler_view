package e.sigare.qaranqus

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import e.sigare.opstalenthelp.Models.Request
import e.sigare.opstalenthelp.R
import e.sigare.opstalenthelp.databinding.RecyclerItemLayoutBinding

/**
 * Created by Sigare on 8.01.2018.
 */

class RecyclerViewAdapter(private val request: ArrayList<Request>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    fun ViewGroup.inflate(parent: ViewGroup?): RecyclerItemLayoutBinding {
        val layoutInflater = LayoutInflater.from(context)
        var binding = DataBindingUtil.inflate<RecyclerItemLayoutBinding>(layoutInflater, R.layout.recycler_item_layout, parent, false)

        return binding
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(request[position])
        Log.d("onBind", "onBindViewHolder")
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", "getItemCount")
        return request.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        Log.d("onCreateViewHolder", "onCreateViewHolder")
        val view = parent?.inflate(parent)
        return ViewHolder(view!!)
    }

    class ViewHolder(private var binding: RecyclerItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(request: Request) {
            Log.d("bind", "bind")
            binding.request = request
        }
    }
}
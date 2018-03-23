package e.sigare.opstalenthelp

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import e.sigare.opstalenthelp.Models.IModel

/**
 * Created by Said Murvatov on 8.01.2018.
 */

class RecyclerViewAdapter(private val model: ArrayList<IModel>, private val layout: Int): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(model[position])
        Log.d("onBind", "onBindViewHolder")
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", "getItemCount")
        return model.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        Log.d("onCreateViewHolder", "onCreateViewHolder")
        val view = parent?.inflate()
        return ViewHolder(view!!)
    }

    class ViewHolder(private var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: IModel) {
            Log.d("bind", "bind")
            binding.setVariable(BR.model, model)
        }
    }

    //region extension
    private fun ViewGroup.inflate(): ViewDataBinding {
        val layoutInflater = LayoutInflater.from(context)

        return DataBindingUtil.inflate(layoutInflater, layout, this, false)
    }
    //endregion
}
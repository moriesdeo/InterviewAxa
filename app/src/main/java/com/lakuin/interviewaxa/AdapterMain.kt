package com.lakuin.interviewaxa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*
import org.jetbrains.anko.startActivity

class AdapterMain(private val list: ArrayList<ResponseMain>) :
    RecyclerView.Adapter<AdapterMain.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMain.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_main,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterMain.VH, position: Int) {
        val items = list[position]

        with(holder.itemView) {
            itemMain.text = items.title

            setOnClickListener {
                context.startActivity<MainActivity2>("data" to items)
            }
        }
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view)
}
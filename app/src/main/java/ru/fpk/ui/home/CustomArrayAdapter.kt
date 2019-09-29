package ru.fpk.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ru.fpk.R
import ru.fpk.passeger_info.data.Station

class CustomArrayAdapter(context: Context, stations: Array<Station>) :
    ArrayAdapter<Station>(context, R.layout.spinner_item_hide, stations) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, R.layout.spinner_item_hide, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, R.layout.spinner_item, convertView, parent)
    }

    private fun initView(position: Int, layout: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            layout,
            parent,
            false
        )
        val station = getItem(position)

        view.findViewById<TextView>(R.id.title).text = station?.name
        return view
    }

}
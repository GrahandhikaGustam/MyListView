package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Actor_Worldwar2Adapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var Actor_WorldWar2 = arrayListOf<Actor_WorldWar2>()

    override fun getCount(): Int {
        return Actor_WorldWar2.size
    }

    override fun getItem(i: Int): Any {
        return Actor_WorldWar2[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_actor_worldwar2, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val actorWorldwar2 = getItem(position) as Actor_WorldWar2
        viewHolder.bind(actorWorldwar2)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(Actor_WorldWar2: Actor_WorldWar2) {
            txtName.text = Actor_WorldWar2.name
            txtDescription.text = Actor_WorldWar2.description
            imgPhoto.setImageResource(Actor_WorldWar2.photo)
        }
    }
}





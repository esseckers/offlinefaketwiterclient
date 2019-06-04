package com.esseckers.test.app.offlinefaketwitterclient.presentation.twits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esseckers.test.app.offlinefaketwitterclient.R
import com.esseckers.test.app.offlinefaketwitterclient.entity.TweetData
import kotlinx.android.synthetic.main.item_tweet.view.*


/**
 * Created by Ivan Danilov on 2019-05-16.
 * Email - idanilov@kplatform.ru
 */

class TweetsAdapter : RecyclerView.Adapter<TweetsAdapter.TwitsHolder>() {

    private val items = ArrayList<TweetData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwitsHolder {
        return TwitsHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_tweet, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TwitsHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: List<TweetData>?) {
        data?.let {
            items.clear()
            items.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun addItem(data: TweetData) {
        items.add(items.size, data)
        notifyItemInserted(items.size)
    }

    inner class TwitsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: TweetData) {
            itemView.userPhoto.setImageResource(item.imgUser)
            itemView.userName.text = item.userName
            itemView.twitBody.text = item.twitText
            itemView.attachment.setImageResource(item.imgPost)
        }
    }
}
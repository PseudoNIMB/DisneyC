package ru.pseudonimb.disneyc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.pseudonimb.disneyc.databinding.CharItemBinding

class CharAdapter : RecyclerView.Adapter<CharAdapter.CharHolder>() {
    val charList = ArrayList<DataModel>()
    class CharHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CharItemBinding.bind(item)
        fun bind(dataModel: DataModel) = with(binding) {
            imageUrl.setImageResource(dataModel._id)
            //Переделать на картинку -_-
            name.text = dataModel.name
            url.text = dataModel.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.char_item, parent, false)
        return CharHolder(view)
    }

    override fun onBindViewHolder(holder: CharHolder, position: Int) {
        holder.bind(charList[position])
    }

    override fun getItemCount(): Int {
        return charList.size
    }

    fun addChar(dataModel: DataModel){
        charList.add(dataModel)
        notifyDataSetChanged()
    }

}
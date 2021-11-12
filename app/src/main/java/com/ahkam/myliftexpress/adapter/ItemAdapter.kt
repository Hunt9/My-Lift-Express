package com.ahkam.myliftexpress.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahkam.myliftexpress.R
import com.ahkam.myliftexpress.databinding.ItemMenuLayoutBinding
import com.ahkam.myliftexpress.model.Item
import com.bumptech.glide.Glide
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.ArrayList

class ItemAdapter(val selectItemListener: (item: Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {
    val itemList = ArrayList<Item>()

    fun setList(items: List<Item>) {
        itemList.clear()
        itemList.addAll(items)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMenuLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_menu_layout, parent, false)
        val vh = MyViewHolder(binding)
        vh.setOnClick()
        return vh

//        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(val binding: ItemMenuLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.ItemName.text = item.title
//        binding.ItemDescription.text = item.urduName
//        binding.ItemPrice.text = item.priceKG
//        binding.ItemUnit.text = item.priceGRAM

            binding.ItemPrice.text = item.price.toString()

            Glide.with(binding.ItemImage.context).load(item.image)
                .into(binding.ItemImage)
            Glide.with(binding.thmbnail.context).load(item.image)
                .into(binding.thmbnail)


            binding.CardView.setOnClickListener {
                binding.CardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.green
                    )
                )
                GlobalScope.launch {

                    binding.ItemPrice.text = "+1 added"
                    delay(1000)
                    binding.CardView.setCardBackgroundColor(Color.BLACK)
//                binding.ItemPrice.text = item.priceKG
                }
            }

        }

        fun setOnClick() {
            binding.root.setOnClickListener {
                itemList[adapterPosition]?.let { it1 -> selectItemListener(it1) }
            }
        }

    }


}
package com.ahkam.myliftexpress.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahkam.myliftexpress.R
import com.ahkam.myliftexpress.databinding.ItemMenuLayoutBinding
import com.ahkam.myliftexpress.model.Item
import com.bumptech.glide.Glide
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
            binding.quantity.text = item.quantity.toString()
            binding.ItemPrice.text = "Rs." + item.price.toString() + "/="
            binding.cardRatings.text= "(" + item.rating?.count.toString() + ")"
            binding.cardRatingIcon.rating = item.rating?.rate?.toFloat()!!

            Glide.with(binding.ItemImage.context).load(item.image)
                .into(binding.ItemImage)


//            binding.CardView.setOnClickListener {
//                binding.CardView.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.green
//                    )
//                )
//
//            }

            binding.plus.setOnClickListener{

                item.quantity = item.quantity.plus(1)
                binding.quantity.text = item.quantity.toString()
            }

            binding.minus.setOnClickListener{
                if(item.quantity >= 0)
                {
                    item.quantity = item.quantity.minus(1)
                    binding.quantity.text = item.quantity.toString()
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
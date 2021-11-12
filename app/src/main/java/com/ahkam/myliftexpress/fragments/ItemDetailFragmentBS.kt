package com.ahkam.myliftexpress.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ahkam.myliftexpress.R
import com.ahkam.myliftexpress.base.BaseBottomSheetDialog
import com.ahkam.myliftexpress.databinding.FragmentItemDetailBSBinding
import com.ahkam.myliftexpress.model.Item
import com.ahkam.myliftexpress.utils.Constant
import com.bumptech.glide.Glide


class ItemDetailFragmentBS : BaseBottomSheetDialog() {


    private lateinit var binding: FragmentItemDetailBSBinding

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getSerializable(Constant.ITEM) as Item

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_item_detail_b_s, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getIntentData()
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            minus.setOnClickListener {
                if (item.quantity >= 0) {
                    item.quantity = item.quantity.minus(1)
                    quantity.text = item.quantity.toString()
                }
            }
            plus.setOnClickListener {
                item.quantity = item.quantity.plus(1)
                quantity.text = item.quantity.toString()

            }
        }
    }

    private fun getIntentData() {
        binding.apply {
            ItemName.text = item.title
            quantity.text = item.quantity.toString()
            ItemPrice.text = "Rs." + item.price.toString() + "/="
            cardRatings.text = "(" + item.rating?.count.toString() + ")"
            cardRatingIcon.rating = item.rating?.rate?.toFloat()!!

            Glide.with(binding.ItemImage.context).load(item.image)
                .into(binding.ItemImage)

            description.text = item.description

            category.text = item.category

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(item: Item) =
            ItemDetailFragmentBS().apply {
                arguments = Bundle().apply {
                    putSerializable(Constant.ITEM, item)

                }
            }
    }
}
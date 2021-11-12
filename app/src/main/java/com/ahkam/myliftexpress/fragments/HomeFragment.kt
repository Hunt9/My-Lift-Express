package com.ahkam.myliftexpress.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahkam.myliftexpress.R
import com.ahkam.myliftexpress.adapter.ItemAdapter
import com.ahkam.myliftexpress.databinding.FragmentHomeBinding
import com.ahkam.myliftexpress.presentation.item.ItemViewModel
import com.ahkam.myliftexpress.presentation.item.ItemViewModelFactory
import com.ahkam.start.presentation.di.Injector
import com.google.android.material.appbar.AppBarLayout
import com.synnapps.carouselview.ImageListener
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ItemViewModelFactory
    private lateinit var binding: FragmentHomeBinding
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var adapter: ItemAdapter

    var slideImages = intArrayOf(
        R.drawable.slideone,
        R.drawable.slidetwo,
        R.drawable.slidethree,
    )

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(slideImages.get(position)) }



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.post {
            val toolbarHeight = binding.toolbar.height
            val appbarHeight = binding.appBar.height
            val whiteBgTopCurveRadius = resources.getDimensionPixelSize(R.dimen.large_margin)
            val threshold = appbarHeight - toolbarHeight - whiteBgTopCurveRadius
            binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                binding.collapsingToolbar.visibility =
                    if (verticalOffset <= -threshold) View.VISIBLE
                    else View.GONE
            })
        }
        setSliders()
        fetchData()
    }

    private fun fetchData() {
        (activity?.application as Injector).createItemSubComponent().inject(this)
        itemViewModel = ViewModelProvider(this,factory).get(ItemViewModel::class.java)
        initRecyclerView()
    }

    private fun setSliders() {
        MainScope().launch {
            binding.carouselView.setImageListener(imageListener)
            binding.carouselView.pageCount = slideImages.size}


    }

    private fun initRecyclerView(){
        binding.mShimmerViewContainer.startShimmer()
       // binding.itemList.showShimmerAdapter()
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        adapter = ItemAdapter()
        {

            ItemDetailFragmentBS.newInstance(it).show(childFragmentManager, "")
        }
        binding.itemList.adapter = adapter
        showItem()

    }

    private fun showItem(){
        val responseLiveData = itemViewModel.getItems()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null)
            {
                binding.itemList.visibility = View.VISIBLE
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.mShimmerViewContainer.stopShimmer()
                binding.mShimmerViewContainer.visibility = View.GONE
            }
        })
    }


}
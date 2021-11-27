package com.autoscout24.cardemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.autoscout24.cardemo.R
import com.autoscout24.cardemo.adapter.CarAdapter
import com.autoscout24.cardemo.databinding.FragmentCarListBinding
import com.autoscout24.cardemo.util.UNIVERSAL_ERROR_MESSAGE
import com.autoscout24.cardemo.util.showShortToast
import com.autoscout24.cardemo.viewmodel.CarListViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.autoscout24.cardemo.model.CarDetailsItem

@AndroidEntryPoint
class CarListFragment : Fragment(R.layout.fragment_car_list) {
    private val viewModel: CarListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding= FragmentCarListBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        val adapter = CarAdapter()
        binding.recyclerview.adapter = adapter

        adapter.setCarItemClickListener(object :
            CarAdapter.CarItemClickListener {
            override fun onCarItemClick(item: CarDetailsItem) {
                val direction = CarListFragmentDirections.actionCarListFragmentToCarDetailsFragment(item)
                findNavController().navigate(direction)
            }
        })

        viewModel.carList.observe(viewLifecycleOwner,{
            adapter.setCarList(it)
        })


        viewModel.errorLiveData.observe(viewLifecycleOwner, {
            requireContext().showShortToast(it?: UNIVERSAL_ERROR_MESSAGE)
        })

        viewModel.loadingLiveData.observe(viewLifecycleOwner, {
            binding.progressDialog.isVisible=it
        })

        viewModel.getAllCars()

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true ) {
                override fun handleOnBackPressed() {
                        requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }

}
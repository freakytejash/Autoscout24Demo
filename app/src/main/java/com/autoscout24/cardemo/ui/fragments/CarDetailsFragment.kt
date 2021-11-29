package com.autoscout24.cardemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.autoscout24.cardemo.R
import com.autoscout24.cardemo.databinding.FragmentCarDetailsBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class CarDetailsFragment : Fragment(R.layout.fragment_car_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding= FragmentCarDetailsBinding.bind(view)

        binding.carousel.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()
        val args by navArgs<CarDetailsFragmentArgs>()
        val carImage = args.carDetailsItem

        carImage.apply {
                images.forEach {
                    list.add(
                        CarouselItem(
                            imageUrl = it.url,
                            caption = make
                        )
                    )
                }
        }
        binding.carousel.setData(list)
    }
}
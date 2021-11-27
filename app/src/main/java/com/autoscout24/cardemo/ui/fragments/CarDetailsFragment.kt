package com.autoscout24.cardemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.autoscout24.cardemo.R
import com.autoscout24.cardemo.databinding.FragmentCarDetailsBinding
import com.limerse.slider.model.CarouselItem

class CarDetailsFragment : Fragment(R.layout.fragment_car_details) {

    //val carousel: ImageCarousel = findViewById(R.id.carousel)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding= FragmentCarDetailsBinding.bind(view)

        binding.imgCarousal.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()
        val args by navArgs<CarDetailsFragmentArgs>()
        val productId = args.carDetailsItem

        productId.apply {
                images.forEach {
                    list.add(
                        CarouselItem(
                            imageUrl = it.url,
                            caption = make
                        )
                    )
                }
        }




        binding.imgCarousal.setData(list)

    }
    companion object {
        fun navigateToDetails(navController: NavController) {
            navController.navigate(R.id.action_carListFragment_to_carDetailsFragment)
        }
    }

}
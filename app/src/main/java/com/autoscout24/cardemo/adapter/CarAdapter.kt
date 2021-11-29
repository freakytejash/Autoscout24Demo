package com.autoscout24.cardemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autoscout24.cardemo.databinding.ItemRecyclerviewCarBinding
import com.bumptech.glide.Glide
import com.autoscout24.cardemo.model.CarDetailsItem

class CarAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private val carList = mutableListOf<CarDetailsItem>()

    private var carItemClickListener: CarItemClickListener? = null

    fun setCarList(list: List<CarDetailsItem>){
        if(carList.isNotEmpty())
            carList.clear()
        carList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewCarBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val car = carList[position]
        holder.binding.txtCarTitle.text = car.make
        holder.binding.tvFuelType.text = car.fuel
        holder.binding.tvPrice.text = car.price.toString()
        holder.binding.tvColor.text = car.colour
        holder.binding.tvNote.text = car.note?.note?:""

        val carImage: String
        if(!car.images.isNullOrEmpty()) {
            carImage = car.images[0].url
            Glide.with(holder.itemView.context)
                 .load(carImage)
                 .into(holder.binding.imageView)
            holder.binding.root.setOnClickListener { carItemClickListener?.onCarItemClick(car) }
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun setCarItemClickListener(listener: CarItemClickListener) {
        carItemClickListener = listener
    }

    interface CarItemClickListener {
        fun onCarItemClick(item: CarDetailsItem)
    }

}

class MainViewHolder(val binding: ItemRecyclerviewCarBinding) : RecyclerView.ViewHolder(binding.root)


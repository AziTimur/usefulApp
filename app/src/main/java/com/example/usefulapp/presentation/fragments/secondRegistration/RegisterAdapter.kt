package com.example.usefulapp.presentation.fragments.secondRegistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.usefulapp.R
import com.example.usefulapp.extensions.loadImage
import com.example.usefulapp.domain.personals.models.ModelImg

class RegisterAdapter : ListAdapter<ModelImg, RegisterAdapter.SecondViewHolder>(
    ImgDiffCall()
) {

    var imgOnLongListener: ((ModelImg) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.certificate_image_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        val imgItem = getItem(position)
        holder.ivImg.loadImage(imgItem.photo)
        holder.itemView.setOnLongClickListener {
            imgOnLongListener?.invoke(imgItem)
            true
        }
    }

    class SecondViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImg: ImageView = itemView.findViewById(R.id.imgCertificate)
    }
}
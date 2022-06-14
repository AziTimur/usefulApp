package com.example.usefulapp.presentation.fragments.mainFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.usefulapp.databinding.MainItemBinding
import com.example.usefulapp.domain.mainAndCourse.model.CourseModel
import com.example.usefulapp.extensions.loadImage

class MainAdapter : ListAdapter<CourseModel, MainAdapter.MainViewHolder>(MainDiffUtil()), Filterable {

    var onItemClick: ((CourseModel) -> Unit)? = null
    var onItemClick2: ((CourseModel) -> Unit)? = null

    var courseList: ArrayList<CourseModel> = ArrayList()
    var courseListFilter: ArrayList<CourseModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class MainViewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(courseModel: CourseModel) {

            binding.tvComments.text = courseModel.description
            binding.tvNameOfAuthor.text = courseModel.nameOfAuthor
            binding.tvTitle.text = courseModel.nameOfCourse
            binding.ivIcon.loadImage(courseModel.image.toString())

            binding.root.setOnClickListener {
                onItemClick?.invoke(getItem(absoluteAdapterPosition))
            }
            binding.btnBuy.setOnClickListener {
                onItemClick2?.invoke(getItem(absoluteAdapterPosition))
            }
        }

    }

//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    list = countryList
//                } else {
//                    val resultList = ArrayList<String>()
//                    for (row in countryList) {
//                        if (row.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
//                            resultList.add(row)
//                        }
//                    }
//                    countryFilterList = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = countryFilterList
//                return filterResults
//            }
//
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                countryFilterList = results?.values as ArrayList<String>
//                notifyDataSetChanged()
//            }
//
//        }
//
//    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(list: List<CourseModel>?) {
        courseList = list as ArrayList<CourseModel>
        courseListFilter = courseList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) courseListFilter = courseList else {
                    val filteredList = ArrayList<CourseModel>()
                    courseList
                        .filter {
                            (it.nameOfCourse!!.contains(constraint!!)) or
                                    (it.nameOfAuthor?.contains(constraint)!!)

                        }
                        .forEach { filteredList.add(it) }
                    courseListFilter = filteredList

                }
                return FilterResults().apply { values = courseListFilter }
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                courseListFilter = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<CourseModel>
                notifyDataSetChanged()
            }
        }

    }
}
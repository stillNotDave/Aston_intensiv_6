package ru.sfedu.aston6recycleview

import androidx.recyclerview.widget.DiffUtil
import ru.sfedu.aston6recycleview.model.Person

class DiffUtil : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.equals(newItem)
    }
}
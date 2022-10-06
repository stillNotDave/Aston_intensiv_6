package ru.sfedu.aston6recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.sfedu.aston6recycleview.databinding.ItemPersonBinding
import ru.sfedu.aston6recycleview.model.Person

class PersonAdapter(
    private val onClickAction: (Person) -> Unit,

    ) : ListAdapter<Person, RecyclerView.ViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonBinding.inflate(inflater)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is ContactViewHolder && item is Person){
            holder.setName(item)
            holder.binding.root.setOnClickListener {
                onClickAction(item)
            }
        }
    }

    class ContactViewHolder(val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setName(person: Person) {
            binding.name.text = person.name
            binding.secondName.text = person.secondName
        }
    }
}
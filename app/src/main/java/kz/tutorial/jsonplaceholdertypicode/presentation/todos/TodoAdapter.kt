package kz.tutorial.jsonplaceholdertypicode.presentation.todos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemToDosBinding
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemUsersBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.ToDoItem
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener


class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ToDoItemViewHolder>() {
    var listener: ClickListener<ToDoItem>? = null
    private var data: List<ToDoItem> = emptyList()
    fun setData(data: List<ToDoItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemToDosBinding.inflate(inflater, parent, false)
        return ToDoItemViewHolder(binding)
    }


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        val toDoItem = data[position]
        holder.itemView.setOnClickListener {
            listener?.onClick(toDoItem)
        }
        with(holder.binding) {
            todoName.text = toDoItem.title
            todoCheckbox.isChecked = toDoItem.completed
        }
    }

    inner class ToDoItemViewHolder(val binding: ItemToDosBinding) :
        RecyclerView.ViewHolder(binding.root)

}
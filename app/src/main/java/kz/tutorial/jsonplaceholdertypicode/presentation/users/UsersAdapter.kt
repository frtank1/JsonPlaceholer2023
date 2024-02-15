package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemCommentBinding
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemUsersBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener


class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersItemViewHolder>() {
    var listener: ClickListener<User>? = null
    private var data: List<User> = emptyList()
    fun setData(data: List<User>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUsersBinding.inflate(inflater, parent, false)
        return UsersItemViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UsersItemViewHolder, position: Int) {
        val user = data[position]
        holder.itemView.setOnClickListener {
            listener?.onClick(user)
        }
        with(holder.binding) {
            title.text = user.username
            flName.text = user.name
            mail.text = user.email
        }
    }

    inner class UsersItemViewHolder(val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root)

}
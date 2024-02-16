package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemCommentBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class CommetsAdapter : RecyclerView.Adapter<CommetsAdapter.CommentsItemViewHolder>() {

    var listener: ClickListener<String>? = null

    private var data: List<Comment> = emptyList()
    fun setData(data: List<Comment>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCommentBinding.inflate(inflater, parent, false)
        return CommentsItemViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CommentsItemViewHolder, position: Int) {
        val comment = data[position]

        with(holder.binding) {
            title.text = comment.name
            bodyComments.text = comment.body
            mail.text = comment.email
            mail.setOnClickListener {
                listener?.onClick(comment.email?:"")
            }
        }
    }

    inner class CommentsItemViewHolder(val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root)

}
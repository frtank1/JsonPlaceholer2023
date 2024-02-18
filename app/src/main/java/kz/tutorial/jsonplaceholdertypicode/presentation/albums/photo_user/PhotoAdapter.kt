package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemAlbumsBinding
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemPhotoBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.AlbumsObject
import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private var data: List<Photo> = emptyList()
    fun setData(data: List<Photo>) {
        this.data = data
    }
    private var layoutStatus = LayoutStatus.LinerLayout
    fun setLayout(status: LayoutStatus) {
        this.layoutStatus = status
    }
    class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo,layoutStatus: LayoutStatus) {
            binding.photoTitle.text = photo.title
            Glide.with(binding.root)
                .load(if(layoutStatus==LayoutStatus.LinerLayout)photo.url else photo.thumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(binding.photoImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(data[position],layoutStatus)
    }
}
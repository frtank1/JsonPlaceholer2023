import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemAlbumsBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.AlbumsObject
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class AlbumsAdapter() :
    RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    private var data: List<AlbumsObject> = emptyList()
    fun setData(data: List<AlbumsObject>) {
        this.data = data
    }
    var listener: ClickListener<Int>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            listener?.onClick(data[position].album.id)
        }
    }

    override fun getItemCount(): Int = data.size

    class AlbumViewHolder(private val binding: ItemAlbumsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: AlbumsObject) {
            binding.albumTitle.text = album.album.title
            binding.albumUsername.text = "User ID: ${album.userName}"
            Glide.with(binding.root)
                .load(album.urlFirstPhoto)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(binding.albumImage)
        }
    }
}



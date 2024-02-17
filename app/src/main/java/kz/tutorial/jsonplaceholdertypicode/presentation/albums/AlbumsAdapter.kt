import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.databinding.ItemAlbumsBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Album

class AlbumsAdapter(private val albums: List<Album>) : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int = albums.size

    class AlbumViewHolder(private val binding: ItemAlbumsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.albumTitle.text = album.title
            binding.albumUsername.text = "User ID: ${album.userId}"


            // Use Glide
            Glide.with(binding.root)
                .load(album.  )
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(binding.albumImage) //


        }
        }
    }

}

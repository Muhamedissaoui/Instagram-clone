import android.view.LayoutInflater
import androidx.paging.PagingDataAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.codinginflow.imagesearchapp.R
import com.codinginflow.imagesearchapp.databinding.StoryItemBinding
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.imagesearchapp.data.UnsplashPhoto
import com.codinginflow.imagesearchapp.ui.gallery.UnsplashPhotoAdapter

class StoryAdapter(private val listener: UnsplashPhotoAdapter.OnItemClickListener)  :
    PagingDataAdapter<UnsplashPhoto,StoryAdapter.StoryViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding =
            StoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StoryViewHolder(binding)
    }

    inner class StoryViewHolder(private val binding: StoryItemBinding) :
    RecyclerView.ViewHolder(binding.root){
        //Getting the item by clicking
        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }
        //Data in views
        fun bind(photo: UnsplashPhoto){
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(storyImage)

                storyOwner.text = photo.user.username

            }
        }
    }
    //Interface of the onClickItem in the fragment
    interface OnItemClickListener {
        fun onItemClick(photo: UnsplashPhoto)
    }
    //Compares items
    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UnsplashPhoto>() {
            override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}
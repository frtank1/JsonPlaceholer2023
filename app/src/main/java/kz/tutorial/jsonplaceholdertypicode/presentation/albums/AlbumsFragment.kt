package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import AlbumsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentAlbumsBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.AlbumsObject
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListenerWithThree
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel


class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private lateinit var adapter: AlbumsAdapter
    private val viewModel: AlbumsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        initAdapter()
        initObservers()
        return binding.root
    }

    private fun initAdapter() {
        adapter = AlbumsAdapter()
        adapter.listener = ClickListenerWithThree { id,name ,albumName->
            NavHostFragment.findNavController(this).navigate(
                AlbumsFragmentDirections.albumsToPhotos(
                    id,name,albumName
                )
            )
        }
        binding.rvAlbums.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.rvAlbums.adapter = adapter
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        binding.rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.albumsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is AlbumsState.Error -> {

                }

                AlbumsState.Loading -> {
                    changeLoading(true)
                }

                is AlbumsState.Success -> {
                    changeLoading(false)
                    changeAdapter(it.listAlbums)
                }
            }
        }
    }

    private fun changeAdapter(list: List<AlbumsObject>) {
        adapter.setData(list)
        adapter.notifyDataSetChanged()
    }

    private fun changeLoading(status: Boolean) {
        when (status) {
            true -> binding.loading.visibility = View.VISIBLE
            else -> binding.loading.visibility = View.GONE
        }
    }
}


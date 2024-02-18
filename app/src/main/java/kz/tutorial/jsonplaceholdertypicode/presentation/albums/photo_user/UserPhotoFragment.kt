package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.whenResumed
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentUserPhotoBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ALBUM_NAME
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ID
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ID_ALBUM
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.USER_NAME
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class UserPhotoFragment : Fragment() {

    private lateinit var binding: FragmentUserPhotoBinding
    private lateinit var adapter: PhotoAdapter
    private lateinit var liner:LayoutStatus
    private val id_album:Int by lazy {
        arguments?.getInt(ID_ALBUM, 0) ?: 0
    }
    private val user_name:String by lazy {
        arguments?.getString(USER_NAME,"")?:""
    }

    private val album_name:String by lazy {
        arguments?.getString(ALBUM_NAME,"")?:""
    }

    private val viewModel: PhotoViewModel by viewModel {
        parametersOf(id_album)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPhotoBinding.inflate(inflater, container, false)
        initTitle()
        initAdapter()
        initObservers()
        iconLayoutObserve()
        return binding.root
    }


    private fun initAdapter() {
        adapter = PhotoAdapter()
        binding.rvPhoto.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        liner = LayoutStatus.LinerLayout
        binding.rvPhoto.adapter = adapter
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        binding.rvPhoto.addItemDecoration(spaceItemDecoration)
    }


    private fun initObservers() {
        viewModel.photoLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is PhotoState.Error -> {

                }

                PhotoState.Loading -> {
                    changeLoading(true)
                }

                is PhotoState.Success -> {
                    changeLoading(false)
                    changeAdapter(it.listPhoto)
                }

                is PhotoState.changeLayout -> {
                    changeLayout(it.layout)
                }
            }
        }
    }

    private fun iconLayoutObserve(){
        binding.icon.setOnClickListener {
            if (liner == LayoutStatus.LinerLayout){
                liner = LayoutStatus.GridLayout
                viewModel.updateLayout(liner)

            }else if (liner == LayoutStatus.GridLayout){
                liner = LayoutStatus.LinerLayout
                viewModel.updateLayout(liner)
            }
        }
    }

    private fun initTitle() {
        with(binding) {
            title.text = album_name
            userName.text = user_name
        }
    }

    private fun changeAdapter(list: List<Photo>) {
        adapter.setData(list)
        adapter.notifyDataSetChanged()
    }

    private fun changeLayout(liner: LayoutStatus){
        when(liner){
            LayoutStatus.LinerLayout -> {
                adapter.setLayout(LayoutStatus.LinerLayout)
                binding.rvPhoto.layoutManager =
                    LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                binding.icon.setImageResource(R.mipmap.liner_icon)
            }
            LayoutStatus.GridLayout -> {
                adapter.setLayout(LayoutStatus.GridLayout)
                binding.rvPhoto.layoutManager =
                    GridLayoutManager(this.context, 2,GridLayoutManager.VERTICAL, false)
                binding.icon.setImageResource(R.mipmap.grid_icon)
            }
        }
    }

    private fun changeLoading(status: Boolean) {
        when (status) {
            true -> binding.loading.visibility = View.VISIBLE
            else -> binding.loading.visibility = View.GONE
        }
    }

}
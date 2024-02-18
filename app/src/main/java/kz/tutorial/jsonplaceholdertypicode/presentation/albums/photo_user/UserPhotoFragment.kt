package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentUserPhotoBinding


class UserPhotoFragment : Fragment() {

    private lateinit var binding:FragmentUserPhotoBinding
    private lateinit var adapter: PhotoAdapter
    private val viewModel:PhotoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPhotoBinding.inflate(inflater,container,false)

        return binding.root
    }

}
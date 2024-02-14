package kz.tutorial.jsonplaceholdertypicode.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentDetailsBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.extensions.showToast
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailsFragment : Fragment() {

    private var _bindig:FragmentDetailsBinding? = null
    private val binding get() =_bindig!!

    private val viewModel: DetailsViewModel by viewModel{
        parametersOf(arguments?.getInt("id",0))
}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindig = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    fun initViews(){
        viewModel.postDetailsLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                when(it){
                    is AppState.Error -> {
                    }
                    AppState.Loading -> {
                        loading.visibility =View.VISIBLE
                    }
                    is AppState.Success -> {
                        loading.visibility =View.GONE
                        titleMain.text = it.post.title
                        body.text = it.post.body
                        with(comments) {
                            with(firstCommit) {
                                title.text = it.listComment[0].name
                                bodyComments.text = it.listComment[0].body
                                mail.text = it.listComment[0].email
                            }
                            with(secondCommit) {
                                title.text = it.listComment[1].name
                                bodyComments.text = it.listComment[1].body
                                mail.text = it.listComment[1].email
                            }
                            with(thirdCommit) {
                                title.text = it.listComment[2].name
                                bodyComments.text = it.listComment[2].body
                                mail.text = it.listComment[2].email
                            }

                        }
                    }
                }

            }
        }
    }

}
package kz.tutorial.jsonplaceholdertypicode.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModel {
        parametersOf(arguments?.getInt("id", 0))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    fun initViews() {
        viewModel.postDetailsLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is PostState.Error -> {
                    }

                    PostState.Loading -> {
                        loading.visibility = View.VISIBLE
                    }

                    is PostState.Success -> {
                        loading.visibility = View.GONE
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
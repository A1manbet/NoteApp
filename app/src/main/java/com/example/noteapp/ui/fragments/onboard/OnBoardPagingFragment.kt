package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0-> {
                txtOn.text = "Очень удобный функционал"
                binding.lottie.setAnimation(R.raw.lottie1)

            }
            1-> {
                txtOn.text = "Быстрый, качественный продукт"
                binding.lottie.setAnimation(R.raw.lottie2)
            }
            2-> {
                txtOn.text = "Куча функций и интересных фишек"
                txtStart.text = "Начать работу"
                binding.lottie.setAnimation(R.raw.lottie3)
            }
        }
    }

}
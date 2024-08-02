package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapters.OnBoardViewPagerAdapter
import com.example.noteapp.utills.PreferenceHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private  lateinit var preferenceHelper: PreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = "$position"
        }.attach()
    }

    private fun setupListeners() = with(binding.viewPager2) {
        registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.txtSkip.visibility = View.INVISIBLE
                } else {
                    binding.txtSkip.visibility = View.VISIBLE
                }
            }
        })
        binding.txtSkip.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.tvStartWork.setOnClickListener {
            if (binding.viewPager2.currentItem == 2)
                preferenceHelper.isOnBoardShown = true
            findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
        }
    }
}
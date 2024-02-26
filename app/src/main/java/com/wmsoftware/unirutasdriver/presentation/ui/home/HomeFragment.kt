package com.wmsoftware.unirutasdriver.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.wmsoftware.unirutasdriver.R
import com.wmsoftware.unirutasdriver.databinding.FragmentHomeBinding
import com.wmsoftware.unirutasdriver.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObservers()
    }

    private fun initObservers(){
        lifecycleScope.launch {
            viewModel.locationFlow.collect { location ->
                location?.let {
                    binding.txtLocation.text = "Latitud: ${location.latitude.toString()} Longitud: ${location.longitude.toString()}"
                }
            }
        }
    }
}
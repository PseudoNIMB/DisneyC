package ru.pseudonimb.disneyc

import android.os.Bundle
import android.view.View

class HomeFragment {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_next.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.home_fragment_root)
        }

        button_prev.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}
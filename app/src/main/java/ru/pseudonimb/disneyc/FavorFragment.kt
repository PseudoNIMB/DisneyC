package ru.pseudonimb.disneyc

import android.os.Bundle
import android.view.View

class FavorFragment {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_next.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.favorites_fragment_root)
        }

        button_prev.setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}
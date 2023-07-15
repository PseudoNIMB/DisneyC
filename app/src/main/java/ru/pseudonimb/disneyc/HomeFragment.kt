package ru.pseudonimb.disneyc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pseudonimb.disneyc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val CharacterAPI = retrofit.create(CharacterAPI::class.java)
        CoroutineScope(Dispatchers.IO).launch{
            val character = CharacterAPI.getCharacterById()
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
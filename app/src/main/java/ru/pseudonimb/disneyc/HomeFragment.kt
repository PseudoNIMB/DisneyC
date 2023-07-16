package ru.pseudonimb.disneyc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pseudonimb.disneyc.databinding.FragmentHomeBinding
import kotlin.random.Random

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private val adapter = CharAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
        init()
    }

    private fun init(){
        binding.apply {
            home.layoutManager = LinearLayoutManager(context)
            home.adapter = adapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val characterAPI = retrofit.create(CharacterAPI::class.java)
        CoroutineScope(Dispatchers.Main).launch{
            val character = characterAPI.getCharacterById(11)
            run{
                this
            }
        }
    }
}
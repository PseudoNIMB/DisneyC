package ru.pseudonimb.disneyc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.pseudonimb.disneyc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_place, HomeFragment())
            .commit()

        initNavigation()

    }

    private fun initNavigation(){
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "Главная", Toast.LENGTH_SHORT).show()
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment((fragment?: HomeFragment()) as Fragment, tag)
                    true
                }
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    val tag = "favor"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment((fragment?: FavorFragment()) as Fragment, tag)
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment((fragment?: SettingsFragment()) as Fragment, tag)
                    true
                }
                else -> false
            }
        }
    }

    //Ищем фрагмент по тегу, если он есть то возвращаем его, если нет, то null
    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_place, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
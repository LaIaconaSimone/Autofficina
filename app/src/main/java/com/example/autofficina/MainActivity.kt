package com.example.autofficina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.fragment.app.replace

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    /*lateinit var navigation: BottomNavigationView

    private val onNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.fragment1 -> {
                supportFragmentManager.commit {
                    replace<FirstFragment>(R.id.container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.fragment2 -> {
                supportFragmentManager.commit {
                    replace<SecondFragment>(R.id.container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }

    }*/

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navMenu)
        navigation.setOnNavigationItemSelectedListener(onNavMenu)
        supportFragmentManager.commit {

            replace<FirstFragment>(R.id.container)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

        Room.databaseBuilder(this, ClienteDatabase::class.java, "persona").apply{}

        }
    }
*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pulsante, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragmentClienti -> {
                supportFragmentManager.commit {
                    replace<FirstFragment>(R.id.container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return true
            }
            R.id.fragmentMacchina -> {
                supportFragmentManager.commit {
                    replace<FragmentMacchina>(R.id.container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return true
            }
            R.id.fragmentInterventi -> {
                supportFragmentManager.commit {
                    replace<FragmentInterventi>(R.id.container)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

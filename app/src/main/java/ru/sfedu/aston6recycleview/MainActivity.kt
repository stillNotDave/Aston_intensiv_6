package ru.sfedu.aston6recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import com.github.javafaker.Faker
import ru.sfedu.aston6recycleview.PersonListFragment.Companion.PERSON_LIST_FRAGMENT_TAG
import ru.sfedu.aston6recycleview.model.Person
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //private lateinit var

    companion object {
        val persons = mutableListOf<Person>()
    }

    init {
        val faker = Faker.instance()
        for (contactId in 0 until 110) {
            persons.add(
                contactId, Person(
                    contactId,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    (10000..1000000).random().toString()
                )
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val personListFragment = PersonListFragment.newInstance()
        fragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, personListFragment, PERSON_LIST_FRAGMENT_TAG)
            commit()
        }
    }

}
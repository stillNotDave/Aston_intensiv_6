package ru.sfedu.aston6recycleview

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import ru.sfedu.aston6recycleview.PersonListFragment.Companion.NAME
import ru.sfedu.aston6recycleview.PersonListFragment.Companion.PHONE
import ru.sfedu.aston6recycleview.PersonListFragment.Companion.SECOND_NAME

class PersonDetailsFragment : Fragment(R.layout.persons_details_fragment) {
    private lateinit var photo: ImageView
    private lateinit var name: TextView
    private lateinit var secondName: TextView
    private lateinit var phone: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            photo = view.findViewById(R.id.photo_image_view)
            name = view.findViewById(R.id.name_text_view)
            secondName = view.findViewById(R.id.second_name_text_vew)
            phone = view.findViewById(R.id.phone_text_vew)
            val args = arguments
            args?.let {
                showPersonInformation(args)
            }
        }
    }

    fun showPersonInformation(args: Bundle) {
        // Некоторые моменты в реализации, включая загрузку случайной картинки взял у Антона.
        // Если посчитаете это за списывание, то не отимайте баллы Антону, отнимайте только мне.
        // Я перепробовал кучу способов, но везде были разные ошибки, поэтому попросил Антона показать,
        // Как он реализовал Адаптер
        val url = "https://source.unsplash.com/random/200x200?sig=${(1..150).random()}"
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(photo)
        name.text = args.get(NAME).toString()
        secondName.text = args.get(SECOND_NAME).toString()
        phone.text = args.get(PHONE).toString()
    }

    companion object {
        val PERSON_DETAILS_FRAGMENT_TAG = "PERSON_DETAILS_FRAGMENT_TAG"
        fun newInstance() = PersonDetailsFragment()
    }
}
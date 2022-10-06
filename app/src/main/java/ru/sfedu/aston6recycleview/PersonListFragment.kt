package ru.sfedu.aston6recycleview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.sfedu.aston6recycleview.MainActivity.Companion.persons
import ru.sfedu.aston6recycleview.PersonDetailsFragment.Companion.PERSON_DETAILS_FRAGMENT_TAG
import ru.sfedu.aston6recycleview.model.Person


class PersonListFragment : Fragment(R.layout.persons_list_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = PersonAdapter(
            onClickAction = {
                launchPersonDetailsFragment(it)
            }
        )
        recyclerView.adapter = adapter
        adapter.submitList(persons)
    }

    private fun launchPersonDetailsFragment(person: Person) {
        var personDetailsFragment = PersonDetailsFragment.newInstance()
        val args = Bundle()
        args.putInt(ID, person.personId)
        args.putString(NAME, person.name)
        args.putString(SECOND_NAME, person.secondName)
        args.putString(PHONE, person.phone)
        personDetailsFragment.arguments = args
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, personDetailsFragment, PERSON_DETAILS_FRAGMENT_TAG)
            addToBackStack(null)
            commit()
        }
    }

    companion object {
        val PERSON_LIST_FRAGMENT_TAG = "PERSON_LIST_FRAGMENT_TAG"
        fun newInstance() = PersonListFragment()
        const val ID = "id"
        const val NAME = "name"
        const val SECOND_NAME = "last name"
        const val PHONE = "phone"
    }
}
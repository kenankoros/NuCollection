package com.example.nucollection

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
class ProfileFragment : Fragment() {
    private lateinit var txtName: TextView
    private lateinit var txtEmail: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        // Get the Firebase Auth instance
        val firebaseAuth = FirebaseAuth.getInstance()
        // Get the user's name and email
        val user = firebaseAuth.currentUser
        val name = user?.displayName
        val email = user?.email
        // Set the text views to the user's name and email
        txtName = view.findViewById(R.id.txtName)
        txtName.text = name
        txtEmail = view.findViewById(R.id.txtEmail)
        txtEmail.text = email
        return view
    }
}
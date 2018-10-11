package com.sbilogan.werewolfmoderator.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sbilogan.werewolfmoderator.R
import kotlinx.android.synthetic.main.fragment_start_game.*

class StartGameFragment : Fragment() {
    private var listener: StartGameFragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_start_game, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is StartGameFragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement StartGameFragmentListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupControls()
    }

    private fun setupControls() {
        new_game_button.setOnClickListener { listener?.onStartGame() }
    }
    
    interface StartGameFragmentListener {
        fun onStartGame()
    }

    companion object {
        fun newInstance() = StartGameFragment()
    }
}

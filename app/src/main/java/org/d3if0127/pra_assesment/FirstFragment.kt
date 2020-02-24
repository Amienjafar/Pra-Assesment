package org.d3if0127.pra_assesment


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if0127.pra_assesment.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)
        setHasOptionsMenu(true)

        binding.btnPersegi.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_firstFragment_to_persegiPanjangFragment)
        }

        binding.btnSegitiga.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_firstFragment_to_segitigaFragment)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}

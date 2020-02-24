package org.d3if0127.pra_assesment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_persegi_panjang.*
import kotlinx.android.synthetic.main.fragment_segitiga.view.*
import org.d3if0127.pra_assesment.databinding.FragmentPersegiPanjangBinding
import java.lang.Exception


/**
 * A simple [Fragment] subclass.
 *
 */
class PersegiPanjangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentPersegiPanjangBinding>(inflater, R.layout.fragment_persegi_panjang, container, false)



        binding.tvLuas.setVisibility(View.GONE)
        binding.tvKeliling.setVisibility(View.GONE)
        binding.btnShare.setVisibility(View.GONE)

        binding.btnHitung.setOnClickListener {

            var panjangPersegi = tx_panjang.text.toString().toDouble()
            var lebarPersegi = tx_lebar.text.toString().toDouble()

            var luasPersegi = panjangPersegi * lebarPersegi
            var kelilingPersegi = 2*(panjangPersegi + lebarPersegi)

            binding.tvLuas.setVisibility(View.VISIBLE)
            binding.tvKeliling.setVisibility(View.VISIBLE)
            binding.btnShare.setVisibility(View.VISIBLE)

            tv_luas.text = luasPersegi.toString().trim()

            tv_keliling.text = kelilingPersegi.toString().trim()

            var message = tv_luas.text.toString().trim()

            sendEmail(recipient = "amienjafar120898@gmail.com", subject = "nilai", message = message)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {

        val mIntent = Intent(Intent.ACTION_SEND)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        mIntent.putExtra(Intent.EXTRA_TEXT, message)

        try {
            startActivity(Intent.createChooser(mIntent, "www.gmail.com"))
        }
        catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
        }

    }


}

package com.example.lovecanculator

import android.content.Context
import android.net.DnsResolver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.persistableBundleOf
import com.example.lovecanculator.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    
    fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val onCreateView = pre.onCreateView(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            calculate.setOnClickListener {
                App.api.getCalculate(yourName.text.toString(), anotherName.text.toString())
                    .enqueue(object :
                        Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            val model = response.body()
                            val bundle = Bundle()
                            bundle.putSerializable("model", model)
                            findNavController().navigate(R.id.ResultFragment, bundle)
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                        }

                    })
            }
        }
    }

    private fun findNavController(): Any {

    }

}

private fun AppCompatActivity.onCreateView(view: View, savedInstanceState: Bundle?) {

}

private fun Any.navigate(resultFragment: Int, bundle: Bundle) {

}

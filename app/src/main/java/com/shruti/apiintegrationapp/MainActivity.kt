package com.shruti.apiintegrationapp


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.shruti.apiintegrationapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchQuotes()
    }

    fun fetchQuotes(){
        RetrofitClass.instance.listQuotes().enqueue(object : Callback<QuotesDataClass> {
            override fun onResponse(
                call: Call<QuotesDataClass>,
                response: Response<QuotesDataClass>
            ) {
                if (response.isSuccessful){
                    val list = response.body()
                    Log.d("Response","Response Body ${list}" )
                    if (list != null){
                        binding.tvName.setText(list.quote)
                        binding.tvAuthor.setText(list.author)
                    }
                    else{
                        Log.e("Api error ", "Response failed: ${response.errorBody().toString()}")
                    }
                }
                else {
                    Log.e("API Error", "Response failed: ${response.errorBody().toString()}")
                }
            }

            override fun onFailure(call: Call<QuotesDataClass>, t: Throwable) {
                Log.e("API Error ", "Request failed : ${t.message}")
            }
        })
    }
}



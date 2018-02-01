package com.sk.kotlinretrofit.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.sk.kotlinretrofit.R
import com.sk.kotlinretrofit.adapter.MovieAdapter
import com.sk.kotlinretrofit.model.Movie
import com.sk.kotlinretrofit.rest.ApiClient
import com.sk.kotlinretrofit.rest.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
 * Created by Sambhaji Karad on 01-02-2018
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    var mAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/sambhaji213")
            startActivity(intent)
        }

        getMovieList()
    }

    private fun getMovieList() {
        val apiService = ApiClient.getClient()!!.create(ApiInterface::class.java)
        val call = apiService.getMovieList()

        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val statusCode = response.code()
                val movieResponse = response.body()!!.moviesList
                if (statusCode == 200) {
                    mAdapter = MovieAdapter(movieResponse, this@MainActivity)
                    recyclerView.adapter = mAdapter
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(TAG, t.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //https://www.simplifiedcoding.net/kotlin-recyclerview-example/
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

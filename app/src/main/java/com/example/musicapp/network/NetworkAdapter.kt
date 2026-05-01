package com.example.musicapp.network

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.musicapp.models.Album
import com.example.musicapp.models.Track
import com.example.musicapp.models.Collector
import com.example.musicapp.models.Performer
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest

class NetworkServiceAdapter constructor(context: Context) {
    companion object{
        const val BASE_URL= "https://backvynils-q6yc.onrender.com/"
        var instance: NetworkServiceAdapter? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: NetworkServiceAdapter(context).also {
                    instance = it
                }
            }
    }
    private val requestQueue: RequestQueue by lazy {
        // applicationContext keeps you from leaking the Activity or BroadcastReceiver if someone passes one in.
        Volley.newRequestQueue(context.applicationContext)
    }
    fun getAlbums(onComplete:(resp:List<Album>)->Unit, onError: (error:VolleyError)->Unit){
        requestQueue.add(getRequest("albums",
            { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Album>()
                for (i in 0 until resp.length()) {
                    val item = resp.getJSONObject(i)
                    list.add(i, Album(albumId = item.getInt("id"),name = item.getString("name"), cover = item.getString("cover"), recordLabel = item.getString("recordLabel"), releaseDate = item.getString("releaseDate").split("-")[0], genre = item.getString("genre"), description = item.getString("description")))
                }
                onComplete(list)
            },
            {
                onError(it)
            }))
    }

    fun getCollectors(onComplete:(resp:List<Collector>)->Unit, onError: (error:VolleyError)->Unit){
        requestQueue.add(getRequest("collectors",
            { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Collector>()
                for (i in 0 until resp.length()) {
                    val item = resp.getJSONObject(i)
                    list.add(i, Collector(
                        collectorId = item.getInt("id"),
                        name = item.getString("name"),
                        telephone = item.getString("telephone"),
                        email = item.getString("email")
                    ))
                }
                onComplete(list)
            },
            { onError(it) }))
    }

    fun getCollectorDetail(collectorId: Int, onComplete:(resp:Collector)->Unit, onError: (error:VolleyError)->Unit){
        requestQueue.add(getRequest("collectors/$collectorId",
            { response ->
                val item = JSONObject(response)
                val collector = Collector(
                    collectorId = item.getInt("id"),
                    name = item.getString("name"),
                    telephone = item.getString("telephone"),
                    email = item.getString("email")
                )
                onComplete(collector)
            },
            { onError(it) }))
    }
    fun getTracks(albumId:Int, onComplete:(resp:List<Track>)->Unit, onError: (error:VolleyError)->Unit) {
        requestQueue.add(getRequest("albums/$albumId/tracks",
            { response ->
                val resp = JSONArray(response)
                val list = mutableListOf<Track>()
                var item:JSONObject? = null
                for (i in 0 until resp.length()) {
                    item = resp.getJSONObject(i)
                    list.add(i, Track(trackId = item.getInt("id"), name = item.getString("name").toString(), duration = item.getString("duration"), albumId = albumId))
                }
                onComplete(list)
            },
            {
                onError(it)
            }))
    }
    private fun getRequest(path:String, responseListener: Response.Listener<String>, errorListener: Response.ErrorListener): StringRequest {
        return StringRequest(Request.Method.GET, BASE_URL+path, responseListener,errorListener)
    }
    private fun postRequest(path: String, body: JSONObject,  responseListener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener ):JsonObjectRequest{
        return  JsonObjectRequest(Request.Method.POST, BASE_URL+path, body, responseListener, errorListener)
    }
    private fun putRequest(path: String, body: JSONObject,  responseListener: Response.Listener<JSONObject>, errorListener: Response.ErrorListener ):JsonObjectRequest{
        return  JsonObjectRequest(Request.Method.PUT, BASE_URL+path, body, responseListener, errorListener)
    }
}
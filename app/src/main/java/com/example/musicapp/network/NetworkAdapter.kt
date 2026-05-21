package com.example.musicapp.network

import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.Volley
import com.example.musicapp.models.Album
import com.example.musicapp.models.Collector
import com.example.musicapp.models.Musician
import com.example.musicapp.models.Performer
import com.example.musicapp.models.Track
import com.example.musicapp.models.CollectorAlbum
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class NetworkServiceAdapter (context: Context) {

    companion object {

        const val BASE_URL = "http://35.225.193.234:3000/"

        var instance: NetworkServiceAdapter? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: NetworkServiceAdapter(context).also {
                    instance = it
                }
            }
    }

    private val requestQueue: RequestQueue by lazy {
        val trustAll = arrayOf<X509TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
        })
        val sslContext = SSLContext.getInstance("TLS").apply {
            init(null, trustAll, SecureRandom())
        }
        Volley.newRequestQueue(
            context.applicationContext,
            HurlStack(null, sslContext.socketFactory)
        )
    }

    fun getAlbums(
        onComplete: (resp: List<Album>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "albums",
                { response ->

                    val resp = JSONArray(response)
                    val list = mutableListOf<Album>()

                    for (i in 0 until resp.length()) {

                        val item = resp.getJSONObject(i)

                        val performersResp = item.getJSONArray("performers")
                        var performers = mutableListOf<Performer>()
                        for (j in 0 until performersResp.length()) {
                            val performer = performersResp.getJSONObject(j)
                            performers.add(
                                Performer(
                                    performerId = performer.getInt("id"),
                                    name = performer.getString("name"),
                                    image = performer.getString("image"),
                                    description = performer.getString("description")
                                )
                            )
                        }

                        list.add(
                            i,
                            Album(
                                albumId = item.getInt("id"),
                                name = item.getString("name"),
                                cover = item.getString("cover"),
                                recordLabel = item.getString("recordLabel"),
                                releaseDate = item.getString("releaseDate").split("-")[0],
                                genre = item.getString("genre"),
                                description = item.getString("description"),
                                performers = performers
                            )
                        )
                    }

                    onComplete(list)
                },
                { onError(it) }
            )
        )
    }

    fun getAlbumById(
        albumId: Int,
        onComplete: (resp: Album) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "albums/$albumId",
                { response ->

                    val resp = JSONObject(response)

                    val performersResp = resp.getJSONArray("performers")
                    var performers = mutableListOf<Performer>()
                    for (j in 0 until performersResp.length()) {
                        val performer = performersResp.getJSONObject(j)
                        performers.add(
                            Performer(
                                performerId = performer.getInt("id"),
                                name = performer.getString("name"),
                                image = performer.getString("image"),
                                description = performer.getString("description")
                            )
                        )
                    }

                    val album = Album(
                        albumId = resp.getInt("id"),
                        name = resp.getString("name"),
                        cover = resp.getString("cover"),
                        recordLabel = resp.getString("recordLabel"),
                        releaseDate = resp.getString("releaseDate").split("-")[0],
                        genre = resp.getString("genre"),
                        description = resp.getString("description"),
                        performers = performers
                    )

                    onComplete(album)
                },
                { onError(it) }
            )
        )
    }

    fun getTracks(
        albumId: Int,
        onComplete: (resp: List<Track>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "albums/$albumId/tracks",
                { response ->

                    val resp = JSONArray(response)
                    val list = mutableListOf<Track>()

                    for (i in 0 until resp.length()) {

                        val item = resp.getJSONObject(i)

                        list.add(
                            i,
                            Track(
                                trackId = item.getInt("id"),
                                name = item.getString("name").toString(),
                                duration = item.getString("duration"),
                                albumId = albumId
                            )
                        )
                    }

                    onComplete(list)
                },
                { onError(it) }
            )
        )
    }

    fun getCollectors(
        onComplete: (resp: List<Collector>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "collectors",
                { response ->

                    val resp = JSONArray(response)
                    val list = mutableListOf<Collector>()

                    for (i in 0 until resp.length()) {

                        val item = resp.getJSONObject(i)

                        val collectorAlbums = mutableListOf<CollectorAlbum>()

                        if (item.has("collectorAlbums")) {

                            val albumsArray = item.getJSONArray("collectorAlbums")

                            for (j in 0 until albumsArray.length()) {

                                val album = albumsArray.getJSONObject(j)

                                collectorAlbums.add(
                                    CollectorAlbum(
                                        collectorAlbumId = album.getInt("id"),
                                        price = album.getInt("price"),
                                        status = album.getString("status")
                                    )
                                )
                            }
                        }

                        list.add(
                            i,
                            Collector(
                                collectorId = item.getInt("id"),
                                name = item.getString("name"),
                                telephone = item.getString("telephone"),
                                email = item.getString("email"),
                                collectorAlbums = collectorAlbums
                            )
                        )
                    }

                    onComplete(list)
                },
                { onError(it) }
            )
        )
    }

    fun getCollectorDetail(
        collectorId: Int,
        onComplete: (resp: Collector) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "collectors/$collectorId",
                { response ->

                    val item = JSONObject(response)

                    val performers = mutableListOf<Performer>()

                    if (item.has("favoritePerformers")) {

                        val performersArray = item.getJSONArray("favoritePerformers")

                        for (i in 0 until performersArray.length()) {

                            val p = performersArray.getJSONObject(i)

                            performers.add(
                                Performer(
                                    performerId = p.getInt("id"),
                                    name = p.getString("name"),
                                    image = p.getString("image"),
                                    description = p.getString("description")
                                )
                            )
                        }
                    }

                    val collectorAlbums = mutableListOf<CollectorAlbum>()

                    if (item.has("collectorAlbums")) {

                        val albumsArray = item.getJSONArray("collectorAlbums")

                        for (i in 0 until albumsArray.length()) {

                            val album = albumsArray.getJSONObject(i)

                            collectorAlbums.add(
                                CollectorAlbum(
                                    collectorAlbumId = album.getInt("id"),
                                    price = album.getInt("price"),
                                    status = album.getString("status")
                                )
                            )
                        }
                    }

                    onComplete(
                        Collector(
                            collectorId = item.getInt("id"),
                            name = item.getString("name"),
                            telephone = item.getString("telephone"),
                            email = item.getString("email"),
                            favoritePerformers = performers,
                            collectorAlbums = collectorAlbums
                        )
                    )
                },
                { onError(it) }
            )
        )
    }

    fun getMusicians(
        onComplete: (resp: List<Musician>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        requestQueue.add(
            getRequest(
                "musicians",
                { response ->
                    try {
                        val resp = JSONArray(response)
                        val list = mutableListOf<Musician>()
                        for (i in 0 until resp.length()) {
                            val item = resp.getJSONObject(i)
                            list.add(
                                Musician(
                                    musicianId = item.getInt("id"),
                                    name = item.getString("name"),
                                    image = item.optString("image", ""),
                                    description = item.optString("description", ""),
                                    birthDate = item.optString("birthDate", "")
                                )
                            )
                        }
                        onComplete(list)
                    } catch (e: Exception) {
                        Log.e("NetworkAdapter", "parse error: ${e.message}")
                        onComplete(emptyList())
                    }
                },
                { onError(it) }
            )
        )
    }

    fun getBands(
        onComplete: (resp: List<Musician>) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {
        requestQueue.add(
            getRequest(
                "bands",
                { response ->
                    try {
                        val resp = JSONArray(response)
                        val list = mutableListOf<Musician>()
                        for (i in 0 until resp.length()) {
                            val item = resp.getJSONObject(i)
                            list.add(
                                Musician(
                                    musicianId = item.getInt("id"),
                                    name = item.getString("name"),
                                    image = item.optString("image", ""),
                                    description = item.optString("description", ""),
                                    birthDate = item.optString("birthDate", "")
                                )
                            )
                        }
                        onComplete(list)
                    } catch (e: Exception) {
                        Log.e("NetworkAdapter", "parse error: ${e.message}")
                        onComplete(emptyList())
                    }
                },
                { onError(it) }
            )
        )
    }

    fun getMusicianDetail(
        musicianId: Int,
        onComplete: (resp: Musician) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "musicians/$musicianId",
                { response ->

                    val item = JSONObject(response)

                    val albums = mutableListOf<Album>()

                    val albumsArray = item.getJSONArray("albums")

                    for (i in 0 until albumsArray.length()) {

                        val a = albumsArray.getJSONObject(i)

                        albums.add(
                            Album(
                                albumId = a.getInt("id"),
                                name = a.getString("name"),
                                cover = a.optString("cover", ""),
                                releaseDate = a.optString("releaseDate", ""),
                                description = a.optString("description", ""),
                                genre = a.optString("genre", ""),
                                recordLabel = a.optString("recordLabel", "")
                            )
                        )
                    }

                    onComplete(
                        Musician(
                            musicianId = item.getInt("id"),
                            name = item.getString("name"),
                            image = item.optString("image", ""),
                            description = item.optString("description", ""),
                            birthDate = item.optString("birthDate", ""),
                            albums = albums
                        )
                    )
                },
                { onError(it) }
            )
        )
    }

    fun getBandDetail(
        bandId: Int,
        onComplete: (resp: Musician) -> Unit,
        onError: (error: VolleyError) -> Unit
    ) {

        requestQueue.add(
            getRequest(
                "bands/$bandId",
                { response ->

                    val item = JSONObject(response)

                    val albums = mutableListOf<Album>()

                    val albumsArray = item.getJSONArray("albums")

                    for (i in 0 until albumsArray.length()) {

                        val a = albumsArray.getJSONObject(i)

                        albums.add(
                            Album(
                                albumId = a.getInt("id"),
                                name = a.getString("name"),
                                cover = a.optString("cover", ""),
                                releaseDate = a.optString("releaseDate", ""),
                                description = a.optString("description", ""),
                                genre = a.optString("genre", ""),
                                recordLabel = a.optString("recordLabel", "")
                            )
                        )
                    }

                    onComplete(
                        Musician(
                            musicianId = item.getInt("id"),
                            name = item.getString("name"),
                            image = item.optString("image", ""),
                            description = item.optString("description", ""),
                            birthDate = item.optString("birthDate", ""),
                            albums = albums
                        )
                    )
                },
                { onError(it) }
            )
        )
    }

    private fun getRequest(
        path: String,
        responseListener: Response.Listener<String>,
        errorListener: Response.ErrorListener
    ): StringRequest {

        return StringRequest(
            Request.Method.GET,
            BASE_URL + path,
            responseListener,
            errorListener
        )
    }

    private fun postRequest(
        path: String,
        body: JSONObject,
        responseListener: Response.Listener<JSONObject>,
        errorListener: Response.ErrorListener
    ): JsonObjectRequest {

        return JsonObjectRequest(
            Request.Method.POST,
            BASE_URL + path,
            body,
            responseListener,
            errorListener
        )
    }

    private fun putRequest(
        path: String,
        body: JSONObject,
        responseListener: Response.Listener<JSONObject>,
        errorListener: Response.ErrorListener
    ): JsonObjectRequest {

        return JsonObjectRequest(
            Request.Method.PUT,
            BASE_URL + path,
            body,
            responseListener,
            errorListener
        )
    }
}
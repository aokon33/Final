package com.example.finalprojecy

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import com.example.finalprojecy.Game
import org.json.JSONException

class SteamAPI {
    interface onRequestCompleteListener<T> {
        fun onComplete(result: Array<T>, errorMessage: String)
    }
    class InvalidTokenException { //make a runtime exception
        fun InvalidTokenException(){

        }
    }
    private var token = ""
    private var queue : RequestQueue? = null
    private var url = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=91CDD5BFAF6865D45E0036233C25A20E&steamid=76561198094391350&include_appinfo=true&format=json"

    private fun SteamAPI(context: Context, token: String){
        if(token.equals("") || token == null){
            //throw new Invalid
        }
        this.token = token;
        this.queue = Volley.newRequestQueue(context)
    }
    fun getGames(onRequestCompleteListener: onRequestCompleteListener<Game>){
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                var games = arrayOf<Game>()
                var game = Game()
                try{
                    game.name = response.get("name") as String
                    game.hours = response.get("playtime_forever") as Int
                }
                catch( e: JSONException){
                    onRequestCompleteListener.onComplete(null, error.toString())
                }
            },
            { error ->
                // TODO: Handle error
            }
        )

//        val JsonObjectRequest = JsonObjectRequest(Request.Method.GET, url,null,
//            Response.Listener<JSONObject> { response ->
//                @Override
//                fun onResponse(response: JSONObject){
//
//                }
//            })
    }

}

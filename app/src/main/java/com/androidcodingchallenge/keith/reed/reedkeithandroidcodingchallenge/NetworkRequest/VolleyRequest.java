package com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.NetworkRequest;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.DataModel.ArrayOfBook;
import com.google.gson.Gson;
import org.json.JSONArray;


public class VolleyRequest {
    Context context;
    String url;
    CompletionHandler networkCompletionHandler;



    public VolleyRequest(Context context){
        this.context = context;
    }

    public VolleyRequest(Context context, CompletionHandler completionHandler){
        this.context = context;
        this.networkCompletionHandler = completionHandler;
    }



    public void getBooks(String JSONURL){
        this.url = JSONURL;

        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Gson googleJson = new Gson();
                        ArrayOfBook books = googleJson.fromJson(jsonArray.toString(), ArrayOfBook.class);
                        networkCompletionHandler.retrieveBooks(books);

                    }
                },


                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(context, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                        networkCompletionHandler.onError();
                    }
                }) {

        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        requestQueue.add(request);
    } {


    }



}

package com.erickogi14gmail.rog.volley;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by kimani kogi on 5/27/2017.
 */

public class volley {


    static RequestQueue queue;
    private Context context;

    public volley(Context context) {
        this.context = context;
    }

    public String response(String response) {
        String res = response;


        return res;
    }

    public void requestDataSources(String uri) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response != null || !response.isEmpty()) {


                        } else {

                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                });

        RetryPolicy policy= new DefaultRetryPolicy(600000,10,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        queue = Volley.newRequestQueue(context);

        queue.add(stringRequest).setRetryPolicy(policy);

    }


//    public void requestDataContent(String uri, final int position) {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,
//
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        ArrayList<Content_model> contentModelArrayList;
//
//
//                        if (response != null || !response.isEmpty()) {
//
//
//                        }
//
//
//                    }
//                },
//
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
//                });
//
//        queue.add(stringRequest);
//
//
//    }

}

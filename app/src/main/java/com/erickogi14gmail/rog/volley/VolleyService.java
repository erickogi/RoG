package com.erickogi14gmail.rog.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by kimani kogi on 5/27/2017.
 */

public class VolleyService {

    IResult mResultCallback = null;
    Context mContext;

    public VolleyService(IResult resultCallback, Context context) {
        mResultCallback = resultCallback;
        mContext = context;
    }


    public void getDataVolley(final String requestType, String url) {


        try {
            RequestQueue queue = Volley.newRequestQueue(mContext);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            if (mResultCallback != null)
                                mResultCallback.notifySuccess(requestType, response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (mResultCallback != null)
                        mResultCallback.notifyError(requestType, error);
                }
            });

            queue.add(stringRequest);

        } catch (Exception e) {

        }
    }

}



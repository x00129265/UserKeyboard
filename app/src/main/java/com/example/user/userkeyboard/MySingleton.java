package com.example.user.userkeyboard;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton mInstances;
    private RequestQueue requestQueue;
    private static Context mCtx;

    private MySingleton(Context context){
        mCtx = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getmInstances(Context context){
        if(mInstances == null){
            mInstances = new MySingleton(context);
        }
        return mInstances;
    }


    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T>void addTorequestque(Request<T> request){
        requestQueue.add(request);
    }
}

package com.marcomaldonado.web.callback;

/**
 * Created by Mxrck on 05/12/15.
 */
public interface Callback {

    void onStart();
    void onFailure(int error, String message);

}

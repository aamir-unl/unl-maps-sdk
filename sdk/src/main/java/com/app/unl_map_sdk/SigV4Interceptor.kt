package com.app.unl_map_sdk


import com.app.unl_map_sdk.data.API_KEY
import com.app.unl_map_sdk.data.VPM_ID
import okhttp3.Interceptor
import okhttp3.Response

/**
 * [SigV4Interceptor] is an [Interceptor] for Authorization of UNL credentials
 *
 * @property api_key is used to load map style
 * @property vpm_id is Virtual Private Map ID
 * @constructor
 */
class SigV4Interceptor(var api_key: String, var vpm_id: String) : Interceptor {

    /**
     * Intercept method is used to set header values to an authorized style for Map
     *
     * @return Returns the Response for Map Style
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        /**
         * [Request] Object is used to send data to server like [api_key] and [vpm_id]
         */
        val request = original.newBuilder()
            .header(API_KEY, api_key)
            .header(VPM_ID, vpm_id)
            .method(original.method, original.body)
            .build()

        return chain.proceed(request)
    }

}
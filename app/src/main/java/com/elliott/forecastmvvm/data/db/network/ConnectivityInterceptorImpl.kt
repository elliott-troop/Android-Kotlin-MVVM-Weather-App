package com.elliott.forecastmvvm.data.db.network

import android.content.Context
import android.net.ConnectivityManager
import com.elliott.forecastmvvm.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

// This class needs a context to get the system service to know if there's an internet connection enabled
class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline())
            throw NoConnectivityException()

        return chain.proceed(chain.request())

    }

    private fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager

        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
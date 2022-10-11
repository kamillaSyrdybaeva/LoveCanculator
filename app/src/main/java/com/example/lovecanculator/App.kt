package com.example.lovecanculator

import android.app.Application

class App:Application () {
    companion object {
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService ()
        api = retrofitService.api
    }

}
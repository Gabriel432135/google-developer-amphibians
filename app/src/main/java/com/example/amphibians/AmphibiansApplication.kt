package com.example.amphibians

import android.app.Application
import com.example.amphibians.data.AmphibiansContainer
import com.example.amphibians.network.DefaultAmphibiansContainer

class AmphibiansApplication: Application(){
    lateinit var container: AmphibiansContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAmphibiansContainer()
    }
}
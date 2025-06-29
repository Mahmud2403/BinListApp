package com.example.binlistapp.di

import androidx.room.Room
import com.example.binlistapp.data.local.dao.BinDao
import com.example.binlistapp.data.local.dao.BinDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = BinDatabase::class.java,
            name = "bin_db"
        ).build()
    }

    single<BinDao> { get<BinDatabase>().binDao() }
}

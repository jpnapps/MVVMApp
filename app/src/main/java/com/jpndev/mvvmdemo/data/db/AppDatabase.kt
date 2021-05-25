package com.jpndev.mvvmdemo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jpndev.mvvmdemo.data.model.Movie
import com.jpndev.mvvmdemo.data.model.Star
import com.jpndev.mvvmdemo.data.model.TvShow

@Database(entities = [Movie::class,Star::class,TvShow::class],
    version = 2,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
/*    abstract val movieDao: MovieDao
    abstract val tvShowDao: TvShowDao
    abstract val starDao: StarDao*/


    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun starDao(): StarDao

/*
    companion object
    {
        @Volatile
       private  var INSTANCE: AppDatabase?=null
       fun getInstance(context: Context): AppDatabase
       {
           synchronized(this){
               var instance: AppDatabase?= INSTANCE
               if(instance==null)
               {
                  instance= Room.databaseBuilder(context.applicationContext,
                      AppDatabase::class.java,"app_db").build()
               }
               return instance
           }


       }


    }*/
}
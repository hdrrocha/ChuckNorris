package com.example.chucknorris

import android.content.Context
import com.example.chucknorris.api.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [
    NetworkModule::class,
    SchedulerModule::class
])

class AppModule

@Module
abstract class AndroidInjectorsModule {
    //TODO
}

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
    AppModule::class,
    AndroidInjectorsModule::class
))

interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>() {
        @BindsInstance
        abstract fun appContext(appContext: Context): Builder
    }
}
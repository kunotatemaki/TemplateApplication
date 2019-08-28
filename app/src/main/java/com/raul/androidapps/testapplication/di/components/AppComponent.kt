package com.raul.androidapps.testapplication.di.components

import com.raul.androidapps.testapplication.MyApplication
import com.raul.androidapps.testapplication.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class), (ActivityBuilder::class), (BindsModule::class),
        (ProvidesModule::class), (FragmentsProvider::class), (FragmentsProvider::class), (ViewModelModule::class)]
)
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(myApp: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }

}
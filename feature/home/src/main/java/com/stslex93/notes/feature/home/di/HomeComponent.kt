package com.stslex93.notes.feature.home.di

import androidx.lifecycle.ViewModelProvider
import com.stslex93.notes.core.label.di.LabelApi
import com.stslex93.notes.core.notes.di.NoteApi
import com.stslex93.notes.core.ui.di.NavigationApi
import dagger.Component

@Component(
    dependencies = [HomeDependencies::class],
    modules = [HomeModule::class]
)
@HomeScope
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: HomeDependencies): HomeComponent
    }

    @Component(
        dependencies = [
            NoteApi::class,
            NavigationApi::class,
            LabelApi::class
        ]
    )
    interface HomeDependenciesComponent : HomeDependencies {

        @Component.Factory
        interface Factory {
            fun create(
                noteApi: NoteApi,
                navigationApi: NavigationApi,
                labelApi: LabelApi
            ): HomeDependencies
        }
    }

    val factory: ViewModelProvider.Factory
}
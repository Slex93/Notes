package com.stslex93.notes.di.module

import com.stslex93.notes.data.repository.NoteRepository
import com.stslex93.notes.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindsRepository(repository: NoteRepositoryImpl): NoteRepository
}
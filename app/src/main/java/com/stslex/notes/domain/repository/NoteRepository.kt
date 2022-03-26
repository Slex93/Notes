package com.stslex.notes.domain.repository

import com.stslex.core.Resource
import com.stslex.notes.data.model.NoteData
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun getAll(): Flow<Resource<List<NoteData>>>
    fun getNote(id: Int): Flow<Resource<NoteData>>
    fun getNotesById(ids: List<String>): Flow<List<NoteData>>
    suspend fun deleteNotesById(ids: List<Int>)
    suspend fun insert(note: NoteData)
    suspend fun insertAll(notes: List<NoteData>)
    suspend fun update(note: NoteData)
}
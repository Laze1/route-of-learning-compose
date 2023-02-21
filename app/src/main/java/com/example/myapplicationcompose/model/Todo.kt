package com.example.myapplicationcompose.model

import androidx.room.*

@Entity(tableName = "todo" )
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "done") var done: Boolean,
)

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    suspend fun getAll(): List<Todo>

    @Query("SELECT * FROM todo WHERE id IN (:ids)")
    suspend fun loadAllByIds(ids: IntArray): List<Todo>

    @Query("SELECT * FROM todo WHERE content LIKE :qContent LIMIT 1")
    suspend fun findByContent(qContent: String): Todo

    @Insert
    suspend fun insertAll(vararg todos: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

}
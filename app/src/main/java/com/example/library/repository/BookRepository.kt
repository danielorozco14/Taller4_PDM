package com.example.library.repository

import android.util.Log
import android.widget.EditText
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.library.data.daos.AuthorDao
import com.example.library.data.entities.Book
import com.example.library.data.daos.BookDao
import com.example.library.data.daos.PublisherDao
import com.example.library.data.daos.TagsDao
import com.example.library.data.entities.Author
import com.example.library.data.entities.Publisher
import com.example.library.data.entities.Tags
import kotlinx.android.synthetic.main.activity_new_word.view.*


class BookRepository(private val bookDao: BookDao, private val authorDao: AuthorDao, private val publisherDao: PublisherDao){//,private val tagsDao:TagsDao) {



    val allBooks:LiveData<List<Book>> = bookDao.getAllBooks()
    val allAuthors:LiveData<List<Author>> = authorDao.getAllAuthors()
    val allPublisher:LiveData<List<Publisher>> = publisherDao.getAllPublishers()
   // val allTags:LiveData<List<Tags>> = tagsDao.getAllTags()

    @WorkerThread
    suspend fun insertBookRepository(book: Book){
        Log.d("MEKGO","INSERTANDO LIBRO, CLASE REPOSITORY")
        bookDao.insert(book)
    }

    @WorkerThread
    suspend fun insertAuthorsRepository(author: Author){
        authorDao.insert(author)
    }

    @WorkerThread
    suspend fun insertPublishersRepository(publisher: Publisher){
        publisherDao.insert(publisher)
    }

    /**@WorkerThread
    suspend fun insertTagsRepository(tags: Tags){
        tagsDao.insert(tags)
    }**/




}

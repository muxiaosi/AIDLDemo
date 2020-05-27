// BookInterface.aidl
package com.mxs.aidltest;

import com.mxs.aidltest.Book;

interface BookManager {

    List<Book> getBooks();

    void addBook(in Book book);
}

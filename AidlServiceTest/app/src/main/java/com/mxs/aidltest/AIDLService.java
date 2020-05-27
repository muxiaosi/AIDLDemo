package com.mxs.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fs972
 * @date 2020/4/22 2:48 PM
 * @description TODO
 */
public class AIDLService extends Service {

    public final String TAG = this.getClass().getSimpleName();

    //包含Book对象的list
    private List<Book> mBooks = new ArrayList<>();

    /**
     * 由AIDL文件生成的BookManager
     */
    private final BookManager.Stub mBookManager = new BookManager.Stub(){
        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this){
                if (mBooks != null){
                    return mBooks;
                }
            }
            return null;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this){
                if (mBooks == null){
                    mBooks = new ArrayList<>();
                }
                if (book == null){
                    book = new Book();
                }
                book.setPrice(23333);
                if (!mBooks.contains(book)) {
                    mBooks.add(book);
                }
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setName("Android开发艺术探索");
        book.setPrice(28);
        mBooks.add(book);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBookManager;
    }
}

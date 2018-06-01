package com.example.administrator.mvpdemo.function.book.view;


import com.example.administrator.mvpdemo.entity.Book;

/**
 *
 */

public interface BookView extends View {
    void onSuccess(Book mBook);
    void onError(String result);
}

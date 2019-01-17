package com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.NetworkRequest;

import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.DataModel.Book;

import java.util.ArrayList;

public interface CompletionHandler {

     void retrieveBooks(ArrayList<Book> retrievedBooks);
     void onError();
}

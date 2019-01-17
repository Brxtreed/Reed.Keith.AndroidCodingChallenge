package com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.CustomAdapter.BookListAdapter;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.DataModel.Book;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.NetworkRequest.CompletionHandler;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.NetworkRequest.VolleyRequest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompletionHandler {
    private RecyclerView bookListView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;
    List<Book> bookList;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookListView = findViewById(R.id.book_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Retreiving books... Please wait...");
        progressDialog.show();
        VolleyRequest getBookRequest = new VolleyRequest(this, this);
        getBookRequest.getBooks("http://de-coding-test.s3.amazonaws.com/books.json");

    }

    @Override
    public void retrieveBooks(ArrayList<Book> retrievedBooks) {
        progressDialog.dismiss();
        this.bookList = retrievedBooks;
        adapter = new BookListAdapter(this,bookList);
        bookListView.setLayoutManager(linearLayoutManager);
        bookListView.setAdapter(adapter);

    }

    @Override
    public void onError() {
        progressDialog.dismiss();

    }
}

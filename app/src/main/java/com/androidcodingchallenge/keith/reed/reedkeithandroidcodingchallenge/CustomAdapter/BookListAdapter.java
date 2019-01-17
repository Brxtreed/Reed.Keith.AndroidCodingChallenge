package com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.CustomAdapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.DataModel.Book;
import com.androidcodingchallenge.keith.reed.reedkeithandroidcodingchallenge.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private Context context;
    private List<Book> bookList;

    public BookListAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_book_view_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Book book = bookList.get(position);
        viewHolder.BookNameText.setText(book.getTitle());
        Picasso.get().load(book.getImageURL()).resize(50, 50).centerCrop().into(viewHolder.BookLogoImage);
        }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView BookNameText;
        public ImageView BookLogoImage;
        View itemView;



        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            BookNameText = itemView.findViewById(R.id.book_title);
            BookLogoImage = itemView.findViewById(R.id.book_image);

            }


    }





}

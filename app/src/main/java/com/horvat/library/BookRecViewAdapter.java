package com.horvat.library;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//5. After creating nested class we can extend it this way:(ViewHolder from our package!!
public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {
    //13. logdt shortcut
    private static final String TAG = "BookRecViewAdapter";

    //6. define Array list and Context
    //Glide library need Context to show the image
    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;

    //7 Konstruktor (Only mContext)
    public BookRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //5. CRTL + i to implement methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //11
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //13
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtName.setText(books.get(position).getName());
        //glide library za sliku!!
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);

        //14
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,books.get(position).getName()+ " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //10
        return books.size();
    }

    //8 seter za Listu knjiga!!
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        //sljedeca metoda obvezna:
        notifyDataSetChanged();
    }

    //1. Nested class ViewHolder
    //3. Novi xml file list_item_book
    public class ViewHolder extends RecyclerView.ViewHolder{

        //4
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;

        //2. Konstruktor (alt + insert)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //4. init view elements:
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}

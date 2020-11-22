package com.horvat.library;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.horvat.library.BookActivity.BOOK_ID_KEY;

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
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, books.get(position).getId());

                mContext.startActivity(intent);
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDescription());

       if(books.get(position).isExpanded()){
           TransitionManager.beginDelayedTransition(holder.parent);
           holder.expandedRelLayout.setVisibility(View.VISIBLE);
           holder.downArrow.setVisibility(View.GONE);
       }else{
           TransitionManager.beginDelayedTransition(holder.parent);
           holder.expandedRelLayout.setVisibility(View.GONE);
           holder.downArrow.setVisibility(View.VISIBLE);
       }

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

        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtDescription;

        //2. Konstruktor (alt + insert)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //4. init view elements:
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtName);

            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelativeLayout);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDesc);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}

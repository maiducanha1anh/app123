package com.example.kt_app_10_09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;


public class NoteAdapter extends ArrayAdapter<Note> {

    private Context context;
    private List<Note> noteList;

    // Constructor
    public NoteAdapter(@NonNull Context context, @NonNull List<Note> noteList) {
        super(context, 0, noteList);
        this.context = context;
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
        }


        Note note = noteList.get(position);


        TextView tvTitle = convertView.findViewById(R.id.tvNoteTitle);
        TextView tvContent = convertView.findViewById(R.id.tvNoteContent);


        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());


        return convertView;
    }
}

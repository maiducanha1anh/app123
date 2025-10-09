package com.example.kt_app_10_09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<>();
    NoteAdapter adapter;
    int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listNotes);
        Button addBtn = findViewById(R.id.btnAddNote);

        adapter = new NoteAdapter(this, notes);
        lv.setAdapter(adapter);

        addBtn.setOnClickListener(v -> showDialog(false, -1));
        lv.setOnItemClickListener((p, v, position, id) -> showDialog(true, position));
    }

    private void showDialog(boolean edit, int index) {
        View view = getLayoutInflater().inflate(R.layout.dialog_add_edit_note, null);
        EditText t = view.findViewById(R.id.etTitle), c = view.findViewById(R.id.etContent);
        AlertDialog.Builder b = new AlertDialog.Builder(this).setView(view);

        if (edit) {
            Note n = notes.get(index);
            t.setText(n.getTitle());
            c.setText(n.getContent());
            b.setTitle("Sửa ghi chú")
                    .setPositiveButton("Lưu", (d, w) -> { n.setTitle(t.getText().toString()); n.setContent(c.getText().toString()); adapter.notifyDataSetChanged(); })
                    .setNegativeButton("Xoá", (d, w) -> { notes.remove(index); adapter.notifyDataSetChanged(); });
        } else {
            b.setTitle("Thêm ghi chú")
                    .setPositiveButton("Thêm", (d, w) -> {
                        String title = t.getText().toString().trim(), content = c.getText().toString().trim();
                        if (!title.isEmpty() && !content.isEmpty()) {
                            notes.add(new Note(title, content));
                            adapter.notifyDataSetChanged();
                        } else Toast.makeText(this, "Nhập đủ tiêu đề và nội dung!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Huỷ", null);
        }
        b.show();
    }
}
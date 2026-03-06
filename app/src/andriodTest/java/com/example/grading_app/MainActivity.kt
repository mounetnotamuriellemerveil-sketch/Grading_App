package com.example.grading_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grading_app.Adapter.StudentAdapter
import com.example.grading_app.utils.readStudentsFromExcel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val PICK_FILE = 100

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val importButton = findViewById<Button>(R.id.importButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        importButton.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"

            startActivityForResult(intent, PICK_FILE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_FILE && resultCode == RESULT_OK) {

            val uri = data?.data ?: return

            val students = readStudentsFromExcel(this, uri)

            recyclerView.adapter = StudentAdapter(students)
        }
    }
}
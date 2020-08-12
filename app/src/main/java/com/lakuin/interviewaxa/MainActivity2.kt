package com.lakuin.interviewaxa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var responseMain: ResponseMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        responseMain = intent.getParcelableExtra<ResponseMain>("data") as ResponseMain

        txtBody.text = "Body : ${responseMain.body}"
        txtTitle.text = "Title : ${responseMain.title}"
        txtID.text = "ID : ${responseMain.id}"
        txtUserId.text = "userID : ${responseMain.userId}"
    }
}
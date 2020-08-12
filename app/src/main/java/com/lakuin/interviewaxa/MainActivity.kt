package com.lakuin.interviewaxa

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel by lazy {
        ViewModelProviders.of(this, Injection.provideViewModelFactory(this.application))
            .get(VmMain::class.java)
    }
    private lateinit var adapterMain: AdapterMain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        btnPage1.setOnClickListener(this)
        btnpage2.setOnClickListener(this)
        btnpage3.setOnClickListener(this)
        btnpage4.setOnClickListener(this)
        viewModel.getData().observe(this, Observer {
            adapterMain = AdapterMain(it)
            rvMain.apply {
                setHasFixedSize(true)
                adapter = adapterMain
            }
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPage1 -> {
                rvMain.scrollToPosition(1)
            }
            R.id.btnpage2 -> {
                rvMain.scrollToPosition(25)
            }
            R.id.btnpage3 -> {
                rvMain.scrollToPosition(50)
            }
            R.id.btnpage4 -> {
                rvMain.scrollToPosition(75)
            }
        }
    }
}
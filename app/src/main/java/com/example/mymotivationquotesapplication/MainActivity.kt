package com.example.mymotivationquotesapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // An pointer to the list for
// displaying previous and next quotes
    var position:Int=0
    public lateinit var quoteslist:List<QuotesModel>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Initialize views
        var tv_quotes: TextView =findViewById(R.id.tv_quotes)
        var tv_author:TextView=findViewById(R.id.tv_author)
        var btn_next:ImageView=findViewById(R.id.btn_next)
        var btn_previous: ImageView =findViewById(R.id.btn_previous)
// Make API call to get random quotes
        ApiCall().getRandomQuotes(){listquote->
            if (listquote != null) {
                quoteslist=listquote
                tv_quotes.text=quoteslist.get(0).text
                tv_author.text="~ "+quoteslist.get(0).author
            } else{
                Toast.makeText(this,"Something Went Wrong",Toast.LENGTH_SHORT).show()
            }
        }
// Button click listeners
        btn_next.setOnClickListener {
            nextQuote(tv_quotes,tv_author)
        }
        btn_previous.setOnClickListener {
            previousQuote(tv_quotes,tv_author)
        }
    }
    // Display the next quote
    fun nextQuote(tv_quotes:TextView,tv_author:TextView){
        if(position<quoteslist.size && position>=0){
            position++;
            tv_quotes.text=quoteslist.get(position).text
            tv_author.text="~ "+quoteslist.get(position).author
        } else{
            Toast.makeText(this@MainActivity,"You Reached the Last page",Toast.LENGTH_SHORT).show()
        }
    }
    // Display the previous quote
    fun previousQuote(tv_quotes:TextView,tv_author:TextView){
        if(position<quoteslist.size && position>0){
            position--;
            tv_quotes.text=quoteslist.get(position).text
            tv_author.text="~ "+quoteslist.get(position).author
        } else{
            Toast.makeText(this@MainActivity,"You are on the 1st Page",Toast.LENGTH_SHORT).show()
        }
    }
}
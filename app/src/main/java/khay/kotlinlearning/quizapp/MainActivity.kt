package khay.kotlinlearning.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val editTextName :EditText = findViewById(R.id.editTextName)
        btnStart.setOnClickListener {


            //check to see if Name in the editText is not empty so button can run
            if(editTextName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            } else{
                val intent = Intent(this, QuizQuestionsActivity::class.java) //calling intent class to move to another page
                intent.putExtra(Constants.USER_NAME, editTextName.text.toString()) //sends the userName from the edit text textview to
                startActivity(intent)
                finish()
            }
        }
    }
}
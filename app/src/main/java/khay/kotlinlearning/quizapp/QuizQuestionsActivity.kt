package khay.kotlinlearning.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    // declaring global variables
    private var mCurrentPosition : Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgressBar : TextView? = null
    private var tvQuestion : TextView? = null
    var ivImage : ImageView? = null

    private var tvOptionOne : TextView? =null
    private var tvOptionTwo : TextView? =null
    private var tvOptionThree : TextView? =null
    private var tvOptionFour : TextView? =null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        //finding by id
        mUserName = intent.getStringExtra(Constants.USER_NAME) //getting the username from manin activity using getStringExtra
        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tvProgressBar)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        //setting the onClickListener ...this is used cos onClickListener is already passed in the class declaration
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions() // getting questions from Question Constant

        setQuestion()


    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition //setting progress of the progressBar
        tvProgressBar?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        //setting the button text based on the position of the question
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        } else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    //setting color action for selected and non selected view
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089")) //setting the text color
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.border)
        }
    }

    //method to handle what happens when an optionView is selected
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43")) //assign the color to selected option
        tv.setTypeface(tv.typeface, Typeface.BOLD) //makes selected option Bold
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->  {
                            setQuestion() }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)// sending to ResultActivity
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++ //increase correct answer if user selects the correct answer
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    } else{
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }

        }

    } //end Onclick method

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    } // end answerView Method

} //end class



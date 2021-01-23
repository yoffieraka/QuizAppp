package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.getQuestions()

        setQuestion()
        var tv_option_One = findViewById<TextView>(R.id.tv_option_one)
        var tv_option_Two = findViewById<TextView>(R.id.tv_option_two)
        var tv_option_Three = findViewById<TextView>(R.id.tv_option_three)
        var tv_option_Four = findViewById<TextView>(R.id.tv_option_four)
        var btn_Submit = findViewById<Button>(R.id.btn_submit)
        tv_option_One.setOnClickListener(this)
        tv_option_Two.setOnClickListener(this)
        tv_option_Three.setOnClickListener(this)
        tv_option_Four.setOnClickListener(this)
        btn_Submit.setOnClickListener(this)
    }

    private fun setQuestion(){
        var btn_Submit = findViewById<Button>(R.id.btn_submit)

        val question = mQuestionList!!.get(mCurrentPosition-1)

        defaultOptionView()

        if(mCurrentPosition == mQuestionList!!.size){
            btn_Submit.text = "SELESAI"
        }else{
            btn_Submit.text = "SUBMIT"
        }

        var PBar = findViewById<ProgressBar>(R.id.progressBar)
        PBar.progress = mCurrentPosition

        var tv_Progress = findViewById<TextView>(R.id.tv_progress)
        tv_Progress.text = "$mCurrentPosition" + "/" + PBar.max

        var tv_Question = findViewById<TextView>(R.id.tv_question)
        tv_Question.text = question!!.question

        var iv_Image = findViewById<ImageView>(R.id.iv_image)
        iv_Image.setImageResource(question.image)

        var tv_option_One = findViewById<TextView>(R.id.tv_option_one)
        var tv_option_Two = findViewById<TextView>(R.id.tv_option_two)
        var tv_option_Three = findViewById<TextView>(R.id.tv_option_three)
        var tv_option_Four = findViewById<TextView>(R.id.tv_option_four)
        tv_option_One.text = question.optionOne
        tv_option_Two.text = question.optionTwo
        tv_option_Three.text = question.optionThree
        tv_option_Four.text = question.optionFour
    }

    private fun defaultOptionView(){
        var tv_option_One = findViewById<TextView>(R.id.tv_option_one)
        var tv_option_Two = findViewById<TextView>(R.id.tv_option_two)
        var tv_option_Three = findViewById<TextView>(R.id.tv_option_three)
        var tv_option_Four = findViewById<TextView>(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0,tv_option_One)
        options.add(1,tv_option_Two)
        options.add(2,tv_option_Three)
        options.add(3,tv_option_Four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        var tv_option_One = findViewById<TextView>(R.id.tv_option_one)
        var tv_option_Two = findViewById<TextView>(R.id.tv_option_two)
        var tv_option_Three = findViewById<TextView>(R.id.tv_option_three)
        var tv_option_Four = findViewById<TextView>(R.id.tv_option_four)
        var btn_Submit = findViewById<Button>(R.id.btn_submit)
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_One,1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_Two,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_Three,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_Four,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        }
                    }
                } else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer !=  mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)


                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_Submit.text = "SELESAI"
                    }else{
                        btn_Submit.text = "PERTANYAAN SELANJUTNYA"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int,drawableView: Int){
        var tv_option_One = findViewById<TextView>(R.id.tv_option_one)
        var tv_option_Two = findViewById<TextView>(R.id.tv_option_two)
        var tv_option_Three = findViewById<TextView>(R.id.tv_option_three)
        var tv_option_Four = findViewById<TextView>(R.id.tv_option_four)
        when(answer){
            1 -> {
                tv_option_One.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_Two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_Three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                tv_option_Four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_bg
        )
    }

}
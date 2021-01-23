package com.example.quizapp

object Constants{

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        //1
        val que1 = Question(1,"Buah apakah ini?",
            R.drawable.ic_buah_apel,
            "Apel",
            "Jeruk",
            "Anggur",
            "Sirsak",
            1
        )
            questionsList.add(que1)

        //2
        val que2 = Question(2,"Buah apakah ini?",
            R.drawable.ic_buah_durian,
            "Nangka",
            "Semangka",
            "Durian",
            "Sirsak",
            3
        )
        questionsList.add(que2)

        //3
        val que3 = Question(3,"Buah apakah ini?",
            R.drawable.ic_buah_jeruk,
            "Strawberry",
            "Jeruk",
            "Apel",
            "Mangga",
            2
        )
        questionsList.add(que3)

        //4
        val que4 = Question(4,"Buah apakah ini?",
            R.drawable.ic_buah_mangga,
            "Jambu",
            "Mangga",
            "Alpukat",
            "Blueberry",
            2
        )
        questionsList.add(que4)

        //5
        val que5 = Question(5,"Buah apakah ini?",
            R.drawable.ic_buah_nanas,
            "Durian",
            "Nangka",
            "Nanas",
            "Rumah Spongebob",
            3
        )
        questionsList.add(que5)

        //6
        val que6 = Question(6,"Buah apakah ini?",
            R.drawable.ic_buah_nangka,
            "Durian",
            "Nangka",
            "Sirsak",
            "Jambu",
            2
        )
        questionsList.add(que6)

        //7
        val que7 = Question(7,"Buah apakah ini?",
            R.drawable.ic_buah_rambutan,
            "Naga",
            "Bulu",
            "Rambut",
            "Rambutan",
            4
        )
        questionsList.add(que7)

        //8
        val que8 = Question(8,"Buah apakah ini?",
            R.drawable.ic_buah_sirsak,
            "Durian",
            "Sirsak",
            "Nangka",
            "Semangka",
            2
        )
        questionsList.add(que8)

        //9
        val que9 = Question(9,"Buah apakah ini?",
            R.drawable.ic_buah_strawberry,
            "Strawberry",
            "Blueberry",
            "Greenberry",
            "Cherry",
            1
        )
        questionsList.add(que9)

        //10
        val que10 = Question(10,"Tarik Sis...?",
            R.drawable.ic_buah_semangka,
            "Semonggo",
            "Semangga",
            "Semongko",
            "Semangka",
            4
        )
        questionsList.add(que10)

        return questionsList
    }

}
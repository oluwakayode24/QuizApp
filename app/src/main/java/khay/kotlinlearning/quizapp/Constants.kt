package khay.kotlinlearning.quizapp

object Constants {

    const val USER_NAME: String = "userName"
    const val TOTAL_QUESTIONS: String = "totalQuestions"
    const val CORRECT_ANSWERS: String = "correctAnswers"

    // function to get questions from Question class
    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        //Setting questions
        val questionOne = Question(
            1, "Which of the following countries does this flag belong to?",
            R.drawable.nigeria_flag,
            "Algeria", "Nigeria", "Morocco", "Tunisia",
            2
        )
        questionList.add(questionOne)

        val questionTwo = Question(
            2, "Which of the following countries does this flag belong to?",
            R.drawable.ghana_flag,
            "Senegal", "Mali", "Ghana", "Sudan",
            3
        )
        questionList.add(questionTwo)

        val questionThree = Question(
            3, "Which of the following countries does this flag belong to?",
            R.drawable.germany_flag,
            "Germany", "Spain", "Poland", "Croatia",
            1
        )
        questionList.add(questionThree)

        val questionFour = Question(
            4, "Which of the following countries does this flag belong to?",
            R.drawable.cotedivore_flag,
            "Cote d'Ivoire", "Liberia", "Cape Verde", "Nigeria",
            1
        )
        questionList.add(questionFour)

        val questionFive = Question(
            5, "Which of the following countries does this flag belong to?",
            R.drawable.italy_flag,
            "Mexico", "Ireland", "Netherlands", "Italy",
            4
        )
        questionList.add(questionFive)

        val questionSix = Question(
            6, "Which of the following countries does this flag belong to?",
            R.drawable.liberia_flag,
            "Gambia", "Liberia", "Sudan", "Burkina Faso",
            2
        )
        questionList.add(questionSix)

        val questionSeven = Question(
            7, "Which of the following countries does this flag belong to?",
            R.drawable.sa_flag,
            "Tanzania", "South Africa", "Zimbabwe", "Kenya",
            2
        )
        questionList.add(questionSeven)

        val questionEight = Question(
            8, "Which of the following countries does this flag belong to?",
            R.drawable.senegal_flag,
            "Senegal", "Mali", "Gabon", "Togo",
            1
        )
        questionList.add(questionEight)

        val questionNine = Question(
            9, "Which of the following countries does this flag belong to?",
            R.drawable.ireland_flag,
            "France", "Azerbaijan", "Romania", "Ireland",
            4
        )
        questionList.add(questionNine)

        val questionTen = Question(
            4, "Which of the following countries does this flag belong to?",
            R.drawable.cameroon_flag,
            "Cameroon", "Liberia", "Ethiopia", "Malawi",
            1
        )
        questionList.add(questionTen)

        return questionList
    }
}
package com.example.tsechacksapp

object Questions {
    fun getQuestions(): ArrayList<QuestionsDataClass> {
        lateinit var questionList: ArrayList<QuestionsDataClass>

        val q1 = QuestionsDataClass(
            1,
            "What is an operation that is not used in Stack?",
            "Push",
            "Pop",
            "Display",
            "Dequeue",
            1
        )

        val q2 = QuestionsDataClass(
            2,
            "What is queue?",
            "Collection of similar types of data stored at contiguous memory locations.",
            "Sequence of nodes where every node is connected to the next node by means of a reference pointer.",
            "A linear data structure that follows the FIFO (First In First Out) approach for accessing elements.",
            "Linear data structure that follows LIFO (Last In First Out) approach for accessing elements.",
            3
        )





        questionList.add(q1)
        return questionList
    }
}
package ru.lesson.service;

import ru.lesson.models.Question;

import java.util.ArrayList;
import java.util.List;

public class LoadData {

    public static List<Question> loadData() {
        Integer id = 1;
        List<Question> result = new ArrayList<>(List.of(
                new Question(id++, "question 1j", "answer 1j"),
                new Question(id++, "question 2j", "answer 2j"),
                new Question(id++, "question 3j", "answer 3j"),
                new Question(id++, "question 4j", "answer 4j"),
                new Question(id++, "question 5j", "answer 5j")
        ));

        return result;
    }


}

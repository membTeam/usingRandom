package ru.lesson.repository;

import ru.lesson.exception.ErrException;
import ru.lesson.models.Question;

import java.util.List;
import java.util.Set;

public interface QuestionRepository {

    Question add(Question item);
    Question delete(Question item) throws ErrException;
    Question update(Question item) throws ErrException;

    Set<Question> getRandomQuestion(int num);
}

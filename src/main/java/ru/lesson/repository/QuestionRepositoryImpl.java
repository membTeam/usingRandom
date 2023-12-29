package ru.lesson.repository;

import ru.lesson.exception.ErrException;
import ru.lesson.models.Question;
import ru.lesson.service.LoadData;

import java.util.*;

public class QuestionRepositoryImpl implements QuestionRepository {

    private SortedSet<Question> setQuestion;

    public QuestionRepositoryImpl() {
         setQuestion = new TreeSet<>();
        var loadData = LoadData.loadData();
        loadData.stream().forEach(item -> setQuestion.add(item));
    }

    public int getSize() {
        return setQuestion.size();
    }

    public Question findById (Integer id) throws ErrException {
        return setQuestion
                .stream()
                .filter(q-> q.getId() == id)
                .findFirst().orElseThrow(()-> new ErrException("Нет данных"));
    }

    @Override
    public Question add(Question item) {

        var maxId = Question.getMaxId(setQuestion) + 1;
        item.setId(maxId);

        return item;
    }

    @Override
    public Question delete(Question item) throws ErrException {

        if (!setQuestion.contains(item)) {
            throw new ErrException("Нет данных");
        }
        setQuestion.remove(item);

        return item;
    }

    @Override
    public Question update (Question item) throws ErrException {

        if (!setQuestion.contains(item)) {
            throw new ErrException("Нет данных");
        }

        var old = findById(item.getId());

        setQuestion.remove(old);
        setQuestion.add(item);

        return item;
    }

    @Override
    public Set<Question> getRandomQuestion(int num) {
        Set<Question> result = new HashSet<>();

        int size = setQuestion.size();

        if (num >= size) {
            num = size - 1;
        }

        var arr = setQuestion.toArray();

        while (result.size() < num) {
            Question array = (Question) arr[new Random().nextInt(size)];
            result.add(array);
        }

        return result;
    }

}

package ru.lesson.models;


import java.util.Objects;
import java.util.SortedSet;

public class Question implements Comparable<Question>{

    private Integer id;
    private String question;
    private String answer;

    public Question() {
    }

    public Question(Integer id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public int compareTo(Question q) {
        return this.id - q.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Integer getMaxId(SortedSet<Question> list) {
        return list.stream().mapToInt(q-> q.getId())
                .max()
                .orElse(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

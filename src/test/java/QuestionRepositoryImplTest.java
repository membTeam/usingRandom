import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.lesson.exception.ErrException;
import ru.lesson.models.Question;
import ru.lesson.repository.QuestionRepositoryImpl;

public class QuestionRepositoryImplTest {

    private QuestionRepositoryImpl questionRepository;

    @BeforeEach
    public void setUp() {
        questionRepository = new QuestionRepositoryImpl();
    }

    @Test
    public void getSize() {
        var size = questionRepository.getSize();
        assertEquals(5, size);
    }

    @Test
    public void findById() throws ErrException {
        Integer id = 2;
        var res = questionRepository.findById(id);
        assertNotNull(res);
    }

    @Test
    public void add() {
        var question = new Question();
        question.setQuestion("this is quwestin");
        question.setAnswer("answer");

        var res = questionRepository.add(question);

        assertNotNull(res);
        assertNotNull(res.getId());
        assertEquals(question, res);
    }

    @Test
    public void delete() throws ErrException {
        Integer id = 5;
        var question = questionRepository.findById(id);
        questionRepository.delete(question);

        assertEquals(4, questionRepository.getSize());
    }

    @Test
    public void getRandomQuestion() {
        var result = questionRepository.getRandomQuestion(4);

        assertNotNull(result);
        assertEquals(4, result.size());
    }

}

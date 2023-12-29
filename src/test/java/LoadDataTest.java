import org.junit.jupiter.api.Test;


import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import ru.lesson.service.LoadData;

public class LoadDataTest {
    @Test
    public void loadDataTesting() {
        var res = LoadData.loadData();
        assertInstanceOf(List.class, res );

        assertEquals(5, res.size());
    }

}

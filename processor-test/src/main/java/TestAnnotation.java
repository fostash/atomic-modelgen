import org.fostash.atomic.modelgen.annotation.Col;
import org.fostash.atomic.modelgen.annotation.DataStructure;
import org.fostash.atomic.modelgen.annotation.Id;
import org.fostash.atomic.modelgen.annotation.Join;

import java.util.List;

@DataStructure
public class TestAnnotation {

    @Id
    private Long id;

    @Col(name = "STR_VALUE")
    private String strValue;

    @Join(on = "TEST_JOIN")
    private TestJoin testJoin;

    @Join(on = "TEST_LIST_JOIN")
    private List<TestJoin> testJoinList;
}

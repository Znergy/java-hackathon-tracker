import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MemberTest {
  // test for contstructor
  @Test
  public void Member_constructorCreatesMemberInstance_true() {
    Member member = new Member("Ryan", "Java and SQL", "https://github.com/znergy");
    assertEquals(true, member instanceof Member);
  }
}

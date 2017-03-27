import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MemberTest {

  @Before
  public void tearDown() {
    Member.clearList();
  }

  // test for constructor
  @Test
  public void Member_constructorCreatesMemberInstance_true() {
    Member member = new Member("Ryan", "Java and SQL", "https://github.com/znergy");
    assertEquals(true, member instanceof Member);
  }

  // test for id getter
  @Test
  public void getId_returnId_Id() {
    Member member = new Member("roy", "java", "https://github.com/znergy/repo-name");
    Member member1 = new Member("roy", "java", "https://github.com/znergy/repo-name");
    assertEquals(5001, member.getId());
    assertEquals(5002, member1.getId());
  }

  // test for find method
  @Test
  public void find_returnObject_true() {
    Member member = new Member("roy", "java", "https://github.com/znergy/repo-name");
    assertEquals(member, member.find(5001));
  }
}

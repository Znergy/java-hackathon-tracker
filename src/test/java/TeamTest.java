import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TeamTest {
  @Before
  public void tearDown() {
    Team.clearList();
  }
  // test for constructor
  @Test
  public void Team_constructorCreatesTeamInstance_true() {
    Team team = new Team("Three Amigos", "New Platform", "https://github.com/znergy/repo-name");
    assertEquals(true, team instanceof Team);
  }
  // test for name getter
  @Test
  public void getName_returnName_Three_Amigos() {
    Team team = new Team("Three Amigos", "New Platform", "https://github.com/znergy/repo-name");
    assertEquals("Three Amigos", team.getName());
  }
  // test for description getter
  @Test
  public void getDescription_returnDescription_New_Platform() {
    Team team = new Team("Three Amigos", "New Platform", "https://github.com/znergy/repo-name");
    assertEquals("New Platform", team.getDescription());
  }
  // test for github getter
  @Test
  public void getGithub_returnGithub_github() {
    Team team = new Team("Three Amigos", "New Platform", "https://github.com/znergy/repo-name");
    assertEquals("https://github.com/znergy/repo-name", team.getGithub());
  }
  // test for
  @Test
  public void getId_returnId_Id() {
    Team team = new Team("Three Amigos", "New Platform", "https://github.com/znergy/repo-name");
    assertEquals(1, team.getId());
  }

}

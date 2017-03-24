public class TeamTest {
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
}

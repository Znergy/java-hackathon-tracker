import java.util.*;

public class Team {
  private String name;
  private String description;
  private String github;
  private int id;
  private List<Member> members = new ArrayList<Member>();
  private static List<Team> allTeams = new ArrayList<Team>();

  public Team(String name, String description, String github) {
    this.name = name;
    this.description = description;
    this.github = github;
    allTeams.add(this);
    this.id = allTeams.size();
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public String getGithub() {
    return this.github;
  }

  public int getId() {
    return this.id;
  }

  public void addMember(Member member) {
    this.members.add(member);
  }

  public static List<Team> getAllTeams() {
    return allTeams;
  }

  public static void clearList() {
    allTeams.clear();
  }

  public static Team find(int id) {
    try {
      return allTeams.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public List<Member> getMembers() {
    return this.members;
  }
}

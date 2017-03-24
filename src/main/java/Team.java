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
    this.id = allTeams.size();
    allTeams.add(this);
  }

  // public String getName() {
  //   return this.name;
  // }

  public String getDescription() {
    return this.description;
  }

  public String getGithub() {
    return this.github;
  }

  public int getId() {
    return this.id;
  }

  public List<Team> getAllTeams() {
    return this.allTeams;
  }

  public Team find(int id) {
    return this.allTeams.get(id - 1);
  }

  public List<Member> getMembers() {
    return this.members;
  }
}

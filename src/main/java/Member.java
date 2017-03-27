import java.util.*;

public class Member {
  private String name;
  private String skills;
  private String github;
  private int id;
  private static List<Member> allMembers = new ArrayList<Member>();

  public Member(String name, String skills, String github) {
    this.name = name;
    this.skills = skills;
    this.github = github;
    allMembers.add(this);
    this.id = allMembers.size() + 5000;
  }

  public String getName() {
    return this.name;
  }

  public String getSkills() {
    return this.skills;
  }

  public String getGithub() {
    return this.github;
  }

  public int getId() {
    return this.id;
  }

  public static void clearList() {
    allMembers.clear();
  }

  public static List<Member> getAllMembers() {
    return allMembers;
  }

  public static Member find(int id) {
    try {
      return allMembers.get(id - 5001);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
}

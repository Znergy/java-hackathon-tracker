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
    this.id = allMembers.size() * 5000;
  }
}

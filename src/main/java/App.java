import java.util.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // need to pass in list of teams
      model.put("teams", Team.getAllTeams());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/team/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // displaying team-form (nothing needed..)
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/team/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // take all the input fields..
      String name = request.queryParams("name");
      String description = request.queryParams("description");
      String github = request.queryParams("github");
      // create a new team with those inputs
      Team team = new Team(name, description, github);
      // add the object to model
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/team/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // pass the id, search for team matching, store found team in 'team'
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      // add members to model to print out member names
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/team/:id/member/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // pass the id, search for team matching, store found team in 'team'
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/team/:id/member/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // pass the id, search for team matching, store found team in 'team'
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      // need to take fields from member-form
      String name = request.queryParams("name");
      String skills = request.queryParams("skills");
      String github = request.queryParams("github");
      // create an object with that
      Member member = new Member(name, skills, github);
      // this will only add to the team that matches the id from url
      team.addMember(member);
      model.put("team", team);
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/team/:id/member/:memberid", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      // pass the id, search for team matching, store found team in 'team'
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      // pass the id, search for member matching id, store found member in 'member'
      Member member = Member.find(Integer.parseInt(request.params(":memberid")));
      model.put("member", member);
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}

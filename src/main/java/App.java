import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response ) -> {
      HashMap<String, Object> model = new HashMap<String, Object >();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   get("words/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/add-word-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/words", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     String wordname = request.queryParams("wordname");
     Word newWord = new Word(wordname);
     model.put("word", newWord);
     model.put("words", Word.all());
     model.put("template", "templates/words.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   get("/words", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("words", Word.all());
     model.put("template", "templates/words.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/words/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
     model.put("template", "templates/word.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/words/:id/definitions/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
     model.put("template", "templates/word-definitions-form.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/words/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
     String newdef = request.queryParams("newdef");
     Definition newDefinition = new Definition(newdef);
     word.addDefinition(newDefinition);
     model.put("word", word);
     model.put("template", "templates/word.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }

}

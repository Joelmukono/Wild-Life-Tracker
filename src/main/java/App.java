import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        get("/save_animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newAnimals = request.queryParams("name");
            Animal newAnimal = new Animal(newAnimals);
            newAnimal.save();
            response.redirect("/");
        return null;
        }, new HandlebarsTemplateEngine());

        get("/add_animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"add-animal-form.hbs");
        },new HandlebarsTemplateEngine());

    }


}

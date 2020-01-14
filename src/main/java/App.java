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

        //save animals
        post("/save_animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newAnimals = request.queryParams("name");
            Animal newAnimal = new Animal(newAnimals);
            newAnimal.save();
            response.redirect("/");
        return null;
        }, new HandlebarsTemplateEngine());

        // render add animal form
        get("/add_animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"add-animal-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            List<Sighting> sighting = Sighting.all();
            model.put("sighting", sighting);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/add_sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newLocation = request.queryParams("location");
            String newRangerName = request.queryParams("rangerName");
            Sighting newSighting = new Sighting(newLocation,newRangerName);
            newSighting.save();
            response.redirect("/");
            return null;

        }, new HandlebarsTemplateEngine());


        get("/add_sighting",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"add-sighting-form.hbs");
        },new HandlebarsTemplateEngine());



        post("/add_endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = request.queryParams("name");
            String newRangerHealth = request.queryParams("health");
            EndangeredAnimals newEndangered = new EndangeredAnimals(newName,newRangerHealth);
            newEndangered.save();
            response.redirect("/");
            return null;

        }, new HandlebarsTemplateEngine());


        get("/add_endangered",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"add-endangered-form.hbs");
        },new HandlebarsTemplateEngine());



    }


}

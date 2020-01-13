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
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("update_animal",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newAnimal = request.queryParams("name");
            int idOfAnimalToEdit = Integer.parseInt(request.params("id"));
            Animal animals = new Animal(newAnimal);
            animals.update(idOfAnimalToEdit,newAnimal );
            return new ModelAndView(model,"add-animal-form.hbs");
        },new HandlebarsTemplateEngine());

    }


}

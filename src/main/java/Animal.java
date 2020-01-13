import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import java.sql.Timestamp;
import java.util.List;

public class Animal {
    private String name;
    private Timestamp created;
    private int animalId;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public  Timestamp getCreated(){
        return created;
    }

    @Override
    public boolean equals(Object otherPerson){
        if (!(otherPerson instanceof Animal )) {
            return false;
        } else {
            Animal newPerson = (Animal) otherPerson;
            return this.getName().equals(newPerson.getName());
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,id,created) VALUES (:name,animalId,now())";
            this.animalId = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    public void update(int id, String newName){
        String sql = "UPDATE animals SET name = :name WHERE id=:id";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}

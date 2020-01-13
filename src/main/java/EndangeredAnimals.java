import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class EndangeredAnimals {
    private int id;
    private String name;
    private String health;

    public String getName(){
        return name;

    }

    public String getHealth(){
        return health;
    }

    public int getId(){
        return id;
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
            String sql = "INSERT INTO endangered (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM endangered";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    public void update(int id, String newName){
        String sql = "UPDATE endangered SET name = :name WHERE id=:id";
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

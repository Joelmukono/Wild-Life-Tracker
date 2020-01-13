import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private String name;
    private int id;

    public Animal(String name){
        this.name = name;
    }

    public String getName(){
        return name;
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
            String sql = "INSERT INTO persons (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }




}

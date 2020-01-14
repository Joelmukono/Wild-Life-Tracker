import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class EndangeredAnimals {
    private int id;
    private String name;
    private String health;
    private Timestamp created;

    public static final boolean HEALTH = true;

    public EndangeredAnimals(String name, String health) {
        this.name = name;
        this.health = health;
    }

    public String getName(){
        return name;

    }

    public Timestamp getCreated() {
        return created;
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
            String sql = "INSERT INTO endangered (name,health,created) VALUES (:name,:health,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health",this.health)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimals> all() {
        String sql = "SELECT * FROM endangered";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimals.class);
        }
    }



}

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting implements Sightings {
    private int id;
    private String location;
    private String rangerName;
    private Timestamp created;

    public Sighting(String location,String rangerName){
        this.location = location;
        this.rangerName = rangerName;

    }


    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangername,created) VALUES (:location, :rangerName,now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.location)
                    .addParameter("description", this.rangerName)
                    .addParameter("date",this.created)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    }
}

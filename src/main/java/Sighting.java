import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sighting implements Sightings {
    private int id;

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    private String location;
    private String rangerName;

    public Timestamp getCreated() {
        return created;
    }

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
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
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


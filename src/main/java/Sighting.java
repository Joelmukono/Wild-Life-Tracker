import org.sql2o.Connection;

public class Sighting implements Sightings {
    private int id;
    private String location;
    private String rangerName;


    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO communities (name, description) VALUES (:name, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public void all() {

    }
}

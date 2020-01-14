import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = new Sighting("name","bob");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void sighting_sightingInstantiatesWithName_true() throws Exception{
        Sighting testSighting= setUpSighting();
        assertEquals("coast",testSighting.getLocation());
    }

    @Test
    public void sighting_InstantiatewithId_1() throws Exception {
        Sighting testSighting = setUpSighting();
        assertEquals(0, testSighting.getId());
    }

    public Sighting setUpSighting(){
        return new Sighting("coast","bob");
    }

}
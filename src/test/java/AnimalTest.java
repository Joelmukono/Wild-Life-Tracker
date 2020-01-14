import org.junit.After;
import org.junit.Before;
import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("name");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void animal_animalInstantiatesWithName_true() throws Exception{
        Animal animal = setUpAnimal();
        assertEquals("lion",animal.getName());
    }

    @Test
    public void Animal_InstantiatewithId_1() throws Exception {
        Animal animal = setUpAnimal();
        assertEquals(0, animal.getId());
    }

    public Animal setUpAnimal(){
        return new Animal("lion");
    }
}
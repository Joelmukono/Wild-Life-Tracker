public class Animal {
    private String name;
    private String id;

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

}

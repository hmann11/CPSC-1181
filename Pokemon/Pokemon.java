public class Pokemon {
    private String name;

    public Pokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void introduce() {
        System.out.println("I am " + this.name + ", a pokemon");
    }
}

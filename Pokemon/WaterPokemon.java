public class WaterPokemon extends Pokemon {
    public WaterPokemon(String name) {
        super(name);
    }

    public void introduce() {
        System.out.println("I am " + this.getName() + ", a 💦 pokemon");
    }
}

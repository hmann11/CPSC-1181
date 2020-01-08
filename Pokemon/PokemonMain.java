public class PokemonMain {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu");
        pikachu.introduce();

        FirePokemon charmander = new FirePokemon("Charmander");
        charmander.introduce();

        WaterPokemon squirtle = new WaterPokemon("Squirtle");
        squirtle.introduce();

        WaterPokemon squirtleAgain = squirtle;
        squirtleAgain.introduce();

    }
}

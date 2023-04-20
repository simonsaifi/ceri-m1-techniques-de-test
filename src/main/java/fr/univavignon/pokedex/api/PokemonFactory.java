package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new Pokemon(
                index,
                Pokedex.pokemons.get(index).getName(),
                Pokedex.pokemons.get(index).getAttack(),
                Pokedex.pokemons.get(index).getDefense(),
                Pokedex.pokemons.get(index).getStamina(),
                cp,
                hp,
                dust,
                candy,
                Pokedex.pokemons.get(index).getIv()
        );
    }

}
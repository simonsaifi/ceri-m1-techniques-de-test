package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return new PokemonMetadata(
                index,Pokedex.pokemons.get(index).getName(),
                Pokedex.pokemons.get(index).getAttack(),
                Pokedex.pokemons.get(index).getDefense(),
                Pokedex.pokemons.get(index).getStamina()
        );
    }

}
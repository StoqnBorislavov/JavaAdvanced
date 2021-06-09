package DefiningClasses.Exercise.PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }
    public void increaseBadges(){
        badges++;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public boolean checkForPokemon(String element){
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void reducePokemonsHealth(){
        for (int i = 0; i < pokemons.size(); i++) {
           pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
           if(pokemons.get(i).getHealth() <= 0){
               pokemons.remove(pokemons.get(i));
               i--;
           }
        }
    }

    public int getBadges() {
        return badges;
    }

    @Override
    public String toString() {
        return this.trainerName + " " + this.badges + " " + this.pokemons.size();
    }
}

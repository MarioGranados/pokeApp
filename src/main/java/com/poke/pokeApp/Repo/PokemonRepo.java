import org.springframework.data.jpa.repository.JpaRepository;

import com.poke.pokeApp.Models.Pokemon;

@interface
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {

}
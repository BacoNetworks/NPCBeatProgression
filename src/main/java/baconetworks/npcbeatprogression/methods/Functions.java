package baconetworks.npcbeatprogression.methods;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;

public class Functions {
    public static EntityPixelmon clonePokemon(final EntityPixelmon pokemon) {
        return pokemon;
    }

    public static String GetGym(String s) {
        String[] array = {"bug", "dark", "dragon", "electric", "fairy", "fighting", "fire", "flying", "ghost", "grass", "ground", "ice", "normal", "poison", "psychic", "rock", "steel", "water"};
        for (String check : array) {
            if (s.equalsIgnoreCase(check)) {
                return check;
            }
        }
        return null;
    }
}

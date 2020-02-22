package baconetworks.npcbeatprogression.methods;

import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;

import java.util.ArrayList;
import java.util.List;

public class Functions {
    public static EntityPixelmon clonePokemon(final EntityPixelmon pokemon) {
        return pokemon;
    }

    public static String GetGym(String s) {
        String[] array = {"EliteFour", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water"};
        for (String check : array) {
            if (s.equalsIgnoreCase(check)) {
                return check;
            }
        }
        return null;
    }

    public static PlayerObject EmptyPlayerObj() {
        List<GymsObject> gymsObjects = new ArrayList<>();
        String[] array = {"EliteFour", "Bug", "Dark", "Dragon", "Electric", "Fairy", "Fighting", "Fire", "Flying", "Ghost", "Grass", "Ground", "Ice", "Normal", "Poison", "Psychic", "Rock", "Steel", "Water"};
        for (String gym : array) {
            gymsObjects.add(new GymsObject(gym, false, false, false, false, false, 0));
        }
        return new PlayerObject(gymsObjects);
    }
}

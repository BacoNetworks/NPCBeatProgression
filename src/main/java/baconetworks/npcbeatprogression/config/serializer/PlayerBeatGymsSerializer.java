package baconetworks.npcbeatprogression.config.serializer;

import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PlayerBeatGymsSerializer implements JsonSerializer<PlayerObject> {
    public JsonElement serialize(PlayerObject playerObject, Type type, JsonSerializationContext ctx) {
        JsonObject json = new JsonObject();
        JsonArray GymArray = new JsonArray();
        for (GymsObject gym : playerObject.getGymsObjects()) {
            JsonObject GymObject = new JsonObject();
            GymObject.addProperty("name", gym.getName());
            GymObject.addProperty("NPC1", gym.isNPC1());
            GymObject.addProperty("NPC2", gym.isNPC2());
            GymObject.addProperty("NPC3", gym.isNPC3());
            GymObject.addProperty("NPC4", gym.isNPC4());
            GymObject.addProperty("BeatGym", gym.isBeatGym());
            GymObject.addProperty("BeatNPCS", gym.getBeatNPCS());
            GymArray.add(GymObject);
        }
        json.add("Gyms", GymArray);
        return json;
    }
}


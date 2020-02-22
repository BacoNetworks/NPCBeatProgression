package baconetworks.npcbeatprogression.config.serializer;

import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PlayerBeatGymsDeserializer implements JsonDeserializer<PlayerObject> {
    public PlayerObject deserialize(JsonElement json, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();

        List<GymsObject> GymArray = new ArrayList<>();


        if (obj.get("Gyms") != null) {
            for (JsonElement e : obj.get("Gyms").getAsJsonArray()) {
                JsonObject gymObj = e.getAsJsonObject();
                GymsObject GymObject = new GymsObject(
                        gymObj.get("name").getAsString(),
                        gymObj.get("NPC1").getAsBoolean(),
                        gymObj.get("NPC2").getAsBoolean(),
                        gymObj.get("NPC3").getAsBoolean(),
                        gymObj.get("NPC4").getAsBoolean(),
                        gymObj.get("BeatGym").getAsBoolean(),
                        gymObj.get("BeatNPCS").getAsInt()
                );
                GymArray.add(GymObject);
            }
        }
        return new PlayerObject(GymArray);
    }
}

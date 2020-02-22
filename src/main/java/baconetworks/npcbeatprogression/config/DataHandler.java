package baconetworks.npcbeatprogression.config;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import baconetworks.npcbeatprogression.config.serializer.PlayerBeatGymsDeserializer;
import baconetworks.npcbeatprogression.config.serializer.PlayerBeatGymsSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.Objects;

public class DataHandler {
    public static LinkedHashMap<String, PlayerObject> PlayerGyms = new LinkedHashMap<>();
    public static String[] GymList = {"Test", "Testv2", "Testv3"};
    private static File PlayerBeatenGyms;
    private static Gson gson;

    public static void init(File rootDir) {
        PlayerBeatenGyms = new File(rootDir, "players");
        gson = new GsonBuilder().registerTypeAdapter(PlayerObject.class, new PlayerBeatGymsSerializer()).registerTypeAdapter(PlayerObject.class, new PlayerBeatGymsDeserializer()).setPrettyPrinting().create();
    }

    public static void load() {
        PlayerBeatenGyms.mkdirs();
        JsonParser parser = new JsonParser();
        for (File f : Objects.requireNonNull(PlayerBeatenGyms.listFiles())) {
            if ((f.isFile()) && (f.getName().matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}\\.json"))) {
                try {
                    JsonObject jsonObject = (JsonObject) parser.parse(new FileReader(f));
                    String PutInLinkedHash = f.getName().replace(".json", "");
                    PlayerObject PlayerObj = gson.fromJson(jsonObject, PlayerObject.class);
                    PlayerGyms.put(PutInLinkedHash, PlayerObj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addPlayer(PlayerObject PlayerObj, String uuid) {
        PlayerGyms.put(uuid, PlayerObj);
        savePlayer(uuid);
    }

    public static void save() {
        for (String uuid : PlayerGyms.keySet()) {
            savePlayer(uuid);
        }
    }

    public static void savePlayer(String uuid) {
        PlayerObject PlayerObj = PlayerGyms.get(uuid);
        if (PlayerObj == null) {
            return;
        }
        File file = new File(PlayerBeatenGyms, uuid + ".json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            String json = gson.toJson(PlayerObj, PlayerObject.class);
            Files.write(file.toPath(), json.getBytes());
            PlayerGyms.put(uuid, PlayerObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<String, PlayerObject> GetPlayerObject() {
        return PlayerGyms;
    }
}
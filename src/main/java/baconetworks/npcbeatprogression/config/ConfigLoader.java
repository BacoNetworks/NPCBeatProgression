package baconetworks.npcbeatprogression.config;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import baconetworks.npcbeatprogression.config.objects.EliteFour.EliteFourObject;
import baconetworks.npcbeatprogression.config.objects.Gyms.*;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class ConfigLoader {
    public static File configFile;
    public static ConfigurationLoader<CommentedConfigurationNode> configManager;
    public static CommentedConfigurationNode config;
    public static ArrayList<String> values = new ArrayList<>();
    public static LinkedHashMap<String, PlayerObject> PlayerGyms = new LinkedHashMap<>();
    private static ConfigLoader instance = new ConfigLoader();

    public static void init(File rootDir) {
        configFile = new File(rootDir, "players.conf");
        configManager = HoconConfigurationLoader.builder().setPath(configFile.toPath()).build();
    }

    public static ConfigLoader getInstance() {
        return instance;
    }

    public static void load() {
        // load file
        try {
            configManager = HoconConfigurationLoader.builder().setPath(configFile.toPath()).build();
            if (!configFile.exists()) {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
                loadConfig();
                makeConfig();
                saveConfig();
            }
            config = configManager.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeConfig() {
        config.getNode(new Object[]{"Players"}).setValue(values.add("f7723a00-d600-41c9-b907-5054b1ffb94b"));
        //EliteFour
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "BeatChampion"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "EliteFour", "BeatNPCS"}).setValue(0);
        //Bug
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "bug", "BeatNPCS"}).setValue(0);
        //Dark
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dark", "BeatNPCS"}).setValue(0);
        //Dragon
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "dragon", "BeatNPCS"}).setValue(0);
        //Electric
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "electric", "BeatNPCS"}).setValue(0);
        //Fairy
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fairy", "BeatNPCS"}).setValue(0);
        //Fighting
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fighting", "BeatNPCS"}).setValue(0);
        //Fire
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "fire", "BeatNPCS"}).setValue(0);
        //Fire
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "flying", "BeatNPCS"}).setValue(0);
        //Ghost
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ghost", "BeatNPCS"}).setValue(0);
        //Grass
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "grass", "BeatNPCS"}).setValue(0);
        //Ground
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ground", "BeatNPCS"}).setValue(0);
        //Ice
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "ice", "BeatNPCS"}).setValue(0);
        //Normal
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "normal", "BeatNPCS"}).setValue(0);
        //Poison
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "poison", "BeatNPCS"}).setValue(0);
        //Psychic
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "psychic", "BeatNPCS"}).setValue(0);
        //Rock
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "rock", "BeatNPCS"}).setValue(0);
        //Steel
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "steel", "BeatNPCS"}).setValue(0);
        //Water
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "NPC1"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "NPC2"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "NPC3"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "NPC4"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "BeatGym"}).setValue(false);
        config.getNode(new Object[]{"Players", "f7723a00-d600-41c9-b907-5054b1ffb94b", "Gyms", "water", "BeatNPCS"}).setValue(0);
    }

    public static void saveConfig() {
        try {
            configManager.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadConfig() {
        try {
            config = configManager.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPlayers() {
        PlayerGyms.clear();
        try {
            ConfigurationNode node = configManager.load();

            ConfigurationNode commandsNode = node.getNode("Players");

            for (ConfigurationNode commandNode : commandsNode.getChildrenMap().values()) {
                try {
                    EliteFourObject EliteFour = new EliteFourObject(
                            commandNode.getNode("EliteFour").getNode("NPC1").getBoolean(),
                            commandNode.getNode("EliteFour").getNode("NPC2").getBoolean(),
                            commandNode.getNode("EliteFour").getNode("NPC3").getBoolean(),
                            commandNode.getNode("EliteFour").getNode("NPC4").getBoolean(),
                            commandNode.getNode("EliteFour").getNode("BeatChampion").getBoolean(),
                            commandNode.getNode("EliteFour").getNode("BeatNPCS").getInt()
                    );
                    BugGymObject BugGym = new BugGymObject(
                            commandNode.getNode("Gyms").getNode("bug").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("bug").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("bug").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("bug").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("bug").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("bug").getNode("BeatNPCS").getInt()
                    );
                    DarkGymObject DarkGym = new DarkGymObject(
                            commandNode.getNode("Gyms").getNode("dark").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dark").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dark").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dark").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dark").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dark").getNode("BeatNPCS").getInt()
                    );
                    DragonGymObject DragonGym = new DragonGymObject(
                            commandNode.getNode("Gyms").getNode("dragon").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dragon").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dragon").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dragon").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dragon").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("dragon").getNode("BeatNPCS").getInt()
                    );
                    ElectricGymObject ElectricGym = new ElectricGymObject(
                            commandNode.getNode("Gyms").getNode("electric").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("electric").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("electric").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("electric").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("electric").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("electric").getNode("BeatNPCS").getInt()
                    );
                    FairyGymObject fairyGym = new FairyGymObject(
                            commandNode.getNode("Gyms").getNode("fairy").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fairy").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fairy").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fairy").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fairy").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fairy").getNode("BeatNPCS").getInt()
                    );
                    FightingGymObject FightingGym = new FightingGymObject(
                            commandNode.getNode("Gyms").getNode("fighting").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fighting").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fighting").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fighting").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fighting").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fighting").getNode("BeatNPCS").getInt()
                    );
                    FireGymObject FireGym = new FireGymObject(
                            commandNode.getNode("Gyms").getNode("fire").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fire").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fire").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fire").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fire").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("fire").getNode("BeatNPCS").getInt()
                    );
                    FlyingGymObject FlyingGym = new FlyingGymObject(
                            commandNode.getNode("Gyms").getNode("flying").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("flying").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("flying").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("flying").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("flying").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("flying").getNode("BeatNPCS").getInt()
                    );
                    GhostGymObject GhostGym = new GhostGymObject(
                            commandNode.getNode("Gyms").getNode("ghost").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ghost").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ghost").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ghost").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ghost").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ghost").getNode("BeatNPCS").getInt()
                    );
                    GrassGymObject GrassGym = new GrassGymObject(
                            commandNode.getNode("Gyms").getNode("grass").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("grass").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("grass").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("grass").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("grass").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("grass").getNode("BeatNPCS").getInt()
                    );
                    GroundGymObject GroundGym = new GroundGymObject(
                            commandNode.getNode("Gyms").getNode("ground").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ground").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ground").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ground").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ground").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ground").getNode("BeatNPCS").getInt()
                    );
                    IceGymObject IceGym = new IceGymObject(
                            commandNode.getNode("Gyms").getNode("ice").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ice").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ice").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ice").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ice").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("ice").getNode("BeatNPCS").getInt()
                    );
                    NormalGymObject NormalGym = new NormalGymObject(
                            commandNode.getNode("Gyms").getNode("normal").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("normal").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("normal").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("normal").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("normal").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("normal").getNode("BeatNPCS").getInt()
                    );
                    PoisonGymObject PoisonGym = new PoisonGymObject(
                            commandNode.getNode("Gyms").getNode("poison").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("poison").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("poison").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("poison").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("poison").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("poison").getNode("BeatNPCS").getInt()
                    );
                    PsychicGymObject PsychicGym = new PsychicGymObject(
                            commandNode.getNode("Gyms").getNode("psychic").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("psychic").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("psychic").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("psychic").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("psychic").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("psychic").getNode("BeatNPCS").getInt()
                    );
                    RockGymObject RockGym = new RockGymObject(
                            commandNode.getNode("Gyms").getNode("rock").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("rock").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("rock").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("rock").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("rock").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("rock").getNode("BeatNPCS").getInt()
                    );
                    SteelGymObject SteelGym = new SteelGymObject(
                            commandNode.getNode("Gyms").getNode("steel").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("steel").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("steel").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("steel").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("steel").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("steel").getNode("BeatNPCS").getInt()
                    );
                    WaterGymObject WaterGym = new WaterGymObject(
                            commandNode.getNode("Gyms").getNode("water").getNode("NPC1").getBoolean(),
                            commandNode.getNode("Gyms").getNode("water").getNode("NPC2").getBoolean(),
                            commandNode.getNode("Gyms").getNode("water").getNode("NPC3").getBoolean(),
                            commandNode.getNode("Gyms").getNode("water").getNode("NPC4").getBoolean(),
                            commandNode.getNode("Gyms").getNode("water").getNode("BeatGym").getBoolean(),
                            commandNode.getNode("Gyms").getNode("water").getNode("BeatNPCS").getInt()
                    );
                    PlayerObject PlayerGym = new PlayerObject(
                            EliteFour,
                            BugGym,
                            DarkGym,
                            DragonGym,
                            ElectricGym,
                            fairyGym,
                            FightingGym,
                            FireGym,
                            FlyingGym,
                            GhostGym,
                            GrassGym,
                            GroundGym,
                            IceGym,
                            NormalGym,
                            PoisonGym,
                            PsychicGym,
                            RockGym,
                            SteelGym,
                            WaterGym
                    );
                    NPCBeatProgression.LOGGER.info(PlayerGym.toString());
                    PlayerGyms.put(Objects.requireNonNull(commandNode.getKey()).toString(), PlayerGym);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<String, PlayerObject> PlayerObjectGet() {
        return PlayerGyms;
    }

    public static CommentedConfigurationNode getNode(String... path) {
        return config.getNode(path);
    }
}
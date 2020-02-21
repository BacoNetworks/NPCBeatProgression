package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.config.ConfigLoader;
import baconetworks.npcbeatprogression.config.objects.EliteFour.EliteFourObject;
import baconetworks.npcbeatprogression.config.objects.Gyms.*;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.LinkedHashMap;

public class PlayerConnectionEvent {
    @SubscribeEvent
    public void PlayerJoinEvent(PlayerEvent.PlayerLoggedInEvent event) {
        LinkedHashMap<String, PlayerObject> PlayerObject = ConfigLoader.PlayerObjectGet();
        if (!(PlayerObject.containsKey(event.player.getUniqueID().toString()))) {
            ConfigLoader.values.add(event.player.getUniqueID().toString());
            //EliteFour
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "BeatChampion"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "EliteFour", "BeatNPCS"}).setValue(0);
            //Bug
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "bug", "BeatNPCS"}).setValue(0);
            //Dark
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dark", "BeatNPCS"}).setValue(0);
            //Dragon
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "dragon", "BeatNPCS"}).setValue(0);
            //Electric
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "electric", "BeatNPCS"}).setValue(0);
            //Fairy
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fairy", "BeatNPCS"}).setValue(0);
            //Fighting
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fighting", "BeatNPCS"}).setValue(0);
            //Fire
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "fire", "BeatNPCS"}).setValue(0);
            //Fire
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "flying", "BeatNPCS"}).setValue(0);
            //Ghost
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ghost", "BeatNPCS"}).setValue(0);
            //Grass
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "grass", "BeatNPCS"}).setValue(0);
            //Ground
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ground", "BeatNPCS"}).setValue(0);
            //Ice
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "ice", "BeatNPCS"}).setValue(0);
            //Normal
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "normal", "BeatNPCS"}).setValue(0);
            //Poison
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "poison", "BeatNPCS"}).setValue(0);
            //Psychic
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "psychic", "BeatNPCS"}).setValue(0);
            //Rock
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "rock", "BeatNPCS"}).setValue(0);
            //Steel
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "steel", "BeatNPCS"}).setValue(0);
            //Water
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "NPC1"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "NPC2"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "NPC3"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "NPC4"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "BeatGym"}).setValue(false);
            ConfigLoader.config.getNode(new Object[]{"Players", event.player.getUniqueID().toString(), "Gyms", "water", "BeatNPCS"}).setValue(0);

            //Adding the the LinkedHashMap
            EliteFourObject EliteFour = new EliteFourObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            BugGymObject BugGym = new BugGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            DarkGymObject DarkGym = new DarkGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            DragonGymObject DragonGym = new DragonGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            ElectricGymObject ElectricGym = new ElectricGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            FairyGymObject fairyGym = new FairyGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            FightingGymObject FightingGym = new FightingGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            FireGymObject FireGym = new FireGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            FlyingGymObject FlyingGym = new FlyingGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            GhostGymObject GhostGym = new GhostGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            GrassGymObject GrassGym = new GrassGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            GroundGymObject GroundGym = new GroundGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            IceGymObject IceGym = new IceGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            NormalGymObject NormalGym = new NormalGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            PoisonGymObject PoisonGym = new PoisonGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            PsychicGymObject PsychicGym = new PsychicGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            RockGymObject RockGym = new RockGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            SteelGymObject SteelGym = new SteelGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
            );
            WaterGymObject WaterGym = new WaterGymObject(
                    false,
                    false,
                    false,
                    false,
                    false,
                    0
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
            PlayerObject.put(event.player.getUniqueID().toString(), PlayerGym);
            ConfigLoader.saveConfig();
        }
    }
}

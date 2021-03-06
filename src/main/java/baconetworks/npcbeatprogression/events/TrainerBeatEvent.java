package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.pixelmonmod.pixelmon.api.events.BeatTrainerEvent;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;

import java.util.LinkedHashMap;
import java.util.List;

public class TrainerBeatEvent {
    @SubscribeEvent
    public void BeatTrainerEvent(BeatTrainerEvent event) {
        NPCTrainer trainer = event.trainer;
        Player player = (Player) event.player;
        final NBTTagCompound nbt = trainer.getEntityData();
        if (nbt.hasKey("BacoGymNPC")) {
            LinkedHashMap<String, PlayerObject> PlayerGyms = DataHandler.GetPlayerObject();
            PlayerObject PlayerObj = PlayerGyms.get(event.player.getUniqueID().toString());
            List<GymsObject> GymList = PlayerObj.getGymsObjects();
            String GymNpc = nbt.getString("BacoGymNPC");
            String Gym = GymNpc.split("-")[0];
            String Npc = GymNpc.split("-")[1];
            for (GymsObject gym : GymList) {
                if (gym.getName().equalsIgnoreCase(Gym)) {
                    gym.increaseBeatNPCS(1);
                    if (gym.getBeatNPCS() > 4) {
                        gym.setBeatGym(true);
                    }
                    if (Npc.contains("NPC1")) {
                        gym.setNPC1(true);
                    }
                    if (Npc.contains("NPC2")) {
                        gym.setNPC2(true);
                    }
                    if (Npc.contains("NPC3")) {
                        gym.setNPC3(true);
                    }
                    if (Npc.contains("NPC4")) {
                        gym.setNPC4(true);
                    }
                }
            }
            PlayerObj.setGymsObjects(GymList);
            DataHandler.savePlayer(player.getUniqueId().toString());
        }
    }
}

package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.pixelmonmod.pixelmon.api.events.AggressionEvent;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.LinkedHashMap;
import java.util.List;

public class AggroTrainerEvent {
    @SubscribeEvent
    public void AgroPlayerEvent(AggressionEvent event) {
        if (event.aggressor instanceof NPCTrainer) {
            NPCTrainer trainer = (NPCTrainer) event.aggressor;
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
                        if (gym.isBeatGym()) {
                            event.setCanceled(true);
                        }
                        if (Npc.contains("NPC1")) {
                            if (gym.isNPC1()) {
                                event.setCanceled(true);
                            }
                        }
                        if (Npc.contains("NPC2")) {
                            if (gym.isNPC2()) {
                                event.setCanceled(true);
                            }
                        }
                        if (Npc.contains("NPC3")) {
                            if (gym.isNPC3()) {
                                event.setCanceled(true);
                            }
                        }
                        if (Npc.contains("NPC4")) {
                            if (gym.isNPC4()) {
                                event.setCanceled(true);
                            }
                        }
                    }
                }
            }
        }
    }
}

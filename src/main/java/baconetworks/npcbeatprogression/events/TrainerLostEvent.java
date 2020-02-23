package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.GymsObject;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.pixelmonmod.pixelmon.api.events.LostToTrainerEvent;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.LinkedHashMap;
import java.util.List;

public class TrainerLostEvent {
    @SubscribeEvent
    public void PlayerLostToTrainer(LostToTrainerEvent event) {
        NPCTrainer trainer = event.trainer;
        Player player = (Player) event.player;
        final NBTTagCompound nbt = trainer.getEntityData();
        if (nbt.hasKey("BacoGymNPC")) {
            LinkedHashMap<String, PlayerObject> PlayerGyms = DataHandler.GetPlayerObject();
            PlayerObject PlayerObj = PlayerGyms.get(event.player.getUniqueID().toString());
            List<GymsObject> GymList = PlayerObj.getGymsObjects();
            String GymNpc = nbt.getString("BacoGymNPC");
            String Gym = GymNpc.split("-")[0];
            if (Gym.equalsIgnoreCase("EliteFour")) {
                for (GymsObject gym : GymList) {
                    if (gym.getName().equalsIgnoreCase(Gym)) {
                        gym.setBeatGym(false);
                        gym.setNPC1(false);
                        gym.setNPC2(false);
                        gym.setNPC3(false);
                        gym.setNPC4(false);
                        gym.setBeatNPCS(0);
                    }
                }
                PlayerObj.setGymsObjects(GymList);
                DataHandler.savePlayer(player.getUniqueId().toString());
                player.sendMessage(Text.of(TextColors.RED, "You've just lost to a member of the elite four! You must now rebattle all of them from the beginning!"));
            }
        }
    }
}

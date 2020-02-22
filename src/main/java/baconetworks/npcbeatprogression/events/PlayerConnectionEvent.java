package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import baconetworks.npcbeatprogression.methods.Functions;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.LinkedHashMap;

public class PlayerConnectionEvent {
    @SubscribeEvent
    public void PlayerJoinEvent(PlayerEvent.PlayerLoggedInEvent event) {
        LinkedHashMap<String, PlayerObject> PlayerObj = DataHandler.GetPlayerObject();
        if (!(PlayerObj.containsKey(event.player.getUniqueID().toString()))) {
            DataHandler.addPlayer(Functions.EmptyPlayerObj(), event.player.getUniqueID().toString());
            NPCBeatProgression.LOGGER.info("Registered " + event.player.getName() + " to NPCBeatProgression");
        }
    }
}

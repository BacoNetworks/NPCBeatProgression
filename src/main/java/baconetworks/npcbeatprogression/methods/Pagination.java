package baconetworks.npcbeatprogression.methods;

import baconetworks.npcbeatprogression.NPCBeatProgression;
import org.spongepowered.api.Game;
import org.spongepowered.api.service.pagination.PaginationService;

public class Pagination {
    //Required definitions
    final NPCBeatProgression plugin = NPCBeatProgression.instance;
    final Game game = plugin.getGame();

    //Pagination service builder
    public PaginationService getPaginationService() {
        if (game.getServiceManager().provide(PaginationService.class).isPresent()) {
            return game.getServiceManager().provide(PaginationService.class).get();
        } else {
            return null;
        }
    }
}

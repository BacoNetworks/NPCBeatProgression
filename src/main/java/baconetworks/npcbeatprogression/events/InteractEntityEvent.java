package baconetworks.npcbeatprogression.events;

import baconetworks.npcbeatprogression.AITarget.TargetAllNearPlayers;
import baconetworks.npcbeatprogression.commands.SetMultipleBattle;
import com.pixelmonmod.pixelmon.AI.AITargetNearest;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class InteractEntityEvent {
    @SubscribeEvent
    public void onInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = (Player) event.getEntityPlayer();
        if (event.getTarget() instanceof NPCTrainer) {
            NPCTrainer npc = (NPCTrainer) event.getTarget();
            if (SetMultipleBattle.CommandQue.get(player.getUniqueId()) != null) {
                final NBTTagCompound nbt = npc.getEntityData();
                String choice = SetMultipleBattle.CommandQue.get(player.getUniqueId());
                if (choice.equalsIgnoreCase("set")) {
                    if (nbt.getBoolean("MultipleBattleEnable")) {
                        SetMultipleBattle.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.RED, "NBT already set on this trainer!"));
                    } else {
                        nbt.setBoolean("MultipleBattleEnable", true);
                        SetMultipleBattle.CommandQue.remove(player.getUniqueId());
                        npc.tasks.addTask(5, new TargetAllNearPlayers(npc, 5));
                        for (EntityAITasks.EntityAITaskEntry task : npc.tasks.taskEntries) {
                            if (task.action instanceof AITargetNearest) {
                                npc.tasks.removeTask(task.action);
                                break;
                            }
                        }
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle enabled on this trainer"));
                    }
                }
                if (choice.equalsIgnoreCase("remove")) {
                    if (!nbt.getBoolean("MultipleBattleEnable")) {
                        SetMultipleBattle.CommandQue.remove(player.getUniqueId());
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle is already disabled on this trainer"));
                    } else {
                        SetMultipleBattle.CommandQue.remove(player.getUniqueId());
                        nbt.removeTag("MultipleBattleEnable");
                        for (EntityAITasks.EntityAITaskEntry task : npc.tasks.taskEntries) {
                            if (task.action instanceof TargetAllNearPlayers) {
                                npc.tasks.removeTask(task.action);
                                break;
                            }
                        }
                        player.sendMessage(Text.of(TextColors.GREEN, "MultipleBattle disabled on this trainer"));
                    }
                }
            }
        }
    }
}

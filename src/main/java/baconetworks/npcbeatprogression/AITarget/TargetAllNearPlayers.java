package baconetworks.npcbeatprogression.AITarget;

import baconetworks.npcbeatprogression.config.DataHandler;
import baconetworks.npcbeatprogression.config.objects.PlayerObject;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.storage.PixelmonStorage;
import com.pixelmonmod.pixelmon.storage.PlayerStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.api.entity.living.player.Player;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;


public class TargetAllNearPlayers extends EntityAIBase {
    EntityLivingBase targetEntity;
    private final EntityAINearestAttackableTarget.Sorter sorter;
    EntityCreature trainer;
    float targetDistance;
    LinkedHashMap<String, PlayerObject> LinkedHashMapGet = DataHandler.GetPlayerObject();


    public TargetAllNearPlayers(EntityCreature entity, float par3) {
        this.targetDistance = par3;
        this.trainer = entity;
        this.setMutexBits(3);
        this.sorter = new EntityAINearestAttackableTarget.Sorter(entity);
    }

    public boolean shouldExecute() {
        AxisAlignedBB axis = new AxisAlignedBB(this.trainer.posX - 5, this.trainer.posY - this.targetDistance, this.trainer.posZ - this.targetDistance, this.trainer.posX + this.targetDistance, this.trainer.posY + this.targetDistance, this.trainer.posZ + this.targetDistance);
        //List<EntityPlayerMP> nearEntities = this.trainer.world.getEntitiesWithinAABB(EntityPlayerMP.class, this.trainer.getEntityBoundingBox().expand(this.targetDistance, 5.0, this.targetDistance));
        List<Entity> nearEntities = this.trainer.world.getEntitiesWithinAABB(EntityPlayerMP.class, axis);
        nearEntities.sort(sorter);
        for (Object o : nearEntities) {
            this.targetEntity = (EntityLivingBase) o;
        }
        return !nearEntities.isEmpty();
    }

    public boolean shouldContinueExecuting() {
        EntityLivingBase livingBase = this.trainer.getAttackTarget();
        if (livingBase == null) {
            return false;
        } else return livingBase.isEntityAlive();
    }

    public void startExecuting() {
        super.startExecuting();
    }

    public void resetTask() {
        this.trainer.setAttackTarget(null);
    }

    public void updateTask() {
        EntityPlayerMP player = (EntityPlayerMP) this.targetEntity;
        //Check if the player is already battling or not.
        if (BattleRegistry.getBattle(player) != null) {
            return;
        }
        Player sponge = (Player) player;
        NPCTrainer trainer = (NPCTrainer) this.trainer;
        String trainerName = this.trainer.getName();
        trainerName = trainerName.replaceAll(" ", "");
        final NBTTagCompound nbt = trainer.getEntityData();
        if (nbt.hasKey("BacoGymNPC")) {
            String key = nbt.getString("BacoGymNPC");
            PlayerObject obj = LinkedHashMapGet.get(player.getUniqueID());
            //Replace this with a check on if the player has beaten the specific npc of that gym
            if (!(sponge.hasPermission("npcbeatprogression." + trainerName))) {
                Optional<PlayerStorage> optstorage = PixelmonStorage.pokeBallManager.getPlayerStorage(player);
                if (optstorage.isPresent()) {
                    PlayerParticipant playerPart;
                    PlayerStorage storage = optstorage.get();
                    EntityPixelmon firstPokemon = storage.getFirstAblePokemon(player.world);
                    playerPart = new PlayerParticipant(player, firstPokemon);
                    TrainerParticipant trainerPart = new TrainerParticipant(trainer, (EntityPlayerMP) this.targetEntity, trainer.getBattleType().numPokemon);
                    firstPokemon.StartBattle(playerPart, trainerPart);
                }
            }
        }
    }

    public boolean isInterruptible() {
        return false;
    }
}



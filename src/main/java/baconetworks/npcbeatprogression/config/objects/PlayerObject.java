package baconetworks.npcbeatprogression.config.objects;

import baconetworks.npcbeatprogression.config.objects.EliteFour.EliteFourObject;
import baconetworks.npcbeatprogression.config.objects.Gyms.*;

public class PlayerObject {
    private EliteFourObject EliteFour;
    private BugGymObject BugGym;
    private DarkGymObject DarkGym;
    private DragonGymObject DragonGym;
    private ElectricGymObject ElectricGym;
    private FairyGymObject FairyGym;
    private FightingGymObject FightingGym;
    private FireGymObject FireGym;
    private FlyingGymObject FlyingGym;
    private GhostGymObject GhostGym;
    private GrassGymObject GrassGym;
    private GroundGymObject GroundGym;
    private IceGymObject IceGym;
    private NormalGymObject NormalGym;
    private PoisonGymObject PoisonGym;
    private PsychicGymObject PsychicGym;
    private RockGymObject RockGym;
    private SteelGymObject SteelGym;
    private WaterGymObject WaterGym;

    public PlayerObject(EliteFourObject EliteFour, BugGymObject BugGym, DarkGymObject darkGym, DragonGymObject dragonGym, ElectricGymObject electricGym,
                        FairyGymObject fairyGym, FightingGymObject fightingGym, FireGymObject fireGym, FlyingGymObject flyingGym,
                        GhostGymObject ghostGym, GrassGymObject grassGym, GroundGymObject groundGym, IceGymObject iceGym, NormalGymObject normalGym,
                        PoisonGymObject poisonGym, PsychicGymObject psychicGym, RockGymObject rockGym, SteelGymObject steelGym, WaterGymObject waterGym) {
        this.EliteFour = EliteFour;
        this.BugGym = BugGym;
        this.DarkGym = darkGym;
        this.DragonGym = dragonGym;
        this.ElectricGym = electricGym;
        this.FairyGym = fairyGym;
        this.FightingGym = fightingGym;
        this.FireGym = fireGym;
        this.FlyingGym = flyingGym;
        this.GhostGym = ghostGym;
        this.GrassGym = grassGym;
        this.GroundGym = groundGym;
        this.IceGym = iceGym;
        this.NormalGym = normalGym;
        this.PoisonGym = poisonGym;
        this.PsychicGym = psychicGym;
        this.RockGym = rockGym;
        this.SteelGym = steelGym;
        this.WaterGym = waterGym;
    }

    public void OverrideEliteFour(EliteFourObject object) {
        this.EliteFour = object;
    }

    public void OverrideBugGym(BugGymObject object) {
        this.BugGym = object;
    }

    public void OverrideDarkGym(DarkGymObject object) {
        this.DarkGym = object;
    }

    public void OverrideDragonGym(DragonGymObject object) {
        this.DragonGym = object;
    }

    public void OverrideElectricGym(ElectricGymObject object) {
        this.ElectricGym = object;
    }

    public void OverrideFairy(FairyGymObject object) {
        this.FairyGym = object;
    }

    public void OverrideFightingGym(FightingGymObject object) {
        this.FightingGym = object;
    }

    public void OverrideFireGym(FireGymObject object) {
        this.FireGym = object;
    }

    public void OverrideFlyingGym(FlyingGymObject object) {
        this.FlyingGym = object;
    }

    public void OverrideGhostGym(GhostGymObject object) {
        this.GhostGym = object;
    }

    public void OverrideGrassGym(GrassGymObject object) {
        this.GrassGym = object;
    }

    public void OverrideGroundGym(GroundGymObject object) {
        this.GroundGym = object;
    }

    public void OverrideIceGym(IceGymObject object) {
        this.IceGym = object;
    }

    public void OverrideNormalGyn(NormalGymObject object) {
        this.NormalGym = object;
    }

    public void OverridePoisonGym(PoisonGymObject object) {
        this.PoisonGym = object;
    }

    public void OverridePsychicGym(PsychicGymObject object) {
        this.PsychicGym = object;
    }

    public void OverrideRockGym(RockGymObject object) {
        this.RockGym = object;
    }

    public void OverrideSteelGym(SteelGymObject object) {
        this.SteelGym = object;
    }

    public void OverrideWaterGym(WaterGymObject object) {
        this.WaterGym = object;
    }
}

package baconetworks.npcbeatprogression.config.objects;

import java.util.List;

public class PlayerObject {

    private List<GymsObject> gymsObjects;

    public PlayerObject(List<GymsObject> object) {
        this.gymsObjects = object;
    }

    public List<GymsObject> getGymsObjects() {
        return gymsObjects;
    }

    public void setGymsObjects(List<GymsObject> gymsObjects) {
        this.gymsObjects = gymsObjects;
    }
}

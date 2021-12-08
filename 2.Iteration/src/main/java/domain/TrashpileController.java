package domain;

import java.io.FileNotFoundException;

public class TrashpileController extends SceneController{
    public TrashpileController() throws FileNotFoundException {
    }

    public void talkHomelessman() throws FileNotFoundException {
        talk("homelessman");
    }
}

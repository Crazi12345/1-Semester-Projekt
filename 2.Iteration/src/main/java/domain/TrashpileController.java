package domain;

import java.io.FileNotFoundException;

public class TrashpileController extends SceneController{
    public TrashpileController() throws FileNotFoundException {
    }

    public void talkHomelessman(){
        talk("homelessman");
    }
}

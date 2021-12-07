package domain;

import java.io.FileNotFoundException;

public class WellController extends SceneController{
    public void lookBucket() throws FileNotFoundException {
        look("bucket");
    }
    public WellController() throws FileNotFoundException {
    }
}

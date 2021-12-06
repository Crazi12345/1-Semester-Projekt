package domain;

import java.io.FileNotFoundException;

public class SchoolController extends SceneController{
    public SchoolController() throws FileNotFoundException {
    }

    public void talkTeacher() throws FileNotFoundException {
        look("teacher");
    }
}

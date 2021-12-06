package domain;

import java.io.FileNotFoundException;

public class SchoolController extends SceneController{
    public void talkTeacher() throws FileNotFoundException {
        look("teacher");
    }
}

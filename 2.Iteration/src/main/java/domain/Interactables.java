package domain;

public abstract class Interactables {

    private String name;
    private String fileName;

    public Interactables(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }


    public String getName() {
        return this.name;
    }

    public String getFileName() {
        return this.fileName;
    }
}

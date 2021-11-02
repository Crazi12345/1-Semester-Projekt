
public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"),
    EAT("eat"), LOOK("look"), TALK("talk"), INVENTORY("inventory"), YES("yes"),
    NO("no"), ENERGY("energy"), SLEEP("sleep");

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    public String toString() {
        return commandString;
    }
}

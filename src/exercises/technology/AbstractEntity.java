package exercises.technology;

public abstract class AbstractEntity {
    private int uniqueId;
    private static int nextId = 1;

    public AbstractEntity() {
        this.uniqueId = nextId;
        nextId++;
    }

    public int getId() {
        return uniqueId;
    }
}

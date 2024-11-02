package clothes;

import java.util.Objects;

public class Clothes {
    private String name;
    private Pocket pocket = new Pocket();

    public Clothes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Pocket getPocket() {
        return pocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes clothes)) return false;
        return Objects.equals(name, clothes.name) && Objects.equals(pocket, clothes.pocket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pocket);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", pocket=" + pocket +
                '}';
    }
}

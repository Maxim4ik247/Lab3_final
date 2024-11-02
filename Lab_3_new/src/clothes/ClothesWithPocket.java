package clothes;

import java.util.Objects;

public class ClothesWithPocket extends Clothes {

    private Pocket pocket = new Pocket();

    public ClothesWithPocket(String name) {
        super(name);
    }

    @Override
    public Pocket getPocket() {
        return pocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothesWithPocket that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(pocket, that.pocket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pocket);
    }

    @Override
    public String toString() {
        return "ClothesWithPocket{" +
                "pocket=" + pocket +
                '}';
    }
}

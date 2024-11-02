package items;

import interfaces.Burnable;

import java.util.Objects;

public class Cigarette extends Item implements Burnable {
    private String markOfCigarete;

    public Cigarette(String name){
        super(name);
    }
    public Cigarette(String name, String mark){
        super(name);
        markOfCigarete = mark;
    }

    public String getMarkOfCigarete() {
        return markOfCigarete;
    }

    public void setMarkOfCigarete(String markOfCigarete) {
        this.markOfCigarete = markOfCigarete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cigarette cigarette)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(markOfCigarete, cigarette.markOfCigarete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), markOfCigarete);
    }

    @Override
    public String toString() {
        return "Cigarette{" +
                "markOfCigarete='" + markOfCigarete + '\'' +
                '}';
    }
}

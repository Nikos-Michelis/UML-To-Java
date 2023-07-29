public abstract class Card {
    private int startYear;
    private int endYear;
    Owner owner;

    Card(int startYear, int endYear, Owner owner) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Card{" +
                "startYear=" + startYear +
                ", endYear=" + endYear +
                ", owner=" + owner +
                '}';
    }
}

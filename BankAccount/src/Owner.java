import java.util.Date;

public class Owner {
    private String  Name;
    private String ID;
    private Date birthYear;

    Owner(String  Name, String ID, Date birthYear){
        this.Name = Name;
        this.ID = ID;
        this.birthYear = birthYear;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return " Owner{" +
                "Name='" + Name + '\'' +
                ", ID='" + ID + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}


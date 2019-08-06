package Dynamic04;

@Club(num = 1, type = {"soccer", "basketball", "football"})
public class SportClub {

    private String city;
    private int standiumSeat;

    public SportClub() {
    }

    public SportClub(String city, int standiumSeat) {
        this.city = city;
        this.standiumSeat = standiumSeat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStandiumSeat() {
        return standiumSeat;
    }

    public void setStandiumSeat(int standiumSeat) {
        this.standiumSeat = standiumSeat;
    }
}

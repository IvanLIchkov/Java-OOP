package jediGalaxy;

public class Galaxy {
    private StarsField field;

    public Galaxy(StarsField field) {
        this.field = field;
    }

    public void moveEvil(int rowEvil, int cowEvil) {
        while (rowEvil >= 0 && cowEvil >= 0) {
            if (field.isInBounds(rowEvil, cowEvil)) {
                field.setValue(rowEvil, cowEvil, 0);
            }
            rowEvil--;
            cowEvil--;
        }
    }

    public long moveJedi(int rowJedi, int cowJedi) {
        long starsCollected = 0;
        while (rowJedi >= 0 && cowJedi < field.getColLength()) {
            if (field.isInBounds(rowJedi, cowJedi)) {
                starsCollected += field.getValue(rowJedi, cowJedi);
            }

            cowJedi++;
            rowJedi--;
        }
        return starsCollected;
    }
}

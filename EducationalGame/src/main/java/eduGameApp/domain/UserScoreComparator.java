package eduGameApp.domain;

import java.util.Comparator;

public class UserScoreComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return -1*o1.getHighScore().compareTo(o2.getHighScore());
    }
}
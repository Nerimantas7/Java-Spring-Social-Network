package lt.techin;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;

import java.util.Comparator;

public class FriendsListComparator implements Comparator<Friend> {
    @Override
    public int compare(Friend friend1, Friend friend2) {
        if (friend1.getCity().compareTo(friend2.getCity()) == 0) {
            if (friend1.getLastName().compareTo(friend2.getLastName()) == 0) {
                return friend1.getFirstName().compareTo(friend2.getFirstName());
            }
            return friend1.getLastName().compareTo(friend2.getLastName());
        }
        return friend1.getCity().compareTo(friend2.getCity());
    }
}

package lt.techin;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

import java.util.*;

public class SocialNetworkImplementation implements SocialNetwork {

    private final List<Friend> friends = new ArrayList<>();

    @Override
    public void addFriend(Friend friend) {
       List<Friend> addedFriends = new ArrayList<>();
       if((friend == null) || (friend.getCity() == null) || (friend.getFirstName() == null) || (friend.getLastName() == null)){
           throw new IllegalArgumentException();
       }if(!friends.contains(friend)) {
                friends.add(friend);
       }
    }

    @Override
    public int getNumberOfFriends() {
        return friends.size();
    }

    @Override
    public Friend findFriend(String firstName, String lastName) throws FriendNotFoundException {
        if ((firstName == null) || (lastName == null)) {
            throw new IllegalArgumentException();
        }
//        for (Friend friend : friends) {
//            if((friend.getFirstName().equals(firstName)) && (friend.getLastName().equals(lastName))){
//                return friend;
//            }
//        }
        return friends.stream().filter(f -> f.getFirstName().equals(firstName) && f.getLastName().equals(lastName)).findAny().get();
//    }
//        throw new FriendNotFoundException(firstName, lastName);
    }

    @Override
    public Collection<Friend> findByCity(String city) {
        if(city == null){
            throw new IllegalArgumentException();
        }
        Collection<Friend> friendsByCity = new ArrayList<>();
        for ( Friend friend : friends) {
            if(friend.getCity().equals(city)){
                friendsByCity.add(friend);
            }
        }
        return friendsByCity;
    }

    @Override
    public Collection<Friend> getOrderedFriends() {
        Collections.sort(friends, new FriendsListComparator());
        return friends;
    }
}
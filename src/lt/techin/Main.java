package lt.techin;

import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork;

public class Main extends BaseSocialNetworkTest {


    @Override
    protected SocialNetwork getSocialNetwork() {
        return new SocialNetworkImplementation();
    }
}

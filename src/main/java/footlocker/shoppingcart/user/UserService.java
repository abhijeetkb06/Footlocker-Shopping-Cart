package footlocker.shoppingcart.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> find(String id) {
        return userRepository.findById(id) ;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void insertUserSampleData() {
        userRepository.saveAll(Collections.singleton(new User("user1", "James Smith", "james@couchbase.com")));
        userRepository.saveAll(Collections.singleton(new User("user2", "Trevor Smith", "trevor@couchbase.com")));
        userRepository.saveAll(Collections.singleton(new User("user3", "Brad Smith", "brad@couchbase.com")));
        userRepository.saveAll(Collections.singleton(new User("user4", "Bellamy Smith", "bellamy@couchbase.com")));
        userRepository.saveAll(Collections.singleton(new User("user5", "adam Smith", "adam@couchbase.com")));
    }
}

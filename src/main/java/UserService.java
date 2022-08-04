import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UserService {


    private UserRepository userRepository;
    
    public UserService() {
       
    }

    public UserService() {
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //To test this method, create a mock user with
    public User login(String userName, String passWord){

        User user = userRepository.findOneById(userName);
        String hashedPassWord = passWord;//needs to be hashes first
        if (hashedPassWord.equals(user.getPassWordHashed())){
            return user;
        }

        return null;
    }


    public User createPassWordWithHasher(String userName, String passWord){

        String hashedPassWord = passWord;//needs to be hashed first
        userRepository.createOne(new User(userName,passWord));
        return userRepository.findOneById(userName);
    }

    public String scramblePassword(String password){

        return null;

    }


}

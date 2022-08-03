import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //To test this method, create a mock user with
    public User login(String userName, String passWord){

        User user = userRepository.findOneById(userName);
        String hashedPassWord = Hashing.sha256()
                .hashString(passWord, StandardCharsets.UTF_8)
                .toString();
        if (hashedPassWord.equals(user.getPassWordHashed())){
            return user;
        }

        return null;
    }


    public User createPassWordWithHasher(String userName, String passWord){

        String hashedPassWord = Hashing.sha256()
                .hashString(passWord, StandardCharsets.UTF_8)
                .toString();
        userRepository.createOne(new User(userName,passWord));
        return userRepository.findOneById(userName);
    }


}

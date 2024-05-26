package Urban.Green.Spaces.Reservation.API.Project.Service;

import Urban.Green.Spaces.Reservation.API.Project.Repository.UserRepository;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.AppUser;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<AppUser> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public AppUser createUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

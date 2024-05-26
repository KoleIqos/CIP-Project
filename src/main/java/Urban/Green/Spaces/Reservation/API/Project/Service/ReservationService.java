package Urban.Green.Spaces.Reservation.API.Project.Service;

import Urban.Green.Spaces.Reservation.API.Project.Repository.GreenSpaceRepository;
import Urban.Green.Spaces.Reservation.API.Project.Repository.UserRepository;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.AppUser;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.GreenSpace;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Maintenance;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Reservation;
import Urban.Green.Spaces.Reservation.API.Project.Repository.ReservationRepository;
import javassist.tools.rmi.AppletServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    GreenSpaceRepository greenSpaceRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public Reservation createReservation(Reservation reservation) {
        Optional<AppUser> appUser = userRepository.findById(reservation.getUser().getId());
        Optional<GreenSpace> greenSpace = greenSpaceRepository.findById(reservation.getGreenSpace().getId());

        AppUser appUser1 = appUser.get();
        GreenSpace greenSpace1 = greenSpace.get();

        reservation.setUser(appUser1);
        reservation.setGreenSpace(greenSpace1);


        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long reservationId, Reservation reservation) {

        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        Optional<GreenSpace> optionalGreenSpace = greenSpaceRepository.findById(reservation.getGreenSpace().getId());
        Optional<AppUser> optionalAppUser = userRepository.findById(reservation.getUser().getId());

        Reservation funcReservation = optionalReservation.get();
        GreenSpace funcGreenSpace = optionalGreenSpace.get();
        AppUser funcAppUser = optionalAppUser.get();

        funcReservation.setGreenSpace(funcGreenSpace);
        funcReservation.setUser(funcAppUser);

        funcReservation.setEndTime(reservation.getEndTime());
        funcReservation.setStartTime(reservation.getStartTime());

        return reservationRepository.save(funcReservation);

    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}

package hu.flowacademy.ads.repository;


import hu.flowacademy.ads.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

}

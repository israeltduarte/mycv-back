package br.com.isertech.mycv.mycvback.repository;

import br.com.isertech.mycv.mycvback.entity.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, String> {
}

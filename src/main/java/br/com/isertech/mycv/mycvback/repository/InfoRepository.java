package br.com.isertech.mycv.mycvback.repository;

import br.com.isertech.mycv.mycvback.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info, String>, JpaSpecificationExecutor<Info> {
}

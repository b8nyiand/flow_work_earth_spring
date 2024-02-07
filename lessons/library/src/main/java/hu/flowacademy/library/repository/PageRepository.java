package hu.flowacademy.library.repository;

import hu.flowacademy.library.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {
}

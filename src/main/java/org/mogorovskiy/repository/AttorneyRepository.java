package org.mogorovskiy.repository;

import org.mogorovskiy.model.Attorney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttorneyRepository extends JpaRepository<Attorney, Long> {
}

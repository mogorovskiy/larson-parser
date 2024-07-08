package org.mogorovskiy.repository;

import org.mogorovskiy.model.Attorney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttorneyRepository extends JpaRepository<Attorney, Long> {
}

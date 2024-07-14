package org.mogorovskiy.service;

import org.mogorovskiy.model.Attorney;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttorneyService {

    void save(List<Attorney> attorneys);

    List<Attorney> findAll();
}

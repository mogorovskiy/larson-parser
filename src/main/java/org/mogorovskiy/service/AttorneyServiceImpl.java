package org.mogorovskiy.service;

import lombok.AllArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.repository.AttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AttorneyServiceImpl implements AttorneyService {

    @Autowired
    private final AttorneyRepository attorneyRepository;

    @Override
    public void save(List<Attorney> attorneys) {
        attorneyRepository.saveAll(attorneys);
    }

    @Override
    public List<Attorney> findAll() {
        return attorneyRepository.findAll();
    }
}

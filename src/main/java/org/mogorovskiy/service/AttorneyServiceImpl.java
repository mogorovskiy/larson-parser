package org.mogorovskiy.service;

import lombok.RequiredArgsConstructor;
import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.repository.AttorneyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttorneyServiceImpl implements AttorneyService {

    private final AttorneyRepository attorneyRepository;

    @Override
    public void save(List<Attorney> attorneys) {
        attorneyRepository.saveAll(attorneys);
    }
}

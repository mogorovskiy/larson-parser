package org.mogorovskiy.service;

import org.mogorovskiy.model.Attorney;

import java.util.List;

public interface AttorneyService {

    void save(List<Attorney> attorneys);

    List<Attorney> findAll();
}

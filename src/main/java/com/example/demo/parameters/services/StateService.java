package com.example.demo.parameters.services;

import com.example.demo.parameters.models.State;
import com.example.demo.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll(){ return stateRepository.findAll(); }
    public State findById(int id){ return stateRepository.findById(id).orElse(null); }
    public void delete(int id){ stateRepository.deleteById(id); }
    public void save(State state){ stateRepository.save(state); }
}

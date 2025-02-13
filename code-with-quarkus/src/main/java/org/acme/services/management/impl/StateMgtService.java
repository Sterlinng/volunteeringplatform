package org.acme.services.management.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.State;
import org.acme.services.management.IStateMgtService;

import java.util.List;

@ApplicationScoped
public class StateMgtService implements IStateMgtService {

    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public State createState(State newState){
        State createState = new State();

        createState.id_state = newState.id_state;
        createState.date_state = newState.date_state;
        createState.wording = newState.wording;

        entityManager.persist(createState);

        return createState;
    }

    @Override
    @Transactional
    public State getStateById(Integer stateId){
        return entityManager.find(State.class, stateId);
    }

    @Override
    @Transactional
    public List<State> getAllState(){
        return entityManager.createQuery("SELECT c FROM State c", State.class).getResultList();
    }

    @Override
    @Transactional
    public State updateState(Integer stateId, State updateState){
        State existingState = entityManager.find(State.class, stateId);
        if (existingState != null){
            existingState.id_state = updateState.id_state;
            existingState.date_state = updateState.date_state;
            existingState.wording = updateState.wording;
        }
        return updateState;
    }

    @Override
    @Transactional
    public void deleteState(Integer stateId){
        State stateToDelete = entityManager.find(State.class, stateId);
        if (stateToDelete != null){
            entityManager.remove(stateToDelete);
        }
    }

}

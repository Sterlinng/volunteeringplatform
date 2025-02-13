package org.acme.services.management;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.State;

import java.util.List;

@ApplicationScoped
public interface IStateMgtService {

    /**
     * Create a new state in the DataBase
     *
     * @param newState
     * @return
     */
    public State createState(State newState);

    /**
     * Read a state by an id
     *
     * @param StateId
     * @return
     */
    public State getStateById(Integer StateId);

    @Transactional
    List<State> getAllState();

    /**
     * Update a state information
     *
     * @param stateId
     * @param updateState
     * @return
     */
    public State updateState(Integer stateId, State updateState);

    /**
     * Delete a State
     *
     * @param certificateId
     */
    public void deleteState(Integer certificateId);
}

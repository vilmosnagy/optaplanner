package org.optaplanner.examples.nqueens.optional.solver.dummymove;

import org.optaplanner.core.api.score.director.ScoreDirector;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.examples.nqueens.domain.NQueens;

public class NoOpMove extends AbstractMove<NQueens> {
    @Override
    protected AbstractMove<NQueens> createUndoMove(ScoreDirector<NQueens> scoreDirector) {
        return new NoOpMove();
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector<NQueens> scoreDirector) {
        // do nothing
    }

    @Override
    public boolean isMoveDoable(ScoreDirector<NQueens> scoreDirector) {
        return false;
    }

    @Override
    public Move<NQueens> rebase(ScoreDirector<NQueens> destinationScoreDirector) {
        return new NoOpMove();
    }
}

package org.optaplanner.examples.nqueens.optional.solver.dummymove;

import org.optaplanner.core.api.score.director.ScoreDirector;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveIteratorFactory;
import org.optaplanner.examples.nqueens.domain.NQueens;

import java.util.Iterator;
import java.util.Random;

public class DummyMoveIteratorFactory
        implements MoveIteratorFactory<NQueens, AbstractMove<NQueens>> {

    private boolean shouldGenerateNoOpMovesInsteadOfEmptyIterator = false;

    @Override
    public long getSize(ScoreDirector<NQueens> scoreDirector) {
        return 15L;
    }

    @Override
    public Iterator<AbstractMove<NQueens>>
            createOriginalMoveIterator(ScoreDirector<NQueens> scoreDirector) {
        return new DummyMoveIterator(shouldGenerateNoOpMovesInsteadOfEmptyIterator);
    }

    @Override
    public Iterator<AbstractMove<NQueens>>
            createRandomMoveIterator(ScoreDirector<NQueens> scoreDirector, Random random) {
        return new DummyMoveIterator(shouldGenerateNoOpMovesInsteadOfEmptyIterator);
    }

    public boolean isShouldGenerateNoOpMovesInsteadOfEmptyIterator() {
        return shouldGenerateNoOpMovesInsteadOfEmptyIterator;
    }

    public void setShouldGenerateNoOpMovesInsteadOfEmptyIterator(boolean shouldGenerateNoOpMovesInsteadOfEmptyIterator) {
        this.shouldGenerateNoOpMovesInsteadOfEmptyIterator = shouldGenerateNoOpMovesInsteadOfEmptyIterator;
    }
}

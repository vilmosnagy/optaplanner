package org.optaplanner.examples.nqueens.optional.solver.dummymove;

import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.examples.nqueens.domain.NQueens;

import java.util.Collections;
import java.util.Iterator;
import java.util.stream.IntStream;

public class DummyMoveIterator implements Iterator<AbstractMove<NQueens>> {

    private final Iterator<Object> internalIterator;

    public DummyMoveIterator(boolean shouldGenerateNoOpMovesInsteadOfEmptyIterator) {
        if (shouldGenerateNoOpMovesInsteadOfEmptyIterator) {
            internalIterator = IntStream
                .range(0, 15)
                .mapToObj(i -> new Object())
                .iterator();
        } else {
            internalIterator = Collections.emptyIterator();
        }
    }

    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }

    @Override
    public AbstractMove<NQueens> next() {
        internalIterator.next();
        return new NoOpMove();
    }
}

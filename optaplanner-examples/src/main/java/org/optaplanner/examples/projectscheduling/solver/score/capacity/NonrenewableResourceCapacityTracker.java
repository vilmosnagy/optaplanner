package org.optaplanner.examples.projectscheduling.solver.score.capacity;

import org.optaplanner.examples.projectscheduling.domain.Allocation;
import org.optaplanner.examples.projectscheduling.domain.ResourceRequirement;
import org.optaplanner.examples.projectscheduling.domain.resource.Resource;

public class NonrenewableResourceCapacityTracker extends ResourceCapacityTracker {

    protected int capacity;
    protected int used;

    public NonrenewableResourceCapacityTracker(Resource resource) {
        super(resource);
        capacity = resource.getCapacity();
        used = 0;
    }

    @Override
    public void insert(ResourceRequirement resourceRequirement, Allocation allocation) {
        used += resourceRequirement.getRequirement();
    }

    @Override
    public void retract(ResourceRequirement resourceRequirement, Allocation allocation) {
        used -= resourceRequirement.getRequirement();
    }

    @Override
    public int getHardScore() {
        if (capacity >= used) {
            return 0;
        }
        return capacity - used;
    }

}

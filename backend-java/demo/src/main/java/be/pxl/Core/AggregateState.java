package be.pxl.Core;

public abstract class AggregateState {
    public void mutate(IDomainEvent evt) {
        evt.visit(this);
    }
}

package be.pxl.Core;

public interface IDomainEvent {
    void visit(AggregateState state);
}

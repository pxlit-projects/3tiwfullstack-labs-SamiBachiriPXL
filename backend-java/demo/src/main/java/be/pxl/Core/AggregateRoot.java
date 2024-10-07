package DDD.Domain.Core;

import be.pxl.Core.AggregateState;
import be.pxl.Core.IDomainEvent;
import be.pxl.Core.Identity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot<TState extends AggregateState, TId extends Identity> {
    private final List<IDomainEvent> events = new ArrayList<>();
    private TState currentState;
    private TId id;
    private int version;

    protected AggregateRoot(TId id) {
        this.id = id;
        this.currentState = createState();
    }

    protected AggregateRoot(TState currentState, TId id, int version) {
        this.currentState = currentState;
        this.id = id;
        this.version = version;
    }

    public List<IDomainEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public TState getCurrentState() {
        return currentState;
    }

    public TId getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    protected void raiseEvent(IDomainEvent evt) {
        if (evt == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        currentState.mutate(evt);
        events.add(evt);
        version++;
    }

    protected abstract TState createState();
}
# SkGame:minigame

Implements an entity-component-system engine for constructing minigames quickly.

## Specification

```java
@Entity
class Participant {}

@Component
class WithPlayer {
    public Player player;
}

@System
class WinConditionSystem {
    @EventListener
    public void onComponentChange(e: ComponentChangeEvent<Score>) {
        if (!(e.entity instanceof Participant)) {
            return;
        }

        if (e.component.score > 10) {
        
        }
    }
}
```

### Query

A query represents a lookup for a particular component. Queries can be chained together to find items with specific properties or rules.

### Property

A property can be applied to a game object to modify its behaviour, or add query parameters.

# SkGame:minigame

Implements an entity-component-system engine for constructing minigames quickly.

## Specification

```java
@Entity
class Participant {}

@Component
class Score {
    public int score;
}

@Component
class WithPlayer {
    public UUID uniqueId;
    public Player getPlayer() { /* Get player from bukkit */ };
}

@Resource
class GameState {
    public int currentRound;
    public int maxRounds;
    public int maxPlayers;
}

@System
class WinConditionSystem {
    @EventListener
    public void onComponentChange(ComponentChangeEvent<Score> score) {
        if (!(e.entity instanceof Participant)) {
            return;
        }

        if (e.component.score > 10) {
            // run some game winning code
        }
    }
}
```

### Query

A query represents a lookup for a particular component. Queries can be chained together to find items with specific properties or rules.

### Property

A property can be applied to a game object to modify its behaviour, or add query parameters.

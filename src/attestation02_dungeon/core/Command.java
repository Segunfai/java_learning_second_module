package attestation02_dungeon.core;

import attestation02_dungeon.model.GameState;
import java.util.List;

@FunctionalInterface
public interface Command { void execute(GameState ctx, List<String> args); }

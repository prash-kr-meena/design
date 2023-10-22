package org.meena.model;

import java.util.Queue;

public record Team(
  Queue<Player> battingOrder
) {
}

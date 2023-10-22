package com.meena.model;


public record Player(
  String name,
  int balls,
  int runs,
  int fours,
  int sixes,
  int noBalls,
  int wideBalls
) {
}

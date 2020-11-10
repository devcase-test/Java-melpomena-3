package org.sytac.test.internal;

import java.util.List;

/**
 * There are two players playing tennis, you need to help them figure out their score.
 * You can read more about this scoring system here: https://en.wikipedia.org/wiki/Tennis_scoring_system.
 *
 * You are given a list containing for each position the name of the player who scored that point.
 * The application has to return the result for that input, in the following format:
 * sets: s1-s2 games: g1-g2 points: p1-p2
 * e.g. sets: 2-1 games: 1-1 points: 40-15
 *
 * Following rules apply:
 * - In case of Advantage we expect AD, so for example: 40-AD means Advantage for Player2.
 * - Do not implement the tie-break functionality, if one player wins a game when it's 5-5 in games, he/she will win
 * the set.
 * - Assume the game never ends, so after a game, or set finishes, then the score goes back to 0-0.
 *
 * Please feel free to add as many methods, or classes as you need, but don't change the Player enum values, since
 * those are the values that the automatic tests are expecting.
 *
 */
public interface Tennis {
    String process(final List<String> points);
}

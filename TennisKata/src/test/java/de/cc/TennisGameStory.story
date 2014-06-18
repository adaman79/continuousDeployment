Narrative:
In order to make points in a tennis game
As a Player
I want to score winners

Scenario:  Winner by PlayerA

Given A tennisGame with <playerA> and <playerB>
When PlayerA scores a winner
Then The tennis game score should count <message>

Examples:
 
| playerA| playerB | message 		|
| playerA| playerB | fifteen, love  |
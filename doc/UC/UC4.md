## UC4: Create a link

### Summary
A player (AI or user) can click on a node (origin) and click on another one (end) to create a link between the two.
This action does nothing if the origin node isn't controlled.
If a link is already present between the origin and the end nodes the link is removed.

### Scenarios

**Success**:
Player click on a controlled node and another one.
1. If there is no link, A line is drawn between them by the system.
2. If there is a link, the link is removed by the system.

**Alternative**:
1. Player click on a non controlled node.
2. The second node clicked is the same as the first one.
(these actions have no effect, no link is created)

*Author: Quentin*

## List of use cases
* [Acess to use cases list][L]

[L]:../UserCase.md
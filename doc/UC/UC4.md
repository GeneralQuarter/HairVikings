## UC4: Create a link

### Summary
A player (AI or user) can click on a node (origin) and click on another one (end) to create a link between the two.
This action does nothing if the origin node isn't controlled.
To create a link between two nodes, the productivity of the origin node must be greater or equal to 1 [See UC11][N].

### Primary Actor
Player

### Goal
Create a link between two nodes either to boost resources to it or attack it (boost and attack are not covered in this UC)
[See UC9][O] and [UC10][P].

### Scope
The game

### Stakeholders and Interest
Player: Want to create a link
System: Has to draw the link

### Precondition
The player controls at least one node

### Trigger
The player clicks on the origin node and then on the end node.

### Success Guarantees
A link created between the two nodes.

### Scenarios

**Success**

* If there is no link, A line is drawn between them by the system.    

**Alternatives**

* The first node clicked is a non controlled node, return start UC
* The second node clicked is the same as the first one, return start UC
* If there is already an existing link [See UC16][M], return start UC

*Author: Quentin*

## List of use cases
* [Acess to use cases list][L]

[L]:../UserCase.md
[M]:UC16.md
[N]:UC11.md
[O]:UC9.md
[P]:UC10.md
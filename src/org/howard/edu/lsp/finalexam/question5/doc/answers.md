# Final Exam — Question 5

Update the “Lecture illustration” lines so they match what your instructor actually said or showed in class.

**Heuristic 1**

**Name:** All data should be hidden within its class (encapsulation).

**Explanation:** Keeping fields private and exposing behavior through methods makes the class easier to read because invariants live in one place, and easier to maintain because you can change internal representation without chasing down every direct field access in the codebase.

**Lecture illustration:** We compared public fields versus private fields with accessors, and discussed how hiding data prevents other classes from putting an object into an invalid state.

**Heuristic 2**

**Name:** Minimize access to variables (use the narrowest visibility that still works).

**Explanation:** When fewer variables are widely visible, there are fewer hidden coupling points, which improves readability (less “action at a distance”) and maintainability (local changes stay local).

**Lecture illustration:** The instructor used dependency arrows on the board to show how widening visibility turns a small edit into something that can ripple across unrelated classes.

**Heuristic 3**

**Name:** Keep related data and behavior together (cohesion).

**Explanation:** A class that represents one main idea reads like a short, coherent story, which helps readability. Maintenance improves because fixes usually land in one class instead of being scattered across unrelated helpers.

**Lecture illustration:** We walked through a “god class” style example and talked about splitting responsibilities so the data and the operations that belong with that data live together, reducing cross-class chatter.

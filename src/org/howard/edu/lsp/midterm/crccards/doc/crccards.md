# CRC Collaboration Explanation

TaskManager collaborates with Task because TaskManager is responsible for storing tasks, locating them by ID, and filtering them by status, which requires direct interaction with Task objects and their properties.  
Task does not collaborate with TaskManager because Task's responsibilities are limited to holding task information, updating its own status, and providing task details.  
This separation follows the CRC cards by keeping Task as a focused domain object and TaskManager as the coordinating class.


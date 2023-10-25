package com.meena.racecondition;

/*
https://jenkov.com/tutorials/java-concurrency/race-conditions-and-critical-sections.html

A race condition is a concurrency problem that may occur inside a critical section.
A critical section is a section of code that is executed by multiple threads and
where the sequence of execution for the threads makes a difference in the result of the concurrent execution of the critical section.

When the result of multiple threads executing a critical section may differ
depending on the sequence in which the threads execute, the critical section is said to contain a race condition.
The term race condition stems from the metaphor that the threads are racing through the critical section, and
that the result of that race impacts the result of executing the critical section.



Two Types of Race Conditions

Race conditions can occur when two or more threads read and write the same variable according to one of these two patterns:
1. Read-modify-write
    The read-modify-write pattern means, that two or more threads first read a given variable,
    then modify its value and write it back to the variable.
    For this to cause a problem, the new value must depend one way or another on the previous value.
    The problem that can occur is, if two threads read the value (into CPU registers) then modify the value (in the CPU registers) and then write the values back.
    This situation is explained in more detail later.
2. Check-then-act
    The check-then-act pattern means, that two or more threads check a given condition,
    for instance if a Map contains a given value, and then go on to act based on that information,
    e.g. taking the value from the Map.
    The problem may occur if two threads check the Map for a given value at the same time - see that the value is present
    - and then both threads try to take (remove) that value.
    However, only one of the threads can actually take the value. The other thread will get a null value back.
    This could also happen if a Queue was used instead of a Map.

*/
public class RaceConditionAndCriticalSection {

}

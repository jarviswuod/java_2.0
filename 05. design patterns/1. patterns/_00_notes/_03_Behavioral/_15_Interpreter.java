package _03_Behavioral;

/*

    NOTES:
    - Interpreter Pattern:
        - Is a behavior pattern that provides a way to evaluate sentences or formula/ expression in a language


    - 3 Main actors in Interpreter:
        a. Abstract Expression:
            - In an interface that declares and interpret a method sued by concrete expressions to interpret the input

        b. Terminal Expression:
            - Is a subclass of Abstract Expression that implements the interpret method for terminal characters into grammar
            - Terminal means this class does not contain any other abstract expression

        c. Non-Terminal Expression:
            - Is also a subclass of Abstract Expression that implements the interpret method for non-terminal characters in the grammar. It usually combines and interprets multiple terminal and non-terminal expressions


    - Advantages and Disadvantages
        - Advantages:
            - Modularity: It breaks down complex grammar into modular expressions resulting in a more organized and maintainable code base
            - Extensibility: The modularity contributes to the systems extensibility making it easier to change existing grammar or add new language constructs by adding or modifying expression


        - Disadvantages:
            - Limited Applicability: The applicability of interpreter is restricted as it's suitable for scenarios where there's a need to create an interpreter for languages expressions or grammars

 */

public class _15_Interpreter {

}

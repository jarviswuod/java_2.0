package _03_Behavioral;

/*

    NOTES:
    - Interpreter is a behavior pattern that provides a way to evaluate sentences or languages in a language.
    - It defines a language and it's grammar in terms of a set of classes where each class represents a rule or production of the language. This is useful for creating an interpreter for s simple language or expression such as regular expression, mathematical expressions or domain specific languages

    - 3 Main actors in Interpreter;
        - Abstract Expression:
            - In an interface that declares and interpret a method sued by concrete expressions to interpret the input
        - Terminal Expression:
            - Is a subclass of Abstract expression that implement the interpret method for terminal characters into grammar
            - Terminal means this class does not contain any other abstract expression
        - Non-Terminal Expression:
            - Is also a subclass of Abstract expression that implements the interpret method for non-terminal characters in the grammar. It usually combines and interprets multiple terminal and non-terminal expressions


    - Advantages and Disadvantages
        - Advantages:
            - Modularity: It breaks down complex grammar into modular expressions resulting in a more organized and maintainable code base
            - Extensibility: The modularity contributes to the systems extensibility making it easier to change existing grammar or add new language constructs by adding or modifying expression


        - Disadvantages:
            - Limited Applicability: The applicability of interpreter is restricted as it's suitable for scenarios where here is a need to create an interpreter for languages expressions or grammars. There also can be more efficient choices than this pattern for more complex scenarios

 */

public class _15_Interpreter {

}

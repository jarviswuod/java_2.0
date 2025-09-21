package _04_DesignPatterns.Behavioral.Interpreter;

/*

    NOTES:
    - Interpreter pattern:
        - Defines a way to represent and evaluate sentences in a language by using an abstract class for expressions, with concrete sublcasses implementing to interpret specific parts of the language's grammar
        - This is the most complex and the least used of all the 23 GoF patterns

       - Use cases:
            - Parsing and executing SQL queries, where the interpreter pattern helps parse the query syntax and execute it against a database
            - Calculators or scientific software that interpret and evaluate complex mathematical formulas entered by users
            - Web frameworks that render HTML templated with embedded expressions or directives - i.e templates (e.g {{ variables }} in Django or <% expression %> in JSP)


    - CHALLENGE:
        - User input: "1 + 2 + 3":
            - An interpreter will convert/parse this input into an Abstract Syntax Tree(AST) / Expression tree

                    Expression expressionTree = 
                        new AdditionExpression(
                            new MultiplicationExpression(
                                new NumberExpression("2"),
                                new NumberExpression("3")
                            ),

                            new NumberExpression("1")
                        );

            - This is essentially converting an input String into a tree of objects according to the grammer rules that we specify
            - The result of this expression can be found by calling it's interpret method:
                    expressionTree.interpreter()


        - The Componenets of the Interpreter pattern:
            - Abstract Expression:
                - Establishes the interface for all expression within the language

            - Terminal Expression:
                - Represents the fundamental components of the language, such as numbers or variables. In this above example NumberExpression is a terminal expression or 'leaf' that represents integers

            - Non-terminal Expression:
                - Represents more complex expressions that are composed of other expressions using operators or functions. Above AdditionExpression and MultiplicatioExpression are non-terminal/ composite expressions


            - Interpreter:
                - Implements the logic for interpretation and determines how to evaluate different types of expressions

 */

public class Notes {

}

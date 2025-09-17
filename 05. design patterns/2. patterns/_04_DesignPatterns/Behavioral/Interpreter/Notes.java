package _04_DesignPatterns.Behavioral.Interpreter;

/*

    NOTES:
    - Interpreter pattern:
        - Defines a way to represent and evaluate sentences in a lanugage by using an abstract class for expressions, which concrete sublcasses implemet to interpret specific parts of the lanauge's grammar

        - NOTE:
            - It's the most complex and the lest used of all the 23 GoF patternns

        - Use cases:
            - Parsing and executing SQL queries, where the interpreter pattern helps parse the query syntax and execute it against a database
            - Calculators or sceintific software that interpret and evaluate complex mathematical forulas entered by users
            - Web frameworks that render HTML templated with embedded expressions or directives - i.e templates - (e.g {{ variables}} in Django or <% expression %> in JSP)

        - User input: "1 + 2 + 3":
            - An interpreter will convert/parse this input into an Abstract Syntax Tree(AST) / Expression tree

                    IExpression expressionTree = 
                        new AdditionExpression(
                            new MultiplicationExpression(
                                new NumberExpression("2"),
                                new NumberExpression("3")
                            ),
                            new NumberExpression("1")

                        );

            - Essentially, we are converting an input string into a tree of objects accorins to the grammer rules that we specify
            - The result of this expression ca be found by calline it's interpret method:

                    expressionTree.interpreter()

            - We ca use the interpreter pattern to get from the user input to the AST

            - The Componenets of the Interpreter pattern:
                - Abstract Expression:
                    - Establihses the interface for all expression withint the language

                - Terminal Expression:
                    - Represents the fundamental componenets of the language, such as numbers or variables. In this above example NumberExpression is a terminal expression or 'leaf' that represets intergers

                - Non-terminal Expression:
                    - Represents more comples expression that are composed of other expression using operators or functions. Above AdditionExpression and MultiplicatioExpression are non-terminal/ 'composite' expression

                - Interpreter:
                    - Implements the logic for interpretation and determines how to evaluate different types of expressions

        

 */

public class Notes {

}

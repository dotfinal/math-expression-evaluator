# Math Expression Evaluator

## Overview

It is a console program evaluating arithmetic expressions like "4.5+5.5+7-9*12/3" from stdin. The goal was to implement a scalable solution that can be easily extended. 

Using an instance of MathExpressionEvaluator we can parse and compute an expression, all we have to pass to it is a list of constraints (regexps) and a list of acceptable operators (consisting of operator keyword, priority and lambda to apply it).

ManualMathExpressionEvaluator is a predictible implementation of the API.

JSEngineMathExpressionEvaluator has been added just for fan =). The realization uses JavaScript Engine to compute an expression. Surely it's insecure but if an input line's carefully validated it makes sense. 

To show that both implimentations works identically some tests are provided.

Thus, this console program is just an example of using that evaluator. Used properties (regexps and operators) provided in TestData.class.

## Build & Run

To run (if the project hasn't built, it'll build automatically using build.sh):

`./run.sh`

To build jar (you need Maven):

`./build.sh`

Feel free to criticise =)

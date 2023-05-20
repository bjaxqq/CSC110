# Assignment 5

### Background
The next iteration of your awesome menu program will allow the user to select the number of sandwiches and drinks they want. The restaurant still only serves 1 kind of sandwich and 1 kind of drink, and the prices are the same ($8.25 and $2.25 respectively). The following rules apply:
- All responses will be legal (non-negative input for number of sandwiches or drinks)
- You should only ask about the loyalty program if the customer orders something
- Any loyalty discount is truncated (to maximize profit for the restaurant)
- Your program should assume that any response to the loyalty question that isn’t “y” or “yes” means they are not a member of the loyalty program.
• All messages about what customers owe should be printed out in the format: `$<dollars>.<cents>` where `<cents>` is always 2 digits! (i.e. $7.20 and not $7.2 and $8.03 and not $8.3)

In addition to allowing customers to order more than one thing, your solution should use functions to calculate totals. I have provided you with starter code for your assignment. You should add a comment at the top with your name, and you should replace all instances of “???” in the code with working Scala to solve the problem.

Here are some sample runs (user input is in **bold**):

How many sandwiches do you want? **1**
How many drinks do you want? **1**
Are you a member of the loyalty program? **y**
You owe $9.45

How many sandwiches do you want? **0**
How many drinks do you want? **1**
Are you a member of the loyalty program? **y**
You owe $2.03

How many sandwiches do you want? **3**
How many drinks do you want? **2**
Are you a member of the loyalty program? **n**
You owe $29.25

How many sandwiches do you want? **3**
How many drinks do you want? **2**
Are you a member of the loyalty program? **Y**
You owe $26.33

How many sandwiches do you want? **2**
How many drinks do you want? **2**
Are you a member of the loyalty program? **Of Course!**
You owe $21.00
# Assignment 4

### Background
Ordering food in restaurants has changed dramatically over the last 10 years or so. From kiosks in Panera to Uber Eats and beyond, diners now can make food choices (and pay) digitally almost everywhere. For this assignment, you should write a program to begin building a food kiosk for a restaurant. This will be an ongoing project as we work through the semester. This first program will be quite simple, but will set the framework for future improvements.

Your first program only knows about sandwiches and drinks. To make your life easier, your restaurant only serves one kind of sandwich and one kind (and size) of drink. No substitutions or changes are allowed! Your restaurant has a loyalty program that gives customers 10% off all orders (rounding what they owe), so you must factor that in. You should ask if the user wants a sandwich, a drink, and/or if they are a member of the loyalty program. It should the print a message with what they owe. Note that sandwiches are $8.25 and drinks are $2.25 apiece.

### Notes
1. User input should be accepted regardless of the case (upper or lower).
2. If a user doesn’t order anything your program should NOT ask if they are a part of the loyalty program.
3. All messages about what customers owe should be printed out in the format: `$<dollars>.<cents> where <cents> is always 2 digits! (i.e. $7.20 and not $7.2)`

Here are some sample runs (user input is in **bold**):

1. 
Do you want a sandwich? (Y/N) **y**
Do you want a drink? (Y/N) **y**
Are you a member of our loyalty program? **n**
Your total is $10.50

2. Do you want a sandwich? (Y/N) **y**
Do you want a drink? (Y/N) **y**
Are you a member of our loyalty program? **y**
Your total is $9.45

3.
Do you want a sandwich? (Y/N) **n**
Do you want a drink? (Y/N) **n**
Your total is $0.00

4.
Do you want a sandwich? (Y/N) **n**
Do you want a drink? (Y/N) **y**
Are you a member of our loyalty program? **y**
Your total is $2.03
### Final Assignment

For your final project you will create an interactive sandwich shop ordering system. This ordering system will be for Blake’s Famous Sandwich Shop!

Orders at the shop consist of 0 or more sandwiches, sides, and drinks (at least 1 of something). Sandwiches consist of bread, protein, cheese, and add-ons. Only the bread is required. Your interactive program will support the following commands (case-insensitive):
- Print Menu (MENU) – Print the menu
- Show Order (SHOW) – Show the current order
- Add Item (ADD) – Add an item to the order (Sandwich, Drink, or Side)
- Delete Item (DELETE) – Delete an item from the order. Print a message if the order is empty.
- Check Out (CHECK) – Calculate and print the order total. The total includes taxes (6.35% CT sales tax, rounded to the nearest penny) and any loyalty discounts (10%, rounded to the nearest penny). If the customer is not in the loyalty program, they should be offered the opportunity to join the loyalty program for $10. If they do, they get the 10% discount.
- Help (HELP) – Print a message describing these commands
- Quit (QUIT) – Quit the program. If there are items in the order, ask the user if they want to quit or not. If no, stay in the ordering process.

Blank lines are ignored, and illegal commands are acknowledged and ignored. The menu items are stored in text files that your program will read in when it starts. Assume that the files are present and well-formatted. The following files will be provided:
- breads.txt
- proteins.txt
- cheeses.txt
- additions.txt
- drinks.txt
- sides.txt

Your program will process commands entered by the user until Quit or Pay is entered. When finished, your program will print Goodbye! To complete this assignment you will use everything we have covered so far, and new things as well! Here is a partial list of topics:
- Case classes
- File I/O
- Iteration
    - While/Do-While
- Collections
- Match statement

Sample runs and starter code will be provided.
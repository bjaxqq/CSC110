# Assignment 7

### Background
Now we get to add a larger menu, and your program will remember the order!
- Your program should start by asking the user how many sandwiches they want (see lists below)
    - For each sandwich, print them (with price), ask which one they want and save it
- Your program should then ask for how many drinks they want (see lists below)
    - For each drink, print them (with price), ask what they want and save it.
- Your program should then ask for how many sides they want (see lists below)
    - For each side, print them (with price), ask what they want and save it.
- If they order nothing, just stop. Otherwise continue to step 5.
- Your program should print out the order (see the examples for the format) and ask if the customer is a member of the loyalty program. If they are, subtract 10% from the cost. Round the discount down before applying it.
- You should then print the total cost (factoring in any loyalty reductions), and the CT state tax owed (6.35%). Round the tax up before adding it.
    - All messages about what customers owe should be printed out in the format: `$<dollars>.<cents>` where `<cents>` is always 2 digits! (i.e. $7.20 and not $7.2 and $8.03 and not $8.3)

Note: All responses will be legal (non-negative integer input for all numbers). **TRY TO MATCH THE OUTPUT FORMAT AS BEST YOU CAN!**

**Menu items and prices**

Sandwiches:
- Roast beef and Cheddar Panini     $8.75
- Turkey and Provolone on a Roll    $7.50
- Chicken Salad Wrap                $7.00
- Meatball Sub                      $9.50
- Veggie Supreme on Wheat           $6.50

Drinks:
- Water                             $1.50
- Soda                              $2.50
- Iced Coffee                       $2.50
- Boba                              $3.75

Sides:
- Chips                             $2.00
- Fries                             $3.50
- Salad                             $2.50
- Cole Slaw                         $2.25
- Potato Salad                      $2.25

NOTE: Scripts of sample runs are provided
/*
** CSC110 22/FA Final Project
**
** Team Names:Brooks Jackson, Riley Damasco, Sean Emede
*/
import scala.io.StdIn._
import scala.io.Source

// Case classes for sandwiches
case class Sandwich(bread: Item, protein: Item, cheese: Item, adds: Array[Item]) {
    override def toString() = {
        var tempCost = 0
        var tempName:String = "" 
        
        for(a<- adds) {
            tempCost += a.cost
            tempName = tempName + "," + a.name 
        }
        
        tempCost += bread.cost + protein.cost + cheese.cost
        tempFinalCost = tempCost
        (f"${bread.name},${protein.name},${cheese.name}${tempName} ($$${tempCost/100.0}%1.2f)")
    }
}

// Case class for individual items
var finalCost = 0.0
var tempFinalCost = 0
case class Item(name: String, cost: Int) {
    override def toString() = {
        tempFinalCost = cost
        (f"$name ($$${cost/100.0}%1.2f)")    
    }
}

// Load item lists from files
val breads: Array[Item] = getItems("breads.txt")
val proteins: Array[Item] = getItems("proteins.txt")
val cheeses: Array[Item] = getItems("cheeses.txt")
val sides: Array[Item] = getItems("sides.txt")
val drinks: Array[Item] = getItems("drinks.txt")
val adds: Array[Item] = getItems("adds.txt")

// Lists of order items
var sandwichOrder: List[Sandwich] = Nil;
var drinkOrder: List[Item] = Nil;
var sideOrder: List[Item] = Nil;
// sandwich that is just bread, will be filled later

// Organizational booleans
var finished: Boolean = false

// Format dollar amount


// Returns Array of type Item from provided file
def getItems(fName: String): Array[Item] = {
    val x = (s: String) => {
        val a = s.split(",")
        Item(a(0), a(1).toInt)
    }
    Source.fromFile(fName).getLines().toArray.map(x)
}

// prints the menu of all items using function printMenu
def menu() {
    println("--MENU--")
    println(f"\tBREADS")
    printMenu(breads)
    println()
    println(f"\n\tPROTEINS")
    printMenu(proteins)
    println()
    println(f"\n\tCHEESES")
    printMenu(cheeses)
    println()
    println(f"\n\tSIDES")
    printMenu(sides)
    println()
    println(f"\n\tDRINKS")
    printMenu(drinks)
    println()
    println(f"\n\tADD-ONS")
    printMenu(adds)
    println()
}

// takes Array[Items] and prints all elements(add formating)
def printMenu(text: Array[Item]) {
    var index = readInt()
    var tempItem : Item = itemArray(0)
    tempItem = itemArray(index-1)
    
    if(itemArray(0).toString ==drinks(0).toString) {
        drinkOrder = tempItem :: drinkOrder
    } else {
        sideOrder = tempItem :: sideOrder
    }
}

// Shows what is in the checkout
def show() {
    println("Sandwiches:")
    
    for(a <- 0 to (sandwichOrder.length-1)) {
        println(f"\t${(a+1)}: ${sandwichOrder(a)}")
    }
    println("Drinks:")
    // loop in everything in drink list and prints
    
    for(a <- 0 to (drinkOrder.length-1)) {
        println(f"\t${(a+1)}: ${drinkOrder(a)}")
    }
    // same as drinks, but using side list
    println("Sides:")
    
    for(a <- 0 to (sideOrder.length-1)) {
        println(f"\t${(a+1)}: ${sideOrder(a)}")
    }
    println(f"Food Total:$$${(finalCost)/100.0}%1.2f")
}

// deletes a item in inventory, user request
def delete() {
    println("1: Sandwich\n2: Drink\n3: Side")
    val cmd = readLine()
    cmd.toUpperCase match {
        case "1" => {
            for(a <- 0 to (sandwichOrder.length-1)) {
                println(f"${(a+1)}: ${sandwichOrder(a)}")
            }
            var del = readInt()
            sandwichOrder = sandwichDelHelper(del,sandwichOrder)
        }
        case "2" => {
            for(a <- 0 to (drinkOrder.length-1)) {
                println(f"${(a+1)}: ${drinkOrder(a)}")
            }
            var del = readInt()
            drinkOrder = delHelper(del,drinkOrder)
        }
        case "3" => {
            for(a <- 0 to (sideOrder.length-1)) {
                println(f"${(a+1)}: ${sideOrder(a)}")
            }
            var del = readInt()
            sideOrder = delHelper(del,sideOrder)
        }
    }
}

// helps delete item in
def delHelper(del: Int, order: List[Item]): List[Item] = {
    order.zipWithIndex.filterNot{ case (e,i) => i == (del-1) }.map(_._1)

}

def sandwichDelHelper(del: Int, order: List[Sandwich]): List[Sandwich] = {
    order.zipWithIndex.filterNot{ case (e,i) => i == (del-1) }.map(_._1)
}

// quit the program, if user has something in there cart ask if they want to quit
def quit() {
    if (sandwichOrder == Nil && drinkOrder == Nil && sideOrder == Nil) {
        finished = true
    } else {
        println("Your order is not empty! Quit anyway?")
        val cmd = readLine()
        cmd.toUpperCase match {
            case "YES" => finished = true
            // Other Commands
            case "NO" => println()
        }
    }
}

def addItem(itemArray: Array[Item]) {
    var tempString = ""
    
    if(itemArray(0).toString == drinks(0).toString) {
        tempString = "drink"
    } else {
        tempString = "Side"
    }
    println(f"please choose a ${tempString}:")
    
    if(itemArray(0).toString == drinks(0).toString) {
        options(drinks)
    } else {
        options(sides)
    }
    var index = readInt()
    var tempItem : Item = itemArray(0)
    tempItem = itemArray(index-1)
    
    if(itemArray(0).toString == drinks(0).toString) {
        drinkOrder = tempItem :: drinkOrder
    } else {
        sideOrder = tempItem :: sideOrder
    }
}

def options(itemArray: Array[Item]) {
    var counter = 1
    
    for(a <- itemArray) {
        println(f" $counter. ${a}")
        counter += 1 // for the number before the options
    }
}

def checkShow() {
    println("Sandwiches:")
    
    for(a <- 0 to (sandwichOrder.length-1)) {
        println(f"\t${(a+1)}: ${sandwichOrder(a)}")
        finalCost += tempFinalCost
    }
    println("Drinks:")
    // loop in everything in drink list and prints
    
    for(a <- 0 to (drinkOrder.length-1)) {
        println(f"\t${(a+1)}: ${drinkOrder(a)}")
        finalCost += tempFinalCost
    }
    // same as drinks, but using side list
    println("Sides:")
    
    for(a <- 0 to (sideOrder.length-1)) {
        println(f"\t${(a+1)}: ${sideOrder(a)}")
        finalCost += tempFinalCost
    }
}

def addSandwich() {
    var tempBread = addBread(breads)
    var tempProteins = addProtein(proteins)
    var tempCheeses = addCheeses(cheeses)
    var tempAdds = addAddOns(adds)
    var tempSand: Sandwich = Sandwich(tempBread: Item,tempProteins: Item, tempCheeses: Item,tempAdds: Array[Item])
    sandwichOrder = tempSand :: sandwichOrder
}

// ---sandwich parts---
def addBread(breads: Array[Item]) = {
    println("Please choose the type of bread:")
    options(breads)
    var index = readInt()
    breads(index-1)
}

def addProtein(proteins: Array[Item]) = {
    println("Please choose a protein:")
    options(proteins)
    var index = readInt()
    proteins(index-1)
}

def addCheeses(cheeses: Array[Item]) = {
    println("Please choose a type of cheese:")
    options(cheeses)
    var index = readInt()
    cheeses(index-1)
}

def addAddOns(adds: Array[Item]) = {
    println("Please choose additions as a comma-separated list of Ints (no spaces):")
    options(adds)
    var tempIndexes = readLine()
    var indexes = tempIndexes.toString.split(",")
    var addsList= Array[Item]()
    val x = (s: String) => {
        val a = adds((s.toInt)-1)
        a
    }
    indexes.map(x)
}

// -------------------------------
// checkout
def checkout() {
    if (sandwichOrder == Nil && drinkOrder == Nil && sideOrder == Nil) {
        println("Your order is empty!")
        finished = true
    } else {
        checkShow()
        println(f"Food Total:$$${(finalCost)/100.0}%1.2f")
        println("\nAre you a member of our loyalty program?\n1: Yes\n2: No")
        val cmd = readLine()
        cmd.toUpperCase match {
            case "1" => {
                var discount = (finalCost/100) * 10
                println(f"Loyalty Discount: $$${(discount)/100.0}%1.2f")
                finalCost -= discount
                println(f"Total After Loyalty Discount: $$${(finalCost)/100.0}%1.2f")
                var tax = (finalCost/100) * 6.35
                println(f"Taxes: $$${tax/100.0}%1.2f")
                finalCost += tax
                println(f"Final Bill: $$${(finalCost)/100.0}%1.2f")
                finished = true
            }
            case "2" => {
                println("Do you wish to join for a $10.00 charge?\n1: Yes\n2: No")
                val cmd = readLine()
                cmd.toUpperCase match {
                    case "1" => {
                        println("Loyalty Membership: $10.00")
                        var discount = (finalCost/100) * 10
                        println(f"Loyalty Discount: $$${(discount)/100.0}%1.2f")
                        finalCost -= discount
                        println(f"Total After Loyalty Discount: $$${(finalCost)/100.0}%1.2f")
                        var tax = (finalCost/100) * 6.35
                        println(f"Taxes: $$${tax/100.0}%1.2f")
                        finalCost += 1000
                        finalCost += tax
                        println(f"Final Bill: $$${(finalCost)/100.0}%1.2f")
                        finished = true
                    }
                    case "2" => {
                        var tax = (finalCost/100) * 6.35
                        println(f"Taxes: $$${tax/100.0}%1.2f")
                        finalCost += tax
                        println(f"Final Bill: $$${(finalCost)/100.0}%1.2f")
                        finished = true
                    }
                }
            }
        }
    }
}

// Intro and process the commands
println("Welcome to the Blake Eatery!\n")
println("Please enter commands (\"help\" for help). Commands are case insensitive.\n")
do {
    print("command: ")
    val cmd = readLine()
    cmd.toUpperCase match {
        case "HELP" => println("HELP        -       Print this help.\nCHECK      -       Check out and pay for your order.\nMENU        
        -       Print the menu.\nADD        -       Add an item to the order.\nDELETE       -       Delete an item from the order.\nQUIT        
        -       Quit the ordering process.\nSHOW        -       Show the current order.")
        // Other Commands
        case "CHECK" => checkout()
        // Empty Command
        case "MENU" => menu()
        case "ADD" => {
            println("1: Sandwich\n2: Drink\n3: Side")
            val cmd = readLine()
            cmd.toUpperCase match {
                case "1" => addSandwich()
                case "2" => addItem(drinks)
                case "3" => addItem(sides)
            }
        }
        case "DELETE" => delete()
        case "QUIT" => quit()
        case "SHOW" => show()
    }
} while(!finished)
println("Goodbye!")
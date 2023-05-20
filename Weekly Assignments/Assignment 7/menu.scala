import scala.io.StdIn._

def printMenuItems(menuItems: List[(String, Double)]): Unit = {
  menuItems.zipWithIndex.foreach { case ((item, price), index) =>
    println(s"${index + 1}: $item ($$${"%.2f".format(price)})")
  }
}

def getMenuChoice(menuItems: List[(String, Double)]): String = {
  val validChoices = menuItems.indices.map(_ + 1).mkString(", ")
  var choice = -1
  while (!menuItems.indices.contains(choice - 1)) {
    print("==> ")
    choice = readInt()
    if (!menuItems.indices.contains(choice - 1)) {
      println(s"Invalid choice. Please enter a valid number: $validChoices")
    }
  }
  menuItems(choice - 1)._1
}

def getQuantity(itemName: String): Int = {
  print(s"How many $itemName do you want? ")
  readInt()
}

def calculateTotalCost(order: List[(String, Double)], loyaltyProgram: Boolean): Double = {
  val totalCost = order.map(_._2).sum
  if (loyaltyProgram) {
    totalCost * 0.9  // Apply 10% discount for loyalty program members
  } else {
    totalCost
  }
}

def calculateTax(totalCost: Double): Double = {
  math.ceil(totalCost * 0.0635 * 100) / 100  // Round up tax to 2 decimal places
}

def printOrder(order: List[(String, Double)]): Unit = {
  println("\nYour order:")
  order.zipWithIndex.foreach { case ((item, _), index) =>
    println(s"${item.capitalize} ${index + 1}: $item")
  }
}

println("Welcome to the Cafe!\n")

val sandwiches = List(
  "Roast beef and Cheddar Panini" -> 8.75,
  "Turkey and Provolone on a Roll" -> 7.50,
  "Chicken Salad Wrap" -> 7.00,
  "Meatball Sub" -> 9.50,
  "Veggie Supreme on Wheat" -> 6.50
)

val drinks = List(
  "Water" -> 1.50,
  "Soda" -> 2.50,
  "Iced Coffee" -> 2.50,
  "Boba" -> 3.75
)

val sides = List(
  "Chips" -> 2.00,
  "Fries" -> 3.50,
  "Salad" -> 2.50,
  "Cole Slaw" -> 2.25,
  "Potato Salad" -> 2.25
)

var sandwichOrder: List[(String, Double)] = Nil
var drinkOrder: List[(String, Double)] = Nil
var sideOrder: List[(String, Double)] = Nil

print("How many sandwiches do you want? ")
val numSandwiches = readInt()
if (numSandwiches > 0) {
  println("\nChoose from the following:")
  printMenuItems(sandwiches)
  for (_ <- 1 to numSandwiches) {
    val choice = getMenuChoice(sandwiches)
    sandwichOrder = sandwichOrder :+ (choice, sandwiches.find(_._1 == choice).get._2)
  }
}

print("\nHow many drinks do you want? ")
val numDrinks = readInt()
if (numDrinks > 0) {
  println("\nChoose from the following:")
  printMenuItems(drinks)
  for (_ <- 1 to numDrinks) {
    val choice = getMenuChoice(drinks)
    drinkOrder = drinkOrder :+ (choice, drinks.find(_._1 == choice).get._2)
  }
}

print("\nHow many sides do you want? ")
val numSides = readInt()
if (numSides > 0) {
  println("\nChoose from the following:")
  printMenuItems(sides)
  for (_ <- 1 to numSides) {
    val choice = getMenuChoice(sides)
    sideOrder = sideOrder :+ (choice, sides.find(_._1 == choice).get._2)
  }
}

val order = sandwichOrder ++ drinkOrder ++ sideOrder

if (order.isEmpty) {
  println("Thank you for visiting the Cafe!")
} else {
  printOrder(order)

  print("\nAre you a member of the loyalty program? (Y/N) ")
  val loyaltyProgramResponse = readLine().toLowerCase
  val loyaltyProgram = loyaltyProgramResponse == "y" || loyaltyProgramResponse == "yes"

  val totalCost = calculateTotalCost(order, loyaltyProgram)
  val tax = calculateTax(totalCost)
  val totalBill = totalCost + tax

  println(f"\nYour bill is $$${"%.2f".format(totalCost)}")
  println(f"Your tax is $$${"%.2f".format(tax)}")
  println(f"You owe $$${"%.2f".format(totalBill)}")
}
import scala.io.StdIn._

def getSandwiches(): Int = {
  println("How many sandwiches do you want?")
  readInt()
}

def getDrinks(): Int = {
  println("How many drinks do you want?")
  readInt()
}

def discount(sum: Int, loyaltyProgram: Boolean): Int = {
  if (loyaltyProgram)
    (sum * 0.1).toInt  // Apply 10% discount for loyalty program members
  else
    0
}

var sandwiches: Int = getSandwiches()
var drinks: Int = getDrinks()

println("Are you a member of the loyalty program?")
val loyaltyProgramResponse = readLine().toLowerCase
val loyaltyProgram = loyaltyProgramResponse == "y" || loyaltyProgramResponse == "yes"

var total: Int = (sandwiches * 825) + (drinks * 225)
total -= discount(total, loyaltyProgram)

val dollars: Int = total / 100
val cents: Int = total % 100

println(f"You owe $$$dollars.$cents%02d")
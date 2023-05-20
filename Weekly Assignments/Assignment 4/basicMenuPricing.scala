import scala.io.StdIn._

println("Do you want a sandwich? (Y/N)")
var sand = readChar
println("Do you want a drink? (Y/N)")
var bev = readChar
println("Are you a member of the loyalty program?")
var disc = readChar

if(sand == 'Y' && bev == 'Y') {
    if(disc == 'Y') {
        println("Your total is: $9.00")
    } else {
        println("Your total is: $10.50.")
    }
} else if(sand == 'N' && bev == 'Y') {
    if(disc == 'Y') {
        println("Your total is: $2.03.")
    } else {
        println("Your total is: $2.25.")
    }
} else if(sand == 'Y' && bev == 'N') {
    if(disc == 'Y') {
        println("Your total is: $7.43.")
    } else {
        println("Your total is: $8.25.")
    }
} else if(sand == 'N' && bev == 'N') {
    println("Why are you here?")
} else {
   println("Error")
}
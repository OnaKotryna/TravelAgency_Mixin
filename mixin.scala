abstract class Trip {
  def CalculateDistance(distance:Double) : Double
  def CalculateDuration(distance:Double) : Double
  def CalculatePrice(price:Double, distance:Double) : Double
  def CalculateTaxes(price:Double) : Double
}
abstract class Order {
  def CalculateDistance(distance:Double) : Double
  def CalculateDuration(distance:Double) : Double
  def CalculatePrice(price:Double, distance:Double) : Double
}
//Transport variacijos
trait CarTransport{
  def CalculateDistance(distance:Double) : Double = {
    var dist = distance * 1.5
    dist
  }
  def CalculateDuration(distance:Double) : Double = {
    var dur = distance * 0.5
    dur
  }
  def CalculatePrice(price:Double, distance:Double) : Double = {
    var total = price + distance * 1.5
    total
  }
}
trait BicycleTransport{
  def CalculateDistance(distance:Double) : Double = {
    var dist = distance * 0.75
    dist
  }
  def CalculateDuration(distance:Double) : Double = {
    var dur = distance * 0.75
    dur
  }
  def CalculatePrice(price:Double, distance:Double) : Double = {
    var total = price + distance * 1.2
    total
  }
}
trait WalkTransport{
  def CalculateDistance(distance:Double) : Double = {
    var dist = distance * 0.5
    dist
  }
  def CalculateDuration(distance:Double) : Double = {
    var dur = distance * 1.5
    dur
  }
  def CalculatePrice(price:Double, distance:Double) : Double = {
    var total = price
    total
  }
}
// Payment variacijos
trait BankCardPayment{
  def CalculateTaxes(price:Double) : Double = {
    var total = price + price * 0.4
    total
  }
}
trait CashPayment{
  def CalculateTaxes(price:Double) : Double = {
    var total = price + price * 0.21
    total
  }
}
// Daugybinis paveldejimas
class TripCarTransportBankCard extends Trip with CarTransport with BankCardPayment{}
class TripCarTransportCash extends Trip with CarTransport with CashPayment{}

class TripBicycleTransportBankCard extends Trip with BicycleTransport with BankCardPayment{}
class TripBicycleTransportCash extends Trip with BicycleTransport with CashPayment{}

class TripWalkTransportBankCard extends Trip with WalkTransport with BankCardPayment{}
class TripWalkTransportCash extends Trip with WalkTransport with CashPayment{}

class OrderCarTransport extends Order with CarTransport{}
class OrderBicycleTransport extends Order with BicycleTransport{}
class OrderWalkTransport extends Order with WalkTransport{}

//******* Keliu klasiu realizavimas
println("Trip by car, paid by cash:")
var carBank = new TripCarTransportCash()
println("-Distance: " + carBank.CalculateDistance(10)
        + "\n-Duration: " + carBank.CalculateDuration(10) 
        + "\n-Price: "+ carBank.CalculatePrice(30,10) 
        + "\n-Price with taxes: " + carBank.CalculateTaxes(carBank.CalculatePrice(30,10)))
println("------------------------------------")
println("Trip by walking, paid by bank card:")
var walkBank = new TripWalkTransportBankCard()
println("-Distance: " + walkBank.CalculateDistance(10)
        + "\n-Duration: " + walkBank.CalculateDuration(10) 
        + "\n-Price: "+ walkBank.CalculatePrice(30,10) 
        + "\n-Price with taxes: " + walkBank.CalculateTaxes(walkBank.CalculatePrice(30,10)))

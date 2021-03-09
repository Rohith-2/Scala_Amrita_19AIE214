import scala.annotation.tailrec
object Classes {
  val i = 0                                       //> i  : Int = 0
  val r0 = Rational(2,3)                          //> r0  : Rational = 2/3
  val r1 = Rational(5,-15)                        //> r1  : Rational = -1/3
  
  (r0+r1).toFloat                                 //> res0: Float = 0.33333334
  (r0*r1).toFloat                                 //> res1: Float = -0.22222222
  
  -r1                                             //> res2: Rational = 1/3
  
  val r2 = Rational(0,1)                          //> r2  : Rational = 0
  val r3 = Rational(0,5)                          //> r3  : Rational = 0
  
  r2==r3                                          //> res3: Boolean = true
  r2.isZero                                       //> res4: Boolean = true
}

class Rational(n:Int,d:Int/*d:Int=1*/) {
	require(d!=0,new IllegalArgumentException("Denominater can't be 0"))
	
	val gcd0 = math.abs(Rational.gcd(n,d))
	
	lazy val numer = (if(d<0) -1 else 1)* n/gcd0
	lazy val denom = math.abs(d/gcd0)
	
	
	
	def this(n:Int) = this(n,1)
	
	override def toString = numer+(if (denom!=1)"/"+denom else "")

	//operator overloading and put space after operator
	def + (that:Rational) = new Rational (this.numer * that.denom + this.denom * that.numer,this.denom*that.denom)
	def * (that:Rational) = new Rational (this.numer * that.numer,this.denom*that.denom)
	def - (that:Rational) = new Rational (this.numer * that.denom - this.denom * that.numer,this.denom*that.denom)
	def unary_- = Rational.ZERO - this
	
	def toInt = numer/denom
	def toFloat = numer.toFloat/denom
	def toDouble = numer.toDouble/denom
	
	def isZero = Rational.ZERO == this
	
}

object Rational{

  @tailrec
	private def gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)
	
	val ZERO = new Rational(0,1)
	
	def apply(p:Int,q:Int) = if(p==0) ZERO else new Rational(p,q)
	def apply(p:Int) = if(p==0) ZERO else new Rational(p,1)
}
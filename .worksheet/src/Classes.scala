import scala.annotation.tailrec
object Classes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  val i = 0;System.out.println("""i  : Int = """ + $show(i ));$skip(25); 
  val r0 = Rational(2,3);System.out.println("""r0  : Rational = """ + $show(r0 ));$skip(27); 
  val r1 = Rational(5,-15);System.out.println("""r1  : Rational = """ + $show(r1 ));$skip(21); val res$0 = 
  
  (r0+r1).toFloat;System.out.println("""res0: Float = """ + $show(res$0));$skip(18); val res$1 = 
  (r0*r1).toFloat;System.out.println("""res1: Float = """ + $show(res$1));$skip(9); val res$2 = 
  
  -r1;System.out.println("""res2: Rational = """ + $show(res$2));$skip(28); 
  
  val r2 = Rational(0,1);System.out.println("""r2  : Rational = """ + $show(r2 ));$skip(25); 
  val r3 = Rational(0,5);System.out.println("""r3  : Rational = """ + $show(r3 ));$skip(12); val res$3 = 
  
  r2==r3;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(12); val res$4 = 
  r2.isZero;System.out.println("""res4: Boolean = """ + $show(res$4))}
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

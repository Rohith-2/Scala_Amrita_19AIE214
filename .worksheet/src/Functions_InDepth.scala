object Functions_InDepth {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(132); 
  //Functions are the First class constructs..
  //Type Inferences is compile time
  
  var a=6 ; var b=7;System.out.println("""a  : Int = """ + $show(a ));System.out.println("""b  : Int = """ + $show(b ));$skip(90); 
  //Parameters are AnyVal
  def fn5(x:Int ,y:Int)={
  	if (x%2==0) x/2 +y
  	else x+y
  };System.out.println("""fn5: (x: Int, y: Int)Int""");$skip(12); val res$0 = 
 
 fn5(a,b);System.out.println("""res0: Int = """ + $show(res$0));$skip(189); 
 /*
 the formal parameters are x and y
 x and y are copies of a and b
 pass by value .. more memory used
 */
 
//Parameters are AnyRef
   def fn6(x:Array[Char] ,y:String)={
  	x(0)='B'
  };System.out.println("""fn6: (x: Array[Char], y: String)Unit""");$skip(36); 
  
  var c = "Rohith".toCharArray();System.out.println("""c  : Array[Char] = """ + $show(c ));$skip(24); 
  fn6(c,"Ramakrishnan");$skip(4); val res$1 = 
  c;System.out.println("""res1: Array[Char] = """ + $show(res$1));$skip(346); 
  
  /*
  'c' the global variable is modified
  AnyRef parameneters are not copied
  They are re-referenced by the formal arguments
  Any change in the formall parameter will result in the chang of actual parameter
  This is call by reference
  */
  
  //IndexedSeq is an immutable array ..
    def fn7(x:IndexedSeq[Char] ,y:String)={
  	x+y
  };System.out.println("""fn7: (x: IndexedSeq[Char], y: String)String""");$skip(17); val res$2 = 
  fn7(c,"Menon");System.out.println("""res2: String = """ + $show(res$2));$skip(59); 
  
  def fn8(x:Int,y: => Int)={
  if(x%3==0)y
  else x
  };System.out.println("""fn8: (x: Int, y: => Int)Int""");$skip(72); val res$3 = 
  //paramter 'y' is never used if the condition fails
  
  fn8(4+5,6+7);System.out.println("""res3: Int = """ + $show(res$3));$skip(48); 
  
  def fp = {
  	println("Called")
  	6+7
  };System.out.println("""fp: => Int""");$skip(17); val res$4 = 
  
  fn8(4+5,fp);System.out.println("""res4: Int = """ + $show(res$4));$skip(17); val res$5 = 
  
  fn8(4+7,fp);System.out.println("""res5: Int = """ + $show(res$5));$skip(67); 
  
  def fact0(n:Int) : Int={
  if(n<2) 1;
  else n*fact0(n-1)
  };System.out.println("""fact0: (n: Int)Int""");$skip(15); val res$6 = 
  
  fact0(20);System.out.println("""res6: Int = """ + $show(res$6));$skip(132); 
  //fact0(20) res7: Int = -2102132736 .. Integer Overflow
  
  def fact1(n:Int) : BigInt = {
   if(n<2) 1;
   else n*fact1(n-1)
  };System.out.println("""fact1: (n: Int)BigInt""");$skip(15); val res$7 = 
  
  fact1(20);System.out.println("""res7: BigInt = """ + $show(res$7));$skip(242); 
  
  //fact1(10000) -> StackOver flow
  
  //Functional abstrraction to hide the 'acc' parameter
  
  def factorial(n:Int) = {
  
   def fact2(x:Int ,acc:BigInt) : BigInt = {
   if(x<2) acc;
   else x*fact2(x-1,acc*x)
  }
  
  fact2(n,1)
  };System.out.println("""factorial: (n: Int)BigInt""");$skip(48); 
  
  //factorial(1000)
  
  
  val err = 0.0001;System.out.println("""err  : Double = """ + $show(err ));$skip(67); 
  
  def isOk(x:Double , g:Double)={math.abs((g - x/g) / x) < err};System.out.println("""isOk: (x: Double, g: Double)Boolean""");$skip(49); 
  
  def improve(x:Double,g:Double)=(g+ x/g)/2.0;System.out.println("""improve: (x: Double, g: Double)Double""");$skip(94); 
  
  def sqt1(x:Double,g:Double):Double={
  	if(isOk(x,g)) g
  	else sqt1(x,improve(x,g))
  };System.out.println("""sqt1: (x: Double, g: Double)Double""");$skip(15); val res$8 = 
  
  sqt1(4,1);System.out.println("""res8: Double = """ + $show(res$8));$skip(308); 
  // sqt1 has no cohere
  
  //Functional Abstraction
  def sqt(x:Double)={
  
	  val err = 0.0001
	  
	  def isOk(g:Double)={math.abs((g - x/g) / x) < err}
	  
	  def improve(g:Double)=(g+ x/g)/2.0
	  
	  def inner(g:Double):Double={
	  	if(isOk(g)) g
	  	else inner(improve(g))
	  }
	  
	  inner(1)
  
  };System.out.println("""sqt: (x: Double)Double""");$skip(30); val res$9 = 
  
  sqt(23123321625475676.0);System.out.println("""res9: Double = """ + $show(res$9));$skip(25); 
  def fn(x:Int) = 5+6.0f;System.out.println("""fn: (x: Int)Float""");$skip(200); 
 
	 /*
	 	Higher Order Functions
		-> They take functions as arguments / parameter
	
	 	Closure expression and anonymous functions
	 	These are lambda functions.
	 */
	 
	 val i : Int=>Int = (a=>a*a);System.out.println("""i  : Int => Int = """ + $show(i ));$skip(7); val res$10 = 
	 i(5);System.out.println("""res10: Int = """ + $show(res$10));$skip(112); 
	 
	 //val j = (a,b)=>a*b wont work because we need to specify datatype
	 val j:(Int,Int) => Int = (a,b) => a*b;System.out.println("""j  : (Int, Int) => Int = """ + $show(j ));$skip(9); val res$11 = 
	 j(5,6);System.out.println("""res11: Int = """ + $show(res$11));$skip(23); 
	 
	 val g = List(i,i);System.out.println("""g  : List[Int => Int] = """ + $show(g ));$skip(343); 
	 
	 /*
	 f(x) = 5x-6
	 value of x for which f(x) is the same as x
	 */
	 
	 def fixedPoint(f:Double=>Double, guess:Double = 1.00)={
	 	val errFP = 0.0001
	 	def isOK(g:Double, next:Double)=math.abs((f(g)-g)/g)<=errFP
	 	def inner(g:Double):Double = {
	 		val next = f(g)
	 		if(isOK(g,next)) g
	 		else inner(next)
	 		}
	 		inner(guess)
	 };System.out.println("""fixedPoint: (f: Double => Double, guess: Double)Double""");$skip(27); val res$12 = 

	fixedPoint(x => 1 + x/2);System.out.println("""res12: Double = """ + $show(res$12));$skip(133); 
	
	/*
	For finding the SQRT : y*y = x
	y = x/y. the fixed point will be sqrt(x)
	*/
	def sqrt1(x:Double) = {
		fixedPoint(y=>x/y)
	};System.out.println("""sqrt1: (x: Double)Double""");$skip(226); 
	
	/*
	HASKEL CURRY invented currying
	This curried version is needed to partially apply parameters
	So we can use this in the existing fixed point computations
	*/
	def averageDamp1(f:Double=>Double)(x:Double) = (f(x)+x)/2.0;System.out.println("""averageDamp1: (f: Double => Double)(x: Double)Double""");$skip(65); 
	
	def sqrt2(x:Double) = {
		fixedPoint(averageDamp1(y=>x/y))
	};System.out.println("""sqrt2: (x: Double)Double""");$skip(10); val res$13 = 
	sqrt2(2);System.out.println("""res13: Double = """ + $show(res$13))}
}

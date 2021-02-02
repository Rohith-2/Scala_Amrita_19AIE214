object Functions_InDepth {
  //Functions are the First class constructs..
  //Type Inferences is compile time
  
  var a=6 ; var b=7                               //> a  : Int = 6
                                                  //| b  : Int = 7
  //Parameters are AnyVal
  def fn5(x:Int ,y:Int)={
  	if (x%2==0) x/2 +y
  	else x+y
  }                                               //> fn5: (x: Int, y: Int)Int
 
 fn5(a,b)                                         //> res0: Int = 10
 /*
 the formal parameters are x and y
 x and y are copies of a and b
 pass by value .. more memory used
 */
 
//Parameters are AnyRef
   def fn6(x:Array[Char] ,y:String)={
  	x(0)='B'
  }                                               //> fn6: (x: Array[Char], y: String)Unit
  
  var c = "Rohith".toCharArray()                  //> c  : Array[Char] = Array(R, o, h, i, t, h)
  fn6(c,"Ramakrishnan")
  c                                               //> res1: Array[Char] = Array(B, o, h, i, t, h)
  
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
  }                                               //> fn7: (x: IndexedSeq[Char], y: String)String
  fn7(c,"Menon")                                  //> res2: String = WrappedArray(B, o, h, i, t, h)Menon
  
  def fn8(x:Int,y: => Int)={
  if(x%3==0)y
  else x
  }                                               //> fn8: (x: Int, y: => Int)Int
  //paramter 'y' is never used if the condition fails
  
  fn8(4+5,6+7)                                    //> res3: Int = 13
  
  def fp = {
  	println("Called")
  	6+7
  }                                               //> fp: => Int
  
  fn8(4+5,fp)                                     //> Called
                                                  //| res4: Int = 13
  
  fn8(4+7,fp)                                     //> res5: Int = 11
  
  def fact0(n:Int) : Int={
  if(n<2) 1;
  else n*fact0(n-1)
  }                                               //> fact0: (n: Int)Int
  
  fact0(20)                                       //> res6: Int = -2102132736
  //fact0(20) res7: Int = -2102132736 .. Integer Overflow
  
  def fact1(n:Int) : BigInt = {
   if(n<2) 1;
   else n*fact1(n-1)
  }                                               //> fact1: (n: Int)BigInt
  
  fact1(20)                                       //> res7: BigInt = 2432902008176640000
  
  //fact1(10000) -> StackOver flow
  
  //Functional abstrraction to hide the 'acc' parameter
  
  def factorial(n:Int) = {
  
   def fact2(x:Int ,acc:BigInt) : BigInt = {
   if(x<2) acc;
   else x*fact2(x-1,acc*x)
  }
  
  fact2(n,1)
  }                                               //> factorial: (n: Int)BigInt
  
  //factorial(1000)
  
  
  val err = 0.0001                                //> err  : Double = 1.0E-4
  
  def isOk(x:Double , g:Double)={math.abs((g - x/g) / x) < err}
                                                  //> isOk: (x: Double, g: Double)Boolean
  
  def improve(x:Double,g:Double)=(g+ x/g)/2.0     //> improve: (x: Double, g: Double)Double
  
  def sqt1(x:Double,g:Double):Double={
  	if(isOk(x,g)) g
  	else sqt1(x,improve(x,g))
  }                                               //> sqt1: (x: Double, g: Double)Double
  
  sqt1(4,1)                                       //> res8: Double = 2.0000000929222947
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
  
  }                                               //> sqt: (x: Double)Double
  
  sqt(23123321625475676.0)                        //> res9: Double = 1.411335553891245E12
  def fn(x:Int) = 5+6.0f                          //> fn: (x: Int)Float
 
	 /*
	 	Higher Order Functions
		-> They take functions as arguments / parameter
	
	 	Closure expression and anonymous functions
	 	These are lambda functions.
	 */
	 
	 val i : Int=>Int = (a=>a*a)              //> i  : Int => Int = Functions_InDepth$$$Lambda$15/1032616650@5ebec15
	 i(5)                                     //> res10: Int = 25
	 
	 //val j = (a,b)=>a*b wont work because we need to specify datatype
	 val j:(Int,Int) => Int = (a,b) => a*b    //> j  : (Int, Int) => Int = Functions_InDepth$$$Lambda$16/2052915500@3fb6a447
	 j(5,6)                                   //> res11: Int = 30
	 
	 val g = List(i,i)                        //> g  : List[Int => Int] = List(Functions_InDepth$$$Lambda$15/1032616650@5ebec
                                                  //| 15, Functions_InDepth$$$Lambda$15/1032616650@5ebec15)
	 
	 /*
	 f(x) = 5x-6
	 value of x for which f(x) is the same as x
	 */
	 
	 def fixedPoint(f:Double=>Double, x:Double)={
	 	val errFP = 0.0001
	 	def isOK(g:Double){}
	 }                                        //> fixedPoint: (f: Double => Double, x: Double)Unit
}
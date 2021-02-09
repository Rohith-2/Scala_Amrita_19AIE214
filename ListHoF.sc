object ListHoF {
  val l = List(1,2,3,4,5,6,7,8,9)                 //> l  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val l0 = 0::l                                   //> l0  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  /*
  	cons operstor '::'
  	
  	All Operators are functions
  	the operater symbol is the function name
  	Class List[Int]{
  		def :: (head:Int) = new List(head,this)
  	}
  */
  
  l.::(0)                                         //> res0: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  //l is the calling object and 0 is the operator
  
  /*
  	BODMAS
  	Programming languages implments this using -
  	Precedence and Associativity
  	
  */
  6+5*4-3.0/5.0                                   //> res1: Double = 25.4
  
  /*
  	Consider, 1+2+3+4+5
  	'+' is left associative
  	3.+(4.+(5))
  */
  1.+(2.+(3.+(4.+(5))))                           //> res2: Int = 15
  1+2+3+4+5                                       //> res3: Int = 15
  
  //Cons is right associative
  
  /*
  	Pattern Matching
  	-> Complex Switch Case with extended features
  */
 val l1 = List(3,4,5,6)                           //> l1  : List[Int] = List(3, 4, 5, 6)
  val b = l1 match {
  	case Nil =>0
  	case List(_) => 1
		case List(_,_) => 2
		case x::ys => x
  	case default => 3
  }                                               //> b  : Int = 3
  
  //Reversing a list :
  def reverse(l0:List[Int]):List[Int] = l0 match {
  	case List() => l0
  	case x::ys => reverse(ys) ++ List(x)
  }                                               //> reverse: (l0: List[Int])List[Int]
  
  //Tail recursive
  def reverse_tail(l0:List[Int],acc:List[Int]=Nil):List[Int] = l0 match {
  	case List() => acc
  	case x::ys => reverse_tail(ys , x::acc) ++ List(x)
  }                                               //> reverse_tail: (l0: List[Int], acc: List[Int])List[Int]
  
  reverse_tail(l)                                 //> res4: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1
                                                  //| )
  
  def length(l0:List[Int],acc:Int=0):Int = l0 match {
  	case Nil => acc
  	case x :: ys => length(ys,acc+1)
  }                                               //> length: (l0: List[Int], acc: Int)Int
  
  length(l)                                       //> res5: Int = 9
  
  def map(l0:List[Int],m:Int=>Int):List[Int] = l0 match {
  	case Nil => l0
  	case x::ys => m(x) :: map(ys,m)
  }                                               //> map: (l0: List[Int], m: Int => Int)List[Int]
  
  map(l,x=>x*x)                                   //> res6: List[Int] = List(1, 4, 9, 16, 25, 36, 49, 64, 81)
  
  def map0(l0:List[Int] , m:Int=>Int , acc:List[Int] = List()):List[Int] = l0 match {
  	case Nil => acc
  	case x::ys => map0(ys,m,acc ++ List(m(x)))
  }                                               //> map0: (l0: List[Int], m: Int => Int, acc: List[Int])List[Int]
  
  map0(l,x=>x*x)                                  //> res7: List[Int] = List(1, 4, 9, 16, 25, 36, 49, 64, 81)
  
  //Finding the last value
  def last(l0:List[Int]):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => x
  	case x::ys => last(ys)
  }                                               //> last: (l0: List[Int])Int
  
  last(reverse(l))                                //> res8: Int = 1
  
  def concat(a:List[Int],b:List[Int]):List[Int]= a match{
  	case Nil =>b
  	case x::ys => x::concat(ys,b)
  }                                               //> concat: (a: List[Int], b: List[Int])List[Int]
  
  concat(l,l)                                     //> res9: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9
                                                  //| )
  
  def reduce(l0:List[Int],r:(Int,Int)=> Int):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => x
  	case x:: ys => r(x,reduce(ys,r))
  	
  }                                               //> reduce: (l0: List[Int], r: (Int, Int) => Int)Int
  reduce(l,_+_)                                   //> res10: Int = 45
  reduce(l,(a,x)=>a+x)                            //> res11: Int = 45
  
  def reduce0(l0:List[Int],r:(Int,Int)=> Int,acc:Int):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => r(acc,x)
  	case x:: ys => reduce0(ys,r,r(acc,x))
  	
  }                                               //> reduce0: (l0: List[Int], r: (Int, Int) => Int, acc: Int)Int
  reduce0(l,_+_,0)                                //> res12: Int = 45
  

}
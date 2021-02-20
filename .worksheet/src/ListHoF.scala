object ListHoF {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(50); 
  val l = List(1,2,3,4,5,6,7,8,9);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(16); 
  val l0 = 0::l;System.out.println("""l0  : List[Int] = """ + $show(l0 ));$skip(193); val res$0 = 
  /*
  	cons operator '::'
  	
  	All Operators are functions
  	the operater symbol is the function name
  	Class List[Int]{
  		def :: (head:Int) = new List(head,this)
  	}
  */
  
  l.::(0);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(173); val res$1 = 
  //l is the calling object and 0 is the operator
  
  /*
  	BODMAS
  	Programming languages implments this using -
  	Precedence and Associativity
  	
  */
  6+5*4-3.0/5.0;System.out.println("""res1: Double = """ + $show(res$1));$skip(102); val res$2 = 
  
  /*
  	Consider, 1+2+3+4+5
  	'+' is left associative
  	3.+(4.+(5))
  */
  1.+(2.+(3.+(4.+(5))));System.out.println("""res2: Int = """ + $show(res$2));$skip(12); val res$3 = 
  1+2+3+4+5;System.out.println("""res3: Int = """ + $show(res$3));$skip(139); 
  
  //Cons is right associative
  
  /*
  	Pattern Matching
  	-> Complex Switch Case with extended features
  */
 val l1 = List(3,4,5,6);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(123); 
  val b = l1 match {
  	case Nil =>0
  	case List(_) => 1
		case List(_,_) => 2
		case x::ys => x
  	case default => 3
  };System.out.println("""b  : Int = """ + $show(b ));$skip(142); 
  
  //Reversing a list :
  def reverse(l0:List[Int]):List[Int] = l0 match {
  	case List() => l0
  	case x::ys => reverse(ys) ++ List(x)
  };System.out.println("""reverse: (l0: List[Int])List[Int]""");$skip(176); 
  
  //Tail recursive
  def reverse_tail(l0:List[Int],acc:List[Int]=Nil):List[Int] = l0 match {
  	case List() => acc
  	case x::ys => reverse_tail(ys , x::acc) ++ List(x)
  };System.out.println("""reverse_tail: (l0: List[Int], acc: List[Int])List[Int]""");$skip(21); val res$4 = 
  
  reverse_tail(l);System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(116); 
  
  def length(l0:List[Int],acc:Int=0):Int = l0 match {
  	case Nil => acc
  	case x :: ys => length(ys,acc+1)
  };System.out.println("""length: (l0: List[Int], acc: Int)Int""");$skip(15); val res$5 = 
  
  length(l);System.out.println("""res5: Int = """ + $show(res$5));$skip(118); 
  
  def map(l0:List[Int],m:Int=>Int):List[Int] = l0 match {
  	case Nil => l0
  	case x::ys => m(x) :: map(ys,m)
  };System.out.println("""map: (l0: List[Int], m: Int => Int)List[Int]""");$skip(19); val res$6 = 
  
  map(l,x=>x*x);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(158); 
  
  def map0(l0:List[Int] , m:Int=>Int , acc:List[Int] = List()):List[Int] = l0 match {
  	case Nil => acc
  	case x::ys => map0(ys,m,acc ++ List(m(x)))
  };System.out.println("""map0: (l0: List[Int], m: Int => Int, acc: List[Int])List[Int]""");$skip(20); val res$7 = 
  
  map0(l,x=>x*x);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(172); 
  
  //Finding the last value
  def last(l0:List[Int]):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => x
  	case x::ys => last(ys)
  };System.out.println("""last: (l0: List[Int])Int""");$skip(22); val res$8 = 
  
  last(reverse(l));System.out.println("""res8: Int = """ + $show(res$8));$skip(114); 
  
  def concat(a:List[Int],b:List[Int]):List[Int]= a match{
  	case Nil =>b
  	case x::ys => x::concat(ys,b)
  };System.out.println("""concat: (a: List[Int], b: List[Int])List[Int]""");$skip(17); val res$9 = 
  
  concat(l,l);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(179); 
  
  def reduce(l0:List[Int],r:(Int,Int)=> Int):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => x
  	case x:: ys => r(x,reduce(ys,r))
  	
  };System.out.println("""reduce: (l0: List[Int], r: (Int, Int) => Int)Int""");$skip(16); val res$10 = 
  reduce(l,_+_);System.out.println("""res10: Int = """ + $show(res$10));$skip(23); val res$11 = 
  reduce(l,(a,x)=>a+x);System.out.println("""res11: Int = """ + $show(res$11));$skip(200); 
  
  def reduce0(l0:List[Int],r:(Int,Int)=> Int,acc:Int):Int = l0 match {
  	case Nil => throw new Exception("List Empty")
  	case List(x) => r(acc,x)
  	case x:: ys => reduce0(ys,r,r(acc,x))
  	
  };System.out.println("""reduce0: (l0: List[Int], r: (Int, Int) => Int, acc: Int)Int""");$skip(19); val res$12 = 
  reduce0(l,_+_,0);System.out.println("""res12: Int = """ + $show(res$12))}
  
}

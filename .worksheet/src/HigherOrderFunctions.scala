object HigherOrderFunctions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to HoF");$skip(156); 

  def sumInts(x: Int, y: Int) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, acc + x)
    }

    iter(x, 0)
  };System.out.println("""sumInts: (x: Int, y: Int)Int""");$skip(18); val res$0 = 

  sumInts(1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(162); 

  def sumSqInts(x: Int, y: Int) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, acc + x * x)
    }

    iter(x, 0)
  };System.out.println("""sumSqInts: (x: Int, y: Int)Int""");$skip(20); val res$1 = 

  sumSqInts(1, 10);System.out.println("""res1: Int = """ + $show(res$1));$skip(241); 

  /*
  	HigherOrderFunction :
  	Generalises the series summation
  */
  def sum(f: Int => Int, x: Int, y: Int) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, acc + f(x))
    }

    iter(x, 0)
  };System.out.println("""sum: (f: Int => Int, x: Int, y: Int)Int""");$skip(22); val res$2 = 

  sum(x => x, 1, 10);System.out.println("""res2: Int = """ + $show(res$2));$skip(25); val res$3 = 
  sum(x => x * x, 1, 10);System.out.println("""res3: Int = """ + $show(res$3));$skip(29); val res$4 = 
  sum(x => x * x * x, 1, 10);System.out.println("""res4: Int = """ + $show(res$4));$skip(319); 

  //We want to generalise all series operations
  def mapreduce(x: Int, y: Int,
    map: Int => Int = x => x,
    reduce: (Int, Int) => Int = (a, b) => a + b,
    iden: Int = 0) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, reduce(acc, map(x)))
    }

    iter(x, iden)
  };System.out.println("""mapreduce: (x: Int, y: Int, map: Int => Int, reduce: (Int, Int) => Int, iden: Int)Int""");$skip(313); 

  def mapreduce1(
    map: Int => Int = x => x,
    reduce: (Int, Int) => Int = (a, b) => a + b,
    iden: Int = 0)
    (x: Int)(y: Int) = { //The Parameters have been curried

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, reduce(acc, map(x)))
    }

    iter(x, iden)
  };System.out.println("""mapreduce1: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(x: Int)(y: Int)Int""");$skip(42); val res$5 = 

  //HoF for summation
  mapreduce(1, 10);System.out.println("""res5: Int = """ + $show(res$5));$skip(31); val res$6 = 
  mapreduce(1, 10, x => x * x);System.out.println("""res6: Int = """ + $show(res$6));$skip(70); val res$7 = 

  //factorial example
  mapreduce1(x => x, (u, v) => u * v, 1)(1)(5);System.out.println("""res7: Int = """ + $show(res$7));$skip(76); 

  //Partially Applied
  val prod = mapreduce1(x => x, (u, v) => u * v, 1)_;System.out.println("""prod  : Int => (Int => Int) = """ + $show(prod ));$skip(13); val res$8 = 
  prod(1)(5);System.out.println("""res8: Int = """ + $show(res$8));$skip(111); 

  //factorial using partially applied general function
  val fct = mapreduce1(x => x, (u, v) => u * v, 1)(1)_;System.out.println("""fct  : Int => Int = """ + $show(fct ));$skip(9); val res$9 = 
  fct(6);System.out.println("""res9: Int = """ + $show(res$9));$skip(337); 

  def mapreduce2(
    map: Int => Int = x => x,
    reduce: (Int, Int) => Int = (a, b) => a + b,
    iden: Int = 0): (Int, Int) => Int = {
    def fn(x: Int, y: Int) = {

      def iter(x: Int, acc: Int): Int = {
        if (x > y) acc;
        else iter(x + 1, reduce(acc, map(x)))
      }

      iter(x, iden)
    }
    return fn
  };System.out.println("""mapreduce2: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(Int, Int) => Int""");$skip(46); 
  val sumints = mapreduce2(x=>x,(u,v)=>u+v,0);System.out.println("""sumints  : (Int, Int) => Int = """ + $show(sumints ));$skip(49); 
	val sumSqints = mapreduce2(x=>x*x,(u,v)=>u+v,0);System.out.println("""sumSqints  : (Int, Int) => Int = """ + $show(sumSqints ));$skip(16); val res$10 = 
  sumints(1,10);System.out.println("""res10: Int = """ + $show(res$10));$skip(18); val res$11 = 
  sumSqints(1,10);System.out.println("""res11: Int = """ + $show(res$11));$skip(81); 

  //Self-Attempt : ------------------------

  var a = List("a", "b", "c", "d");System.out.println("""a  : List[String] = """ + $show(a ));$skip(330); 

  def conCat(
    map: String => String = x => x + x,
    reduce: (String, String) => String = (a, b) => a + b,
    iden: String = "")
    (x: List[String]) = {
    
    def iter(x: List[String], acc: String): String = {
      if (x == Nil) acc;
      else iter(x.tail, reduce(acc, map(x.head)))
    }
    
    iter(x, iden)
  };System.out.println("""conCat: (map: String => String, reduce: (String, String) => String, iden: String)(x: List[String])String""");$skip(27); val res$12 = 
  
  conCat(x => x * 2)(a);System.out.println("""res12: String = """ + $show(res$12));$skip(250); 
  //---------------------------------------
  
  /*
  Call by name is a functional parameter
  Null => <Some_Type>
  Function 0 - depends on the number of parameters
  x is not a variable but assume it to be some function
  */
  def fn(x: =>Int) = x;System.out.println("""fn: (x: => Int)Int""")}

}

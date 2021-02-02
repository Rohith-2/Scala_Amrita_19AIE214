object DataTypes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  println("Welcome to the Scala worksheet");$skip(12); 
  val i = 1;System.out.println("""i  : Int = """ + $show(i ));$skip(4); val res$0 = 
  i;System.out.println("""res0: Int = """ + $show(res$0));$skip(35); 
  // i=2 will not work
  var j = 2;System.out.println("""j  : Int = """ + $show(j ));$skip(12); 
  var k = 8;System.out.println("""k  : Int = """ + $show(k ));$skip(6); 
  j=3;$skip(79); 
  
  //res stands for result its being throwing away its like a residual
  j=k;$skip(56); val res$1 = 
  //assignemnt will not throw out a value or result
  k;System.out.println("""res1: Int = """ + $show(res$1));$skip(63); 
  //var keyword produces mutable variables..
  
  val b = 1.5f;System.out.println("""b  : Float = """ + $show(b ));$skip(21); 
  val c:Float = 1.5f;System.out.println("""c  : Float = """ + $show(c ));$skip(14); 
  val d = 'a';System.out.println("""d  : Char = """ + $show(d ));$skip(20); 
  val e:Float = 'a';System.out.println("""e  : Float = """ + $show(e ));$skip(118); 
  
  //there will be an error if val e:Float = 1.5 its a type mismatch coz its a double
  val f:Float = (1.5).toFloat;System.out.println("""f  : Float = """ + $show(f ));$skip(116); 
  
  //double to float loss is expected beacuse float had smaller memory compared to double
  val s = "Scala"+" FP";System.out.println("""s  : String = """ + $show(s ));$skip(33); 
  val l0 = List(1,2,3,4,5,6,7,8);System.out.println("""l0  : List[Int] = """ + $show(l0 ));$skip(80); 
  
  //square brackets are type parameters
  
  val a0 = Array(1,2,3,4,5,6,7,8);System.out.println("""a0  : Array[Int] = """ + $show(a0 ));$skip(42); 
  val l1 : List[String] = List("ab","bc");System.out.println("""l1  : List[String] = """ + $show(l1 ));$skip(42); val res$2 = 
  
  //paranthesis for subscripts
  l0(3);System.out.println("""res2: Int = """ + $show(res$2));$skip(8); val res$3 = 
  a0(3);System.out.println("""res3: Int = """ + $show(res$3));$skip(16); 
  
  a0(3) = 54;$skip(81); 
  //Arrays are mutable and Lists are immutable
  val l2 = List(1.2f,'a',1,false);System.out.println("""l2  : List[AnyVal] = """ + $show(l2 ));$skip(52); 
  
  val l3 = List("Rohi",List(1,2,3),Array(1,2,3))
  //empty class constructor
  class A ();System.out.println("""l3  : List[java.io.Serializable] = """ + $show(l3 ));$skip(77); 
    val rr = List('a',1.3f,1,new A);System.out.println("""rr  : List[Any] = """ + $show(rr ));$skip(58); 
  
  val l4 = List("Rohi",List(1,2,3),Array(1,2,3),new A);System.out.println("""l4  : List[Object] = """ + $show(l4 ));$skip(68); 
  val l5:List[AnyRef] = List("Rohi",List(1,2,3),Array(1,2,3),new A);System.out.println("""l5  : List[AnyRef] = """ + $show(l5 ));$skip(16); 
  val m = (j=4);System.out.println("""m  : Unit = """ + $show(m ));$skip(44); 
  //Empty type ----> Unit
  val l6 = List();System.out.println("""l6  : List[Nothing] = """ + $show(l6 ));$skip(57); 
  
  //Nil and List[Nothing] are the same
  val l7 = Nil;System.out.println("""l7  : scala.collection.immutable.Nil.type = """ + $show(l7 ));$skip(14); val res$4 = 
  
  l6 == l7;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(14); val res$5 = 
  
  l6 ++ l0;System.out.println("""res5: List[Int] = """ + $show(res$5))}
}

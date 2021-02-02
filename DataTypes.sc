object DataTypes {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val i = 1                                       //> i  : Int = 1
  i                                               //> res0: Int = 1
  // i=2 will not work
  var j = 2                                       //> j  : Int = 2
  var k = 8                                       //> k  : Int = 8
  j=3
  
  //res stands for result its being throwing away its like a residual
  j=k
  //assignemnt will not throw out a value or result
  k                                               //> res1: Int = 8
  //var keyword produces mutable variables..
  
  val b = 1.5f                                    //> b  : Float = 1.5
  val c:Float = 1.5f                              //> c  : Float = 1.5
  val d = 'a'                                     //> d  : Char = a
  val e:Float = 'a'                               //> e  : Float = 97.0
  
  //there will be an error if val e:Float = 1.5 its a type mismatch coz its a double
  val f:Float = (1.5).toFloat                     //> f  : Float = 1.5
  
  //double to float loss is expected beacuse float had smaller memory compared to double
  val s = "Scala"+" FP"                           //> s  : String = Scala FP
  val l0 = List(1,2,3,4,5,6,7,8)                  //> l0  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  
  //square brackets are type parameters
  
  val a0 = Array(1,2,3,4,5,6,7,8)                 //> a0  : Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)
  val l1 : List[String] = List("ab","bc")         //> l1  : List[String] = List(ab, bc)
  
  //paranthesis for subscripts
  l0(3)                                           //> res2: Int = 4
  a0(3)                                           //> res3: Int = 4
  
  a0(3) = 54
  //Arrays are mutable and Lists are immutable
  val l2 = List(1.2f,'a',1,false)                 //> l2  : List[AnyVal] = List(1.2, a, 1, false)
  
  val l3 = List("Rohi",List(1,2,3),Array(1,2,3))  //> l3  : List[java.io.Serializable] = List(Rohi, List(1, 2, 3), Array(1, 2, 3))
                                                  //| 
  //empty class constructor
  class A ()
    val rr = List('a',1.3f,1,new A)               //> rr  : List[Any] = List(a, 1.3, 1, DataTypes$A$1@6b2fad11)
  
  val l4 = List("Rohi",List(1,2,3),Array(1,2,3),new A)
                                                  //> l4  : List[Object] = List(Rohi, List(1, 2, 3), Array(1, 2, 3), DataTypes$A$
                                                  //| 1@79698539)
  val l5:List[AnyRef] = List("Rohi",List(1,2,3),Array(1,2,3),new A)
                                                  //> l5  : List[AnyRef] = List(Rohi, List(1, 2, 3), Array(1, 2, 3), DataTypes$A$
                                                  //| 1@73f792cf)
  val m = (j=4)                                   //> m  : Unit = ()
  //Empty type ----> Unit
  val l6 = List()                                 //> l6  : List[Nothing] = List()
  
  //Nil and List[Nothing] are the same
  val l7 = Nil                                    //> l7  : scala.collection.immutable.Nil.type = List()
  
  l6 == l7                                        //> res4: Boolean = true
  
  l6 ++ l0                                        //> res5: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
}
object EDA {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Exploratory Data Analysis (EDA)");$skip(41); 
  
  val l2 = List(1,2,3,4,5,6,7,8,9,10);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(17); val res$0 = 
  l2.reduce(_+_);System.out.println("""res0: Int = """ + $show(res$0));$skip(28); val res$1 = 
	l2.map(x=>x*x).reduce(_+_);System.out.println("""res1: Int = """ + $show(res$1));$skip(16); val res$2 = 
	l2.reduce(_*_);System.out.println("""res2: Int = """ + $show(res$2));$skip(53); 
	
	//Mean
	val m = l2.reduce(_+_)/l2.length.toDouble;System.out.println("""m  : Double = """ + $show(m ));$skip(41); 
	
	//Deviations
	val dev = l2.map(_ - m);System.out.println("""dev  : List[Double] = """ + $show(dev ));$skip(76); 
	
	//Varience
  val sigSq = dev.map(x=>x*x).reduce(_+_) /l2.length.toDouble;System.out.println("""sigSq  : Double = """ + $show(sigSq ));$skip(54); 
  //Standerd Deviation
  val sigma = math.sqrt(sigSq);System.out.println("""sigma  : Double = """ + $show(sigma ));$skip(111); 
  
  //Doing it all in one step
  val sig = math.sqrt(l2.map(_-m).map(x=>x*x).reduce(_+_) /l2.length.toDouble);System.out.println("""sig  : Double = """ + $show(sig ));$skip(86); 
  
  //Lets compuet PI , like why not? Lets use integration also
  
  val dx = 0.0001;System.out.println("""dx  : Double = """ + $show(dx ));$skip(51); 
  
  val f:Double=>Double = x => 1.00/(1.00 + x*x);System.out.println("""f  : Double => Double = """ + $show(f ));$skip(238); 
  //val x_axis =    (1 to 10000).map(_*dx)
   		//(1 to 10000).map(x=>x*dx) same thing
  //val f_x = x_axis v
   		// x_axis.map(x=>f(x))
   //val pi = f_x.reduce(_+_)*dx*4
   
   val pi = (0.0 to 1.0 by dx).map(x=>f(x)).reduce(_+_)*dx*4;System.out.println("""pi  : Double = """ + $show(pi ));$skip(72); 
   
   val pi1 = Range.Double(0.0,1.0,dx).map(x=>f(x)).reduce(_+_)*dx*4;System.out.println("""pi1  : Double = """ + $show(pi1 ))}
		
  
}

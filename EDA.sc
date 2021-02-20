object EDA {
  println("Exploratory Data Analysis (EDA)")      //> Exploratory Data Analysis (EDA)
  
  val l2 = List(1,2,3,4,5,6,7,8,9,10)             //> l2  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  l2.reduce(_+_)                                  //> res0: Int = 55
	l2.map(x=>x*x).reduce(_+_)                //> res1: Int = 385
	l2.reduce(_*_)                            //> res2: Int = 3628800
	
	//Mean
	val m = l2.reduce(_+_)/l2.length.toDouble //> m  : Double = 5.5
	
	//Deviations
	val dev = l2.map(_ - m)                   //> dev  : List[Double] = List(-4.5, -3.5, -2.5, -1.5, -0.5, 0.5, 1.5, 2.5, 3.5,
                                                  //|  4.5)
	
	//Varience
  val sigSq = dev.map(x=>x*x).reduce(_+_) /l2.length.toDouble
                                                  //> sigSq  : Double = 8.25
  //Standerd Deviation
  val sigma = math.sqrt(sigSq)                    //> sigma  : Double = 2.8722813232690143
  
  //Doing it all in one step
  val sig = math.sqrt(l2.map(_-m).map(x=>x*x).reduce(_+_) /l2.length.toDouble)
                                                  //> sig  : Double = 2.8722813232690143
  
  //Lets compuet PI , like why not? Lets use integration also
  
  val dx = 0.0001                                 //> dx  : Double = 1.0E-4
  
  val f:Double=>Double = x => 1.00/(1.00 + x*x)   //> f  : Double => Double = EDA$$$Lambda$22/649734728@5f2050f6
  //val x_axis =    (1 to 10000).map(_*dx)
   		//(1 to 10000).map(x=>x*dx) same thing
  //val f_x = x_axis v
   		// x_axis.map(x=>f(x))
   //val pi = f_x.reduce(_+_)*dx*4
   
   val pi = (0.0 to 1.0 by dx).map(x=>f(x)).reduce(_+_)*dx*4
                                                  //> pi  : Double = 3.1418926519232273
   
   val pi1 = Range.Double(0.0,1.0,dx).map(x=>f(x)).reduce(_+_)*dx*4
                                                  //> pi1  : Double = 3.14169265192314
		
  
}
object HigherOrderFunctions {
  println("Welcome to HoF")                       //> Welcome to HoF

  def sumInts(x: Int, y: Int) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, acc + x)
    }

    iter(x, 0)
  }                                               //> sumInts: (x: Int, y: Int)Int

  sumInts(1, 10)                                  //> res0: Int = 55

  def sumSqInts(x: Int, y: Int) = {

    def iter(x: Int, acc: Int): Int = {
      if (x > y) acc;
      else iter(x + 1, acc + x * x)
    }

    iter(x, 0)
  }                                               //> sumSqInts: (x: Int, y: Int)Int

  sumSqInts(1, 10)                                //> res1: Int = 385

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
  }                                               //> sum: (f: Int => Int, x: Int, y: Int)Int

  sum(x => x, 1, 10)                              //> res2: Int = 55
  sum(x => x * x, 1, 10)                          //> res3: Int = 385
  sum(x => x * x * x, 1, 10)                      //> res4: Int = 3025

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
  }                                               //> mapreduce: (x: Int, y: Int, map: Int => Int, reduce: (Int, Int) => Int, ide
                                                  //| n: Int)Int

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
  }                                               //> mapreduce1: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(x: Int)
                                                  //| (y: Int)Int

  //HoF for summation
  mapreduce(1, 10)                                //> res5: Int = 55
  mapreduce(1, 10, x => x * x)                    //> res6: Int = 385

  //factorial example
  mapreduce1(x => x, (u, v) => u * v, 1)(1)(5)    //> res7: Int = 120

  //Partially Applied
  val prod = mapreduce1(x => x, (u, v) => u * v, 1)_
                                                  //> prod  : Int => (Int => Int) = HigherOrderFunctions$$$Lambda$18/997110508@6e
                                                  //| 8dacdf
  prod(1)(5)                                      //> res8: Int = 120

  //factorial using partially applied general function
  val fct = mapreduce1(x => x, (u, v) => u * v, 1)(1)_
                                                  //> fct  : Int => Int = HigherOrderFunctions$$$Lambda$22/398887205@7e0ea639
  fct(6)                                          //> res9: Int = 720

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
  }                                               //> mapreduce2: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(Int, In
                                                  //| t) => Int
  val sumints = mapreduce2(x=>x,(u,v)=>u+v,0)     //> sumints  : (Int, Int) => Int = HigherOrderFunctions$$$Lambda$25/1908316405@
                                                  //| 6fadae5d
  sumints(1,10)                                   //> res10: Int = 55
  
  val sumSqints = mapreduce2(x=>x*x,(u,v)=>u+v,0) //> sumSqints  : (Int, Int) => Int = HigherOrderFunctions$$$Lambda$25/190831640
                                                  //| 5@2812cbfa
  sumSqints(1,10)                                 //> res11: Int = 385
  

}